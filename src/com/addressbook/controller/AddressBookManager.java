package com.addressbook.controller;

import com.addressbook.model.*;
import java.util.*;

public class AddressBookManager
{
    List<Person> personList=new ArrayList<Person>();
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
    public List<Person> getPersonList()
    {
        return this.personList;
    }
    public void addPerson(Person newPerson)
    {
        if(newPerson==null)
        {
            newPerson = new Person();

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

            System.out.println("Added Person Successfully");
        }
        this.personList.add(newPerson);
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
}
