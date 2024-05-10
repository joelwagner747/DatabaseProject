package App.Domain;

import java.util.List;

public class Quote {
    private int quoteId;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String quoteState;
    private String dateOfCreation;
    private String startAvailable;
    private String endAvailable;
    private String quoteEmployeeNote;
    private String quoteCustomerNote;
    private List<ServiceQuote> serviceQuotes;
    private Customer customer = new Customer();

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public void setQuoteState(String quoteState) {
        this.quoteState = quoteState;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setStartAvailable(String startAvailable) {
        this.startAvailable = startAvailable;
    }

    public void setEndAvailable(String endAvailable) {
        this.endAvailable = endAvailable;
    }

    public void setQuoteEmployeeNote(String quoteEmployeeNote) {
        this.quoteEmployeeNote = quoteEmployeeNote;
    }

    public void setQuoteCustomerNote(String quoteCustomerNote) {
        this.quoteCustomerNote = quoteCustomerNote;
    }

    public void setServiceQuotes(List<ServiceQuote> serviceQuotes) {
        this.serviceQuotes = serviceQuotes;
    }

    public List<ServiceQuote> getServiceQuotes() {
        return this.serviceQuotes;
    }

    public int getQuoteId() {
        return this.quoteId;
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

    public String getQuoteState() {
        return this.quoteState;
    }

    public String getDateOfCreation() {
        return this.dateOfCreation;
    }

    public String getStartAvailable() {
        return this.startAvailable;
    }

    public String getEndAvailable() {
        return this.endAvailable;
    }

    public String getQuoteEmployeeNote() {
        return this.quoteEmployeeNote;
    }

    public String getQuoteCustomerNote() {
        return this.quoteCustomerNote;
    }

    public Customer getCustomer() {
        return this.customer;
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

}
