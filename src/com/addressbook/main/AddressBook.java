package com.addressbook.main;

import com.addressbook.service.AddressBookManager;

import java.util.Scanner;

public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Program");
        Scanner Scanner = new Scanner(System.in);
        AddressBookManager addressBookManager = new AddressBookManager();
        while (true) {
            System.out.println("1) add a person");
            System.out.println("2) edit person");
            System.out.println("3) delete a person");
            System.out.println("4) sort AddressBook");
            System.out.println("5) view for person by city and state");
            System.out.println("6) search for person in city or state");
            System.out.println("7) print address book");
            System.out.println("8) exit");
            System.out.println("Choose one option");
            int choice = Scanner.nextInt();
            switch (choice) {
                case 1 -> addressBookManager.addPerson();
                case 2 -> addressBookManager.editPerson();
                case 3 -> addressBookManager.deletePerson();
                case 4 -> addressBookManager.sorting();
                case 5 -> addressBookManager.viewByCityAndState();
                case 6 -> addressBookManager.searchByCityOrState();
                case 7 -> addressBookManager.personList.forEach(AddressBookManager::printEachRecord);
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
