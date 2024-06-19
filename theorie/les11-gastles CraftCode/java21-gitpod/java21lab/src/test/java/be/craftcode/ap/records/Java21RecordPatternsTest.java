package be.craftcode.ap.records;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class Java21RecordPatternsTest {
    Java21RecordPatterns java21RecordPatterns = new Java21RecordPatterns();

    Award awardOne = new Award("International Horror Guild Award", "Living Legend Award", 2003);
    Award awardTwo = new Award("Bram Stoker Award", "Lifetime Achievement Award", 2002);
    Award awardThree = new Award("World Horror Convention", "Grand Master Award", 1992);
    Author authorOne = new Author("Stephen", "King", 79, new ArrayList<>(Arrays.asList(awardOne, awardTwo, awardThree)));
    Book bookOne = new Book("Pet Sematary", 416, 15.99, authorOne);

    @Test
    void oldWrongTest() {
        assertEquals("", java21RecordPatterns.oldStyleFindOldestAwardCategory(null), "Expected wrong object to return empty.");
        assertEquals("", java21RecordPatterns.oldStyleFindOldestAwardCategory(3), "Expected wrong object to return empty.");
        assertEquals("", java21RecordPatterns.oldStyleFindOldestAwardCategory(awardOne), "Expected wrong object to return empty."); 
    }

    @Test
    void oldRightTest() {
        assertEquals("Grand Master Award", java21RecordPatterns.oldStyleFindOldestAwardCategory(bookOne));
    }

    @Test
    void givenWrongInputOldestCategoryShouldReturnEmpty() {
        assertEquals("", java21RecordPatterns.findOldestAwardCategory(null), "Expected wrong object to return empty.");
        assertEquals("", java21RecordPatterns.findOldestAwardCategory(3), "Expected wrong object to return empty.");
        assertEquals("", java21RecordPatterns.findOldestAwardCategory(awardOne), "Expected wrong object to return empty."); 
    }

    @Test
    void givenBookOldestCategoryShouldReturnCorrectString() {
        assertEquals("Grand Master Award", java21RecordPatterns.findOldestAwardCategory(bookOne));
    }
}
