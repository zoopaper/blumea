package org.blumea.cms.config;

import net.common.utils.config.xml.server.Server;
import net.common.utils.config.xml.server.Servers;
import net.common.utils.xml.JAXBUtil;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 16:44
 */
public class RedisServerContext {

    private String redisServerXml;

    private Map<String, Server> serverMap;

    private Servers servers;

    @PostConstruct
    public void init() {

        servers = JAXBUtil.unmarshal(Servers.class, redisServerXml);
        serverMap = servers.getServers();
    }

    public void setRedisServerXml(String redisServerXml) {
        this.redisServerXml = redisServerXml;
    }

    public Servers getServers() {
        return servers;
    }
}
