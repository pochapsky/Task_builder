package org.example;

public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

//Добавлено несколько новых людей для наглядности
        Person woman = new PersonBuilder()
                .setName("Светлана")
                .setSurname("Андреева")
                .build();
        woman.setAddress("Москва");
        System.out.println(woman);

        Person man = new PersonBuilder()
                .setName("Алекс")
                .setAge(16)
                .setSurname("Блэк")
                .setAddress("Сиэтл")
                .build();
        man.happyBirthday();
        System.out.println(man);

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}