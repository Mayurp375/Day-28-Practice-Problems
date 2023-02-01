package org.example.Day28PracticeProblems.adressBook;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contactList = new ArrayList<Contact>();
        contactList.add(new Contact("mayur", "polojwar", 442603));
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().equals("mayur")) {
                System.out.println(contactList);
                System.out.println("found");
            } else {
                System.out.println("not found");
            }
        }
    }
}
