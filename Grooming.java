import java.io.Serializable;

public class Grooming implements Serializable {
    private static final long serialVersionUID = 1L;

    private String groomingId;
    private String petId;
    private String servicesIncluded; // e.g. "Bathing, Nail Trimming, Hair Cutting, Ear Cleaning"
    private String groomingDate;
    private String completionStatus; // Pending / Completed

    public Grooming(String groomingId, String petId, String servicesIncluded,
                     String groomingDate, String completionStatus) {
        this.groomingId = groomingId;
        this.petId = petId;
        this.servicesIncluded = servicesIncluded;
        this.groomingDate = groomingDate;
        this.completionStatus = completionStatus;
    }

    public String getGroomingId() { return groomingId; }
    public String getPetId() { return petId; }
    public String getServicesIncluded() { return servicesIncluded; }
    public String getGroomingDate() { return groomingDate; }
    public String getCompletionStatus() { return completionStatus; }

    public void setServicesIncluded(String servicesIncluded) { this.servicesIncluded = servicesIncluded; }
    public void setGroomingDate(String groomingDate) { this.groomingDate = groomingDate; }
    public void setCompletionStatus(String completionStatus) { this.completionStatus = completionStatus; }

    @Override
    public String toString() {
        return "Grooming ID: " + groomingId +
                " | Pet ID: " + petId +
                " | Services: " + servicesIncluded +
                " | Date: " + groomingDate +
                " | Status: " + completionStatus;
    }
}
