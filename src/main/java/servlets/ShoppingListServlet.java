package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShoppingListServlet", value = "/ShoppingListServlet")
public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
        RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp");

        HttpSession session = request.getSession();
        ArrayList<String> items = new ArrayList<>();
        String action = request.getParameter("action");

        switch (action){
            case "register":
                String username = request.getParameter("username");
                if (username == null || username.equals("")) {
                    request.setAttribute("message", "Please enter a username!");
                    rd1.forward(request, response);
                } else {
                    session.setAttribute("username", username);
                    session.setAttribute("items", items);
                    rd2.forward(request, response);
                }
                break;
            case "add":
                String item = request.getParameter("item");
                if (item == null || item.equals("")) {
                    session.setAttribute("message2", "Please enter an item!");
                    rd2.forward(request, response);
                } else {
                    items = (ArrayList<String>) session.getAttribute("items");
                    items.add(item);
                    session.setAttribute("items", items);
                    request.setAttribute("list", items);
                    rd2.forward(request, response);
                }
                break;
            case "delete":
                String itemDel = request.getParameter("itemDel");
                if (itemDel == null || itemDel.equals("")) {
                    request.setAttribute("message2", "Please select an item!");
                    rd2.forward(request, response);
                }
                items = (ArrayList<String>) session.getAttribute("items");
                items.remove(itemDel);

                session.setAttribute("items", items);
                request.setAttribute("list", items);
                rd2.forward(request, response);
                break;
        }
    }
}
