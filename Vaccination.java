import java.io.Serializable;

public class Vaccination implements Serializable {
    private static final long serialVersionUID = 1L;

    private String vaccinationId;
    private String petId;
    private String vaccineName;
    private String vaccinationDate;
    private String nextDueDate;
    private String vetRemarks;

    public Vaccination(String vaccinationId, String petId, String vaccineName,
                        String vaccinationDate, String nextDueDate, String vetRemarks) {
        this.vaccinationId = vaccinationId;
        this.petId = petId;
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
        this.nextDueDate = nextDueDate;
        this.vetRemarks = vetRemarks;
    }

    public String getVaccinationId() { return vaccinationId; }
    public String getPetId() { return petId; }
    public String getVaccineName() { return vaccineName; }
    public String getVaccinationDate() { return vaccinationDate; }
    public String getNextDueDate() { return nextDueDate; }
    public String getVetRemarks() { return vetRemarks; }

    public void setVaccineName(String vaccineName) { this.vaccineName = vaccineName; }
    public void setVaccinationDate(String vaccinationDate) { this.vaccinationDate = vaccinationDate; }
    public void setNextDueDate(String nextDueDate) { this.nextDueDate = nextDueDate; }
    public void setVetRemarks(String vetRemarks) { this.vetRemarks = vetRemarks; }

    @Override
    public String toString() {
        return "Vaccination ID: " + vaccinationId +
                " | Pet ID: " + petId +
                " | Vaccine: " + vaccineName +
                " | Date: " + vaccinationDate +
                " | Next Due: " + nextDueDate +
                " | Vet Remarks: " + vetRemarks;
    }
}
