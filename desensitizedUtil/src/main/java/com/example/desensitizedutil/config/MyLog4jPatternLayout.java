package com.example.desensitizedutil.config;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.pattern.RegexReplacement;
import org.apache.logging.log4j.status.StatusLogger;

import java.nio.charset.Charset;
/**
 * @ClassName AsyncController
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/7/10 9:10
 * @Version 1.0
 */
@Plugin(name = "MyLog4jPatternLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class MyLog4jPatternLayout  extends AbstractStringLayout {
    /**
     * logger
     */
    private static final Logger LOGGER = StatusLogger.getLogger();
    /**
     * PatternLayout
     */
    private PatternLayout patternLayout;
    /**
     * 是否启用脱敏
     */
    private Boolean sensitive;
    /**
     * 脱敏规则
     */
    private RegexReplacements replaces;

    protected MyLog4jPatternLayout(Charset charset, String pattern, Boolean sensitive, RegexReplacements replaces) {
        super(charset);
        this.patternLayout = PatternLayout.newBuilder().withPattern(pattern).build();
        this.sensitive = sensitive;
        this.replaces = replaces;
    }

    /**
     * 插件构造工厂方法
     *
     * @param pattern   输出pattern
     * @param charset   字符集
     * @param sensitive 是否开启脱敏
     * @param replaces  脱敏规则
     * @return Layout<String>
     */
    @PluginFactory
    public static Layout<String> createLayout(@PluginAttribute(value = "pattern") final String pattern,
                                              @PluginAttribute(value = "charset", defaultString = "UTF-8") final Charset charset,
                                              @PluginAttribute(value = "sensitive") final Boolean sensitive,
                                              @PluginElement("replaces") final RegexReplacements replaces) {
        return new MyLog4jPatternLayout(charset, pattern, sensitive, replaces);
    }

    /**
     * 重写序列化方法（汉脱敏处理）
     *
     * @param event LogEvent
     * @return 日志信息
     */
    @Override
    public String toSerializable(LogEvent event) {
        // 原日志信息
        String msg = this.patternLayout.toSerializable(event);

        if (Boolean.FALSE.equals(this.sensitive)) {
            // 不脱敏，直接返回
            return msg;
        }

        if (this.replaces == null || this.replaces.getReplaces() == null || this.replaces.getReplaces().length == 0) {
            LOGGER.error("日志脱敏开启，但未配置脱敏规则，请检查配置后重试");
            return msg;
        }

        for (RegexReplacement replace : this.replaces.getReplaces()) {
            // 遍历脱敏正则 & 替换敏感数据
            msg = replace.format(msg);
        }

        // 脱敏后的日志
        return msg;
    }
}
