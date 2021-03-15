package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            s.executeUpdate("insert into hero values (1,'诸葛亮','法师'),(2,'孙尚香','射手')");
            System.out.println("插入数据完毕!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
