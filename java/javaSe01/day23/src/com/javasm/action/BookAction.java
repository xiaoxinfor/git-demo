package com.javasm.action;

import com.javasm.bean.Book;
import com.javasm.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/2/17-17:03
 * @Since:jdk1.8
 * @Description:
 */
public class BookAction {
    /**
     * 查询整张表的数据
     *
     * @return
     */
    public List<Book> select(){
        List<Book> bookList = new ArrayList<>();
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (con != null && !con.isClosed()){
                String sql = "select * from book";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    Book book = new Book();
                    book.setId(rs.getInt(1));
                    book.setBookname(rs.getString(2));
                    book.setNums(rs.getInt(3));
                    book.setPrice(rs.getInt(4));
                    bookList.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con,ps,rs);
        }
        return bookList;
    }

    public Book seletById(int id){
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = null;
        try {
            if (con != null && !con.isClosed()){
                String sql = "select * from book where id = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1,id);
                rs = ps.executeQuery();
                if (rs.next()){
                    book = new Book();
                    book.setId(rs.getInt(1));
                    book.setBookname(rs.getString(2));
                    book.setNums(rs.getInt(3));
                    book.setPrice(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    /**
     * 增加数据
     * @param book
     */
    public void insert(Book book){
        //获取连接
        Connection con = JDBCUtils.getConnection();
        PreparedStatement ps = null;

        try {
            if (con != null && !con.isClosed()){
                System.out.println("连接成功");
            }
            //编写sql语句
            String sql = "INSERT INTO book(id,bookName,nums,price) VALUES (?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,book.getId());
            ps.setString(2,book.getBookname());
            ps.setInt(3,book.getNums());
            ps.setInt(4,book.getPrice());

            int jieguo = ps.executeUpdate();
            if (jieguo > 0){
                System.out.println("添加成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(con,ps);
        }
    }
}
