package com.trinity.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    String fullName;
    LocalDate dob;
    String address;

    public Author() {
    }

    public Author(String fullName, LocalDate dob, String address) {
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Author{" + fullName + ", " + dob + ", " + address + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(fullName, author.fullName) && Objects.equals(dob, author.dob) && Objects.equals(address, author.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
