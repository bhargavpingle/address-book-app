import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
        loadContacts();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContacts();
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean deleteContact(String name) {
        Contact contact = findContactByName(name);
        if (contact != null) {
            contacts.remove(contact);
            saveContacts();
            return true;
        }
        return false;
    }

    private void saveContacts() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("contacts.dat"))) {
            out.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    private void loadContacts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("contacts.dat"))) {
            contacts = (List<Contact>) in.readObject();
        } catch (FileNotFoundException e) {
            // No contacts file exists yet, so ignore
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}
