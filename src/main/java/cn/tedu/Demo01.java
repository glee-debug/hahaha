package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            s.execute("create table hero(id int primary key auto_increment,name varchar(20),type varchar(20)) charset=utf8");
            System.out.println("hero表创建完毕!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
