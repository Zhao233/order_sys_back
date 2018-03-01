package service;

import dao.FoodDao;
import domain.Food;

import java.util.LinkedList;

public class FoodService {
    FoodDao foodDao;

    public FoodService(){
        foodDao = new FoodDao();
    }

    public LinkedList<Food> getAllFood(){
        return foodDao.getAllFood();
    }

    public LinkedList<Food> getFoodListByName(String name){
        return foodDao.getFoodListByName(name);
    }
}
