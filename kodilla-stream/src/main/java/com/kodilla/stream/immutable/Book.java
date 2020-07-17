package com.kodilla.stream.immutable;

public final class Book {
    private final String tytul;
    private final String author;
    private final int yearOfPublication;

    public Book(final String title, final String author,
                final int yearOfPublication) {
        this.tytul = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTytul() {
        return tytul;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }


}