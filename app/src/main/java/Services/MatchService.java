package Services;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Models.MatchModel;

public class MatchService {
    public Connection con;


    public String insertMatch(MatchModel matchModel) throws SQLException {

            String query="INSERT INTO `match`( `address`, `foundedDate`, `additional_Information`, `IsOrg`, `PostID`) VALUES ('"+matchModel.getAddress()+"','"+
                    new SimpleDateFormat("yyyy/MM/dd").format(matchModel.getFoundedDate())+"','"+matchModel.getAdditional_information()+"',"+matchModel.isOrg()+","+matchModel.getPost().getID()+")";
            PreparedStatement st = con.prepareStatement(query);
        Log.e("Err",query);
            st.executeUpdate();
            return "Successfully Inserted";



    }
}
