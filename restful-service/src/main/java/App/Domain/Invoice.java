package App.Domain;

import java.util.List;

public class Invoice {
    private int invoiceId;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String invoiceDate;
    private boolean invoicePaid;
    private List<ServicePrice> servicesCompleted;
    private Customer customer = new Customer();

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setInvoicePaid(boolean invoicePaid) {
        this.invoicePaid = invoicePaid;
    }

    public void setState(String state) {
        this.state = state;
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

    public void setServicesCompleted(List<ServicePrice> servicesCompleted) {
        this.servicesCompleted = servicesCompleted;
    }

    public List<ServicePrice> getServicesCompleted() {
        return this.servicesCompleted;
    }

    public int getInvoiceId() {
        return this.invoiceId;
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

    public String getInvoiceDate() {
        return this.invoiceDate;
    }

    public boolean getInvoicePaid() {
        return this.invoicePaid;
    }

    public Customer getCustomer() {
        return this.customer;
    }

}
