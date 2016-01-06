package com.andela.model;

/**
 * Created by Spykins on 20/12/2015.
 */
public class Book {

  private String bookTitle;
  private int isbnNumber;
  private String nameOfAuthor;
  private int numberOfCopies;

  public Book(String bookTitle, int isbnNumber, String nameOfAuthor, int numberOfCopies) {
    this.bookTitle = bookTitle;
    this.isbnNumber = isbnNumber;
    this.nameOfAuthor = nameOfAuthor;
    this.numberOfCopies = numberOfCopies;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public int getIsbnNumber() {
    return isbnNumber;
  }

  public String getNameOfAuthor() {
    return nameOfAuthor;
  }

  public int getNumberOfCopies() {
    return numberOfCopies;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public void incrementBookCopies(int numberOfCopiesToAdd){
    this.numberOfCopies += numberOfCopiesToAdd;
  }
}
