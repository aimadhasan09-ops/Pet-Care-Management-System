import java.io.Serializable;

public class Boarding implements Serializable {
    private static final long serialVersionUID = 1L;

    private String boardingId;
    private String petId;
    private String checkInDate;
    private String expectedPickupDate;
    private String foodPreference;
    private String specialInstructions;
    private String status; // Checked-In / Checked-Out

    public Boarding(String boardingId, String petId, String checkInDate, String expectedPickupDate,
                     String foodPreference, String specialInstructions, String status) {
        this.boardingId = boardingId;
        this.petId = petId;
        this.checkInDate = checkInDate;
        this.expectedPickupDate = expectedPickupDate;
        this.foodPreference = foodPreference;
        this.specialInstructions = specialInstructions;
        this.status = status;
    }

    public String getBoardingId() { return boardingId; }
    public String getPetId() { return petId; }
    public String getCheckInDate() { return checkInDate; }
    public String getExpectedPickupDate() { return expectedPickupDate; }
    public String getFoodPreference() { return foodPreference; }
    public String getSpecialInstructions() { return specialInstructions; }
    public String getStatus() { return status; }

    public void setExpectedPickupDate(String expectedPickupDate) { this.expectedPickupDate = expectedPickupDate; }
    public void setFoodPreference(String foodPreference) { this.foodPreference = foodPreference; }
    public void setSpecialInstructions(String specialInstructions) { this.specialInstructions = specialInstructions; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Boarding ID: " + boardingId +
                " | Pet ID: " + petId +
                " | Check-In: " + checkInDate +
                " | Expected Pickup: " + expectedPickupDate +
                " | Food Preference: " + foodPreference +
                " | Special Instructions: " + specialInstructions +
                " | Status: " + status;
    }
}
