package org.blumea.cms.service.redis;

import org.blumea.cms.config.RedisServerContext;
import org.blumea.cms.config.RedisServerGroupContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p/>
 * User : shijingui
 * Date: 2015/7/1
 * Time: 17:29
 */
@Component
public class RedisServiceProvider {

    @Autowired
    private RedisServerContext serverContext;

    @Autowired
    private RedisServerGroupContext serverGroupContext;




}
