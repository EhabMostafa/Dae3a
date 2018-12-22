package Controller;

import java.util.Date;

import DAOS.MatchDao;
import Models.MatchModel;

public class MatchController {
    public String addMatch(String additionalInformation, String address, Date foundedDate, int postID, boolean isOrg)
    {
        MatchModel matchModel = new MatchModel();
        matchModel.setAdditionalInformation(additionalInformation);
        matchModel.setAddress(address);
        matchModel.setFoundedDate(foundedDate);
        matchModel.setOrg(true);
        MatchDao matchDao=new MatchDao();
        matchDao.postID=postID;
        String addMessage=matchDao.addMatch(matchModel);
        if(addMessage.equals("successfully inserted"))
        {
            return "successfullty insert wait for verification";
        }
        return "faild inserted";

    }
}
