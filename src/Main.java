import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add Contact
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    addressBook.addContact(new Contact(name, phoneNumber, email));
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    // List Contacts
                    System.out.println("Contacts List:");
                    for (Contact contact : addressBook.getAllContacts()) {
                        System.out.println(contact);
                    }
                    break;
                case 3:
                    // Search Contact
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Contact contact = addressBook.findContactByName(searchName);
                    if (contact != null) {
                        System.out.println("Contact found: " + contact);
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 4:
                    // Delete Contact
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    if (addressBook.deleteContact(deleteName)) {
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 5:
                    // Exit
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
