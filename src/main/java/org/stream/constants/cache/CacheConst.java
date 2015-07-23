package org.stream.constants.cache;

/**
 * 业务全局共用的缓存相关配置
 */
public final class CacheConst {

    private CacheConst() {
    }

    /**
     * 全局entity缓存版本号，当entity的全限定名（类名或包名）修改时，需要更新该值
     * 如果只更新了某一个entity，请在相应的key上增加自己特定的版本号
     */
    public static final String CACHE_KEY_ENTITY_GLOBAL_VERSION = "_2";

    /**
     * 区分缓存键
     */
    private static final String CACHE_KEY_ENTITY_HEADER = "1_";
    private static final String CACHE_KEY_API_HEADER = "2_";
    private static final String CACHE_KEY_PLAT_HEADER = "3_";
    private static final String CACHE_KEY_WORKER_HEADER = "4_";


    /**
     * 缓存组 ：用于做为entity的缓存组 :
     */
    public static final String CACHE_GROUP_ENTITY = "cache_group_entity";

    /**
     * 缓存组 ：存放业务相关缓存的组 : api相关
     */
    public static final String CACHE_GROUP_SERVICE_API = "cache_group_service_api";

    /**
     * 缓存组 ：存放新增终端标识的组, worker
     */
    public static final String CACHE_GROUP_SERVICE_WORKER = "cache_group_service_worker";

    /**
     * 缓存组 ：存放业务相关需要持久化缓存的组 : 可拆分
     */
    public static final String CACHE_GROUP_SNAP_0 = "cache_group_snap_0";


    // 缓存时间

    /**
     * 永久缓存持续时间
     */
    public static final int CACHE_TIME_FOR_EVER = 0;

    /**
     * 缓存时间：1分钟
     */
    public static final int CACHE_TIME_ONE_MINUTE = 60;

    /**
     * 缓存时间：1个小时
     */
    public static final int CACHE_TIME_ONE_HOUR = 60 * 60;

    /**
     * 缓存时间：1天
     */
    public static final int CACHE_TIME_ONE_DAY = 24 * CACHE_TIME_ONE_HOUR;

    /**
     * 缓存时间一个月
     */
    public static final int CACHE_TIME_ONE_MONTH = 32 * CACHE_TIME_ONE_DAY;

    /**
     * 作弊行为判断： 缓存时间（单位为秒） 5分钟
     */
    public static final int CACHE_TIME_ANTI_CHEAT = 5 * 60;

    // 缓存内容使用的缓存组 映射


    // 缓存key

    /**
     * AppBean 缓存key : 参数 appId
     */
    public static final String CACHE_KEY_APP_ENTITY_APPID = "app_aid_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;
    /**
     * AppGrayBean 缓存key : 参数 appId
     */
    public static final String CACHE_KEY_APP_GRAY_ENTITY_APPID = "agray_aid_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;
    /**
     * DistAppGrayBean 缓存key : 参数 appId
     */
    public static final String CACHE_KEY_DIST_GRAY_ENTITY_APPID_PID = "dgray_pid_%s_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * RoleBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_ROLE_ENTITY_ID = "role_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * Media实体
     */
    public static final String CACHE_KEY_MEDIA_ENTITY_ID = "media_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * Entry实体
     */
    public static final String CACHE_KEY_ENTRY_ENTITY_ID = "entry_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;


    //------------实体缓存时间---------------------------------

    /**
     * 角色实体缓存时间
     */
    public static final int CACHE_TIME_ROLE_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * 媒体实体缓存时间
     */
    public static final int CACHE_TIME_MEDIA_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * Entry实体缓存时间
     */
    public static final int CACHE_TIME_ENTRY_ENTITY = CACHE_TIME_ONE_HOUR;


}
