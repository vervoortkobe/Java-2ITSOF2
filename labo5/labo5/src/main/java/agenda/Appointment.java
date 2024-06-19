package agenda;

public class Appointment {
    private final String customerName;
    private final String reason;

    public Appointment(String customerName, String reason) {
        this.customerName = customerName;
        this.reason = reason;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "customerName='" + customerName + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
