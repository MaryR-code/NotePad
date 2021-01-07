package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Person extends Record {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID из Record
        return String.format("%s. first name: %s; last name: %s; phone: %s; email: %s", str, firstName, lastName, phone, email);
    }

    @Override
    public void askData() {
        firstName = InputUtils.askString("First name");
        lastName = InputUtils.askString("Last name");
        phone = InputUtils.askString("Phone");
        email = InputUtils.askString("Email");
    }

    @Override
    public RecordType getType() { return RecordType.PERSON; }

    @Override
    public void saveRecord(PrintWriter out) {
        super.saveRecord(out);
        out.println(firstName);
        out.println(lastName);
        out.println(phone);
        out.println(email);
    }

    @Override
    public void loadRecord(Scanner in) {
        super.loadRecord(in);
        firstName = in.next();
        lastName = in.next();
        phone = in.next();
        email = in.next();
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || firstName.toLowerCase().contains(substr)
                || lastName.toLowerCase().contains(substr)
                || phone.toLowerCase().contains(substr)
                || email.toLowerCase().contains(substr);
    }
}
