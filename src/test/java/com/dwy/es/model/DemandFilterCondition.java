package com.dwy.es.model;

import com.dwy.es.util.StringUtil;

import java.io.Serializable;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 14:01
 */
public class DemandFilterCondition extends ClueFilterCondition implements Serializable {
    private static final long serialVersionUID = 7093515236991556269L;
    private String intention;
    private String intentionProvince;
    private String intentionCity;
    private String intentionDistrict;
    private String intentionArea;
    private String purpose;
    private String areaRequirement;
    private String floorHeight;
    private String bearing;
    private String electricityConsumption;
    private String matchingRequirement;
    private String specialRequirement;

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getIntentionProvince() {
        return intentionProvince;
    }

    public void setIntentionProvince(String intentionProvince) {
        this.intentionProvince = intentionProvince;
    }

    public String getIntentionCity() {
        return intentionCity;
    }

    public void setIntentionCity(String intentionCity) {
        this.intentionCity = intentionCity;
    }

    public String getIntentionDistrict() {
        return intentionDistrict;
    }

    public void setIntentionDistrict(String intentionDistrict) {
        this.intentionDistrict = intentionDistrict;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getAreaRequirement() {
        return areaRequirement;
    }

    public void setAreaRequirement(String areaRequirement) {
        this.areaRequirement = areaRequirement;
    }

    public String getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(String floorHeight) {
        this.floorHeight = floorHeight;
    }

    public String getBearing() {
        return bearing;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    public String getElectricityConsumption() {
        return electricityConsumption;
    }

    public void setElectricityConsumption(String electricityConsumption) {
        this.electricityConsumption = electricityConsumption;
    }

    public String getMatchingRequirement() {
        return matchingRequirement;
    }

    public void setMatchingRequirement(String matchingRequirement) {
        this.matchingRequirement = matchingRequirement;
    }

    public String getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(String specialRequirement) {
        this.specialRequirement = specialRequirement;
    }

    public String getIntentionArea() {
        return intentionArea;
    }

    public void setIntentionArea(String intentionArea) {
        this.intentionArea = intentionArea;
        if (!StringUtil.isEmpty(intentionArea)){
            String[] split = intentionArea.split(",");
            if (split.length == 3){
                if ("0".equals(split[2])){
                    this.setIntentionDistrict(null);
                }else {
                    this.setIntentionDistrict(split[2]);
                }

                if("0".equals(split[1])){
                    this.setIntentionDistrict(null);
                    this.setIntentionCity(null);
                }else {
                    this.setIntentionCity(split[1]);
                }

                this.setIntentionProvince(split[0]);
            }

            if (split.length == 2){
                this.setIntentionProvince(split[0]);
                if ("0".equals(split[1])){
                    this.setIntentionDistrict(null);
                    this.setIntentionCity(null);
                }else {
                    this.setIntentionDistrict(split[1]);
                }
                if("0".equals(split[0])){
                    this.setIntentionDistrict(null);
                    this.setIntentionCity(null);
                    this.setIntentionProvince(null);
                }
            }
        }
    }
}

