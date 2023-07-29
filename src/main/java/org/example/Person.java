package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        if (name == null) {
            throw new IllegalStateException("Не заполнены обязательные поля, имя не указанно, name: " + name);
        } else {
            this.name = name;
        }

        if (surname == null) {
            throw new IllegalStateException("Не заполнены обязательные поля, фамилия не указанна, " +
                    "surname: " + surname);
        } else {
            this.surname = surname;
        }

        this.age = age;
        this.address = address;
    }


    public boolean hasAge() {
        if (getAge().hashCode() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        if (this.address == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {

        return this.surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(this.age);
    }

    public String getAddress() {
        if (hasAddress()) {
            return this.address;
        } else {
            return "Адрес не известен";
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (getAge().hashCode() != 0) {
            this.age += 1;
        }
    }

    @Override
    public String toString() {
        return "Person: " +
                "\n name='" + name +
                "\n surname='" + surname +
                "\n age='" + age +
                "\n address='" + address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(7)
                .setAddress(address);
    }


}
