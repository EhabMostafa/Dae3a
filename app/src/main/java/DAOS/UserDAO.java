package DAOS;

import android.util.Log;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Models.UserModel;
import Services.UserService;

public class UserDAO {
    UserService US=new UserService();

    public boolean CheckNotExist(UserModel Um) throws SQLException {
        ConnectionMySql CON=new ConnectionMySql();
        CON.Open();

        boolean res=false;

        US.con=CON.connection;
        String Password= US.getPassword(Um);
        CON.Close();


        Log.e("pass from DAO", Password);


        if(Password.equals("")){
            res=true;
        }

        return  res;
    }

    public void Save(UserModel UM) throws SQLException {
        ConnectionMySql CON=new ConnectionMySql();
        CON.Open();
        US.con=CON.connection;
        US.AddUser(UM);
        CON.Close();
    }

}
