package Services;

import android.graphics.Bitmap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


import Models.CategoryModel;
import Models.PostModel;
import Models.UserModel;

public class PostService {
    public Connection con;
    public ArrayList<PostModel> fetchPostsInSelectedCategory(CategoryModel selected_post_model,Connection CON) throws SQLException {

        Statement st = null;
        try {
            st = CON.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = st.executeQuery("select * from post where categoryid = "+selected_post_model.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id=0;
        String title;
        String description;
        Date postdate;
        boolean isadded;
        boolean isedited;
        int catid;
        String userid;

        ArrayList<PostModel> models_arr=new ArrayList<PostModel>();
        while (rs.next()) {
            PostModel P_M = new PostModel();
            id=rs.getInt(1);
            title=rs.getString(2);
            description=     rs.getString(3);
            postdate=rs.getDate(4);
            isadded=rs.getBoolean(5);
            isedited=rs.getBoolean(6);
            catid=rs.getInt(7);
            userid=rs.getString(8);
            //img=rs.getBlob(9);

            CategoryModel c1=new CategoryModel();
            c1.setID(catid);
            UserModel u1=new UserModel();
            u1.setNationalID(userid);

            P_M.setpostmodel(id,title,description,postdate,isadded,isedited,c1,u1,null);

            models_arr.add(P_M);
        }
        return models_arr;
    }
    public int insertPost(PostModel post) throws SQLException {
        String query="INSERT INTO post (title,description,postDate,iAdded,isEdited,CategoryID,UserID,PostImage) values ('"+post.getTitle() +"','"+post.getDescription()+"','"+post.getPostDate()+"',"
                +post.isAdded()+","+post.isEdited()+","+post.getCategory().getID()+
                ","+post.getUser().getNationalID()+","+post.getPostImage()+")";
        Statement st = con.prepareStatement(query);
        int id= ((PreparedStatement) st).executeUpdate();
        return id;

    }
}
