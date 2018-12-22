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
    public Bitmap getPostImage() {
        return postImage;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public Date getPostDate() {
        return postDate;
    }

    public int getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public UserModel getUser() {
        return user;
    }

    public void setAdded(boolean added) {
        isAdded = added;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEdited(boolean edited) {
        isEdited = edited;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setPostImage(Bitmap postImage) {
        this.postImage = postImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


}
