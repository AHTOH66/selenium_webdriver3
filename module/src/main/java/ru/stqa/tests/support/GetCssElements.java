package ru.stqa.tests.support;

import org.openqa.selenium.WebElement;

public class GetCssElements {

    public String[] getColors(WebElement element) {
        String colors = element.getCssValue("color");
        String charsToRemove = "rgba(),";
        for (char c : charsToRemove.toCharArray()) {
            colors = colors.replace(String.valueOf(c), "");
        }
        return colors.split(" ");
    }

    public int getFontSize(WebElement element) {
        String fontSize = element.getCssValue("font-size");
        String charsToRemove = "px";
        for (char c : charsToRemove.toCharArray()) {
            fontSize = fontSize.replace(String.valueOf(c), "");
        }
        return Integer.parseInt(fontSize);
    }
}
