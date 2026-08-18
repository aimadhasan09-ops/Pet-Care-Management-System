import java.io.Serializable;

public class ServiceBooking implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookingId;
    private String petId;
    private String serviceType;   // Grooming, Vaccination, Health Check-up, Boarding
    private String serviceDate;
    private String status;        // Pending, Completed, Cancelled

    public ServiceBooking(String bookingId, String petId, String serviceType, String serviceDate, String status) {
        this.bookingId = bookingId;
        this.petId = petId;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.status = status;
    }

    public String getBookingId() { return bookingId; }
    public String getPetId() { return petId; }
    public String getServiceType() { return serviceType; }
    public String getServiceDate() { return serviceDate; }
    public String getStatus() { return status; }

    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public void setServiceDate(String serviceDate) { this.serviceDate = serviceDate; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
                " | Pet ID: " + petId +
                " | Service: " + serviceType +
                " | Date: " + serviceDate +
                " | Status: " + status;
    }
}
