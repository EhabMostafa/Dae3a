package Models;

import android.graphics.Bitmap;

public class CategoryModel {
    private int ID;
    private String name;
    private Bitmap catImage;

    public void setCategory(int ID,String name,Bitmap catImage){
        this.ID=ID;
        this.name=name;
        this.catImage=catImage;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
}
