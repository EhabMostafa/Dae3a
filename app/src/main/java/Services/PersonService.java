package Services;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.UserModel;

public class PersonService {
    public Connection con ;

    public String getPassword(String email) throws SQLException {
        String password="";
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;



        try {
            rs = st.executeQuery("select password from person where email = '"+email+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        while (rs.next()) {
            password = rs.getString(1) ;

        }
        Log.e("pass : ", password);

        return  password;
    }
}
