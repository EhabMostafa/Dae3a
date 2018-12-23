package Controller;

import android.graphics.Bitmap;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    public int addPost(Bitmap itemImage, String title, String description,String UserEmail) throws SQLException {
        PostModel post=new PostModel();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        System.out.println();


        post.setPostModel(title,description,new Date(),itemImage,UserEmail);

        PostDAO PoDAO=new PostDAO();
        return PoDAO.addPost(post);
    }
}
