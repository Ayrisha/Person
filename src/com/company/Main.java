package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Person{
    private String name;
    private String surname;
    private String patronymic;
    private Date birthday;

    public Person(String name, String surname, String patronymic, Date birthday){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setPatronymic(String patronymic){
        this.patronymic = patronymic;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getPatronymic(){
        return this.patronymic;
    }
    public Date getBirthday(){
        return this.birthday;
    }
}

public class Main {
    public static boolean Check(String str){
        return str.matches("^[А-Яа-я]+$");
    }

    public static void main(String[] args) {
        String pol = "";
        System.out.println("Введите свои данные(Фамилия Имя Отчество Дата рождения(ДД.ММ.ГГГГ)): ");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        String surname = in.next();
        String patronymic = in.next();
        String birthday = in.next();
        SimpleDateFormat formatForDate = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = formatForDate.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Неправильный ввод даты");
        }
        Person pr = new Person(name, surname, patronymic, date);
        try{
            if (pr.getPatronymic().substring(pr.getPatronymic().length() - 2, pr.getPatronymic().length()).equals("ич")
                    || pr.getPatronymic().substring(pr.getPatronymic().length() - 2, pr.getPatronymic().length()).equals("лы")) {
                pol = "Мужчина";
            }
            else {
                pol = "Женщина";
            }

        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println("Невозможно определить пол");
        }
        try {
            long difference = System.currentTimeMillis() - date.getTime();
            int day = (int)(difference/(24 * 60 * 60 * 1000));
            int old = day/365;
            if (!Check(name))
                throw new NullPointerException();
            System.out.println("Ваши инициалы, пол, возраст:");
            System.out.println(pr.getName().charAt(0)+"."+pr.getSurname().charAt(0)+"."+pr.getPatronymic().charAt(0)+". "+pol+" "+ old);
        }
        catch (NullPointerException e){
            System.out.println("Недостаточно данных");
        }
    }
}
