package App.Domain;

public class ServicePrice {
    private String serviceName;
    private double servicePrice;

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public double getServicePrice() {
        return this.servicePrice;
    }

}
