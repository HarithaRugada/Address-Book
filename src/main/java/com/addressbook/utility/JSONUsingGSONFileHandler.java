package com.addressbook.utility;

import com.addressbook.model.Person;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONUsingGSONFileHandler implements IFileHandling{
    final String JSON_FILE_PATH = "./src/main/resources/PersonDetailsUsingGSON.json";

    @Override
    public void convertToFile(List<Person> addressBook,String filePath) {
        String personDetails = new Gson().toJson(addressBook);
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(personDetails);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public List<Person> convertToList(String filePath) {
        List<Person> addressBookList = null;
        try {
            Person[] personDetails = new Gson().fromJson(new FileReader(filePath), Person[].class);
            addressBookList = new ArrayList<>(Arrays.asList(personDetails));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }
}
