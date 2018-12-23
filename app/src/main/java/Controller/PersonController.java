package Controller;

import java.sql.SQLException;

import DAOS.PersonDAO;

public class PersonController {
    public String Login(String email,String password) throws SQLException {

        PersonDAO PDAO=new PersonDAO();

        if(PDAO.checkValid(email,password)){
            return "Login succefully";
        }

        return "Login failed";
    }
}
