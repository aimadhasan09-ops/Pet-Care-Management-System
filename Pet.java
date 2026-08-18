import java.io.Serializable;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String petId;
    private String ownerId;
    private String petName;
    private String species;
    private String breed;
    private int age;
    private String gender;
    private double weight;
    private String medicalNotes;

    public Pet(String petId, String ownerId, String petName, String species, String breed,
                int age, String gender, double weight, String medicalNotes) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.petName = petName;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.medicalNotes = medicalNotes;
    }

    public String getPetId() { return petId; }
    public String getOwnerId() { return ownerId; }
    public String getPetName() { return petName; }
    public String getSpecies() { return species; }
    public String getBreed() { return breed; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public double getWeight() { return weight; }
    public String getMedicalNotes() { return medicalNotes; }

    public void setPetName(String petName) { this.petName = petName; }
    public void setSpecies(String species) { this.species = species; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setMedicalNotes(String medicalNotes) { this.medicalNotes = medicalNotes; }

    @Override
    public String toString() {
        return "Pet ID: " + petId +
                " | Owner ID: " + ownerId +
                " | Name: " + petName +
                " | Species: " + species +
                " | Breed: " + breed +
                " | Age: " + age +
                " | Gender: " + gender +
                " | Weight: " + weight + " kg" +
                " | Medical Notes: " + medicalNotes;
    }
}
