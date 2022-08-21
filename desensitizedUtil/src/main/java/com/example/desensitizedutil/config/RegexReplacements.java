package com.example.desensitizedutil.config;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.pattern.RegexReplacement;
import org.apache.logging.log4j.status.StatusLogger;

/**
 * @ClassName RegexReplacements
 * @Description TODO
 * @Author Summer_DM
 * @Date 2022/8/14 9:46
 * @Version 1.0
 */
@Plugin(name = "replaces", category = Node.CATEGORY, printObject = true)
public class RegexReplacements {
    /**
     * LOGGER
     */
    private static final Logger LOGGER = StatusLogger.getLogger();
    /**
     * 脱敏正则
     */
    private RegexReplacement[] replaces;

    /**
     * 元素创建工厂方法
     *
     * @param replaces replaces
     * @return RegexReplacements
     */
    @PluginFactory
    public static RegexReplacements build(@PluginElement("replaces") final RegexReplacement[] replaces) {
        if (replaces == null) {
            LOGGER.error("未配置replaces节点，日志脱敏将不生效");
            return null;
        }
        if (replaces.length == 0) {
            LOGGER.error("未配置replace节点，日志脱敏将不生效");
            return null;
        }
        return new RegexReplacements(replaces);
    }

    public RegexReplacements(RegexReplacement[] replaces) {
        this.replaces = replaces;
    }

    public RegexReplacement[] getReplaces() {
        return replaces;
    }

    public void setReplaces(RegexReplacement[] replaces) {
        this.replaces = replaces;
    }
}
