package com.addressbook.test;

import com.addressbook.controller.AddressBookManager;

import java.awt.*;
import java.util.*;

public class AddressBook {
    public static void main(String[] args)
    {
        AddressBook addressBook=new AddressBook();
        AddressBookManager addressBookManager=new AddressBookManager();

        System.out.println("Welcome to Address Book Program");
        Scanner Sc=new Scanner(System.in);
        System.out.println("1.Add Person");
        System.out.println("2.Edit Person");
        System.out.println("3.Delete Person");
        System.out.println("4.Sort by First Name");
        System.out.println("5.Sort by City");
        System.out.println("6.Sort By State");
        System.out.println("7.Sort By Zip");
        System.out.println("8.View By City");
        System.out.println("9.View By State");
        System.out.println("10.Search Person");
        System.out.println("11.Exit");
        while(true)
        {
            System.out.println("Enter your choice");
            int choice = Sc.nextInt();
            switch (choice)
            {
                    case 1:
                        addressBookManager.addPerson();
                        break;

                    case 2:
                        addressBookManager.editPerson(null);
                        break;

                    case 3:
                        addressBookManager.deletePerson(null);
                        break;

                    case 4:
                        addressBookManager.sortByFirstName();
                        break;

                    case 5:
                        addressBookManager.sortByCity();
                        break;

                    case 6:
                        addressBookManager.sortByState();
                        break;

                    case 7:
                        addressBookManager.sortByZip();
                        break;

                    case 8:
                        addressBookManager.viewPersonByCity();
                        break;

                    case 9:
                        addressBookManager.viewPersonByState();
                        break;

                    case 10:
                        addressBookManager.viewPersonDetails();
                        break;

                    case 11:
                        System.exit(0);

                    default:
                        System.out.println("Wrong Choice");
            }
        }
    }
}
