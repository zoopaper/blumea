package org.stream.entity;

import org.stream.entity.base.IMybatisEntity;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 0:05
 */
public class EntryBean extends IMybatisEntity {

    private long id;
    private int pid;                //	父栏目ID
    private String title;            //	标题
    private String subhead;            //	副标题
    private String content;            //	正文内容
    private Timestamp ctime;        //	创建时间
    private Timestamp uptime;        //	修改时间
    private int priority = 60;        //	权重
    private int status;
    private int channelId;            //	频道
    private int mediaId;        //	媒体Id
    private String author;        //	作者
    private int editor;                //	编辑
    private int dutyEditor;        //	责任编辑
    private String url;                //	生成的静态永久地址
    private String category;    //	目录id
    private String shortName;        //	短引用
    private String keyword;            //	关键词
    private List<Long> pictures;        //	图片id list
    private String reurl;            //	跳转链接
    private String tags;            //	tag
}
