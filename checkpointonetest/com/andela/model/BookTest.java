package com.andela.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Spykins on 20/12/2015.
 */
public class BookTest {
  Book bookTest = new Book("Lion King", 1024, "Waleola", 1);
  @Test
  public void testIncrementBookCopies() throws Exception {
    int increment = 5;
    int initialNumberOfCopies = bookTest.getNumberOfCopies();
    bookTest.incrementBookCopies(increment);
    assertTrue(bookTest.getNumberOfCopies() == initialNumberOfCopies + increment);
  }
}