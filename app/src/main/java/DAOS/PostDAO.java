package DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.CategoryModel;
import Models.PostModel;
import Services.PostService;

public class PostDAO {
    public ArrayList<PostModel> getAllPostsInCategories(CategoryModel selected_post_model){
        PostService post_serv=new PostService();

        ConnectionMySql CON=new ConnectionMySql();

        CON.Open();
        ArrayList<PostModel> models_arr = null;
        try {
            models_arr = post_serv.fetchPostsInSelectedCategory(selected_post_model,CON.connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CON.Close();
        return models_arr;
    }
    public int addPost(PostModel post) throws SQLException {
        ConnectionMySql con=new ConnectionMySql();
        con.Open();
        PostService service=new PostService();
        service.con=con.connection;
        int id=service.insertPost(post);
        con.Close();
        return id;

    }

}
