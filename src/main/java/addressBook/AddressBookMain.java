package addressBook;

import com.example.addressBook.AddressBook;
import com.example.addressBook.Person;

import java.io.*;
import java.util.List;

public class AddressBookMain {

    public static Person newPerson(String name, int id, String email, Person.PhoneNumber[] phones) {
         return Person.newBuilder()
                .setEmail(email)
                .setId(id)
                .setName(name)
                .addAllPhones(List.of(phones)).build();
    }

    public static Person.PhoneNumber newPhoneNumber(String number, Person.PhoneType type) {
        return Person.PhoneNumber.newBuilder()
                .setNumber(number)
                .setType(type).build();
    }

    public static void writeToAddressBook(Person person, String path){
        try{
            AddressBook.Builder addressBook = AddressBook.newBuilder();
            try {
                FileInputStream fis = new FileInputStream(path);
                addressBook.mergeFrom(fis);
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found: Creating New File");
            }
            FileInputStream fis = new FileInputStream(path);
            addressBook.mergeFrom(fis);
            addressBook.addPeople(person);

            FileOutputStream fos = new FileOutputStream(path);

            addressBook.build().writeTo(fos);
            fos.close();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromAddressBook(String path){
        try{
            FileInputStream fis = new FileInputStream(path);
            AddressBook addressBook = AddressBook.parseFrom(fis);
            System.out.println(addressBook);

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Person.PhoneNumber[] phones = new Person.PhoneNumber[3];

        phones[0] = newPhoneNumber("1234567890", Person.PhoneType.HOME);
        phones[1] = newPhoneNumber("1234567891", Person.PhoneType.MOBILE);
        phones[2] = newPhoneNumber("1234567892", Person.PhoneType.WORK);

        Person person = newPerson("A Name", 890, "abc@xyz.com", phones);

        String path = "addressBook.bin";

        writeToAddressBook(person, path);
        readFromAddressBook(path);

    }
}
