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

public class JSONFileHandler {
    public void writeToJSONFile(Person person) {
        final String JSON_FILE_PATH = "./src/main/resources/PersonDetails.json";
        JSONArray personArray = new JSONArray();
        JSONObject personDetails = new JSONObject();
        personDetails.put("First Name", person.getFirstName());
        personDetails.put("Last Name", person.getLastName());
        personDetails.put("Address", person.getAddress());
        personDetails.put("City", person.getCity());
        personDetails.put("State", person.getState());
        personDetails.put("Zip", person.getZip());
        personDetails.put("Phone Number", person.getPhoneNumber());
        personArray.add(personDetails);
        try (FileWriter file = new FileWriter(JSON_FILE_PATH)) {
            file.write(personArray.toJSONString());
            file.flush();
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

    public List<Person> readFromJsonFile(String jsonFilePath) {
        JSONParser jsonParser = new JSONParser();
        List<Person> addressBook = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(jsonFilePath);
            Object obj = jsonParser.parse(fileReader);
            JSONArray personList = (JSONArray) obj;
            personList.forEach(person -> addressBook.add(parsePersonObject((JSONObject) person)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return addressBook;
    }
}
