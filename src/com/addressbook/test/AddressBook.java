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
        System.out.println("Enter your choice");
        int choice=Sc.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Add Person");
                addressBookManager.addPerson(null);
                break;

            case 2:
                System.out.println("Edit Person");
                addressBookManager.editPerson(null);
                break;

            default:
                System.out.println("Wrong Choice");
        }
    }
}
