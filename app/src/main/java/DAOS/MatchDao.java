package DAOS;

import java.sql.SQLException;

import Models.MatchModel;
import Services.MatchService;

public class MatchDao {

    public String addMatch(MatchModel matchModel) throws SQLException {
        ConnectionMySql con=new ConnectionMySql();
        con.Open();
        MatchService service =new MatchService();
        service.con=con.connection;
        String msgRes=service.insertMatch(matchModel);
        con.Close();
        return msgRes;

    }
}
