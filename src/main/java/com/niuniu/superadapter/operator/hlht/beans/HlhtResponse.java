package com.niuniu.superadapter.operator.hlht.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.niuniu.superadapter.platform.params.StationInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex.Chen on 2016/12/15.
 */


public class HlhtResponse {

    @JsonProperty(value = "PageNo")
    private String pageNo;
    @JsonProperty(value = "PageCount")
    private String pageCount;
    @JsonProperty(value = "ItemSize")
    private String itemSize;
    @JsonProperty(value = "StationInfos")
    private List<StationInfo> stationInfos;


    public List<StationInfo> getStationInfos() {
        return stationInfos;
    }

    public void setStationInfos(List<StationInfo> stationInfos) {
        this.stationInfos = stationInfos;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }
}
