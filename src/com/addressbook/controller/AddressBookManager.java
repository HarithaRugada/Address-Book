package com.addressbook.controller;

import com.addressbook.model.*;
import java.util.*;

public class AddressBookManager
{
    LinkedList<Person> personList=new LinkedList<Person>();
    HashMap<String,Person>cityMap=new HashMap<>();
    HashMap<String,Person>stateMap=new HashMap<>();

    Scanner Sc=new Scanner(System.in);
    public Person getPersonList(String firstName,String lastName)
    {
        for(Person person : this.personList)
        {
            if(firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName()))
            {
                return person;
            }
        }
        return null;
    }
    public LinkedList<Person> getPersonList()
    {
        return this.personList;
    }
    public void printAddressBookList()
    {
        System.out.println("############################");
        for(Person person:this.personList)
        {
            System.out.println(person.toString());
        }
        return;
  }
    public void addPerson()
    {
        //if(newPerson==null)
        //{
        Person newPerson = new Person() {
            @Override
            public int compareTo(Person o) {
                return 0;
            }
        };

        System.out.println("First Name");
            newPerson.setFirstName(Sc.next());

            System.out.println("Last Name");
            newPerson.setLastName(Sc.next());

            System.out.println("Address");
            newPerson.setAddress(Sc.next());

            System.out.println("City");
            newPerson.setCity(Sc.next());

            System.out.println("State");
            newPerson.setState(Sc.next());

            System.out.println("ZIP");
            newPerson.setZip(Sc.next());

            System.out.println("Phone Number");
            newPerson.setPhoneNumber(Sc.next());

        Person duplicate=getPersonList(newPerson.getFirstName(),newPerson.getLastName());

            if(newPerson.equals(duplicate))
                {
                    System.out.println("Already exists");
                    return;
                }
            else
                {
                    System.out.println("Added Person Successfully");
                }
        //}
        personList.add(newPerson);
        cityMap.put(newPerson.getCity(),newPerson);
        stateMap.put(newPerson.getState(),newPerson);
    }

    public void editPerson(Person editPerson)
    {
        System.out.println("Enter the First Name of the person to edit the details");
        String firstName=Sc.next();

        System.out.println("Enter the Last Name of the person to edit the details");
        String lastName=Sc.next();

        editPerson=this.getPersonList(firstName,lastName);

        if(editPerson!=null)
        {

            System.out.println("Address");
            editPerson.setAddress(Sc.next());

            System.out.println("City");
            editPerson.setCity(Sc.next());

            System.out.println("State");
            editPerson.setState(Sc.next());

            System.out.println("ZIP");
            editPerson.setZip(Sc.next());

            System.out.println("Phone Number");
            editPerson.setPhoneNumber(Sc.next());

            System.out.println("Person details edited Successfully");
            return;
        }
    System.out.println("ERROR : Person details doesn't exist");
    }

    public void deletePerson(Person editPerson)
    {
        System.out.println("First Name of person to delete : ");
        String firstName=Sc.next();
        System.out.println("Last Name of person to delete");
        String lastName=Sc.next();
        editPerson=this.getPersonList(firstName,lastName);
        if(editPerson!=null);
        {
            this.personList.remove(editPerson);
            System.out.println("Person Details Deleted Successfully");
            return;
        }
        //System.out.println("ERROR : Person details doesn't exists");
    }

    public void sortByFirstName()
    {
        this.personList.sort(Comparator.comparing(e->e.getFirstName().toLowerCase()));
    }

    public void sortByCity()
    {
        this.personList.sort(Comparator.comparing(e->e.getCity().toLowerCase()));
    }

    public void sortByState()
    {
        this.personList.sort(Comparator.comparing(e->e.getState().toLowerCase()));
    }

    public void sortByZip()
    {
        this.personList.sort(Comparator.comparing(e->e.getZip().toLowerCase()));
    }

    public void viewPersonByCity()
    {
        System.out.println("Enter city to get the persons list");
        String city=Sc.nextLine();
        System.out.println(cityMap.get(city));
    }

    public void viewPersonByState()
    {
        System.out.println("Enter State to get the persons list");
        String state=Sc.nextLine();
        System.out.println(stateMap.get(state));
    }
}
