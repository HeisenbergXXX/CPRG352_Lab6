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

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");

        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
        }

        if (username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            request.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
//        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd1 = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
        RequestDispatcher rd2 = getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp");

        HttpSession session = request.getSession();
        ArrayList<String> items = new ArrayList<>();
        String username = request.getParameter("username");
        String action = request.getParameter("action");
        String item = request.getParameter("item");
        String itemToRemove = request.getParameter("itemsRadio");
        String itemSave = request.getParameter("itemSave");

        switch (action){
            case "register":
                if (username == null || username.equals("")) {
                    request.setAttribute("message", "Please enter a username!");
                    rd1.forward(request, response);
                } else {
                    session.setAttribute("username", username);
                    request.setAttribute("username", username);
                }
                break;
            case "add":
                if (item == null || item.equals("")) {
                    request.setAttribute("message2", "Please enter an item!");
//                    rd2.forward(request, response);
                } else {
                    request.setAttribute("message2", "");
                    items = session.getAttribute("items") == null ? new ArrayList<>() : (ArrayList<String>) session.getAttribute("items");
                    items.add(item);
                }
                break;
            case "delete":
                if (itemToRemove == null || itemToRemove.equals("")) {
                    request.setAttribute("message2", "Please select an item!");
//                    rd2.forward(request, response);
                } else {
                    request.setAttribute("message2", "");
                    items = (ArrayList<String>) session.getAttribute("items");
                    items.remove(itemToRemove);
//                    request.setAttribute("message2", itemToRemove + " was removed!");
                }
                break;
        }
        session.setAttribute("items", items);
        request.setAttribute("list", items);
        rd2.forward(request, response);
    }
}
