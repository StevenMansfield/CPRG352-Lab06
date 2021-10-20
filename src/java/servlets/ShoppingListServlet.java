package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        session.getAttribute("username"); 
        String action = request.getParameter("action");
        
        if (action != null) {
            if (action.equals("logout")) {
                session.invalidate(); 
                response.sendRedirect("shoppingList"); 
                return;
            }
        }
        
         if (session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return; 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        String action = request.getParameter("action");
        ArrayList<String> itemList = (ArrayList<String>)session.getAttribute("itemList"); 
        
        if(itemList == null) {
            itemList = new ArrayList<>(); 
        }
        
        if (action != null) {
            if (action.equals("register")) {
                String username = request.getParameter("username");
                session.setAttribute("username", username);
                response.sendRedirect("shoppingList"); 
                return;
            } 
            
            if (action.equals("add")) {
                if(request.getParameter("item") != null) {
                    itemList.add(request.getParameter("item"));
                }
                session.setAttribute("itemList", itemList);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
            
            if (action.equals("delete")) {
                if(request.getParameter("item") != null) {
                    itemList.remove(request.getParameter("item"));
                }
                session.setAttribute("itemList", itemList);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }
    }
}