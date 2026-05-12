package dao;

import java.sql.*;
import java.util.*;
import model.Book;

public class BookDAO {

    private String url = "jdbc:mysql://localhost:3306/library";
    private String user = "";
    private String pass = "";

    // Get all books
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM books");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("isIssued"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date")
                        
                ));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    // Add ToatalBooks
    
    public int getTotalBooks() {
        int count = 0;

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM books");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    

    // Add new book
    public void addBook(String title, String author) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(title, author, isIssued) VALUES (?, ?, false)"
            );

            ps.setString(1, title);
            ps.setString(2, author);

            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Issue Book 
    public boolean issueBook(int id) {
        boolean success = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement(
                "UPDATE books SET isIssued = true, issue_date = CURDATE(), return_date = DATE_ADD(CURDATE(), INTERVAL 7 DAY) WHERE id = ?"
            );

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            success = rows > 0;

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }
    
    // Issue Books
    public int getIssuedBooks() {
        int count = 0;

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM books WHERE isIssued = true");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    // Available Books
    
    public int getAvailableBooks() {
        int count = 0;

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM books WHERE isIssued = false");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
    // Ovedue Books
    
    public int getOverdueBooks() {
        int count = 0;

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement(
                "SELECT COUNT(*) FROM books WHERE return_date < CURDATE() AND isIssued = true"
            );
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }
       
    // 🔹 Return book
    public boolean returnBook(int id) {
        boolean success = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement(
                "UPDATE books SET isIssued = false, issue_date = NULL, return_date = NULL WHERE id = ?"
            );

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            success = rows > 0;

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }

 
    public boolean isBookIssued(int id) {
        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement(
                "SELECT isIssued FROM books WHERE id = ?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = rs.getBoolean("isIssued");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
