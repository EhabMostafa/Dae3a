package DAOS;

import java.sql.SQLException;

import Services.PersonService;

public class PersonDAO {
    PersonService PS=new PersonService();

    public boolean checkValid(String email,String password) throws SQLException {
        ConnectionMySql CON=new ConnectionMySql();
        CON.Open();
        PS.con=CON.connection;
        String passInDataBase=PS.getPassword(email);
        if(passInDataBase.equals(password)){
            return true;
        }
        CON.Close();
        return false;
    }
}
