package org.blumea.cms.service.staticres.impl;


import com.google.common.base.Function;
import com.google.common.collect.Maps;
import org.blumea.cms.config.AppConfigContext;
import org.blumea.cms.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 静态资源配置服务
 */

public class StaticResCfgServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(StaticResCfgServiceImpl.class);

    /**
     * 静态资源zk配置节点key
     */
    private static final String CFG_NODE_KEY = "plat.cfg.staticres.zk.node";

    /**
     * 静态资源zk配置节点key
     */
    private static final String COMMONS_CFG_NODE_KEY = "commons.cfg.staticres.zk.node";

    @Autowired
    private AppConfigContext context;

    /**
     * 以zookeeper为数据源的map
     */
//    private ZkMap<String> zkMap;
//
//    /**
//     * 以zookeeper为数据源的map
//     */
//    private ZkMap<String> commonsMap;

    private Map<String, String> zkMap = Maps.newHashMap();

    private Map<String, String> commonsMap = Maps.newHashMap();

    /**
     * zookeeper节点值解码函数
     */
    private static final Function<byte[], String> DECODER = new Function<byte[], String>() {

        @Override
        public String apply(@Nullable byte[] input) {
            if (input == null) {
                return null;
            }
            try {
                return new String(input, Constants.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                LOGGER.error("read string from zk error", e);
                return null;
            }
        }
    };

    //    /**
//     * 构造方法
//     *
//     * @param conf     全局配置
//     * @param zkClient zk客户端
//     */
//    @Inject
//    public StaticResCfgServiceImpl(@Named(GlobalKeys.APP_GLOBAL_CONF_KEY_NAME) ImmutableMap<String, String> conf,
//                                   ZkClient zkClient) {
//        Preconditions.checkArgument(zkClient != null, "zk client is null");
//        String zkNode = MapConfig.getString(CFG_NODE_KEY, conf, null);
//        Preconditions.checkArgument(zkNode != null, "zk node is null");
//        zkMap = ZkMap.createZkMap(zkClient, zkNode, DECODER);
//        String commonsNode = MapConfig.getString(COMMONS_CFG_NODE_KEY, conf, null);
//        Preconditions.checkArgument(zkNode != null, "zk node is null");
//        commonsMap = ZkMap.createZkMap(zkClient, commonsNode, DECODER);
//    }

//    public StaticResCfgServiceImpl() {
//
//        zkMap.put("prefix", context.getString("static.conf.prefix", null));
//        zkMap.put("domain", context.getString("static.conf.domain", null));
//        zkMap.put("src_mode", context.getString("static.conf.src_mode", null));
//        commonsMap.put("prefix", context.getString("static.conf.prefix", null));
//        commonsMap.put("domain", context.getString("static.conf.domain", null));
//        commonsMap.put("src_mode", context.getString("static.conf.src_mode", null));
//    }

    public Map<String, String> getJsResCfgMap() {
        zkMap.put("prefix", context.getString("static.conf.prefix", null));
        zkMap.put("domain", context.getString("static.conf.domain", null));
        zkMap.put("src_mode", context.getString("static.conf.src_mode", null));
        return zkMap;
    }

    public Map<String, String> getCssResCfgMap() {
        zkMap.put("prefix", context.getString("static.conf.prefix", null));
        zkMap.put("domain", context.getString("static.conf.domain", null));
        zkMap.put("src_mode", context.getString("static.conf.src_mode", null));
        return zkMap;
    }

    public Map<String, String> getCssResCommMap() {
        commonsMap.put("prefix", context.getString("static.conf.prefix", null));
        commonsMap.put("domain", context.getString("static.conf.domain", null));
        commonsMap.put("src_mode", context.getString("static.conf.src_mode", null));
        return commonsMap;
    }

    public Map<String, String> getJsResCommMap() {
        commonsMap.put("prefix", context.getString("static.conf.prefix", null));
        commonsMap.put("domain", context.getString("static.conf.domain", null));
        commonsMap.put("src_mode", context.getString("static.conf.src_mode", null));
        return commonsMap;
    }

    public Map<String, String> getImgResCfgMap() {
        zkMap.put("prefix", context.getString("static.conf.prefix", null));
        zkMap.put("domain", context.getString("static.conf.domain", null));
        zkMap.put("src_mode", context.getString("static.conf.src_mode", null));
        return zkMap;
    }

    public Map<String, String> getImgResCommMap() {
        return commonsMap;
    }

    public void setContext(AppConfigContext context) {
        context = context;
    }

    public AppConfigContext getContext() {
        return context;
    }

}
