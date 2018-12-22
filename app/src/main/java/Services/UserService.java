package Services;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Models.UserModel;

public class UserService {
    public Connection con ;

    public String getPassword(UserModel Um) throws SQLException {
        String password="";
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        String emo=Um.getEmail();
        System.out.println();
        System.out.print(emo);

        try {
            rs = st.executeQuery("select password from person where email = '"+Um.getEmail()+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String s = "hello";
        while (rs.next()) {
            s = rs.getString(1) ;

        }
        password=s;
        return  password;
    }
    public void AddUser(UserModel Um){

    }
}
