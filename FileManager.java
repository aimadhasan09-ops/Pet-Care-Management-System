import java.io.*;
import java.util.ArrayList;

// Handles saving and loading ArrayLists to/from disk using Object Serialization.
public class FileManager {

    // Saves any ArrayList of Serializable objects to a file.
    public static void saveData(String fileName, ArrayList<?> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error while saving data to " + fileName + " -> " + e.getMessage());
        }
    }

    // Loads an ArrayList from a file. If the file does not exist yet, returns an empty list.
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> loadData(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<T>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<T>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<T>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading data from " + fileName + " -> " + e.getMessage());
            return new ArrayList<T>();
        }
    }
}
