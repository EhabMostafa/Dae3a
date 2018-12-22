package DAOS;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
    public void test() throws SQLException {
        ConnectionMySql CON=new ConnectionMySql();
        CON.Open();


            Statement st = CON.connection.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            ResultSetMetaData rsmd = rs.getMetaData();
            String s = "";
            while (rs.next()) {
                s += rs.getString(1) + " | ";
                s += rs.getString(2);
                s += "-------------";
            }
            System.out.println("Res :"+s);
        CON.Close();
    }
}
