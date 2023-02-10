import Models.PhoneBook;

import java.util.Scanner;

public class Main {
    protected static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        while (true){
            System.out.println("1 - add contact, 2 - show contacts, 3 - remove contact, 4 - edit contact");
            String number = console.nextLine();
            if(number.equals("1")) phoneBook.AddContact();
            else if(number.equals("2")) phoneBook.ShowContacts();
            else if(number.equals("3")) phoneBook.Remove();
            else if(number.equals("4")) phoneBook.Edit();
        }

    }
}