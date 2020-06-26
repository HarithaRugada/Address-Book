package com.addressbook.controller;

import com.addressbook.model.Person;

import java.util.*;


public class AddressBookManager {
    LinkedList<Person> personList = new LinkedList<Person>();
    HashMap<String, Person> cityMap = new HashMap<>();
    HashMap<String, Person> stateMap = new HashMap<>();
    HashMap<String, Person> firstNameMap = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public Person getPersonList(String phoneNumber) {
        for (Person person : this.personList) {
            if (phoneNumber.equals(person.getPhoneNumber())) {
                return person;
            }
        }
        return null;
    }

    public void printAddressBookList() {
        System.out.println("############################");
        for (Person person : this.personList) {
            System.out.println(person.toString());
        }
        return;
    }

    public void addPerson() {
        Person newPerson = new Person();

        System.out.println("First Name");
        newPerson.setFirstName(scanner.next());

        System.out.println("Last Name");
        newPerson.setLastName(scanner.next());

        System.out.println("Address");
        newPerson.setAddress(scanner.next());

        System.out.println("City");
        newPerson.setCity(scanner.next());

        System.out.println("State");
        newPerson.setState(scanner.next());

        System.out.println("ZIP");
        newPerson.setZip(scanner.next());

        System.out.println("Phone Number");
        newPerson.setPhoneNumber(scanner.next());

        Person duplicate = getPersonList(newPerson.getPhoneNumber());

        if (newPerson.equals(duplicate)) {
            System.out.println("Already exists");
            return;
        } else {
            personList.add(newPerson);
            cityMap.put(newPerson.getCity(), newPerson);
            stateMap.put(newPerson.getState(), newPerson);
            firstNameMap.put(newPerson.getFirstName(), newPerson);
            System.out.println("Added Person Successfully");
        }

    }

    public void editPerson() {
        System.out.println("Enter the Phone Number of the person to edit the details");
        String phoneNumber = scanner.next();

        Person editPerson = this.getPersonList(phoneNumber);

        if (editPerson != null) {

            System.out.println("Address");
            editPerson.setAddress(scanner.next());

            System.out.println("City");
            editPerson.setCity(scanner.next());

            System.out.println("State");
            editPerson.setState(scanner.next());

            System.out.println("ZIP");
            editPerson.setZip(scanner.next());

            System.out.println("Person details edited Successfully");
            return;
        }
        System.out.println("ERROR : Person details doesn't exist");
    }

    public void deletePerson() {
        System.out.println("Phone Number of person to delete : ");
        String phoneNumber = scanner.next();

        Person editPerson = this.getPersonList(phoneNumber);
        if (editPerson != null) {
            this.personList.remove(editPerson);
            System.out.println("Person Details Deleted Successfully");
            return;
        }
        System.out.println("ERROR : Person details doesn't exists");
    }

    public void sort() {
        System.out.println("SORT\n 1.First Name\n 2.City\n 3.State\n 4.ZIP\n 5.Exit");
        while (true) {
            System.out.println("Choose any one option");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Collections.sort(personList, new sortByFirstName());
                    break;

                case 2:
                    Collections.sort(personList, new sortByCity());
                    break;

                case 3:
                    Collections.sort(personList, new sortByState());
                    break;

                case 4:
                    Collections.sort(personList, new sortByZIP());
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Wrong Choice");

            }
        }
    }

    public void view() {
        System.out.println("VIEW \n 1.First Name\n 2.City\n 3.State\n 4.Exit");
        while (true) {
            System.out.println("Choose any one option");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewPersonDetails();
                    break;

                case 2:
                    viewPersonByCity();
                    break;

                case 3:
                    viewPersonByState();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Wrong Choice");

            }
        }
    }

    class sortByFirstName implements Comparator<Person> {
        public int compare(Person person1, Person person2) {
            return person1.getFirstName().compareTo(person2.getFirstName());
        }
    }

    class sortByCity implements Comparator<Person> {
        public int compare(Person person1, Person person2) {
            return person1.getCity().compareTo(person2.getCity());
        }
    }

    class sortByState implements Comparator<Person> {
        public int compare(Person person1, Person person2) {
            return person1.getState().compareTo(person2.getState());
        }
    }

    class sortByZIP implements Comparator<Person> {
        public int compare(Person person1, Person person2) {
            return person1.getZip().compareTo(person2.getZip());
        }
    }

    public void viewPersonByCity() {
        System.out.println("Enter city to get the persons list");
        String city = scanner.nextLine();
        System.out.println(cityMap.get(city));
    }

    public void viewPersonByState() {
        System.out.println("Enter State to get the persons list");
        String state = scanner.nextLine();
        System.out.println(stateMap.get(state));
    }

    public void viewPersonDetails() {
        System.out.println("Enter Person Name");
        String firstName = scanner.nextLine();
        System.out.println(firstNameMap.get(firstName));
    }
}