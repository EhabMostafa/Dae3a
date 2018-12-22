package DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.CategoryModel;
import Services.CategoryService;

public class CategoryDAO {
    public ArrayList<CategoryModel> getAllCategories(){
        CategoryService categoryserv =new CategoryService();
        ConnectionMySql CON=new ConnectionMySql();
        CON.Open();
        ArrayList<CategoryModel> models_arr = null;
        try {
            models_arr = categoryserv.fetchCategotyData(CON.connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CON.Close();
        return models_arr;
    }
}
