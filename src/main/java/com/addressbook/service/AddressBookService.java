package com.addressbook.service;

import com.addressbook.model.Person;
import com.addressbook.utility.IFileHandling;
import com.addressbook.utility.JSONFileHandler;
import com.addressbook.utility.JSONUsingGSONFileHandler;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookService implements IAddressBookService {
    Scanner scanner = new Scanner(System.in);
    IFileHandling fileHandling;
    String addressBook;
    public List<Person> personList;
    JSONFileHandler jsonFileHandler = new JSONFileHandler();
    JSONUsingGSONFileHandler jsonUsingGSONFileHandler = new JSONUsingGSONFileHandler();
    final String CSV_FILE_PATH = "./src/main/resources/PersonDetails.csv";

    public AddressBookService(IFileHandling fileHandling, String addressBook) {
        this.addressBook = addressBook;
        this.fileHandling = fileHandling;
        this.personList = fileHandling.convertToList(addressBook);
    }

    public Person getPersonDetails() {
        System.out.println("enter first name");
        String firstName = scanner.next();
        System.out.println("enter last name");
        String lastName = scanner.next();
        for (Person person : this.personList) {
            if (firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName())) {
                return person;
            }
        }
        return null;
    }

    public boolean checkPerson(String firstName, String lastName) {
        for (Person person : this.personList) {
            if (firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName())) {
                return true;
            }
        }
        return false;
    }

    public void addressDetails(Person person) {
        System.out.println("enter address");
        person.setAddress(scanner.next());
        System.out.println("enter city");
        person.setCity(scanner.next());
        System.out.println("enter state");
        person.setState(scanner.next());
        System.out.println("enter zipcode");
        person.setZip(scanner.next());
        System.out.println("enter phone number");
        person.setPhoneNumber(scanner.next());
    }

    @Override
    public void addPerson() {
        Person person = new Person();
        System.out.println("enter first name");
        person.setFirstName(scanner.next());
        System.out.println("enter last name");
        person.setLastName(scanner.next());
        addressDetails(person);
        boolean duplicate = this.checkPerson(person.getFirstName(), person.getLastName());
        if (!duplicate) {
            personList.add(person);
            fileHandling.convertToFile(personList, addressBook);
            System.out.println("added person successfully");
        } else {
            System.out.println("details already exists");
        }
    }

    @Override
    public void editPerson() {
        Person personToEdit = this.getPersonDetails();
        if (personToEdit != null) {
            addressDetails(personToEdit);
            System.out.println("details updated");
        } else {
            System.out.println("no details found");
        }
    }

    @Override
    public void deletePerson() {
        Person personToDelete = this.getPersonDetails();
        if (personToDelete != null) {
            this.personList.remove(personToDelete);
            System.out.println("deleted successfully");
        } else
            System.out.println("invalid details");
    }

    public static void printEachRecord(Person record) {
        System.out.println("Name > " + record.getLastName() + " " + record.getFirstName());
        System.out.println("Address > " + record.getAddress());
        System.out.println("City > " + record.getCity());
        System.out.println("State > " + record.getState());
        System.out.println("Zip > " + record.getZip());
        System.out.println("Phone Number > " + record.getPhoneNumber());
    }

    @Override
    public void sorting() {
        List<Person> addressBookList = fileHandling.convertToList(addressBook);
        System.out.println("enter type of sort 1)name 2)city 3)state 4)zipcode");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addressBookList.sort(((Comparator<Person>)
                        (detail1, detail2) -> detail2.getFirstName().compareTo(detail1.getFirstName())).reversed());
                addressBookList.forEach(AddressBookService::printEachRecord);
                break;
            case 2:
                addressBookList.sort(((Comparator<Person>)
                        (detail1, detail2) -> detail2.getCity().compareTo(detail1.getCity())).reversed());
                addressBookList.forEach(AddressBookService::printEachRecord);
                break;
            case 3:
                addressBookList.sort(((Comparator<Person>)
                        (detail1, detail2) -> detail2.getState().compareTo(detail1.getState())).reversed());
                addressBookList.forEach(AddressBookService::printEachRecord);
                break;
            case 4:
                addressBookList.sort(((Comparator<Person>)
                        (detail1, detail2) -> detail2.getZip().compareTo(detail1.getZip())).reversed());
                addressBookList.forEach(AddressBookService::printEachRecord);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    @Override
    public void viewByCityAndState() {
        System.out.println("Enter state:");
        String state = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();
        for (Person person : personList) {
            if (person.getState().equals(state) && person.getCity().equals(city))
                System.out.println("\nFirst Name > " + person.getFirstName()
                        + "\nLast Name > " + person.getLastName()
                        + "\nAddress > " + person.getAddress()
                        + "\nCity > " + person.getCity()
                        + "\nState > " + person.getState()
                        + "\nZip > " + person.getZip()
                        + "\nPhone Number > " + person.getPhoneNumber());
        }
    }

    @Override
    public void searchByCityOrState() {
        System.out.println("enter type of search 1)state 2)city");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter state:");
                String state = scanner.next();
                for (Person person : personList) {
                    if (person.getState().equals(state))
                        System.out.println("\nFirst Name > " + person.getFirstName()
                                + "\nLast Name > " + person.getLastName()
                                + "\nAddress > " + person.getAddress()
                                + "\nCity > " + person.getCity()
                                + "\nState > " + person.getState()
                                + "\nZip > " + person.getZip()
                                + "\nPhone Number > " + person.getPhoneNumber());
                }
                break;
            case 2:
                System.out.println("Enter city:");
                String city = scanner.next();
                for (Person person : personList) {
                    if (person.getCity().equals(city))
                        System.out.println("\nFirst Name > " + person.getFirstName()
                                + "\nLast Name > " + person.getLastName()
                                + "\nAddress > " + person.getAddress()
                                + "\nCity > " + person.getCity()
                                + "\nState > " + person.getState()
                                + "\nZip > " + person.getZip()
                                + "\nPhone Number > " + person.getPhoneNumber());
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
