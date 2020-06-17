package com.addressbook.controller;

import com.addressbook.model.*;
import java.util.*;

public class AddressBookManager
{
    List<Person> personList=new ArrayList<Person>();
    Scanner Sc=new Scanner(System.in);

    public void addPerson(Person person)
    {
        if(person==null)
        {
            person = new Person();

            System.out.println("First Name");
            person.setFirstName(Sc.next());

            System.out.println("Last Name");
            person.setLastName(Sc.next());

            System.out.println("Address");
            person.setAddress(Sc.next());

            System.out.println("City");
            person.setCity(Sc.next());

            System.out.println("State");
            person.setState(Sc.next());

            System.out.println("ZIP");
            person.setZip(Sc.next());

            System.out.println("Phone Number");
            person.setPhoneNumber(Sc.next());

            System.out.println("Added Person Successfully");
        }
        this.personList.add(person);
    }
}
