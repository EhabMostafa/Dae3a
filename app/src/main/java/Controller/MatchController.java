package Controller;

import java.sql.SQLException;
import java.util.Date;

import DAOS.MatchDao;
import Models.MatchModel;

public class MatchController {

    public String addMatch(String additionalInformation, String address, Date foundedDate, int postID) throws SQLException {
        MatchModel matchModel = new MatchModel();

        matchModel.setMatchModel(additionalInformation,address,foundedDate,postID);


        MatchDao matchDao=new MatchDao();

        String addMessage=matchDao.addMatch(matchModel);

        return addMessage;

    }
}
