import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.logging.Logger;


@javax.servlet.annotation.WebServlet(name = "Love",urlPatterns = "/Server")
public class Server extends javax.servlet.http.HttpServlet {
    UserService service;
    Writer writer;

    public Server(){
        service = new UserService();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        handle(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        handle(request,response);
    }

    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String name = request.getParameter("userName");
            String id = request.getParameter("userOpenId");

            writer = response.getWriter();
            writer.write("name" + name + "/n");
            writer.write("id" + id + "/n");

            service.isFirst(id,name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            writer.write("error");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
