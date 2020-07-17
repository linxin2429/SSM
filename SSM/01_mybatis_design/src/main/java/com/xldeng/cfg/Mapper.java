package com.xldeng.cfg;

/**
 * @author 邓鑫林
 * @since 2020/7/15 14:46
 * 封装SQL语句和结果类型的全限定类名
 */
public class Mapper {
    //SQL
    private String queryString;
    //全限定类名
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}