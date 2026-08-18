import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // File names used for storing serialized data
    private static final String OWNER_FILE = "owners.ser";
    private static final String PET_FILE = "pets.ser";
    private static final String VACCINATION_FILE = "vaccinations.ser";
    private static final String BOOKING_FILE = "bookings.ser";
    private static final String GROOMING_FILE = "groomings.ser";
    private static final String BOARDING_FILE = "boardings.ser";

    // In-memory data lists (loaded from files at startup)
    private static ArrayList<Owner> owners;
    private static ArrayList<Pet> pets;
    private static ArrayList<Vaccination> vaccinations;
    private static ArrayList<ServiceBooking> bookings;
    private static ArrayList<Grooming> groomings;
    private static ArrayList<Boarding> boardings;

    private static Scanner sc = new Scanner(System.in);

    // Hardcoded staff credentials for Module 1: Staff Authentication
    private static final String STAFF_USERNAME = "Eren";
    private static final String STAFF_PASSWORD = "Eren@123";

    public static void main(String[] args) {
        loadAllData();

        if (staffLogin()) {
            mainMenu();
        } else {
            System.out.println("Login failed. Exiting application...");
        }
    }

    // ---------------- Module 1: Staff Authentication ----------------
    private static boolean staffLogin() {
        System.out.println("=========================================");
        System.out.println("     PET CARE MANAGEMENT SYSTEM - LOGIN   ");
        System.out.println("=========================================");

        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter Username: ");
            String username = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            if (username.equals(STAFF_USERNAME) && password.equals(STAFF_PASSWORD)) {
                System.out.println("Login successful! Welcome, " + username + ".\n");
                return true;
            } else {
                attempts--;
                System.out.println("Invalid credentials. Attempts remaining: " + attempts + "\n");
            }
        }
        return false;
    }

    // ---------------- Main Menu ----------------
    private static void mainMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n================= MAIN MENU =================");
            System.out.println("1. Register Pet Owner");
            System.out.println("2. Register Pet Profile");
            System.out.println("3. Book Pet Service");
            System.out.println("4. Record Vaccination Details");
            System.out.println("5. Manage Grooming Service");
            System.out.println("6. Manage Pet Boarding");
            System.out.println("7. Search Pet Record");
            System.out.println("8. Update Pet Information");
            System.out.println("9. Generate Service Report");
            System.out.println("10. Save Records to File");
            System.out.println("11. Exit Application");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1: registerOwner(); break;
                case 2: registerPet(); break;
                case 3: bookService(); break;
                case 4: recordVaccination(); break;
                case 5: manageGrooming(); break;
                case 6: manageBoarding(); break;
                case 7: searchPet(); break;
                case 8: updatePetInformation(); break;
                case 9: generateServiceReport(); break;
                case 10: saveAllData(); System.out.println("All records saved successfully."); break;
                case 11: running = false; exitApplication(); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // ---------------- Module 2: Pet Owner Registration ----------------
    private static void registerOwner() {
        System.out.println("\n--- Register Pet Owner ---");
        try {
            String ownerId = "OWN" + (owners.size() + 1);
            System.out.print("Enter Owner Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Contact Number: ");
            String contact = sc.nextLine();
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            System.out.print("Enter Emergency Contact: ");
            String emergencyContact = sc.nextLine();

            Owner owner = new Owner(ownerId, name, contact, address, emergencyContact);
            owners.add(owner);
            System.out.println("Owner registered successfully. Owner ID: " + ownerId);
        } catch (Exception e) {
            System.out.println("Error while registering owner: " + e.getMessage());
        }
    }

    // ---------------- Module 3: Pet Profile Registration ----------------
    private static void registerPet() {
        System.out.println("\n--- Register Pet Profile ---");
        if (owners.isEmpty()) {
            System.out.println("No owners found. Please register an owner first.");
            return;
        }
        try {
            System.out.print("Enter Owner ID (e.g. OWN1): ");
            String ownerId = sc.nextLine();

            if (!ownerExists(ownerId)) {
                System.out.println("Owner ID not found. Please register the owner first.");
                return;
            }

            String petId = "PET" + (pets.size() + 1);
            System.out.print("Enter Pet Name: ");
            String petName = sc.nextLine();
            System.out.print("Enter Species: ");
            String species = sc.nextLine();
            System.out.print("Enter Breed: ");
            String breed = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = readInt();
            System.out.print("Enter Gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter Weight (kg): ");
            double weight = readDouble();
            System.out.print("Enter Medical Notes: ");
            String medicalNotes = sc.nextLine();

            Pet pet = new Pet(petId, ownerId, petName, species, breed, age, gender, weight, medicalNotes);
            pets.add(pet);
            System.out.println("Pet registered successfully. Pet ID: " + petId);
        } catch (Exception e) {
            System.out.println("Error while registering pet: " + e.getMessage());
        }
    }

    // ---------------- Module 4: Service Booking Management ----------------
    private static void bookService() {
        System.out.println("\n--- Book Pet Service ---");
        System.out.print("Enter Pet ID: ");
        String petId = sc.nextLine();

        if (!petExists(petId)) {
            System.out.println("Pet ID not found.");
            return;
        }

        System.out.println("Select Service Type: 1. Grooming  2. Vaccination  3. Health Check-up  4. Boarding");
        int type = readInt();
        String serviceType;
        switch (type) {
            case 1: serviceType = "Grooming"; break;
            case 2: serviceType = "Vaccination"; break;
            case 3: serviceType = "Health Check-up"; break;
            case 4: serviceType = "Boarding"; break;
            default: serviceType = "General"; break;
        }

        System.out.print("Enter Service Date (dd-mm-yyyy): ");
        String serviceDate = sc.nextLine();

        String bookingId = "BKG" + (bookings.size() + 1);
        ServiceBooking booking = new ServiceBooking(bookingId, petId, serviceType, serviceDate, "Pending");
        bookings.add(booking);
        System.out.println("Service booked successfully. Booking ID: " + bookingId);
    }

    // ---------------- Module 5: Vaccination Record Management ----------------
    private static void recordVaccination() {
        System.out.println("\n--- Vaccination Record Management ---");
        System.out.println("1. Add New Vaccination Record  2. Update Existing Vaccination Record");
        int choice = readInt();

        if (choice == 1) {
            System.out.print("Enter Pet ID: ");
            String petId = sc.nextLine();
            if (!petExists(petId)) {
                System.out.println("Pet ID not found.");
                return;
            }
            String vaccinationId = "VAC" + (vaccinations.size() + 1);
            System.out.print("Enter Vaccine Name: ");
            String vaccineName = sc.nextLine();
            System.out.print("Enter Vaccination Date (dd-mm-yyyy): ");
            String vaccinationDate = sc.nextLine();
            System.out.print("Enter Next Due Date (dd-mm-yyyy): ");
            String nextDueDate = sc.nextLine();
            System.out.print("Enter Veterinarian Remarks: ");
            String vetRemarks = sc.nextLine();

            Vaccination v = new Vaccination(vaccinationId, petId, vaccineName, vaccinationDate, nextDueDate, vetRemarks);
            vaccinations.add(v);
            System.out.println("Vaccination record added. Vaccination ID: " + vaccinationId);

        } else if (choice == 2) {
            System.out.print("Enter Vaccination ID to update: ");
            String vid = sc.nextLine();
            Vaccination found = null;
            for (Vaccination v : vaccinations) {
                if (v.getVaccinationId().equalsIgnoreCase(vid)) {
                    found = v;
                    break;
                }
            }
            if (found == null) {
                System.out.println("Vaccination record not found.");
                return;
            }
            System.out.print("Enter New Next Due Date (dd-mm-yyyy): ");
            found.setNextDueDate(sc.nextLine());
            System.out.print("Enter New Veterinarian Remarks: ");
            found.setVetRemarks(sc.nextLine());
            System.out.println("Vaccination record updated successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // ---------------- Module 6: Grooming Service Management ----------------
    private static void manageGrooming() {
        System.out.println("\n--- Grooming Service Management ---");
        System.out.print("Enter Pet ID: ");
        String petId = sc.nextLine();
        if (!petExists(petId)) {
            System.out.println("Pet ID not found.");
            return;
        }
        System.out.println("Select grooming services (comma separated), e.g. Bathing,Nail Trimming,Hair Cutting,Ear Cleaning:");
        String services = sc.nextLine();
        System.out.print("Enter Grooming Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        String groomingId = "GRM" + (groomings.size() + 1);
        Grooming grooming = new Grooming(groomingId, petId, services, date, "Pending");
        groomings.add(grooming);
        System.out.println("Grooming service scheduled. Grooming ID: " + groomingId);

        System.out.print("Mark as Completed now? (yes/no): ");
        String ans = sc.nextLine();
        if (ans.equalsIgnoreCase("yes")) {
            grooming.setCompletionStatus("Completed");
            System.out.println("Grooming marked as Completed.");
        }
    }

    // ---------------- Module 7: Pet Boarding Management ----------------
    private static void manageBoarding() {
        System.out.println("\n--- Pet Boarding Management ---");
        System.out.print("Enter Pet ID: ");
        String petId = sc.nextLine();
        if (!petExists(petId)) {
            System.out.println("Pet ID not found.");
            return;
        }
        System.out.print("Enter Check-In Date (dd-mm-yyyy): ");
        String checkIn = sc.nextLine();
        System.out.print("Enter Expected Pickup Date (dd-mm-yyyy): ");
        String pickup = sc.nextLine();
        System.out.print("Enter Food Preference: ");
        String food = sc.nextLine();
        System.out.print("Enter Special Care Instructions: ");
        String instructions = sc.nextLine();

        String boardingId = "BRD" + (boardings.size() + 1);
        Boarding boarding = new Boarding(boardingId, petId, checkIn, pickup, food, instructions, "Checked-In");
        boardings.add(boarding);
        System.out.println("Boarding record created. Boarding ID: " + boardingId);
    }

    // ---------------- Module 8: Pet Search ----------------
    private static void searchPet() {
        System.out.println("\n--- Search Pet Record ---");
        System.out.println("Search by: 1. Pet ID  2. Pet Name  3. Owner Name  4. Contact Number");
        int choice = readInt();
        System.out.print("Enter search value: ");
        String value = sc.nextLine();

        boolean found = false;

        switch (choice) {
            case 1:
                for (Pet p : pets) {
                    if (p.getPetId().equalsIgnoreCase(value)) {
                        System.out.println(p);
                        found = true;
                    }
                }
                break;
            case 2:
                for (Pet p : pets) {
                    if (p.getPetName().equalsIgnoreCase(value)) {
                        System.out.println(p);
                        found = true;
                    }
                }
                break;
            case 3:
                for (Owner o : owners) {
                    if (o.getName().equalsIgnoreCase(value)) {
                        for (Pet p : pets) {
                            if (p.getOwnerId().equals(o.getOwnerId())) {
                                System.out.println(p);
                                found = true;
                            }
                        }
                    }
                }
                break;
            case 4:
                for (Owner o : owners) {
                    if (o.getContactNumber().equals(value)) {
                        for (Pet p : pets) {
                            if (p.getOwnerId().equals(o.getOwnerId())) {
                                System.out.println(p);
                                found = true;
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (!found) {
            System.out.println("No matching records found.");
        }
    }

    // ---------------- Module 9: Pet Record Update ----------------
    private static void updatePetInformation() {
        System.out.println("\n--- Update Pet Information ---");
        System.out.print("Enter Pet ID to update: ");
        String petId = sc.nextLine();

        Pet pet = null;
        for (Pet p : pets) {
            if (p.getPetId().equalsIgnoreCase(petId)) {
                pet = p;
                break;
            }
        }

        if (pet == null) {
            System.out.println("Pet not found.");
            return;
        }

        System.out.println("Leave field blank to keep the current value.");

        System.out.print("Enter New Pet Name (" + pet.getPetName() + "): ");
        String name = sc.nextLine();
        if (!name.isBlank()) pet.setPetName(name);

        System.out.print("Enter New Breed (" + pet.getBreed() + "): ");
        String breed = sc.nextLine();
        if (!breed.isBlank()) pet.setBreed(breed);

        System.out.print("Enter New Age (" + pet.getAge() + "): ");
        String ageStr = sc.nextLine();
        if (!ageStr.isBlank()) {
            try {
                pet.setAge(Integer.parseInt(ageStr));
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Keeping old value.");
            }
        }

        System.out.print("Enter New Weight (" + pet.getWeight() + "): ");
        String weightStr = sc.nextLine();
        if (!weightStr.isBlank()) {
            try {
                pet.setWeight(Double.parseDouble(weightStr));
            } catch (NumberFormatException e) {
                System.out.println("Invalid weight. Keeping old value.");
            }
        }

        System.out.print("Enter New Medical Notes (" + pet.getMedicalNotes() + "): ");
        String notes = sc.nextLine();
        if (!notes.isBlank()) pet.setMedicalNotes(notes);

        System.out.println("Pet information updated successfully.");
    }

    // ---------------- Module 10: Service Report Generation ----------------
    private static void generateServiceReport() {
        System.out.println("\n=========== SERVICE REPORT ===========");

        System.out.println("\n-- Registered Pet Owners (" + owners.size() + ") --");
        for (Owner o : owners) System.out.println(o);

        System.out.println("\n-- Registered Pets (" + pets.size() + ") --");
        for (Pet p : pets) System.out.println(p);

        System.out.println("\n-- Service Bookings (" + bookings.size() + ") --");
        for (ServiceBooking b : bookings) System.out.println(b);

        System.out.println("\n-- Grooming Records (" + groomings.size() + ") --");
        for (Grooming g : groomings) System.out.println(g);

        System.out.println("\n-- Boarding Records (" + boardings.size() + ") --");
        for (Boarding b : boardings) System.out.println(b);

        System.out.println("\n-- Vaccination Records (" + vaccinations.size() + ") --");
        for (Vaccination v : vaccinations) System.out.println(v);

        System.out.println("\n=======================================");
    }

    // ---------------- Module 11: Data Backup and Recovery ----------------
    private static void loadAllData() {
        owners = FileManager.loadData(OWNER_FILE);
        pets = FileManager.loadData(PET_FILE);
        vaccinations = FileManager.loadData(VACCINATION_FILE);
        bookings = FileManager.loadData(BOOKING_FILE);
        groomings = FileManager.loadData(GROOMING_FILE);
        boardings = FileManager.loadData(BOARDING_FILE);
    }

    private static void saveAllData() {
        FileManager.saveData(OWNER_FILE, owners);
        FileManager.saveData(PET_FILE, pets);
        FileManager.saveData(VACCINATION_FILE, vaccinations);
        FileManager.saveData(BOOKING_FILE, bookings);
        FileManager.saveData(GROOMING_FILE, groomings);
        FileManager.saveData(BOARDING_FILE, boardings);
    }

    // ---------------- Module 12: System Exit ----------------
    private static void exitApplication() {
        saveAllData();
        System.out.println("All records saved. Thank you for using Pet Care Management System!");
        sc.close();
    }

    // ---------------- Helper Methods ----------------
    private static boolean ownerExists(String ownerId) {
        for (Owner o : owners) {
            if (o.getOwnerId().equalsIgnoreCase(ownerId)) return true;
        }
        return false;
    }

    private static boolean petExists(String petId) {
        for (Pet p : pets) {
            if (p.getPetId().equalsIgnoreCase(petId)) return true;
        }
        return false;
    }

    // Safely reads an integer from console, handling invalid input via Exception Handling
    private static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // Safely reads a double from console, handling invalid input via Exception Handling
    private static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
}
