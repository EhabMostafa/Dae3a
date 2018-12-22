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

    public void setpostmodel(int ID,String title,String description,
                            Date postDate,boolean isAdded, boolean isEdited,
                            CategoryModel category,UserModel user,Bitmap postImage)
    {
        this.ID=ID;
        this.title=title;
        this.description=description;
        this.postDate=postDate;
        this.isAdded=isAdded;
        this.isEdited=isEdited;
        this.postImage=postImage;
        this.category=category;
        this.user=user;
    }


}
