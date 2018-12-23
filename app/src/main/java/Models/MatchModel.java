package Models;

import java.util.Date;

import DAOS.PostDAO;

public class MatchModel {
    private int ID;
    private String address;
    private Date foundedDate;
    private String additional_information;
    private boolean IsOrg;
    private UserModel user=new UserModel();
    private PostModel post=new PostModel();



    public void setMatchModel(String additional_information,String address,Date foundedDate,int postID){
        this.additional_information=additional_information;
        this.address=address;
        this.foundedDate=foundedDate;
        this.IsOrg=true;
        this.post.setID(postID);
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public Date getFoundedDate() {
        return foundedDate;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public boolean isOrg() {
        return IsOrg;
    }

    public PostModel getPost() {
        return post;
    }
}
