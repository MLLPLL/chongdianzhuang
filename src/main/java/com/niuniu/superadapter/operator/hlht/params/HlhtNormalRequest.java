package com.niuniu.superadapter.operator.hlht.params;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Alex.Chen on 2016/12/15.
 */
public class HlhtNormalRequest {
    @JsonProperty(value = "OperatorID")
    private String operatorID;
    @JsonProperty(value = "Data")
    private String data;
    @JsonProperty(value = "Sig")
    private String sig;
    @JsonProperty(value = "TimeStamp")
    private String timeStamp;
    @JsonProperty(value = "Seq")
    private String seq;

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
