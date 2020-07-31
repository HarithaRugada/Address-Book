package com.addressbook.service;

import com.addressbook.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBookManager {
    Scanner scanner = new Scanner(System.in);
    public List<Person> personList = new ArrayList<>();

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
            System.out.println("added person successfully");
        } else {
            System.out.println("details already exists");
        }
    }

    public void editPerson() {
        Person personToEdit = this.getPersonDetails();
        if (personToEdit != null) {
            addressDetails(personToEdit);
            System.out.println("details updated");
        } else {
            System.out.println("no details found");
        }
    }

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

    public void sorting() {
        System.out.println("enter type of sort 1)name 2)city 3)state 4)zipcode");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> personList.stream().sorted(Comparator.comparing(Person::getFirstName)).forEach(AddressBookManager::printEachRecord);
            case 2 -> personList.stream().sorted(Comparator.comparing(Person::getCity)).forEach(AddressBookManager::printEachRecord);
            case 3 -> personList.stream().sorted(Comparator.comparing(Person::getState)).forEach(AddressBookManager::printEachRecord);
            case 4 -> personList.stream().sorted(Comparator.comparing(Person::getZip)).forEach(AddressBookManager::printEachRecord);
            default -> System.out.println("Invalid choice");
        }
    }

    public void viewByCityAndState() {
        System.out.println("Enter state:");
        String state = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getState().equals(state) && personList.get(i).getCity().equals(city))
                personList.forEach(AddressBookManager::printEachRecord);
            else
                System.out.println("No data found");
        }
    }

    public void searchByCityOrState() {
        System.out.println("enter type of search 1)state 2)city");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> {
                System.out.println("Enter state:");
                String state = scanner.next();
                for (int i = 0; i < personList.size(); i++) {
                    if (personList.get(i).getState().equals(state))
                        personList.forEach(AddressBookManager::printEachRecord);
                    else
                        System.out.println("No data found");
                }
            }
            case 2 -> {
                System.out.println("Enter city:");
                String city = scanner.next();
                for (int i = 0; i < personList.size(); i++) {
                    if (personList.get(i).getCity().equals(city))
                        personList.forEach(AddressBookManager::printEachRecord);
                    else
                        System.out.println("No data found");
                }
            }
            default -> System.out.println("Invalid choice");
        }
    }
}