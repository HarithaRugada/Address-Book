package com.addressbook.controller;

import com.addressbook.service.AddressBookService;

import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Program");
        Scanner Scanner = new Scanner(System.in);
        AddressBookService addressBookService = new AddressBookService();
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
                case 1:
                    addressBookService.addPerson();
                    break;
                case 2:
                    addressBookService.editPerson();
                    break;
                case 3:
                    addressBookService.deletePerson();
                    break;
                case 4:
                    addressBookService.sorting();
                    break;
                case 5:
                    addressBookService.viewByCityAndState();
                    break;
                case 6:
                    addressBookService.searchByCityOrState();
                    break;
                case 7:
                    addressBookService.personList.forEach(AddressBookService::printEachRecord);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
