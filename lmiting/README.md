##SpringBoot结合Redis+Lua脚本实现api接口限流
###场景
    最近做了一个新的项目，需要提供接口供第三方调用，在api接口调用处需要实现一个限流的策略，
    所以采用了 Redis + Lua脚本的一个策略来达到一个限流的目的
###实现原理
    当第三方服务在请求某一个具体的接口之前，把接口名作为key去redis中查看这个key在单位时间内的访问次数（例如1秒20次，那就设置这个key的过期时间是1秒）
    当这个key的次数在一秒内的次数没有达到20次，也就是没有达到限流的阈值，此时可以正常访问
    当这个key的次数在一秒内的次数达到了20次，也就是达到了限流的阈值，此时返回“访问频率过高,请稍后重试”的异常
这里需要注意是对接口限流还是IP？
###使用lua 优点
    减少网络开销： 不使用 Lua 的代码需要向 Redis 发送多次请求，而脚本只需一次即可，减少网络传输；即多个reids命令的集合,不用每次都去建立连接
    原子操作：Redis 将整个脚本作为一个原子执行，无需担心并发，也就无需事务；
    复用：脚本会永久保存 Redis 中，其他客户端可继续使用。命令非常多，可以放在一个文件中，这样其他的redis也可以调用，使其复用
###lua流程说明
    local key = KEYS[1]
    local count = tonumber(ARGV[1])
    local time = tonumber(ARGV[2])
    local current = redis.call('get', key)
    if current and tonumber(current) > count then
    return tonumber(current)
    end
    current = redis.call('incr', key)
    if tonumber(current) == 1 then
    redis.call('expire', key, time)
    end
    return tonumber(current)
    首先获取到传进来的 key 以及 限流的 count 和时间 time。
    通过 get 获取到这个 key 对应的值，这个值就是当前时间窗内这个接口可以访问多少次。
    如果是第一次访问，此时拿到的结果为 nil，否则拿到的结果应该是一个数字，所以接下来就判断，如果拿到的结果是一个数字，并且这个数字还大于 count，那就说明已经超过流量限制了，那么直接返回查询的结果即可。
    如果拿到的结果为 nil，说明是第一次访问，此时就给当前 key 自增 1，然后设置一个过期时间。
    最后把自增 1 后的值返回就可以了。
