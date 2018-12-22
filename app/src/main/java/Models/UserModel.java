package Models;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class UserModel extends PesronModel {
    private String NationalID;
    private Bitmap nationalImage;
    private boolean isVerified;

    public String getNationalID() {
        return NationalID;
    }

    public Bitmap getNationalImage() {
        return nationalImage;
    }

    public boolean isVerified() {
        return isVerified;
    }

    private ArrayList<UserModel> LosersCommunication;

    public void SetData(String FullName, String Email, String Password, String PhoneNumber, String NationalID, Bitmap NationaID_IMG){
       this.fullName=FullName;
       this.email=Email;
        this.password=Password;
       this.phone=PhoneNumber;
       this.NationalID=NationalID;

       this.nationalImage=NationaID_IMG;
       this.isVerified=true;
       this.isAdmin=false;

    }
}
