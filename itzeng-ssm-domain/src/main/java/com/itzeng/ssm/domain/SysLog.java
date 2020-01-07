package com.itzeng.ssm.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.domain
 */

public class SysLog {
    private String id;
    private Date visitime;
    private String visitTimeStr;
    private String name;
    private String ip;
    private String url;
    private long executionTime;
    private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitime() {
        return visitime;
    }

    public void setVisitime(Date visitime) {
        this.visitime = visitime;
    }

    public String getVisitTimeStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(visitime);
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
