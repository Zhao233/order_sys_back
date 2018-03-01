import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Data;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "TestServlet" ,urlPatterns = "/testServlet")
public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Writer writer = response.getWriter();

        Data data = new Data();

        User[] users=new User[2];

        User user = new User();
        user.setName("hello");
        user.setLogin_times(5);

        users[0]=user;
        users[1]=user;

        data.user = users;

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(data);

        writer.write(json);

        System.out.println(json);

    }
}
