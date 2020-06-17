package com.addressbook.test;

import com.addressbook.controller.AddressBookManager;

import java.util.*;

public class AddressBook {
    public static void main(String[] args)
    {
        AddressBook addressBook=new AddressBook();
        AddressBookManager addressBookManager=new AddressBookManager();

        System.out.println("Welcome to Address Book Program");
        Scanner Sc=new Scanner(System.in);
        System.out.println("Add Person");
        System.out.println("Edit Person");
        System.out.println("Delete Person");
        System.out.println("Exit");
        while(true)
        {
            System.out.println("Enter your choice");
            int choice = Sc.nextInt();
            switch (choice)
            {
                    case 1:
                        addressBookManager.addPerson(null);
                        break;

                    case 2:
                        addressBookManager.editPerson(null);
                        break;

                    case 3:
                        addressBookManager.deletePerson(null);
                        break;

                    case 4:
                        System.exit(0);

                    default:
                        System.out.println("Wrong Choice");
            }
        }
    }
}
