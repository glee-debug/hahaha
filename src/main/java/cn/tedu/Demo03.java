package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select name,type from hero");
            while (rs.next()){
                String name = rs.getString(1);
                String type = rs.getString(2);
                System.out.println(name+":"+type);
            }
            System.out.println("查询数据完毕!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
