/* =============================================================
 * Created: [2016年3月15日] by Linsx
 * =============================================================
 *
 * Copyright 2014-2015 NetDragon Websoft Inc. All Rights Reserved
 *
 * =============================================================
 */
package com.cq.common.entity;

import com.cq.common.utils.PropertyNamingStrategyCloud;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

/**
 * @author Lsx
 * @since 0.1.0
 */
@JsonNaming(PropertyNamingStrategyCloud.class)
public class DataResult<T> implements Serializable {

    /**
     * 数据返回格式
     */

    private static final long serialVersionUID = 1675455733501893074L;

    private long totalRecord; // 记录数

    private int totalPage; // 总页数

    private int pageIndex; // 当前页数

    private T data;// 每页数据

    private int code;// 返回的代码 1:成功；0：失败

    private String message;// 返回的信息

    private String errorMessage;// 返回较为友好的错误信息

    private String systemError;//系统的错误信息


    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage == null ? "" : errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getSystemError() {
        return systemError;
    }

    public void setSystemError(String systemError) {
        this.systemError = systemError;
    }

    public DataResult() {
        super();
        this.code = 1;
    }

    /***
     * 成功返回的构造函数(有分页数据)
     *
     * @param totalRecord 当前页数据量
     * @param totalPage   总页数
     * @param pageIndex   当前页数
     * @param data        当前页的数据
     * @param message     返回的信息
     */
    public DataResult(long totalRecord, int totalPage, int pageIndex, T data, String message) {
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.pageIndex = pageIndex;
        this.data = data;
        this.code = 1;
        this.message = message;
    }

    /**
     * 成功返回的构造函数(不含分页数据)
     *
     * @param totalRecord
     * @param data
     * @param message
     */
    public DataResult(long totalRecord, T data, String message) {
        this.totalRecord = totalRecord;
        this.data = data;
        this.totalPage = 1;
        this.pageIndex = 1;
        this.code = 1;
        this.message = message;
    }

    /**
     * 成功返回的构造函数(不含分页数据)
     *
     * @param totalRecord
     * @param data
     * @param message
     */
    public DataResult(long totalRecord, T data, int code, String message) {
        this.totalRecord = totalRecord;
        this.data = data;
        this.totalPage = 1;
        this.pageIndex = 1;
        this.code = code;
        this.message = message;
    }

    /**
     * 旧版本的错误返回的构造函数(适合捕捉到自定义异常时使用)
     *
     * @param errorMessage 错误消息
     */
    public DataResult(String errorMessage) {
        this.code = 0;
        this.errorMessage = errorMessage;
    }

    /**
     * 系统错误时候的返回的构造函数(适合捕捉到系统异常时使用)
     *
     * @param errorMessage 错误消息
     */
    public DataResult(String errorMessage, String systemError) {
        this.code = 0;
        this.errorMessage = errorMessage;
        this.systemError = systemError;
    }


}