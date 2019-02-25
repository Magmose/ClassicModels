package mappers;

public class CustomerSimple {

    public String firstName;
    public String lastName;
    public String customerName;
    public Long orderCount;
    
    public CustomerSimple(String firstName, String lastName, String customerName, Long orderCount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerName = customerName;
        this.orderCount = orderCount;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
}
