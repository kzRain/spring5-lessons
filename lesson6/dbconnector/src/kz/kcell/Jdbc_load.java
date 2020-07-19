package kz.kcell;


import java.sql.*;
import java.util.HashMap;


public class Jdbc_load {


    public static void main(String[] args) {
        String driver="com.mysql.jdbc.Driver";
        String user="testmysql";
        String password="Test+!Mysql=2";
        String url="jdbc:mysql://192.168.196.197:3306/classicmodels";
        String query="select * from all_data_types";

      get_result(driver,user,password,url,query);

    }

    public void get_result(String driver, String user, String password, String url, String query)  {
         Connection connect = null;
         Statement statement = null;
         PreparedStatement preparedStatement = null;
         ResultSet resultSet = null;
         int columsN =0;
         String type=null;

        ResultSetMetaData rsmd = null;
        HashMap<Integer, String> myColumsTyps = null;
        //Подключаем драйвер
        try {
            Class.forName(driver.trim());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);

            myColumsTyps = new HashMap <Integer, String>();
            rsmd = resultSet.getMetaData();
            columsN = rsmd.getColumnCount();
            for (int j = 1; j <= columsN; j++) {
                myColumsTyps.put( j,rsmd.getColumnClassName(j) );
            }

            for (int j = 1; j <= columsN; j++) {
                System.out.println(myColumsTyps.get(j));
            }

            while (resultSet.next()) {
                this.getconvertValue(myColumsTyps, resultSet );

            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            //close connection ,stmt and resultset here
            try { connect.close(); } catch(SQLException se) { /*can't do anything */ }
            try { statement.close(); } catch(SQLException se) { /*can't do anything */ }
            try { resultSet.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    public String   getconvertValue( HashMap coltypes,  ResultSet rs){
        String result="";
        int columsN=coltypes.size();

        for (int j = 1; j <= columsN; j++) {

        }

        return result;
    }




    }



