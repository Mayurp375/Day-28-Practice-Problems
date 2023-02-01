package org.example.Day28PracticeProblems.adressBook;

import com.opencsv.CSVReader;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ContactMain {
    static List<Contact> bookList;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        String path = "D:\\java program\\Java by intelliJ\\demo\\src\\main\\java\\org\\example\\Day28PracticeProblems\\adressBook\\Contact.csv";
        ContactMain.fileAgenda(path);

        int ch;
        while (true) {
            System.out.println("enter value 0- Exit,1.add contact,3 - delete contact " +
                    "4 Find by cityName or stateName "+"5 find number by name" +
                    "+ 6 find dy sorted manner by there name");
            ch = sc.nextInt();
            if (ch == 0) {
                break;
            } else if (ch == 1) {
                //add contact
                ContactMain.Contact();
                ContactMain.fileWrite(path, bookList);
            } else if (ch == 2) {
                //edit contact
                System.out.println("enter name to edit");
                String name = sc.nextLine();
                ContactMain.editContact(name, path);

            } else if (ch == 3) {
                //delete contact
                System.out.println("enter name to delet");
                String name = sc.nextLine();
                ContactMain.deleteContact(name, path);
            }else if(ch == 4){
                System.out.println("enter cityName or stateName to search");
                String name = sc.nextLine();
                search(name,path);
            }else if(ch == 5){
                System.out.println("getting number of contact by name ");
                String name = sc.nextLine();
                searchContactNumber(name,path);
            }else if(ch == 6){
                System.out.println("sorted my name ");
                sortedByName(path);
            }
        }
    }
    private static void sortedByName(String path){
        //using stream API
        List<Contact> collect = bookList.stream().sorted(Comparator.comparing(Contact::getName)).collect(Collectors.toList());
        System.out.println(collect);
    } private static void sortedByCity(String path){
        //using stream API
        List<Contact> collect = bookList.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
        System.out.println(collect);
    } private static void sortedByState(String path){
        //using stream API
        List<Contact> collect = bookList.stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
        System.out.println(collect);
    } private static void sortedByZip(String path){
        //using stream API
        List<Contact> collect = bookList.stream().sorted(Comparator.comparing(Contact::getZip)).collect(Collectors.toList());
        System.out.println(collect);
    }
    private static void searchContactNumber(String name, String path) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name)) {
                System.out.println("found .......");
                Comparable<String> phone = bookList.get(i).getPhone();
                System.out.println(phone);
            }
        }
    }

    private static void deleteContact(String name, String path) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name)) {
                System.out.println("found .......");
                bookList.remove(i);
                System.out.println("Successfully removed....");
                System.out.println(bookList);
            }
        }
    }

    private static void editContact(final String name, String path) throws IOException {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name)) {
                System.out.println("found .......");
                System.out.println(bookList);
                if (true) {
                    Iterator<Contact> iterator = bookList.iterator();
                    while (iterator.hasNext()) {
                        Contact next = iterator.next();
                        System.out.println("enter new lastname");
                        String lastname = sc.nextLine();
                        System.out.println("enter new address");
                        String address = sc.nextLine();
                        System.out.println("enter new city");
                        String city = sc.nextLine();
                        System.out.println("enter new state");
                        String state = sc.nextLine();
                        System.out.println("enter new phone");
                        String phone = sc.nextLine();
                        System.out.println("enter new email");
                        String email = sc.nextLine();
                        System.out.println("enter new zip");
                        int zip = sc.nextInt();
                        bookList.add(new Contact(name, lastname, address, city, state, phone, email, zip));
                    }
                }
            } else {
                System.out.println("not found.......");
            }
        }
    }

    private static void search(final String name, String path) throws IOException {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCity().equals(name) || bookList.get(i).getState().equals(name)) {
                System.out.println("Record found .......");
                System.out.println(bookList);
            }
        }
    }


    private static void Contact() {

        Contact contact = new Contact();

        bookList = new ArrayList<Contact>();
        System.out.println("enter  firstname");
        String name = sc.next();
        System.out.println("enter  lastname");
        String lastname = sc.next();
        System.out.println("enter  address");
        String address = sc.next();
        System.out.println("enter  city");
        String city = sc.next();
        System.out.println("enter  state");
        String state = sc.next();
        System.out.println("enter  phone");
        String phone = sc.next();
        System.out.println("enter  email");
        String email = sc.next();
        System.out.println("enter  zip");
        int zip = sc.nextInt();
        contact = new Contact(name, lastname, address, city, state, phone, email, zip);
        if (contact.equals(bookList)) {
            System.out.println("Waste record already exist.....");
        } else {
            bookList.add(contact);
            System.out.println("Great record added successfully.....");
        }
    }

    static boolean fileAgenda(String path) throws IOException {

        File file = new File(path);
        boolean newFile = false;

        if (file.createNewFile()) {
            System.out.println("Created Successfully........!");
            newFile = true;
        } else {
            System.out.println("Already exist.........!");
        }
        return newFile;
    }

    private static void fileWrite(String path, List<Contact> bookList) throws IOException {

        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(String.valueOf(bookList));
        fileWriter.close();
        System.out.println("File writen successfully....");
    }
    private static  void fileRead(String path){
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(path);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
