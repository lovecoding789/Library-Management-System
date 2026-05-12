package model;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;
    private Date issueDate;
    private Date returnDate;

    public Book(int id, String title, String author, boolean issued,Date issueDate,Date returnDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
        this.issueDate=issueDate;
        
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return issued; }
    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
