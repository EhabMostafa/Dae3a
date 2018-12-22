package DAOS;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

class ConnectionMySql {
    String className = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://192.168.137.1/dae3a";         //localhost and database name
    String MySQL_userName = "ehab";                         //DataBase Username
    String MySQL_Password = "111";                          //DataBase Password for this user name

    Connection connection = null;


    public void Open() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);


        try {
            System.out.println();

            Class.forName(className);

            connection = DriverManager.getConnection(url, MySQL_userName, MySQL_Password);


        } catch (SQLException se) {

            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {

            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {

            Log.e("ERRO", e.getMessage());
        }
    }

    public void Close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}