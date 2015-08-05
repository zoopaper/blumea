package org.blumea.cms.config;

import net.common.utils.config.xml.client.Group;
import net.common.utils.config.xml.client.ServiceGroup;
import net.common.utils.xml.JAXBUtil;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 16:45
 */
public class RedisServerGroupContext {

    private String redisServerGroupXml;

    private Map<String, Group> serverGroup;

    private ServiceGroup serviceGroup;

    @PostConstruct
    public void init() {
        serviceGroup = JAXBUtil.unmarshal(ServiceGroup.class, redisServerGroupXml);
        serverGroup = serviceGroup.getGroups();
    }


    public void setRedisServerGroupXml(String redisServerGroupXml) {
        this.redisServerGroupXml = redisServerGroupXml;
    }

    public ServiceGroup getServiceGroup() {
        return serviceGroup;
    }
}
