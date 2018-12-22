package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import Models.MatchModel;

public class MatchService {
    public Connection con;
    public int postID;
    public String insertMatch(MatchModel matchModel)
    {
        try
        {
            String query="INSERT INTO match (address,foundedDate,additional_information,IsOrg,PostID) values ('"+matchModel.getAddress()+"','"+
                    matchModel.getFoundedDate()+"','"+matchModel.getAdditionalInformation()+"',"+matchModel.isOrg()+","+postID+")";
            Statement st = con.prepareStatement(query);
            ((PreparedStatement) st).executeUpdate();
            return "successfully Inserted";
        }
        catch (Exception e)
        {
            return "faild inserted";

        }

    }
}
