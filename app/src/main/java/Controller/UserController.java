package Controller;

import android.graphics.Bitmap;

import java.sql.SQLException;

import DAOS.UserDAO;
import Models.UserModel;

public class UserController {
    UserDAO UD=new UserDAO();
    String Message="";
    boolean res=true;
    UserModel UM=new UserModel();
    public String  Register(String FullName, String Email, String Password, String PhoneNumber, String NationalID, Bitmap NationaID_IMG){
        UM.SetData(FullName,Email,Password,PhoneNumber,NationalID,NationaID_IMG);
        try {
           res= UD.CheckNotExist(UM);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(res){
            Message="Registeration Success";
            UD.Save(UM);
        }
        else{
            Message="Registeration Faild";
        }

        return Message;
    }
}
