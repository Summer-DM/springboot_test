package com.example.desensitizedutil;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.json.JSONUtil;
import com.example.desensitizedutil.model.Job;
import com.example.desensitizedutil.model.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;

@SpringBootTest
class DesensitizedUtilApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(DesensitizedUtilApplicationTests.class);

    @Test
    void contextLoads() {

        String password = DesensitizedUtil.password("221g3dsadad5");
        logger.info("普通密码脱敏：{}", password);
        String mobilePhone = DesensitizedUtil.mobilePhone("13456789802");
        logger.info("普通手机号脱敏：{}", mobilePhone);
    }

    @Test
    public void test0() {
        MDC.put("alice", System.currentTimeMillis() + "");
        // 等号
        logger.info("mobile={}", "13511114444");
        // 等号+[
        logger.info("mobile=[{}]", "13511114444");
        // 等号+英文单引号
        logger.info("mobile='{}'", "13511114444");
        // 中文冒号
        logger.info("mobile：{}", "13511114444");
        // 英文冒号
        logger.info("mobile:{}", "13511114444");
        // 英文双引号+英文冒号+英文双引号
        logger.info("\"mobile\":\"{}\"", "13511114444");
        // 英文单引号+英文冒号+英文单引号
        logger.info("'mobile':'{}'", "13511114444");
    }

    /**
     * 基本输出
     */
    @Test
    public void test1() {
        // 11位手机号
        logger.info("mobile={}", "13511114444");
        logger.info("mobile={},手机号：{}", "13511112222", "13511113333");
        logger.info("手机号：{}", "13511115555");
        // 固定电话（带区号-）
        logger.info("tel：{},座机={}", "0791-83376222", "021-88331234");
        logger.info("tel：{}", "0791-83376222");
        logger.info("座机={}", "021-88331234");

        // 地址
        logger.info("address：{}", "浙江省杭州市西湖区某条路123号");
        logger.info("地址：{}", "上海市浦东区北京东路1-10号");

        // 19位卡号
        logger.info("cardNo：{}", "6227002020000101222");

        // 姓名
        logger.info("name={}, 姓名=[{}]，name={}，姓名：{}", "张三", "上官婉儿", "李云龙", "楚云飞");

        // 密码
        logger.info("password：{}，密码={}", "123456", "456789");
        // 密码
        logger.info("password：{}", "123456");
        logger.info("密码={}", "123456");

        // 身份证号码
        logger.info("idCard：{}，身份证号={}", "360123202111111122", "360123202111111122");
        logger.info("身份证号={}", "360123202111111122");

        // 邮箱
        logger.info("邮箱:{}", "alice@google.com");
        logger.info("email={}", "bob520@163.com");
    }

    /**
     * toString/json输出
     */
    @Test
    public void test2() {
        User user = new User();
        user.setCardNo("6227002020000101222");
        user.setTel("0571-28821111");
        user.setBirth(new Date());

        user.setAddress("浙江省西湖区西湖路288号钱江乐园2-101室");
        user.setEmail("zhangs12345@qq.com");
        user.setPassword("123456");
        user.setMobile("15911116789");
        user.setName("张三");
        user.setIdCard("360123202111111122");

        Job job = new Job();
        job.setAddress("浙江省杭州市西湖区某条路123号");
        job.setTel("0571-28826666");
        job.setJobName("操作员");
        job.setSalary(2000);
        job.setCompany("阿里妈妈有限公司");
        job.setPosition(Arrays.asList("需求", "开发", "测试", "上线"));

        user.setJob(job);
        System.out.println(user.toString());
        logger.error("用户信息：{}", user.toString());
        System.out.println(JSONUtil.toJsonStr(user));
        logger.error("用户信息：{}", JSONUtil.toJsonStr(user));
    }

    /**
     * 多线程的toString/json输出
     */
    @Test
    public void test3() throws InterruptedException {
        User user = new User();
        user.setCardNo("6227002020000101222");
        user.setTel("0571-28821111");

        user.setAddress("浙江省西湖区西湖路288号钱江乐园2-101室");
        user.setEmail("zhangs12345@google.com");
        user.setPassword("123456");
        user.setMobile("15911116789");
        user.setName("张三");
        user.setIdCard("360123202111111122");

        Job job = new Job();
        job.setAddress("浙江省杭州市西湖区某条路123号");
        job.setTel("0571-28826666");
        job.setJobName("操作员");
        // job.setSalary(2000);
        job.setCompany("阿拉丁有限公司");
        job.setPosition(Arrays.asList("需求", "开发", "测试", "上线"));

        user.setJob(job);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int jj = 0; jj < 100; jj++) {
                    job.setSalary(jj);
                    logger.info("用户信息：{}", user);
                    logger.info("用户信息：{}", JSONUtil.toJsonStr(user));
                }
            }).start();
        }
        Thread.sleep(3_000);
    }
}








