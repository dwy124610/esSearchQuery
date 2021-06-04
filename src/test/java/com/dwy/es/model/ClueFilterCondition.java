package com.dwy.es.model;

import com.dwy.es.util.StringUtil;

import java.io.Serializable;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 13:46
 */
public class ClueFilterCondition  implements Serializable {
    private static final long serialVersionUID = 3199273803694408445L;
    private String enterpriseName;
    private String enterpriseIntroduction;
    private String contacts;
    private String contactNumber;
    private String operationStatus;
    private String industryCategory;
    private String province;
    private String city;
    private String district;
    private String area;
    private String enterpriseAddress;
    private String businessNature;
    private String registeredCapital;
    private String paidInCapital;
    private String establishDate;
    private String shareholderName;
    private String enterpriseType;
    private String enterpriseScale;
    private String numberOfInsured;
    private String annualTurnover;
    private String highTechEnterprise;
    private String selfResearchTeam;
    private String unicornEnterprise;
    private String chinaTop500;
    private String worldTop500;
    private String microEnterprise;
    private String annualReport;
    private String businessModify;
    private String branch;
    private String recruitmentInformation;
    private String websiteInformation;
    private String patentType;
    private String qualificationCertificate;
    private String allocationStatus;
    private String feedbackStatus;
    private Long responsiblePerson;
    private String inPark;

    private String industryCategorySelect;

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
        setIndustryCategorySelct(industryCategory);
        this.industryCategory = industryCategory;
    }

    public String getIndustryCategorySelect() {
        return industryCategorySelect;
    }

    public void setIndustryCategorySelct(String industryCategorySelect) {
        if (!StringUtil.isEmpty(industryCategorySelect) && industryCategorySelect.endsWith("00")){
            this.industryCategorySelect = industryCategorySelect.substring(0,industryCategorySelect.lastIndexOf("00"));
        }else {
            this.industryCategorySelect = industryCategorySelect;
        }
    }

    public String getProvince() {
        return province;
    }

    public static void main(String[] args) {
        System.out.println("010000".lastIndexOf("00"));
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

    public String getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(String registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(String paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
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

    public String getEnterpriseScale() {
        return enterpriseScale;
    }

    public void setEnterpriseScale(String enterpriseScale) {
        this.enterpriseScale = enterpriseScale;
    }

    public String getNumberOfInsured() {
        return numberOfInsured;
    }

    public void setNumberOfInsured(String numberOfInsured) {
        this.numberOfInsured = numberOfInsured;
    }

    public String getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(String annualTurnover) {
        this.annualTurnover = annualTurnover;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
        if (!StringUtil.isEmpty(area)){
            String[] split = area.split(",");
            if (split.length == 3){
                if ("0".equals(split[2])){
                    this.setDistrict(null);
                }else {
                    this.setDistrict(split[2]);
                }

                if("0".equals(split[1])){
                    this.setDistrict(null);
                    this.setCity(null);
                }else {
                    this.setCity(split[1]);
                }

                this.setProvince(split[0]);
            }

            if (split.length == 2){
                this.setProvince(split[0]);
                if ("0".equals(split[1])){
                    this.setDistrict(null);
                    this.setCity(null);
                }else {
                    this.setDistrict(split[1]);
                }
                if("0".equals(split[0])){
                    this.setDistrict(null);
                    this.setCity(null);
                    this.setProvince(null);
                }
            }
        }
    }
}

