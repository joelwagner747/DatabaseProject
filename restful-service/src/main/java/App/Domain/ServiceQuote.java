package App.Domain;

public class ServiceQuote {
    private String serviceName;
    private double servicePrice;
    private boolean serviceApproved;

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public void setServiceApproved(boolean serviceApproved) {
        this.serviceApproved = serviceApproved;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public double getServicePrice() {
        return this.servicePrice;
    }

    public boolean getServiceApproved() {
        return this.serviceApproved;
    }

}
