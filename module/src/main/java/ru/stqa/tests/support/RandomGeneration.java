package ru.stqa.tests.support;

import java.util.Random;

public class RandomGeneration {

    public String randomAlphabeticalString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int length = 10;
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (new Random().nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public String randomAlphabeticalChar() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        StringBuilder buffer = new StringBuilder(1);
        int randomLimitedInt = leftLimit + (int)
                (new Random().nextFloat() * (rightLimit - leftLimit + 1));
        buffer.append((char) randomLimitedInt);
        String generatedString = buffer.toString();
        return generatedString;
    }
}
