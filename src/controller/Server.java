package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Food;
import domain.User;
import service.FoodService;
import service.UserService;
import util.JSONHandler;
import util.log.Logcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(name = "Server", urlPatterns = "/order_Service")
public class Server extends HttpServlet {
    UserService userService;

    FoodService foodService;

    Writer writer;

    JSONHandler<Food> handler_food;

    User user = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(writer == null){
            writer = response.getWriter();
        }

        if(handler_food == null){
            handler_food = new JSONHandler<>();
        }

        if(foodService == null){
            foodService = new FoodService();
        }

        userService = new UserService();

        String command = request.getParameter("command");

        switch (command){
            //获取所有菜品
            case "getAllFood" :
                writeToRemote( handler_food.objectToJson(new Data( getAllFood()) ) );
                break;
            //根据菜品类名，获取该类所有菜品
            case "getFoodList" :
                String nameOfFoodList = request.getParameter("name");

                LinkedList<Food> foodList = getFoodList_ByName(nameOfFoodList);

                System.out.print("the food list:");
                System.out.println(handler_food.objectToJson(foodList));

                writeToRemote( handler_food.objectToJson( new Data( foodList ) ) );

                Logcat.log("complete");
            //登陆
            case "login" :
                login(request);

                break;
            //点餐
            case "order_dish" :
                break;
            //呼叫服务员
            case "order_waiter" :
                break;
            //结算
            case "settle" :
        }
    }

    public LinkedList<Food> getAllFood(){
        return foodService.getAllFood();
    }

    public LinkedList<Food> getFoodList_ByName(String name){
        return foodService.getFoodListByName(name);
    }

    public void login(HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        try {
            userService.isFirst(id,name);

            user = new User();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isLogedin(){
        return user==null;

    }

    public void order_dish(){

    }

    public void order_waiter(){

    }

    public void settle(){

    }

    public void writeToRemote(String data){
        try {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Data{
    private LinkedList<Food> foodList;

    public Data(LinkedList linkedList){
        foodList = linkedList;
    }

    public LinkedList<Food> getList() {
        return foodList;
    }

    public void setList(LinkedList<Food> list) {
        this.foodList = list;
    }
}
