package com.luma.automation.framework.features.managers;

import com.github.javafaker.Faker;

import java.util.Locale;

public class JavaFaker {
    private static Faker fakerObject = new Faker();

    public static String getRandomFirstName(){
        return fakerObject.name().firstName();
    }
    public static String getRandomLastName(){
        return fakerObject.name().lastName();
    }
    public static String getRandomEmail(){
        return fakerObject.internet().emailAddress();
    }
    public static String getRandomPassword(){
        return String.valueOf(fakerObject.internet().password(5,20,true,true,true));
    }


}
