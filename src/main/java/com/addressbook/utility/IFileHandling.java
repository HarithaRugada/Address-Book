package com.addressbook.utility;

import com.addressbook.model.Person;

import java.util.List;

public interface IFileHandling {
    List<Person> convertToList(String filePath);

    void convertToFile(List<Person> addressBook, String filePath);
}
