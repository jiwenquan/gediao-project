package com.gedia.sms.studentmanagementsystem.entity;

import java.util.Date;

/**
 * 考试
 *
 * @author jiwenquan
 * @create 2018/6/28 12:49
 */
public class Examination {
    /**
     * 主键id
     */
    private String id;
    /**
     * 考试概要
     */
    private String summary;
    /**
     * 描述
     */
    private String description;
    private Date created;
    private Date updated;
    private String createUser;
    private String updateUser;
}
