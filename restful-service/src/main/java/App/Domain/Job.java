package App.Domain;

import java.util.List;

public class Job {
    private int jobId;
    private String jobDate;
    private String jobTime;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private boolean jobCompleted;
    private String jobEmployeeNote;
    private String jobCustomerNote;
    private List<ServicePrice> services;
    private List<SpecialEquipUses> specialEquipUses;
    private Customer customer = new Customer();

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public void setStreetAddress(String streetAdress) {
        this.streetAddress = streetAdress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setJobCompleted(boolean jobCompleted) {
        this.jobCompleted = jobCompleted;
    }

    public void setJobEmployeeNote(String jobEmployeeNote) {
        this.jobEmployeeNote = jobEmployeeNote;
    }

    public void setJobCustomerNote(String jobCustomerNote) {
        this.jobCustomerNote = jobCustomerNote;
    }

    public void setCustomerId(int customerId) {
        this.customer.setCustomerId(customerId);
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customer.setCustomerFirstName(customerFirstName);
    }

    public void setCustomerLastName(String customerLastName) {
        this.customer.setCustomerLastName(customerLastName);
    }

    public void setBillingStreetAddress(String billingStreetAddress) {
        this.customer.setStreetAddress(billingStreetAddress);
    }

    public void setBillingCity(String billingCity) {
        this.customer.setCity(billingCity);
    }

    public void setBillingState(String billingState) {
        this.customer.setState(billingState);
    }

    public void setBillingZipCode(String billingZipCode) {
        this.customer.setZipCode(billingZipCode);
    }

    public void setCustomerPhoneNum(String customerPhoneNum) {
        this.customer.setCustomerPhoneNum(customerPhoneNum);
    }

    public void setCustomerEmail(String customerEmail) {
        this.customer.setCustomerEmail(customerEmail);
    }

    public void setService(List<ServicePrice> services) {
        this.services = services;
    }

    public void setSpecialEquipUses(List<SpecialEquipUses> specialEquipUses) {
        this.specialEquipUses = specialEquipUses;
    }

    public List<SpecialEquipUses> getSpecialEquipUses() {
        return this.specialEquipUses;
    }

    public List<ServicePrice> getServices() {
        return this.services;
    }

    public int getJobId() {
        return this.jobId;
    }

    public String getJobDate() {
        return this.jobDate;
    }

    public String getJobTime() {
        return this.jobTime;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public boolean getJobCompleted() {
        return this.jobCompleted;
    }

    public String getJobEmployeeNote() {
        return this.jobEmployeeNote;
    }

    public String getJobCustomerNote() {
        return this.jobCustomerNote;
    }

    public Customer getCustomer() {
        return this.customer;
    }

}
