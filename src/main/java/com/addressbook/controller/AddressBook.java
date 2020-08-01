package com.addressbook.controller;

import com.addressbook.service.AddressBookService;
import com.addressbook.service.IAddressBookService;
import com.addressbook.utility.CSVFileHandler;
import com.addressbook.utility.JSONFileHandler;
import com.addressbook.utility.JSONUsingGSONFileHandler;

import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IAddressBookService addressBookService;
        final String JSON_FILE_PATH = "./src/main/resources/PersonDetails.json";
        final String CSV_FILE_PATH = "./src/main/resources/PersonDetails.csv";
        final String JSON_FILE_PATH_USING_GSON = "./src/main/resources/PersonDetailsUsingGSON.json";
        System.out.println("Welcome To Address Book Program");
        System.out.println("Select the type of file handler");
        System.out.println("1.JSON File Handler");
        System.out.println("2.CSV File Handler");
        System.out.println("3.JSON File Handler using GSON");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addressBookService = new AddressBookService(new JSONFileHandler(), JSON_FILE_PATH);
                break;
            case 2:
                addressBookService = new AddressBookService(new CSVFileHandler(), CSV_FILE_PATH);
                break;
            case 3:
                addressBookService = new AddressBookService(new JSONUsingGSONFileHandler(), JSON_FILE_PATH_USING_GSON);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }

        while (true) {
            System.out.println("1) add a person");
            System.out.println("2) edit person");
            System.out.println("3) delete a person");
            System.out.println("4) sort AddressBook");
            System.out.println("5) view for person by city and state");
            System.out.println("6) search for person in city or state");
            System.out.println("7) exit");
            System.out.println("Choose one option");
            int choice = scanner.nextInt();
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
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
