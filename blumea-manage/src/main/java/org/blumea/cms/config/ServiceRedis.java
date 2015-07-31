package org.blumea.cms.config;

import net.common.data.redis.IRedis;
import net.common.data.redis.client.RedisServiceLoaderImpl;
import net.common.utils.service.INameResourceService;
import net.common.utils.service.common.CommonNameResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 21:46
 */
@Component
public class ServiceRedis {

    @Autowired
    private RedisServerContext redisServerContext;

    @Autowired
    private RedisServerGroupContext redisServerGroupContext;

    INameResourceService<IRedis> redisNameService;

    @PostConstruct
    public void init() {
        RedisServiceLoaderImpl.RedisConfig redisConfig = new RedisServiceLoaderImpl.RedisConfig();
        RedisServiceLoaderImpl redisServiceLoader = new RedisServiceLoaderImpl(redisConfig, redisServerContext.getServers(), redisServerGroupContext.getServiceGroup());
        redisNameService = new CommonNameResourceServiceImpl<IRedis>(redisServiceLoader);
    }

    public INameResourceService<IRedis> getRedisNameService() {
        return redisNameService;
    }

}
