package com.addressbook.utility;

import com.addressbook.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileHandler implements IFileHandling {
    @Override
    public void convertToFile(List<Person> addressBook, String filePath) {
        JSONArray personArray = new JSONArray();
        for (Person person : addressBook) {
            JSONObject personDetails = new JSONObject();
            personDetails.put("First Name", person.getFirstName());
            personDetails.put("Last Name", person.getLastName());
            personDetails.put("Address", person.getAddress());
            personDetails.put("City", person.getCity());
            personDetails.put("State", person.getState());
            personDetails.put("Zip", person.getZip());
            personDetails.put("Phone Number", person.getPhoneNumber());
            personArray.add(personDetails);
        }
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(personArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Person parsePersonObject(JSONObject jsonObject) {
        JSONObject personObject = (JSONObject) jsonObject.get("person");
        Person person = new Person();
        person.firstName = (String) personObject.get("First Name");
        person.lastName = (String) personObject.get("Last Name");
        person.address = (String) personObject.get("Address");
        person.city = (String) personObject.get("City");
        person.state = (String) personObject.get("State");
        person.zip = (String) personObject.get("Zipcode");
        person.phoneNumber = (String) personObject.get("Phone Number");
        return person;
    }

    @Override
    public List<Person> convertToList(String filePath) {
        JSONParser jsonParser = new JSONParser();
        List<Person> addressBook = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            Object obj = jsonParser.parse(fileReader);
            JSONArray personList = (JSONArray) obj;
            personList.forEach(person -> addressBook.add(parsePersonObject((JSONObject) person)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return addressBook;
    }
}
