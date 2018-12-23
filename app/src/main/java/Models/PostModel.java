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
    CategoryModel category=new CategoryModel();
    UserModel user=new UserModel();

    public void setPostModel(String title,String description,Date postDate,Bitmap postImage,String UserEmail)
    {
        this.title=title;
        this.description=description;
        this.postDate=postDate;
        this.postImage=postImage;

        this.isAdded=true;
        this.isEdited=true;

        this.category.setID(1);;
        this.user.setEmail(UserEmail);

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getPostDate() {
        return postDate;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public Bitmap getPostImage() {
        return postImage;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public UserModel getUser() {
        return user;
    }
}
