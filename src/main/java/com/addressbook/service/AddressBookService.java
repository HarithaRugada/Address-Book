package com.addressbook.service;

import com.addressbook.model.Person;
import com.addressbook.utility.JSONFileHandler;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBookService {
    Scanner scanner = new Scanner(System.in);
    public List<Person> personList = new ArrayList<>();
    JSONFileHandler jsonFileHandler = new JSONFileHandler();
    final String CSV_FILE_PATH = "./src/main/resources/PersonDetails.csv";


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
            jsonFileHandler.writeToJSONFile(person);
            this.writeToCSVFile();
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
        List<Person> addressBook=this.readFromCSV();
        System.out.println("enter type of sort 1)name 2)city 3)state 4)zipcode");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addressBook.sort(((Comparator<Person>)
                        (detail1, detail2) ->detail2.getFirstName().compareTo(detail1.getFirstName())).reversed());
                addressBook.forEach(AddressBookService::printEachRecord);
                break;
            case 2:
                addressBook.sort(((Comparator<Person>)
                        (detail1, detail2) ->detail2.getCity().compareTo(detail1.getCity())).reversed());
                addressBook.forEach(AddressBookService::printEachRecord);
                break;
            case 3:
                addressBook.sort(((Comparator<Person>)
                        (detail1, detail2) ->detail2.getState().compareTo(detail1.getState())).reversed());
                addressBook.forEach(AddressBookService::printEachRecord);
                break;
            case 4:
                addressBook.sort(((Comparator<Person>)
                        (detail1, detail2) ->detail2.getZip().compareTo(detail1.getZip())).reversed());
                addressBook.forEach(AddressBookService::printEachRecord);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

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

    public void writeToCSVFile() {
        try {
            FileWriter csvWriter = new FileWriter(CSV_FILE_PATH);
            csvWriter.append("First Name,");
            csvWriter.append("Last Name,");
            csvWriter.append("Address,");
            csvWriter.append("City,");
            csvWriter.append("State,");
            csvWriter.append("Zip,");
            csvWriter.append("Phone Number");
            for (Person person : personList) {
                csvWriter.append("\n").append(person.getFirstName());
                csvWriter.append(",").append(person.getLastName());
                csvWriter.append(",").append(person.getAddress());
                csvWriter.append(",").append(person.getCity());
                csvWriter.append(",").append(person.getState());
                csvWriter.append(",").append(person.getZip());
                csvWriter.append(",").append(person.getPhoneNumber());
            }
            csvWriter.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public List<Person> readFromCSV() {
        List<Person> addressBookList;
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(Person.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            addressBookList = (ArrayList<Person>) csvToBean.parse();
            return addressBookList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
