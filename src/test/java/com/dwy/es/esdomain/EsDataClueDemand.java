package com.dwy.es.esdomain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: DongWenYu
 * @Date: 2021/6/3 13:45
 */
@Document(indexName = "elib",type = "data_clue_demand")
public class EsDataClueDemand implements Serializable {

    private static final long serialVersionUID = 2541697196880275622L;
    /**
     * 企业id
     */
    @Id()
    private Long id;

    /**
     * 营业执照号
     */
    @Field(type = FieldType.Keyword)
    private String license;

    /**
     * 发证机关
     */
    @Field(type = FieldType.Keyword)
    private String certificateAuthority;

    /**
     * 核准日期
     */
    @Field(type = FieldType.Keyword)
    private String approvalDate;

    /**
     * 经营期限
     */
    @Field(type = FieldType.Keyword)
    private String operationTerm;

    /**
     * 类型，线索和需求的标识符，1为线索，2为需求
     */
    @Field(type = FieldType.Keyword)
    private String informationType;

    /**
     * 企业名称
     */
    @Field(type = FieldType.Keyword)
    private String enterpriseName;

    /**
     * 企业名称缩写
     */
    @Field(type = FieldType.Keyword,fielddata = true)
    private String enterpriseNameInitials;

    /**
     * 企业曾用名
     */
    @Field(type = FieldType.Keyword)
    private String enterpriseUsedName;

    /**
     * 企业简介
     */
    @Field(type = FieldType.Keyword)
    private String enterpriseIntroduction;

    /**
     * 联系人
     */
    @Field(type = FieldType.Keyword)
    private String contacts;

    /**
     * 联系电话
     */
    @Field(type = FieldType.Keyword)
    private String contactNumber;

    /**
     * 邮箱
     */
    @Field(type = FieldType.Keyword)
    private String email;

    /**
     * 在线qq咨询
     */
    @Field(type = FieldType.Keyword)
    private String contactQq;

    /**
     * 邮政编码
     */
    @Field(type = FieldType.Keyword)
    private String contactPostcode;

    /**
     * 经营状态
     */
    @Field(type = FieldType.Keyword,fielddata = true)
    private String operationStatus;

    /**
     * 经营模式
     */
    @Field(type = FieldType.Keyword)
    private String operationMode;

    /**
     * 行业分类
     */
    @Field(type = FieldType.Keyword)
    private String industryCategory;

    /**
     * 行业代码
     */
    @Field(type = FieldType.Keyword)
    private String categoryCode;

    /**
     * 所属省份
     */
    @Field(type = FieldType.Keyword)
    private String province;

    /**
     * 所属城市
     */
    @Field(type = FieldType.Keyword)
    private String city;

    /**
     * 所属区县
     */
    @Field(type = FieldType.Keyword)
    private String district;

    /**
     * 注册地址
     */
    @Field(type = FieldType.Keyword)
    private String registerAddress;

    /**
     * 商铺
     */
    @Field(type = FieldType.Keyword)
    private String shop;

    /**
     * product
     */
    @Field(type = FieldType.Keyword)
    private String product;

    /**
     * 经营范围
     */
    @Field(type = FieldType.Keyword)
    private String businessNature;

    /**
     * 注册资本
     */
    @Field(type = FieldType.Keyword)
    private String registeredCapital;

    /**
     * 注册资本区间code
     */
    @Field(type = FieldType.Keyword)
    private String registeredCapitalSection;

    /**
     * 实缴资本
     */
    @Field(type = FieldType.Keyword)
    private String paidInCapital;

    /**
     * 成立日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Field(type = FieldType.Date,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date establishDate;

    @Field(type = FieldType.Keyword,fielddata = true)
    private Long establishDateSort;
    /**
     * 法定代表人
     */
    @Field(type = FieldType.Keyword)
    private String legalRepresentative;

    /**
     * 股东
     */
    @Field(type = FieldType.Keyword)
    private String shareholderName;

    /**
     * 公司类型
     */
    @Field(type = FieldType.Keyword)
    private String enterpriseType;

    /**
     * 公司规模
     */
    @Field(type = FieldType.Keyword)
    private String enterpriseScale;

    /**
     * 公司规模区间code
     */
    @Field(type = FieldType.Keyword)
    private String enterpriseScaleSection;

    /**
     * 参保人数
     */
    @Field(type = FieldType.Keyword)
    private String numberOfInsured;

    /**
     * 参保人数区间code
     */
    @Field(type = FieldType.Keyword)
    private String numberOfInsuredSection;

    /**
     * 年营业额
     */
    @Field(type = FieldType.Keyword)
    private String annualTurnover;

    /**
     * 是否高新技术企业
     */
    @Field(type = FieldType.Keyword)
    private String highTechEnterprise;

    /**
     * 是否有自研团队
     */
    @Field(type = FieldType.Keyword)
    private String selfResearchTeam;

    /**
     * 是否独角兽企业
     */
    @Field(type = FieldType.Keyword)
    private String unicornEnterprise;

    /**
     * 是否中国500强
     */
    @Field(type = FieldType.Keyword)
    private String chinaTop500;

    /**
     * 是否世界500强
     */
    @Field(type = FieldType.Keyword)
    private String worldTop500;

    /**
     * 是否小微企业
     */
    @Field(type = FieldType.Keyword)
    private String microEnterprise;

    /**
     * 有无年报
     */
    @Field(type = FieldType.Keyword)
    private String annualReport;

    /**
     * 有无工商变更
     */
    @Field(type = FieldType.Keyword)
    private String businessModify;

    /**
     * 有无分支机构
     */
    @Field(type = FieldType.Keyword)
    private String branch;

    /**
     * 有无招聘信息
     */
    @Field(type = FieldType.Keyword)
    private String recruitmentInformation;

    /**
     * 有无网址信息
     */
    @Field(type = FieldType.Keyword)
    private String websiteInformation;

    /**
     * 网址
     */
    @Field(type = FieldType.Keyword)
    private String website;

    /**
     * 专利类型
     */
    @Field(type = FieldType.Keyword)
    private String patentType;

    /**
     * 资质证书
     */
    @Field(type = FieldType.Keyword)
    private String qualificationCertificate;

    /**
     * 在园项目
     */
    @Field(type = FieldType.Keyword)
    private String inPark;

    /**
     * 渠道来源
     */
    @Field(type = FieldType.Keyword)
    private String channelSource;

    /**
     * 具体渠道来源
     */
    @Field(type = FieldType.Keyword)
    private String detailChannelSource;

    /**
     * 推荐人
     */
    @Field(type = FieldType.Long)
    private Long recommendPerson;

    /**
     * 分配状态
     */
    @Field(type = FieldType.Keyword ,fielddata = true)
    private String allocationStatus;

    /**
     * 分配日期
     */
    @Field(type = FieldType.Keyword)
    private String allocationDate;

    /**
     * 导出次数
     */
    @Field(type = FieldType.Integer)
    private Integer exportCount;

    /**
     * 导出人员
     */
    @Field(type = FieldType.Keyword)
    private String exportPeople;

    /**
     * 反馈状态
     */
    @Field(type = FieldType.Keyword)
    private String feedbackStatus;

    /**
     * 负责人
     */
    @Field(type = FieldType.Long)
    private Long responsiblePerson;

    /**
     * 交谈内容
     */
    @Field(type = FieldType.Keyword)
    private String conversationContent;

    /**
     * 组织
     */
    @Field(type = FieldType.Keyword)
    private String organization;

    /**
     * 意向（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String intention;

    /**
     * 意向区域（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String intentionArea;

    /**
     * 意向省份（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String intentionProvince;

    /**
     * 意向城市（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String intentionCity;

    /**
     * 意向区县（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String intentionDistrict;

    /**
     * 功能用途（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String purpose;

    /**
     * 面积需求（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String areaRequirement;

    /**
     * 层高（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String floorHeight;

    /**
     * 承重（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String bearing;

    /**
     * 用电量（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String electricityConsumption;

    /**
     * 配套需求（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String matchingRequirement;

    /**
     * 意向园区（属于需求）
     */
    @Field(type = FieldType.Keyword)
    private String intentionPark;

    /**
     * 其他
     */
    @Field(type = FieldType.Keyword)
    private String other;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Field(type = FieldType.Date,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCertificateAuthority() {
        return certificateAuthority;
    }

    public void setCertificateAuthority(String certificateAuthority) {
        this.certificateAuthority = certificateAuthority;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getOperationTerm() {
        return operationTerm;
    }

    public void setOperationTerm(String operationTerm) {
        this.operationTerm = operationTerm;
    }

    public String getInformationType() {
        return informationType;
    }

    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseNameInitials() {
        return enterpriseNameInitials;
    }

    public void setEnterpriseNameInitials(String enterpriseNameInitials) {
        this.enterpriseNameInitials = enterpriseNameInitials;
    }

    public String getEnterpriseUsedName() {
        return enterpriseUsedName;
    }

    public void setEnterpriseUsedName(String enterpriseUsedName) {
        this.enterpriseUsedName = enterpriseUsedName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactQq() {
        return contactQq;
    }

    public void setContactQq(String contactQq) {
        this.contactQq = contactQq;
    }

    public String getContactPostcode() {
        return contactPostcode;
    }

    public void setContactPostcode(String contactPostcode) {
        this.contactPostcode = contactPostcode;
    }

    public String getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(String operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

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

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public String getRegisteredCapitalSection() {
        return registeredCapitalSection;
    }

    public void setRegisteredCapitalSection(String registeredCapitalSection) {
        this.registeredCapitalSection = registeredCapitalSection;
    }

    public String getPaidInCapital() {
        return paidInCapital;
    }

    public void setPaidInCapital(String paidInCapital) {
        this.paidInCapital = paidInCapital;
    }

    public Date getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
        if (establishDate != null){
            this.setEstablishDateSort(establishDate.getTime());
        }
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
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

    public String getEnterpriseScaleSection() {
        return enterpriseScaleSection;
    }

    public void setEnterpriseScaleSection(String enterpriseScaleSection) {
        this.enterpriseScaleSection = enterpriseScaleSection;
    }

    public String getNumberOfInsured() {
        return numberOfInsured;
    }

    public void setNumberOfInsured(String numberOfInsured) {
        this.numberOfInsured = numberOfInsured;
    }

    public String getNumberOfInsuredSection() {
        return numberOfInsuredSection;
    }

    public void setNumberOfInsuredSection(String numberOfInsuredSection) {
        this.numberOfInsuredSection = numberOfInsuredSection;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getInPark() {
        return inPark;
    }

    public void setInPark(String inPark) {
        this.inPark = inPark;
    }

    public String getChannelSource() {
        return channelSource;
    }

    public void setChannelSource(String channelSource) {
        this.channelSource = channelSource;
    }

    public String getDetailChannelSource() {
        return detailChannelSource;
    }

    public void setDetailChannelSource(String detailChannelSource) {
        this.detailChannelSource = detailChannelSource;
    }

    public Long getRecommendPerson() {
        return recommendPerson;
    }

    public void setRecommendPerson(Long recommendPerson) {
        this.recommendPerson = recommendPerson;
    }

    public String getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(String allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public String getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(String allocationDate) {
        this.allocationDate = allocationDate;
    }

    public Integer getExportCount() {
        return exportCount;
    }

    public void setExportCount(Integer exportCount) {
        this.exportCount = exportCount;
    }

    public String getExportPeople() {
        return exportPeople;
    }

    public void setExportPeople(String exportPeople) {
        this.exportPeople = exportPeople;
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

    public String getConversationContent() {
        return conversationContent;
    }

    public void setConversationContent(String conversationContent) {
        this.conversationContent = conversationContent;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getIntentionArea() {
        return intentionArea;
    }

    public void setIntentionArea(String intentionArea) {
        this.intentionArea = intentionArea;
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

    public String getIntentionPark() {
        return intentionPark;
    }

    public void setIntentionPark(String intentionPark) {
        this.intentionPark = intentionPark;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getEstablishDateSort() {
        return establishDateSort;
    }

    public void setEstablishDateSort(Long establishDateSort) {
        this.establishDateSort = establishDateSort;
    }

    public EsDataClueDemand() {}
}
