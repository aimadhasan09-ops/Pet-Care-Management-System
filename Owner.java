import java.io.Serializable;

public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ownerId;
    private String name;
    private String contactNumber;
    private String address;
    private String emergencyContact;

    public Owner(String ownerId, String name, String contactNumber, String address, String emergencyContact) {
        this.ownerId = ownerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.emergencyContact = emergencyContact;
    }

    public String getOwnerId() { return ownerId; }
    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }
    public String getAddress() { return address; }
    public String getEmergencyContact() { return emergencyContact; }

    public void setName(String name) { this.name = name; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setAddress(String address) { this.address = address; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    @Override
    public String toString() {
        return "Owner ID: " + ownerId +
                " | Name: " + name +
                " | Contact: " + contactNumber +
                " | Address: " + address +
                " | Emergency Contact: " + emergencyContact;
    }
}
