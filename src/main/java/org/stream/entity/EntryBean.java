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

    /**
     * 栏目
     */
    private int subjectId;

    private String title;

    private String subhead;

    private String content;

    private Timestamp ctime;

    private Timestamp uptime;

    private int priority = 60;

    private int status;
    /**
     * 频道
     */
    private int channelId;

    /**
     * 媒体
     */
    private int mediaId;
    /**
     * 作者
     */
    private String author;
    /**
     * 编辑
     */
    private int editor;
    /**
     * 责任编辑
     */
    private int dutyEditor;
    /**
     *
     */
    private String url;

    private String category;

    private String shortName;
    /**
     * 关键字
     */
    private String keyword;

    private List<Long> pictures;

    private String reurl;
    /**
     * 标签
     */
    private String tags;
    /**
     * 摘要
     */
    private String summary;
}
