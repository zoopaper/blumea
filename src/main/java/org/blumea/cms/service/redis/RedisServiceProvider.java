package org.blumea.cms.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.blumea.cms.config.RedisServerContext;
import org.blumea.cms.config.RedisServerGroupContext;

/**
 * <p/>
 * User : krisibm@163.com
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
