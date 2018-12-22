package DAOS;

import Models.MatchModel;
import Services.MatchService;

public class MatchDao {
    public int postID;
    public String addMatch(MatchModel matchModel)
    {
        ConnectionMySql con=new ConnectionMySql();
        con.Open();
        MatchService service =new MatchService();
        service.con=con.connection;
        service.postID=postID;
        String msgRes=service.insertMatch(matchModel);
        con.Close();
        return "successfully inserted";


    }
}
