import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactApp {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while(flag){
            System.out.println("Welcome To Contact Manager App\n" +
                    "1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n" +
                    "Enter an option (1, 2, 3, 4 or 5):");
            int response = sc.nextInt();
            switch(response){
                case 1:
                    showContacts();
                    break;
                case 2:
                    System.out.println("What is the first name?");
                    String first = sc.next();
                    System.out.println("What is the last name?");
                    String last = sc.next();
                    System.out.println("What is the phone number?");
                    String phone = sc.next();
                    addContact(first, last, phone);
                    showContacts();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(1);
            }
        }

    }

    public static void showContacts(){
        Path filepath = Paths.get("data", "contacts.txt");
        List<String> lines;
        List<Contact> contacts = new ArrayList<>();
        try {
            lines = Files.readAllLines(filepath);
            for(String line: lines){
                System.out.printf("%s%n", line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addContact(String firstName, String lastName, String phoneNumber){
        Path filepath = Paths.get("data", "contacts.txt");
        String contactEntry = String.format("%s %s | %s", firstName, lastName, phoneNumber);
        try {
            Files.write(filepath, Arrays.asList(contactEntry), StandardOpenOption.APPEND);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }



}
