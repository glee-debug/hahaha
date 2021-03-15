package cn.tedu;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class task {
    @Test
    //查询人数最多的工作名称及人数
    public void test01(){
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "select job,count(job) from emp group by job order by count(job) desc limit 0,1";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                String job = rs.getString(1);
                int count = rs.getInt(2);
                System.out.println(job +":"+ count+"人");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    //查询每种工作的平均工资取前三种
    public void test02(){
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "select job,avg(sal) from emp group by job order by avg(sal) desc limit 0,3";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                String job = rs.getString(1);
                double avgSal = rs.getDouble(2);
                System.out.println(job +":"+ avgSal+"元");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    //查询每种工作的人数 只查询三个人以内的工作
    public void test03(){
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "select job,count(job) 人数 from emp group by job having 人数<3";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                String job = rs.getString(1);
                 int count = rs.getInt(2);
                System.out.println(job +":"+ count+"人");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    //查询最高工资的部门有多少人
    public void test04(){
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "select deptno,count(*) from emp where deptno=(select deptno from emp where sal=(select max(sal) from emp))";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                int deptno = rs.getInt(1);
                int count = rs.getInt(2);
                System.out.println(deptno +":"+ count+"人");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    //查询工资高于2000的每个员工的姓名,工资和对应的部门名
    public void test05(){
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "select ename,sal,dname from emp e join dept d on e.deptno = d.deptno where sal>2000";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString(1);
                double salary = rs.getDouble(2);
                String dname = rs.getString(3);
                System.out.println(name +": 工资:"+ salary+"元,"+"部门名:"+dname);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    //查询所有的部门名和对应的员工姓名和工资
    public void test06(){
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "select dname,ename,sal from emp e join dept d on e.deptno = d.deptno";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                String dname = rs.getString(1);
                String name = rs.getString(2);
                double salary = rs.getDouble(3);
                System.out.println(dname +"部: 姓名:"+ name+",工资:"+salary);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Test
    //查询平均工资最高的部门编号
    public void test07(){
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            String sql = "select deptno from emp group by deptno order by avg(sal) desc limit 0,1";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                String deptno = rs.getString(1);
                System.out.println("最高工资部门编号:"+deptno);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
