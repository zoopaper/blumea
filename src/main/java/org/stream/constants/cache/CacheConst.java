package org.stream.constants.cache;

/**
 * 业务全局共用的缓存相关配置
s */
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


    // 缓存内容使用的缓存组 映射


    /**
     * AppBean 缓存
     */
    public static final String CACHE_GROUP_APP_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * AppGrayBean 缓存
     */
    public static final String CACHE_GROUP_APP_GRAY_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * DistAppGrayBean 缓存
     */
    public static final String CACHE_GROUP_DIST_GRAY_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * AppForDistBean 缓存
     */
    public static final String CACHE_GROUP_APP_DIST_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * AppDistrictBean 缓存
     */
    public static final String CACHE_GROUP_APP_DISTRICT_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * DISTDistrictBean 缓存
     */
    public static final String CACHE_GROUP_DIST_DISTRICT_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * DistributerBean 缓存
     */
    public static final String CACHE_GROUP_DISTRIBUTER_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * DistrictBean 缓存
     */
    public static final String CACHE_GROUP_DISTRICT_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * DicAppCategoryBean 缓存
     */
    public static final String CACHE_GROUP_DICAPPCATEGORY_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * AdverBean 缓存
     */
    public static final String CACHE_GROUP_ADVER_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * AdDriverBean 缓存
     */
    public static final String CACHE_GROUP_DRIVER_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * ModelBean 缓存
     */
    public static final String CACHE_GROUP_MODEL_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * DeviceBean 缓存
     */
    public static final String CACHE_GROUP_DEVICE_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * AdminBean 缓存
     */
    public static final String CACHE_GROUP_ADMIN_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * BatchBean 缓存
     */
    public static final String CACHE_GROUP_BATCH_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * PackageBean 缓存
     */
    public static final String CACHE_GROUP_PACKAGE_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * ConfigBean 缓存
     */
    public static final String CACHE_GROUP_CONFIG_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * AppDistriBean 缓存
     */
    public static final String CACHE_GROUP_APP_DISTRI_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * BlacklistBean 缓存
     */
    public static final String CACHE_GROUP_BLACKLIST_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * NoticeBean 缓存
     */
    public static final String CACHE_GROUP_NOTICE_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * 注册激活码缓存组
     */
    public static final String CACHE_GROUP_CAPTCHA_REG = CACHE_GROUP_ENTITY;

    /**
     * RoleBean 缓存
     */
    public static final String CACHE_GROUP_ROLE_ENTITY = CACHE_GROUP_ENTITY;

    /**
     * 角色权限关联缓存组： 缓存组的名称对应配置文件里的名称
     */
    public static final String CACHE_GROUP_ROLE_PERMISSION = CACHE_GROUP_ENTITY;

    /**
     * AdmRoleBean 缓存
     */
    public static final String CACHE_GROUP_ADM_ROLE_ENTITY = CACHE_GROUP_ENTITY;

    /**
     * 管理员角色权限关联缓存组
     */
    public static final String CACHE_GROUP_ADMROLE_PERMISSION = CACHE_GROUP_ENTITY;

    /**
     * 管理员角色关联缓存组： 缓存组的名称对应配置文件里的名称
     */
    public static final String CACHE_GROUP_ADMIN_ROLE = CACHE_GROUP_ENTITY;

    /**
     * RecoveryBean 缓存
     */
    public static final String CACHE_GROUP_RECOVERY_ENTITY = CACHE_GROUP_ENTITY;

    /**
     * Recovery Driver 缓存
     */
    public static final String CACHE_GROUP_RECOVERY_DRIVER_ENTITY = CACHE_GROUP_ENTITY;
    /**
     * Brand 缓存
     */
    public static final String CACHE_GROUP_BRAND_ENTITY = CACHE_GROUP_ENTITY;

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

    /**
     * AppBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_APP_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * AppGrayBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_APP_GRAY_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * DistAppGrayBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_DIST_GRAY_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * AppForDistBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_APP_DIST_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * AppDistrictBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_APP_DISTRICT_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * DistDistrictBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_DIST_DISTRICT_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * DistributerBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_DISTRIBUTER_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * DistrictBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_DISTRICT_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * DicAppCategoryBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_DICAPPCATEGORY_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * AdverBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_ADVER_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * ModelBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_MODEL_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * DeviceBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_DEVICE_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * ModelBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_DRIVER_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * AdminBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_ADMIN_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * BatchBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_BATCH_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * PackageBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_PACKAGE_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * AppDistriBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_APP_DISTRI_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * ConfigBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_CONFIG_ENTITY = CACHE_TIME_ONE_MINUTE;

    /**
     * RoleBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_ROLE_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * 角色权限关联缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_ROLE_PERMISSION = CACHE_TIME_ONE_HOUR;

    /**
     * AdmRoleBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_ADM_ROLE_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * 管理员角色权限关联缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_ADMROLE_PERMISSION = CACHE_TIME_ONE_HOUR;

    /**
     * 管理员角色关联缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_ADMIN_ROLE = CACHE_TIME_ONE_HOUR;

    /**
     * RecoveryBean缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_RECOVERY_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * RecoveryDriverBean缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_RECOVERY_DRIVER_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * BrandBean缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_BRAND_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * BlacklistBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_BLACKLIST_ENTITY = CACHE_TIME_ONE_HOUR;

    /**
     * NoticeBean 缓存时间（单位为秒）
     */
    public static final int CACHE_TIME_NOTICE_ENTITY = CACHE_TIME_ONE_HOUR;

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
     * AppBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_APP_ENTITY_ID = "app_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AppGrayBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_APP_GRAY_ENTITY_ID = "agray_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DistAppGrayBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_DIST_GRAY_ENTITY_ID = "dgray_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AppForDistBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_APP_DIST_ENTITY_ID = "a_d_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AppDistrictBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_APP_DISTRICT_ENTITY_APPID = "a_dic_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DistDistrictBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_DIST_DISTRICT_ENTITY_DISTID = "d_dic_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * ConfigBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_CONFIG_ENTITY_ID = "config_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AppDistriBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_APP_DISTRI_ENTITY_ID = "appdist_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DistributerBean 缓存key : 参数 pId
     */
    public static final String CACHE_KEY_DISTRIBUTER_ENTITY_PID = "dist_pid_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DistributerBean 缓存key : 参数 account
     */
    public static final String CACHE_KEY_DISTRIBUTER_ENTITY_ACCOUNT = "dist_ac_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdverBean 缓存key : 参数 account
     */
    public static final String CACHE_KEY_ADVER_ENTITY_ACCOUNT = "ad_ac_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdbDriverBean 缓存key : 参数 vId,pId
     */
    public static final String CACHE_KEY_DRIVER_ENTITY_VID_PID = "adr_vp_%s_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdbDriverBean 缓存key : 参数 vId,pId
     */
    public static final String CACHE_KEY_DRIVER_ENTITY_CHECK_VID_PID = "adr_c_vp_%s_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdminBean 缓存key : 参数 account
     */
    public static final String CACHE_KEY_ADMIN_ENTITY_ACCOUNT = "adm_ac_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * BatchBean 缓存key : 参数 batchCode
     */
    public static final String CACHE_KEY_BATCH_ENTITY_BATCHCODE = "bat_bc_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DistributerBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_DISTRIBUTER_ENTITY_ID = "dist_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DistrictrBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_DISTRICT_ENTITY_ID = "dicd_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DistrictrBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_DICAPPCATEGORY_ENTITY_ID = "dicc_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdverBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_ADVER_ENTITY_ID = "ad_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdbDriverBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_DRIVER_ENTITY_ID = "adr_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * ModelBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_MODEL_ENTITY_ID = "mod_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * ModelBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_MODEL_ENTITY_UA = "mod_ua_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DeviceBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_DEVICE_ENTITY_ID = "dev_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * DeviceBean 对象缓存的主key : 参数 code
     */
    public static final String CACHE_KEY_DEVICE_ENTITY_CODE = "dev_dc_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdminBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_ADMIN_ENTITY_ID = "adm_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * BatchBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_BATCH_ENTITY_ID = "bat_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * PackageBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_PACKAGE_ENTITY_ID = "pkg_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * RoleBean 缓存主key : 参数 id
     */
    public static final String CACHE_KEY_ROLE_ENTITY_ID = "role_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * 角色权限关联缓存主key : 参数　roleId permissionType
     */
    public static final String CACHE_KEY_ROLE_PERMISSION_ROLEID_PERTYPE = "role_%s_pt_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdmRoleBean 缓存key : 参数 md5(roleName)
     */
    public static final String CACHE_KEY_ADM_ROLE_ENTITY_NAME = "adm_r_n_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * AdmRoleBean 缓存主key : 参数 id
     */
    public static final String CACHE_KEY_ADM_ROLE_ENTITY_ID = "adm_r_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * 管理员角色权限关联缓存主key : 参数　roleId
     */
    public static final String CACHE_KEY_ADMROLE_PERMISSION_ROLEID = "admrole_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * 管理员角色关联缓存主key : 参数　admId
     */
    public static final String CACHE_KEY_ADMIN_ROLE_ADMID = "adm_r_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * RecoveryBean缓存主Key:参数 id
     */
    public static final String CACHE_KEY_RECOVERY_ENTITY_ID = "rec_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * RecoveryDriverBean缓存主Key:参数 id
     */
    public static final String CACHE_KEY_RECOVERY_DRIVER_ENTITY_ID = "recdri_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;
    /**
     * BrandBean缓存主Key:参数 id
     */
    public static final String CACHE_KEY_BRAND_ENTITY_ID = "brand_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * BlacklistBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_BLACKLIST_ENTITY_ID = "blacklist_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * NoticeBean 对象缓存的主key : 参数 id
     */
    public static final String CACHE_KEY_NOTICE_ENTITY_ID = "notice_id_%s" + CACHE_KEY_ENTITY_GLOBAL_VERSION;

    /**
     * 验证码cache的key前缀
     */
    public static final String CACHE_KEY_CAP_PREFIX = "cap_";

    /**
     * iPad banner图片类型
     */
    public static final int PIC_TYPE_IPAD = 9;

}
