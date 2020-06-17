package com.addressbook.model;

public class Person
{
    private final String firstName;
    private final String lastName;
    String address;
    String city;
    String state;
    int zip;
    String phoneNumber;
    public Person(String firstName,String lastName,String address,String city,String state,int zip,String phoneNumber)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNumber=phoneNumber;
    }
    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public int getZip()
    {
        return this.zip;
    }

    public void setZip(int zip)
    {
        this.zip = zip;
    }

    public String getPhoneNo()
    {
        return this.phoneNumber;
    }

    public void setPhoneNo(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

}
