package com.dwy.es.model;

import com.dwy.es.annotation.Search;
import com.dwy.es.enums.BoolType;
import com.dwy.es.enums.BoundType;
import com.dwy.es.enums.OperatorType;

import java.io.Serializable;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 14:02
 */
public class DemandQueryCondition extends ClueQueryCondition implements Serializable {
    private static final long serialVersionUID = 1173465274466780444L;

    @Search(boolType = BoolType.Term)
    private String intention;

    @Search(boolType = BoolType.Term)
    private String intentionProvince;

    @Search(boolType = BoolType.Term)
    private String intentionCity;

    @Search(boolType = BoolType.Term)
    private String intentionDistrict;

    @Search(boolType = BoolType.Term)
    private String purpose;

    @Search(boolType = BoolType.Range , fieldName = "areaRequirement" , bound = BoundType.Start)
    private Double areaRequirementStart;

    @Search(boolType = BoolType.Range , fieldName = "areaRequirement" , bound = BoundType.End)
    private Double areaRequirementEnd;

    @Search(boolType = BoolType.Range , fieldName = "floorHeight" , bound = BoundType.Start)
    private Integer floorHeightStart;


    @Search(boolType = BoolType.Range , fieldName = "floorHeight" , bound = BoundType.End)
    private Integer floorHeightEnd;

    @Search(boolType = BoolType.Range , fieldName = "bearing" , bound = BoundType.Start)
    private Double bearingStart;

    @Search(boolType = BoolType.Range , fieldName = "bearing" , bound = BoundType.End)
    private Double bearingEnd;

    @Search(boolType = BoolType.Range , fieldName = "electricityConsumption" , bound = BoundType.Start)
    private Double electricityConsumptionStart;

    @Search(boolType = BoolType.Range , fieldName = "electricityConsumption" , bound = BoundType.End)
    private Double electricityConsumptionEnd;

    @Search(boolType = BoolType.Term)
    private String matchingRequirement;

    @Search(boolType = BoolType.Term)
    private String specialRequirement;


    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getAreaRequirementStart() {
        return areaRequirementStart;
    }

    public void setAreaRequirementStart(Double areaRequirementStart) {
        this.areaRequirementStart = areaRequirementStart;
    }

    public Double getAreaRequirementEnd() {
        return areaRequirementEnd;
    }

    public void setAreaRequirementEnd(Double areaRequirementEnd) {
        this.areaRequirementEnd = areaRequirementEnd;
    }

    public Integer getFloorHeightStart() {
        return floorHeightStart;
    }

    public void setFloorHeightStart(Integer floorHeightStart) {
        this.floorHeightStart = floorHeightStart;
    }

    public Integer getFloorHeightEnd() {
        return floorHeightEnd;
    }

    public void setFloorHeightEnd(Integer floorHeightEnd) {
        this.floorHeightEnd = floorHeightEnd;
    }

    public Double getBearingStart() {
        return bearingStart;
    }

    public void setBearingStart(Double bearingStart) {
        this.bearingStart = bearingStart;
    }

    public Double getBearingEnd() {
        return bearingEnd;
    }

    public void setBearingEnd(Double bearingEnd) {
        this.bearingEnd = bearingEnd;
    }

    public Double getElectricityConsumptionStart() {
        return electricityConsumptionStart;
    }

    public void setElectricityConsumptionStart(Double electricityConsumptionStart) {
        this.electricityConsumptionStart = electricityConsumptionStart;
    }

    public Double getElectricityConsumptionEnd() {
        return electricityConsumptionEnd;
    }

    public void setElectricityConsumptionEnd(Double electricityConsumptionEnd) {
        this.electricityConsumptionEnd = electricityConsumptionEnd;
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

    @Override
    public void setDifLevelOperatorType() {
        difLevelOperatorMap.put(0, OperatorType.Must);
    }
}
