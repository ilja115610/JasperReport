package ee.airest.airest.domain.dto;

import javax.validation.constraints.NotBlank;

public class FormRequestDTO {


    @NotBlank(message = "Field cannot be blank!")
    private String authority;
    @NotBlank(message = "Field cannot be blank!")
    private String trackingNumber;
    @NotBlank(message = "Field cannot be blank!")
    private String orgNameAndAddress;
    @NotBlank(message = "Field cannot be blank!")
    private String workOrder;
    @NotBlank(message = "Field cannot be blank!")
    private String item;
    @NotBlank(message = "Field cannot be blank!")
    private String description;
    @NotBlank(message = "Field cannot be blank!")
    private String partNo;
    @NotBlank(message = "Field cannot be blank!")
    private String qty;
    @NotBlank(message = "Field cannot be blank!")
    private String serialNo;
    @NotBlank(message = "Field cannot be blank!")
    private String status;
    @NotBlank(message = "Field cannot be blank!")
    private String remarks;
    @NotBlank(message = "Field cannot be blank!")
    private String signature;
    @NotBlank(message = "Field cannot be blank!")
    private String approvalRef;
    @NotBlank(message = "Field cannot be blank!")
    private String name;
    @NotBlank(message = "Field cannot be blank!")
    private String date;


    public FormRequestDTO() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getOrgNameAndAddress() {
        return orgNameAndAddress;
    }

    public void setOrgNameAndAddress(String orgNameAndAddress) {
        this.orgNameAndAddress = orgNameAndAddress;
    }

    public String getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(String workOrder) {
        this.workOrder = workOrder;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getApprovalRef() {
        return approvalRef;
    }

    public void setApprovalRef(String approvalRef) {
        this.approvalRef = approvalRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
