package ru.stqa.enums;

public enum Links {
    GOOGLE ("www.google.com"),
    LITECARD_ADMIN("localhost/litecard/admin/");


    private final String link;

    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return "http://" + link;
    }
}
