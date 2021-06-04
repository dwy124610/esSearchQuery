package com.dwy.es.model;

import com.dwy.es.annotation.Search;
import com.dwy.es.enums.BoolType;
import com.dwy.es.enums.BoundType;
import com.dwy.es.enums.DirectionType;
import com.dwy.es.enums.OperatorType;
import com.dwy.es.metadata.AbstractBaseCondition;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 13:48
 */
public class ClueQueryCondition  extends AbstractBaseCondition implements Serializable {
    private static final long serialVersionUID = 8327270029843097708L;
    @Search(boolType = BoolType.WildCard , level = 1)
    private String enterpriseName;

    @Search(boolType = BoolType.WildCard)
    private String enterpriseIntroduction;

    @Search(boolType = BoolType.WildCard , level = 1)
    private String contacts;

    @Search(boolType = BoolType.WildCard , operator = OperatorType.MustNot)
    private String contactNumber;

    @Search(boolType = BoolType.Term)
    private String operationStatus;

    private String industryCategory;

    @Search(boolType = BoolType.Term , level = 2)
    private String province;

    @Search(boolType = BoolType.Term , level = 2)
    private String city;

    @Search(boolType = BoolType.Term , level = 2)
    private String district;

    @Search(boolType = BoolType.Term , operator = OperatorType.Should)
    private String enterpriseAddress;

    @Search(boolType = BoolType.Term)
    private String businessNature;

    @Search(boolType = BoolType.Term)
    private String registeredCapitalSection;

    @Search(boolType = BoolType.Range , fieldName = "paidInCapital" , bound = BoundType.Start)
    private Double paidInCapitalStart;

    @Search(boolType = BoolType.Range , fieldName = "paidInCapital" , bound = BoundType.End)
    private Double paidInCapitalEnd;

    private String establishDateStart;

    @Search(boolType = BoolType.Range , fieldName = "establishDateSort" , bound = BoundType.Start)
    private Long establishDateStartLong;

    private String establishDateEnd;

    @Search(boolType = BoolType.Range , fieldName = "establishDateSort" , bound = BoundType.End)
    private Long establishDateEndLong;

    @Search(boolType = BoolType.WildCard)
    private String shareholderName;

    @Search(boolType = BoolType.Term)
    private String enterpriseType;

    @Search(boolType = BoolType.Term)
    private String enterpriseScaleSection;

    @Search(boolType = BoolType.Term)
    private String numberOfInsuredSection;

    @Search(boolType = BoolType.Range , fieldName = "annualTurnover" , bound = BoundType.Start)
    private Double annualTurnoverStart;

    @Search(boolType = BoolType.Range , fieldName = "annualTurnover" , bound = BoundType.End)
    private Double annualTurnoverEnd;

    @Search(boolType = BoolType.Term)
    private String highTechEnterprise;

    @Search(boolType = BoolType.Term)
    private String selfResearchTeam;

    @Search(boolType = BoolType.Term)
    private String unicornEnterprise;

    @Search(boolType = BoolType.Term)
    private String chinaTop500;

    @Search(boolType = BoolType.Term)
    private String worldTop500;

    @Search(boolType = BoolType.Term)
    private String microEnterprise;

    @Search(boolType = BoolType.Term)
    private String annualReport;

    @Search(boolType = BoolType.Term)
    private String businessModify;

    @Search(boolType = BoolType.Term)
    private String branch;

    @Search(boolType = BoolType.Term)
    private String recruitmentInformation;

    @Search(boolType = BoolType.Term)
    private String websiteInformation;

    @Search(boolType = BoolType.Term)
    private String patentType;

    @Search(boolType = BoolType.Term)
    private String qualificationCertificate;

    @Search(boolType = BoolType.Term)
    private String allocationStatus;

    @Search(boolType = BoolType.Term)
    private String feedbackStatus;

    @Search(boolType = BoolType.Term)
    private Long responsiblePerson;

    @Search(boolType = BoolType.Term)
    private String inPark;

    @Search(boolType = BoolType.WildCard , direction = DirectionType.Right , fieldName = "industryCategory")
    private String industryCategorySelect;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseIntroduction() {
        return enterpriseIntroduction;
    }

    public void setEnterpriseIntroduction(String enterpriseIntroduction) {
        this.enterpriseIntroduction = enterpriseIntroduction;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public String getRegisteredCapitalSection() {
        return registeredCapitalSection;
    }

    public void setRegisteredCapitalSection(String registeredCapitalSection) {
        this.registeredCapitalSection = registeredCapitalSection;
    }

    public String getEnterpriseScaleSection() {
        return enterpriseScaleSection;
    }

    public void setEnterpriseScaleSection(String enterpriseScaleSection) {
        this.enterpriseScaleSection = enterpriseScaleSection;
    }

    public String getNumberOfInsuredSection() {
        return numberOfInsuredSection;
    }

    public void setNumberOfInsuredSection(String numberOfInsuredSection) {
        this.numberOfInsuredSection = numberOfInsuredSection;
    }

    public Double getPaidInCapitalStart() {
        return paidInCapitalStart;
    }

    public void setPaidInCapitalStart(Double paidInCapitalStart) {
        this.paidInCapitalStart = paidInCapitalStart;
    }

    public Double getPaidInCapitalEnd() {
        return paidInCapitalEnd;
    }

    public void setPaidInCapitalEnd(Double paidInCapitalEnd) {
        this.paidInCapitalEnd = paidInCapitalEnd;
    }

    public String getEstablishDateStart() {
        return establishDateStart;
    }

    public void setEstablishDateStart(String establishDateStart) throws ParseException {
        this.establishDateStart = establishDateStart;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.setEstablishDateStartLong(simpleDateFormat.parse(establishDateStart).getTime());
    }

    public String getEstablishDateEnd() {
        return establishDateEnd;
    }

    public void setEstablishDateEnd(String establishDateEnd) throws ParseException {
        this.establishDateEnd = establishDateEnd;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.setEstablishDateEndLong(simpleDateFormat.parse(establishDateEnd).getTime());
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }


    public Double getAnnualTurnoverStart() {
        return annualTurnoverStart;
    }

    public void setAnnualTurnoverStart(Double annualTurnoverStart) {
        this.annualTurnoverStart = annualTurnoverStart;
    }

    public Double getAnnualTurnoverEnd() {
        return annualTurnoverEnd;
    }

    public void setAnnualTurnoverEnd(Double annualTurnoverEnd) {
        this.annualTurnoverEnd = annualTurnoverEnd;
    }

    public String getHighTechEnterprise() {
        return highTechEnterprise;
    }

    public void setHighTechEnterprise(String highTechEnterprise) {
        this.highTechEnterprise = highTechEnterprise;
    }

    public String getSelfResearchTeam() {
        return selfResearchTeam;
    }

    public void setSelfResearchTeam(String selfResearchTeam) {
        this.selfResearchTeam = selfResearchTeam;
    }

    public String getUnicornEnterprise() {
        return unicornEnterprise;
    }

    public void setUnicornEnterprise(String unicornEnterprise) {
        this.unicornEnterprise = unicornEnterprise;
    }

    public String getChinaTop500() {
        return chinaTop500;
    }

    public void setChinaTop500(String chinaTop500) {
        this.chinaTop500 = chinaTop500;
    }

    public String getWorldTop500() {
        return worldTop500;
    }

    public void setWorldTop500(String worldTop500) {
        this.worldTop500 = worldTop500;
    }

    public String getMicroEnterprise() {
        return microEnterprise;
    }

    public void setMicroEnterprise(String microEnterprise) {
        this.microEnterprise = microEnterprise;
    }

    public String getAnnualReport() {
        return annualReport;
    }

    public void setAnnualReport(String annualReport) {
        this.annualReport = annualReport;
    }

    public String getBusinessModify() {
        return businessModify;
    }

    public void setBusinessModify(String businessModify) {
        this.businessModify = businessModify;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRecruitmentInformation() {
        return recruitmentInformation;
    }

    public void setRecruitmentInformation(String recruitmentInformation) {
        this.recruitmentInformation = recruitmentInformation;
    }

    public String getWebsiteInformation() {
        return websiteInformation;
    }

    public void setWebsiteInformation(String websiteInformation) {
        this.websiteInformation = websiteInformation;
    }

    public String getPatentType() {
        return patentType;
    }

    public void setPatentType(String patentType) {
        this.patentType = patentType;
    }

    public String getQualificationCertificate() {
        return qualificationCertificate;
    }

    public void setQualificationCertificate(String qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
    }

    public String getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(String allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public String getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(String feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public Long getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(Long responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getInPark() {
        return inPark;
    }

    public void setInPark(String inPark) {
        this.inPark = inPark;
    }

    public String getIndustryCategorySelect() {
        return industryCategorySelect;
    }

    public void setIndustryCategorySelect(String industryCategorySelect) {
        this.industryCategorySelect = industryCategorySelect;
    }

    public Long getEstablishDateStartLong() {
        return establishDateStartLong;
    }

    public void setEstablishDateStartLong(Long establishDateStartLong) {
        this.establishDateStartLong = establishDateStartLong;
    }

    public Long getEstablishDateEndLong() {
        return establishDateEndLong;
    }

    public void setEstablishDateEndLong(Long establishDateEndLong) {
        this.establishDateEndLong = establishDateEndLong;
    }

    @Override
    public void setDifLevelOperatorType() {
        difLevelOperatorMap.put(0, OperatorType.Must);
    }
}

