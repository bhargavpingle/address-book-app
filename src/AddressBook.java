import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
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
            return true;
        }
        return false;
    }
}
