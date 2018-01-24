package stv_test_bookManagerment_project.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stv_test_bookManagerment_project.beans.Book;
import stv_test_bookManagerment_project.beans.FeedBack;
 
public class DBUtils {
 
    public static List<Book> queryProduct(Connection conn) throws SQLException {
        String sql = "Select a.ID, a.Name, a.Publisher, a.NUMBER_OF_PAGES from Product a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Book> list = new ArrayList<Book>();
        while (rs.next()) {
        	int Id = rs.getInt("ID");
            String bookName = rs.getString("Name");
            String publisherName = rs.getString("Publisher");
            int numberOfPage = rs.getInt("NUMBER_OF_PAGES");
            Book product = new Book();
            product.setId(Id);
            product.setBookName(bookName);
            product.setPublisherName(publisherName);
            product.setNumberOfPage(numberOfPage);
            list.add(product);
        }
        return list;
    }
 
    public static Book findProduct(Connection conn, int id) throws SQLException {
        String sql = "Select a.ID, a.Name, a.Publisher, a.NUMBER_OF_PAGES from Product a where a.ID=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("Name");
            String publisher = rs.getString("Publisher");
            int numberOfPage = rs.getInt("NUMBER_OF_PAGES");
            Book product = new Book(id, name, publisher, numberOfPage);
            return product;
        }
        return null;
    }
 
    public static void updateProduct(Connection conn, Book product) throws SQLException {
        String sql = "Update Product set Name =?, Publisher=?, NUMBER_OF_PAGES=? where ID=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getBookName());
        pstm.setString(2, product.getPublisherName());
        pstm.setInt(3, product.getNumberOfPage());
        pstm.setInt(4, product.getId());
        pstm.executeUpdate();
    }
 
    public static void insertProduct(Connection conn, Book product) throws SQLException {
        String sql = "Insert into Product(Name, Publisher, NUMBER_OF_PAGES) values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getBookName());
        pstm.setString(2, product.getPublisherName());
        pstm.setInt(3, product.getNumberOfPage());
        pstm.executeUpdate();
    }
 
    public static void deleteProduct(Connection conn, int id) throws SQLException {
        String sql = "Delete From Product where ID= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, id);
 
        pstm.executeUpdate();
    }
    
    public static List<FeedBack> queryFeedBack(Connection conn) throws SQLException {
        String sql = "Select a.ID, a.PRODUCT_ID, a.FEED_BACK from FEEDBACK a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<FeedBack> list = new ArrayList<FeedBack>();
        while (rs.next()) {
        	int Id = rs.getInt("ID");
        	int productId = rs.getInt("PRODUCT_ID");
            String feedBackContent = rs.getString("FEED_BACK");
            FeedBack feedBack = new FeedBack();
            feedBack.setID(Id);
            feedBack.setProductId(productId);
            feedBack.setFeedBack(feedBackContent);
            list.add(feedBack);
        }
        return list;
    }
    
    public static FeedBack findFeedBack(Connection conn, int id) throws SQLException {
        String sql = "Select a.ID, a.PRODUCT_ID, a.FEED_BACK from FEEDBACK a where a.ID=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	int productId = rs.getInt("PRODUCT_ID");
            String feedBackContent = rs.getString("FEED_BACK");
            FeedBack feedBack = new FeedBack(id, productId, feedBackContent);
            return feedBack;
        }
        return null;
    }
    
    public static void updateFeedBack(Connection conn, FeedBack feedBack) throws SQLException {
        String sql = "Update FEEDBACK set PRODUCT_ID =?, FEED_BACK=? where ID=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, feedBack.getProductId());
        pstm.setString(2, feedBack.getFeedBack());
        pstm.setInt(1, feedBack.getID());
        pstm.executeUpdate();
    }
    
    public static void deleteFeedBack(Connection conn, int id) throws SQLException {
        String sql = "Delete From FEEDBACK where ID= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, id);
 
        pstm.executeUpdate();
    }
    
    public static void insertFeedBack(Connection conn, FeedBack feedBack) throws SQLException {
        String sql = "Insert into FEEDBACK(PRODUCT_ID, FEED_BACK) values (?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, feedBack.getProductId());
        pstm.setString(2, feedBack.getFeedBack());
        pstm.executeUpdate();
    }
    
    public static void insertNewFeedBack(Connection conn, FeedBack feedBack) throws SQLException {
        String sql = "Insert into FEEDBACK(FEED_BACK) values (?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, feedBack.getFeedBack());
        pstm.executeUpdate();
    }
 
}
