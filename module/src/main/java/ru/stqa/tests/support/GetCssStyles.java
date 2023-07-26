package ru.stqa.tests.support;

import org.openqa.selenium.WebElement;

public class GetCssStyles {

    public String[] getColors(WebElement element) {
        String colors = element.getCssValue("color");
        colors = removeChars(colors, "rgba(),");
        return colors.split(" ");
    }

    public Double getFontSize(WebElement element) {
        String fontSize = element.getCssValue("font-size");
        return Double.parseDouble(removeChars(fontSize, "px"));
    }

    private String removeChars(String newString, String charsToRemove) {
        for (char c : charsToRemove.toCharArray()) {
            newString = newString.replace(String.valueOf(c), "");
        }
        return newString;
    }
}
