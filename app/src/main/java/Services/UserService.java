package Services;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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


        try {
            rs = st.executeQuery("select password from person where email = '"+Um.getEmail()+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        while (rs.next()) {
            password = rs.getString(1) ;

        }
        Log.e("pass : ", password);

        return  password;
    }


    public void AddUser(UserModel Um) throws SQLException {

        ByteArrayOutputStream STREAM=new ByteArrayOutputStream();
        Um.getNationalImage().compress(Bitmap.CompressFormat.JPEG,90,STREAM);
        byte[] inbyte=STREAM.toByteArray();
        ByteArrayInputStream in=new ByteArrayInputStream(inbyte);

        String Q="insert into person (`fullName`, `email`, `password`, `phoneNumber`, `nationalID`, `IsVerified`, `IsAdmin`,`nationalIdImage`) VALUES ( '"+Um.getFullName()+"','"+Um.getEmail()+"','"+Um.getPassword()+"','"+Um.getPhone()+"','"+Um.getNationalID()+"',"+Um.isVerified()+","+Um.isAdmin()+",?)";
        Log.e("Query", Q);
        PreparedStatement ps=con.prepareStatement(Q);
        ps.setBinaryStream(1,in);
        ps.executeUpdate();
    }
}
