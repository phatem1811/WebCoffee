/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDB;
import entity.Cart;
import entity.Item;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 84971
 */
@WebServlet(name = "HandleCartController", urlPatterns = {"/handle"})
public class HandleCartController extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null)
               cart = (Cart)o;
        else
            cart = new Cart();
        int num =  Integer.parseInt(request.getParameter("num"));
        int id =  Integer.parseInt(request.getParameter("id"));
        if (num == -1 && cart.getQuantitybyID(id) == 1)
            cart.removeItem(id);
        else {
             Product p =ProductDB.findProductrById(id);
            Item i = new Item(p,num);
            cart.addItem(i);
        }
        List<Item> listI = cart.getItems();
        session.setAttribute("cart", cart);
        session.setAttribute("size", listI.size());
        request.getRequestDispatcher("cart.jsp").forward(request, response);
           
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        if (o != null)
               cart = (Cart)o;
        else
            cart = new Cart();
        int id =  Integer.parseInt(request.getParameter("id"));
        
        cart.removeItem(id);
        List<Item> listI = cart.getItems();
        session.setAttribute("cart", cart);
        session.setAttribute("size", listI.size());
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
