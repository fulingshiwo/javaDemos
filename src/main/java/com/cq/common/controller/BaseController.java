/* =============================================================
 * Created: [2016年3月25日] by ZhengChen
 * =============================================================
 *
 * Copyright 2014-2015 NetDragon Websoft Inc. All Rights Reserved
 *
 * =============================================================
 */

package com.cq.common.controller;

/**
 * @author ZhengChen
 * @since 0.1.0
 */

public class BaseController {

    // 返回成功
    public static final int SUCCESS = 1;
    // 返回失败
    public static final int ERROR = 0;

    // 操作状态参数名称
    public static final String STATUS_PARAMETER_NAME = "status";
    // 操作消息参数名称
    public static final String MESSAGE_PARAMETER_NAME = "message";

    // 操作状态（警告、错误、成功）
    public enum Status {
                        warn, error, success
    }

    protected Long id;
    protected Long[] ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }

}
