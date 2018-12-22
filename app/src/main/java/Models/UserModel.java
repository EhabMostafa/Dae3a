package Models;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class UserModel extends PesronModel {
    private String NationalID;
    private Bitmap nationalImage;
    private boolean isVerified;
    private ArrayList<UserModel> LosersCommunication;

    public void SetData(String FullName, String Email, String Password, String PhoneNumber, String NationalID, Bitmap NationaID_IMG){
       this.fullName=FullName;
       this.email=Email;
       this.fullName=FullName;
       this.phone=PhoneNumber;
       this.NationalID=NationalID;
       this.isVerified=true;
       this.nationalImage=NationaID_IMG;

    }
}
