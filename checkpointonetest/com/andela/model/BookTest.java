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
    bookTest.getBookTitle();
    bookTest.getIsbnNumber();
    bookTest.getNameOfAuthor();
    bookTest.getNumberOfCopies();
    bookTest.setBookTitle("Rich Dad Poor Dad");


    int increment = 5;
    int initialNumberOfCopies = bookTest.getNumberOfCopies();
    bookTest.incrementBookCopies(increment);
    assertTrue(bookTest.getNumberOfCopies() == initialNumberOfCopies + increment);
  }
  @Test
  public void testdecrementBookCopies() throws Exception {
    int decrement = 1;
    int initialNumberOfCopies = bookTest.getNumberOfCopies();
    bookTest.decrementBookCopies(decrement);
    assertTrue(bookTest.getNumberOfCopies() == 0);

    bookTest.incrementBookCopies(6);
    bookTest.decrementBookCopies(5);
    assertTrue(bookTest.getNumberOfCopies() == 1);

  }
}