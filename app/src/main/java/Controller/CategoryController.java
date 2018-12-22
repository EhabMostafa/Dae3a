package Controller;

import java.util.ArrayList;

import DAOS.CategoryDAO;
import Models.CategoryModel;

public class CategoryController {
    public ArrayList<CategoryModel> searchByCategory(){
        CategoryDAO categorydao=new CategoryDAO();
        ArrayList<CategoryModel> models_arr;
        models_arr=categorydao.getAllCategories();
        return models_arr;
    }
}
