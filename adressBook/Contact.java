package org.example.Day28PracticeProblems.adressBook;

import java.util.Comparator;

public class Contact implements Comparable<Contact> {
    String name, lastName, address, city, state, phone, email;
    int zip;

    public Contact(String name, String lastName, int zip) {
        this.name = name;
        this.lastName = lastName;
        this.zip = zip;
    }

    public Contact(String name, String lastName, String address, String city, String state, String phone, String email, int zip) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
        this.zip = zip;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "ContactBook{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", zip=" + zip +
                '}';
    }

    public int compareTo(Contact o) {
        return this.zip - o.zip;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact that = (Contact) o;
        return zip == that.zip && name.equals(that.name) && lastName.equals(that.lastName) && address.equals(that.address) && city.equals(that.city) && state.equals(that.state) && phone.equals(that.phone) && email.equals(that.email);
    }
}

class SortByName implements Comparator<Contact>{

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
