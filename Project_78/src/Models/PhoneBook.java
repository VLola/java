package Models;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {

    Scanner console = new Scanner(System.in);
    protected ArrayList<Contact> Contacts = new ArrayList<Contact>();
    public void AddContact(){
        FullName fullName = new FullName();
        System.out.println("Enter surname:");
        fullName.setSurname(console.nextLine());
        System.out.println("Enter name:");
        fullName.setName(console.nextLine());
        System.out.println("Enter patronymic:");
        fullName.setPatronymic(console.nextLine());

        Phone phone = new Phone();
        System.out.println("Enter phone number:");
        phone.setNumber(console.nextLine());

        Category category = EnterCategory();

        Contact contact = new Contact();
        contact.setFullName(fullName);
        contact.setPhone(phone);
        contact.setCategory(category);
        Contacts.add(contact);
    }
    public void ShowContacts(){
        if(Contacts.size() == 0) System.out.println("Contact list is empty!");
        for (var contact: Contacts) {
            System.out.println(contact);
        }
    }
    public void Remove(){
        System.out.println("Enter number phone:");
        String number = console.nextLine();
        Contact contact = Find(number);
        if(contact == null) System.out.println("Contact not found!");
        else {
            Contacts.remove(contact);
            System.out.println("Contact removed");
        }
    }
    private Contact Find(String number){
        for (var contact: Contacts) {
            if(contact.getPhone().getNumber().equals(number)) return contact;
        }
        return null;
    }
    public void Edit(){
        console = new Scanner(System.in);
        System.out.println("Enter number phone:");
        String number = console.nextLine();
        Contact contact = Find(number);
        if(contact == null) System.out.println("Contact not found!");
        else {
            console = new Scanner(System.in);
            System.out.println("1 - Edit name, 2 - Edit surname, 3 - Edit patronymic, 4 - Edit phone, 5 - Edit category");
            int enter = console.nextInt();
            console = new Scanner(System.in);
            if(enter == 1){
                System.out.println("Enter name:");
                String name = console.nextLine();
                contact.getFullName().setName(name);
            }
            else if(enter == 2){
                System.out.println("Enter surname:");
                String surname = console.nextLine();
                contact.getFullName().setSurname(surname);
            }
            else if(enter == 3){
                System.out.println("Enter patronymic:");
                String patronymic = console.nextLine();
                contact.getFullName().setPatronymic(patronymic);
            }
            else if(enter == 4){
                System.out.println("Enter phone:");
                String phone = console.nextLine();
                contact.getPhone().setNumber(phone);
            }
            else if(enter == 5){
                contact.setCategory(EnterCategory());
            }
            System.out.println(contact);
        }
    }
    private Category EnterCategory(){
        System.out.println("Enter number category:");
        System.out.println("1 - Home, 2 - Work, any - Other");
        int number = console.nextInt();
        if(number == 1) return new HomeCategory();
        else if(number == 2) return new WorkCategory();
        else return new OtherCategory();
    }
}
