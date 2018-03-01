package dao;

import domain.Food;
import util.DBConnection;
import util.log.Logcat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class FoodDao {
    private Connection connection;
    private Statement statement;

    private LinkedList<Food> list_food = null;

    public FoodDao(){
        connection = DBConnection.getConnection();

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Food> getAllFood(){
        list_food = new LinkedList<>();

        String sql = "select * from food";

        int id;
        String name;
        String pic_Url;
        int price;

        try {
            ResultSet set = statement.executeQuery(sql);

            while(set.next()){
                id = set.getInt("id");
                name = set.getString("name");
                pic_Url = set.getString("pic_Url");
                price = set.getInt("price");

                //向日志输出获取的菜品信息
                Logcat.log("id:"+id+" name:"+name+" pic_Url:"+pic_Url+" price:"+price);

                list_food.add(new Food(id,name,pic_Url,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list_food;
    }

    public Food getFoodById(String listName, int id){
        String sql = "select * from '"+listName+"'where id='"+id+"'";

        Food food = null;

        try {
            ResultSet set = statement.executeQuery(sql);

            while(set.next()){
                food = getFoodBySet(set);
            }

            return food;
        } catch (SQLException e) {

            Logcat.log(e.getSQLState());
            Logcat.log(e.getMessage());

            e.printStackTrace();
        }

        return null;
    }
    public Food getFoodByName(String listName, String name){
        String sql = "select * from '"+listName+"'where name='"+name+"'";

        Food food = null;

        try {
            ResultSet set = statement.executeQuery(sql);

            while(set.next()){
                food = getFoodBySet(set);
            }

            return food;
        } catch (SQLException e) {

            Logcat.log(e.getSQLState());
            Logcat.log(e.getMessage());

            e.printStackTrace();
        }

        return null;
    }

    public LinkedList<Food> getFoodListByName(String name){
       LinkedList<Food> list = new LinkedList<>();

        String sql = "select * from "+name;

        try {
            ResultSet set = statement.executeQuery(sql);

            int id;
            String name_food;
            String pic_Url;
            int price;

            Food food;

            while(set.next()){
                id = set.getInt("id");
                name_food = set.getString("name");
                pic_Url = set.getString("pic_Url");
                price = set.getInt("price");

                ////向日志输出获取的菜品信息
                Logcat.log("id:"+id+" name:"+name+" pic_Url:"+pic_Url+" price:"+price);

                food = new Food(id,name_food,pic_Url,price);
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();

            Logcat.log(e.getMessage());
        }

        return list;
    }

    public Food getFoodBySet(ResultSet set) throws SQLException {
        return getFoodBySet(set);
    }
}
