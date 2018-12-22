package Models;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class UserModel extends PesronModel {
    private String NationalID;
    private Bitmap nationalImage;
    private boolean isVerified;
    private ArrayList<UserModel> LosersCommunication;
}
