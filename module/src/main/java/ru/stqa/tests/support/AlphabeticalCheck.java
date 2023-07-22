package ru.stqa.tests.support;

import java.util.ArrayList;
import java.util.Collections;

public class AlphabeticalCheck {

    public void checkByAlphabetical(ArrayList<String> listOnPage) {
        ArrayList<String> listByAlphabetical = new ArrayList<>(listOnPage);
        Collections.sort(listByAlphabetical);
        for (int i = 0; i < listOnPage.size(); i++) {
            if (!listOnPage.get(i).equals(listByAlphabetical.get(i))) {
                throw new NullPointerException(
                        "On the page in " + i + " row is " + listOnPage.get(i) + " but should be " + listByAlphabetical.get(i));
            }
        }
    }
}
