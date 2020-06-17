package com.addressbook.test;

import com.addressbook.controller.AddressBookManager;

public class AddressBook {
    public static void main(String[] args)
    {
        AddressBook addressBook=new AddressBook();
        AddressBookManager addressBookManager=new AddressBookManager();

        System.out.println("Welcome to Address Book Program");

        System.out.println("Add Person");
        addressBookManager.addPerson(null);
    }
}
