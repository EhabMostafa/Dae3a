package Controller;

import java.util.ArrayList;

import DAOS.PostDAO;
import Models.CategoryModel;
import Models.PostModel;

public class PostController {
    public ArrayList<PostModel> getAllPostsInCategory(CategoryModel selected_Cat_model){
        PostDAO postdao=new PostDAO();
        ArrayList<PostModel> models_arr = null;
        models_arr = postdao.getAllPostsInCategories(selected_Cat_model);
        return  models_arr;
    }
}
