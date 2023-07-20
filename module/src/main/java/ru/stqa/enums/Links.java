package ru.stqa.enums;

public enum Links {
    GOOGLE ("www.google.com"),
    LITECART_ADMIN("localhost/litecart/admin/"),

    LITECART("localhost/litecart/");


    private final String link;
    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return "http://" + link;
    }
}
