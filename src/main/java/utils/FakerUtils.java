package utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static String generateName(){
        Faker faker = new Faker();
        return faker.regexify("Playlist " + "[A-Za-z0-9 ,_-]{10}");
    }

    public static String generateDesc(){
        Faker faker = new Faker();
        return faker.regexify("Description " + "[A-Za-z0-9 @$#^()?,_-]{20}");
    }
}
