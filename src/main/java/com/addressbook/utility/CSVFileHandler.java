package com.addressbook.utility;

import com.addressbook.model.Person;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler implements IFileHandling {
    @Override
    public void convertToFile(List<Person> addressBook, String filePath) {
        try {
            Writer csvWriter = Files.newBufferedWriter(Paths.get(filePath));
            csvWriter.append("First Name,");
            csvWriter.append("Last Name,");
            csvWriter.append("Address,");
            csvWriter.append("City,");
            csvWriter.append("State,");
            csvWriter.append("Zip,");
            csvWriter.append("Phone Number");
            for (Person person : addressBook) {
                csvWriter.append("\n").append(person.getFirstName());
                csvWriter.append(",").append(person.getLastName());
                csvWriter.append(",").append(person.getAddress());
                csvWriter.append(",").append(person.getCity());
                csvWriter.append(",").append(person.getState());
                csvWriter.append(",").append(person.getZip());
                csvWriter.append(",").append(person.getPhoneNumber());
            }
            csvWriter.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public List<Person> convertToList(String filePath) {
        List<Person> addressBookList = null;
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(Person.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            addressBookList = (ArrayList<Person>) csvToBean.parse();
            return addressBookList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }
}
