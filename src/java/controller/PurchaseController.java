/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.OrderDB;
import dao.OrderdetailDB;
import entity.Cart;
import entity.Item;
import entity.Order;
import entity.Orderdetail;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author 84971
 */
public class PurchaseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String address = request.getParameter("address");
        String sdt = request.getParameter("sdt");
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("acc");
        Cart c = (Cart) session.getAttribute("cart");

        List<Item> listitem = c.getItems();
        LocalDate d = java.time.LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = d.format(formatter);
        if (c.getCount() > 0) {
            Order order = new Order();
            order.setUser(user);
            order.setSdt(sdt);
            order.setAdress(address);
            order.setDate(date);
            order.setTotal(c.getTotalPrice());

            OrderDB.insert(order);
            for (int i = 0; i < c.getCount(); i++) {
                Item item = listitem.get(i);
                Orderdetail od = new Orderdetail();
                od.setOrder(order);
                od.setProduct(item.getProduct());
                od.setQuantity(item.getQuantity());
                OrderdetailDB.insert(od);
            }
            session.removeAttribute("cart");
            session.removeAttribute("size");
            request.getRequestDispatcher("thanks.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "No item in your cart ");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }
    }

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
        processRequest(request, response);

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
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession Mysession = request.getSession();
        User user = (User) Mysession.getAttribute("acc");
        String email = user.getEmail();
        String username = user.getUsername();
        String from = "dinhquynh240703@gmail.com";
        String to = email;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("quynhthuy394@gmail.com", "zmse fsci bhxu qhjv");// Put your email
                // id and
                // password here
            }
        });
        // compose message

        try {
            String body = "Dear " + username + "!" + "\n"
                    + "Thanks for your ordering. \n"
                    + "Have a great day and thanks again. \n";

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));// change accordingly
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("The Coffee Shop Thanks For Your Order");
            message.setText(body);
            // send message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("thanks.jsp").forward(request, response);
    }
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */

