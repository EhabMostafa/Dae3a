package Models;

import android.graphics.Bitmap;

import java.util.Date;

public class PostModel {
    private int ID;
    private String title;
    private String description;
    private Date postDate;
    private boolean isAdded;
    private boolean isEdited;
    private Bitmap postImage;
    CategoryModel category;
    UserModel user;
}
