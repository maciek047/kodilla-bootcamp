package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Tim Ferris", "4 hour body", 2007,"signature1"));
        bookSet.add(new Book("Jordan Peterson", "Maps of meaning", 1992,"signature2"));
        bookSet.add(new Book("Jocko Willink", "Discipline equals freedom", 2016,"signature3"));
        bookSet.add(new Book("Grant Cardone", "10X rule", 2018,"signature4"));
        bookSet.add(new Book("Dave Asprey", "The Bulletproof diet", 2012,"signature5"));
        bookSet.add(new Book("Mihaly Csikszentmihalyi", "Flow", 2010,"signature6"));

        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println(median);
        assertEquals(median,2012, 0);
    }
}
