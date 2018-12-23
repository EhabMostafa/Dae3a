package Services;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

            //P_M.setpostmodel(id,title,description,postdate,isadded,isedited,c1,u1,null);

            models_arr.add(P_M);
        }
        return models_arr;
    }


    public int insertPost(PostModel post) throws SQLException {
        ByteArrayOutputStream STREAM=new ByteArrayOutputStream();
        post.getPostImage().compress(Bitmap.CompressFormat.JPEG,90,STREAM);
        byte[] inbyte=STREAM.toByteArray();
        ByteArrayInputStream in=new ByteArrayInputStream(inbyte);



        String query="INSERT INTO post (title,description,postDate,isAdded,isEdited,CategoryID,UserEmail,PostImage) values ('"+post.getTitle() +"','"+post.getDescription()+"','"+new SimpleDateFormat("yyyy/MM/dd").format( post.getPostDate())+"',"
                +post.isAdded()+","+post.isEdited()+","+post.getCategory().getID()+
                ",'"+post.getUser().getEmail()+"',?)";
        PreparedStatement st = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        st.setBinaryStream(1,in);
        st.executeUpdate();

        int id=-1;

        ResultSet rs=st.getGeneratedKeys();

        if(rs.next()){
            id=rs.getInt(1);
        }


        return id;

    }
}
