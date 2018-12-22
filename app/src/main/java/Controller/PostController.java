package Controller;

import android.graphics.Bitmap;

import java.sql.SQLException;
import java.util.ArrayList;

import DAOS.PostDAO;
import Models.CategoryModel;
import Models.PostModel;

public class PostController {
    int userID;
    public ArrayList<PostModel> getAllPostsInCategory(CategoryModel selected_Cat_model){
        PostDAO postdao=new PostDAO();
        ArrayList<PostModel> models_arr = null;
        models_arr = postdao.getAllPostsInCategories(selected_Cat_model);
        return  models_arr;
    }
    public void addPost(Bitmap itemImage, String title, String description) throws SQLException {
        PostModel post=new PostModel();
        post.setTitle(title);
        post.setPostImage(itemImage);
        post.setDescription(description);
        post.setAdded(true);
        post.setID(userID);
        post.setEdited(true);
        PostDAO d=new PostDAO();
        d.addPost(post);
    }
}
