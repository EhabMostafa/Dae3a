package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Models.CategoryModel;


public class CategoryService {
    public ArrayList<CategoryModel> fetchCategotyData(Connection CON) throws SQLException {

        Statement st = null;
        try {
            st = CON.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet rs = null;
        try {
            rs = st.executeQuery("select * from category");
        } catch (SQLException e) {
            e.printStackTrace();
        }

            int id=0;
            String cat_name = "";


        ArrayList<CategoryModel> models_arr=new ArrayList<CategoryModel>();
            while (rs.next()) {
                CategoryModel C_M = new CategoryModel();
                id = rs.getInt(1);
                cat_name = rs.getString(2);
                C_M.setCategory(id, cat_name, null
                );
                models_arr.add(C_M);
            }
        return models_arr;

    }
}
