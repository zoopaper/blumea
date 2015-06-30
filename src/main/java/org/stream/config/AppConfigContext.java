package org.stream.config;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import net.common.utils.config.MapConfig;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/29
 * Time: 17:59
 */
public class AppConfigContext {

    private String configXml;

    private ImmutableMap<String, String> ctxMap;


    public int getInt(String name, int defaultValue) {
        Preconditions.checkArgument(name != null, "name");
        if (ctxMap == null) {
            return defaultValue;
        }
        String s = ctxMap.get(name);
        if (s == null) {
            return defaultValue;
        }
        return Integer.parseInt(s);
    }


    public byte getByte(String name, byte defaultValue) {
        Preconditions.checkArgument(name != null, "name");
        if (ctxMap == null) {
            return defaultValue;
        }
        String s = ctxMap.get(name);
        if (s == null) {
            return defaultValue;
        }
        return Byte.parseByte(s);
    }


    public long getLong(String name, long defaultValue) {
        Preconditions.checkArgument(name != null, "name");
        if (ctxMap == null) {
            return defaultValue;
        }
        String s = ctxMap.get(name);
        if (s == null) {
            return defaultValue;
        }
        return Long.parseLong(s);
    }

    public String getString(@Nonnull String name, String defaultValue) {
        Preconditions.checkArgument(name != null, "name");
        if (ctxMap == null) {
            return defaultValue;
        }
        String s = ctxMap.get(name);
        if (s == null) {
            return defaultValue;
        }
        return s;
    }


    public static boolean getBoolean(@Nonnull String name, @Nullable Map<String, String> config, boolean defaultValue) {
        Preconditions.checkArgument(name != null, "name");
        if (config == null) {
            return defaultValue;
        }
        String s = config.get(name);
        if (s == null) {
            return defaultValue;
        }
        return Boolean.valueOf(s);
    }

    @PostConstruct
    public void init() {
        ctxMap = MapConfig.parseConf(configXml);
    }


    public void setConfigXml(String configXml) {
        this.configXml = configXml;
    }
}
