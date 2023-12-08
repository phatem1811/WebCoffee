/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CategoryDB;
import dao.OrderDB;
import dao.ProductDB;
import dao.UserDB;
import entity.Category;
import entity.Order;
import entity.Product;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 84971
 */
public class ManageServlet extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String url;
        if(action == null) {
           action="manageuser";
        }
        if(action.equals("manageuser")){
            ManegeUser(request,response);
        }
        else if(action.equals("manageproduct")){  
            ManegeProduct(request,response);
        }
        else if(action.equals("manageorder")){  
            ManegeOrder(request,response);
        }
        else if(action.equals("managecategory")){  
            ManegeCategory(request,response);
        }
        else if(action.equals("deleteuser")){
            DeleteUser(request,response);  
        }
        else if(action.equals("edituser")){
            EditUser(request,response);  
        }
        else if(action.equals("updateuser")){
            UpdateUser(request,response);  
        }
        else if(action.equals("addcategory")){
            AddCategory(request,response);  
        }
        else if(action.equals("deletecategory")){
            DeleteCategory(request,response);  
        }
        else if(action.equals("editcategory")){
            EditCategory(request,response);  
        }
        else if(action.equals("updatecategory")){
            UpdateCategory(request,response);  
        }
        else if(action.equals("loadcateforpro")){
            LoadCateForProduct(request,response);  
        }
        else if(action.equals("addproduct")){
            AddProduct(request,response);  
        }
        else if(action.equals("editproduct")){
            EditProduct(request,response);  
        }
        else if(action.equals("updateproduct")){
            UpdateProduct(request,response);  
        }
        else if(action.equals("deleteproduct")){
            DeleteProduct(request,response);  
        }
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
        doGet(request, response);
        
        
    }
    protected void DeleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int pid = Integer.parseInt( request.getParameter("pid"));
        ProductDB p = new ProductDB();
        Product product = new Product();
        product = ProductDB.findProductrById(pid);
        p.delete(product);
        String url = "/manage?action=manageproduct";
        request.getRequestDispatcher(url).forward(request, response);
    }
     
    protected void UpdateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));   
       
        ProductDB p = new ProductDB();
        Product product = new Product();
        product = ProductDB.findProductrById(id);
        
        int cid = Integer.parseInt(request.getParameter("category")); 
        CategoryDB c = new CategoryDB();
        Category category = new Category();
        category = c.findCategoryById(cid);
            
        String productName = request.getParameter("productname");
        String img = request.getParameter("filename");
        int productPrice = Integer.parseInt(request.getParameter("price"));   
        int productSize = Integer.parseInt(request.getParameter("size"));   


        product.setProductName(productName);
        product.setImg(img);
        product.setProductPrice(productPrice);
        product.setProductSize(productSize);
        product.setCategory(category);
            
        ProductDB.update(product);
        String url = "/manage?action=manageproduct";
        request.getRequestDispatcher(url).forward(request, response);
    }
    protected void EditProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int pid = Integer.parseInt( request.getParameter("pid"));
        ProductDB p = new ProductDB();
        Product product = new Product();
        product = ProductDB.findProductrById(pid);
        
        CategoryDB c =new CategoryDB();
        List<Category> listc = c.findALL(); 
        
        request.setAttribute("listc", listc);
        request.setAttribute("product", product);
        request.getRequestDispatcher("editproduct.jsp").forward(request, response);
        
    }
    protected void AddProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
                
        int cid = Integer.parseInt(request.getParameter("category")); 
        CategoryDB c = new CategoryDB();
        Category category = new Category();        
        category = c.findCategoryById(cid);
        
        Product product = new Product();    
//        ProductDB p = new ProductDB();
        String productName = request.getParameter("productname");
        String img = request.getParameter("filename");
        int productPrice = Integer.parseInt(request.getParameter("price"));   
        int productSize = Integer.parseInt(request.getParameter("size"));   

        product.setProductID(33);
        product.setProductName(productName);
        product.setImg(img);
        product.setProductPrice(productPrice);
        product.setProductSize(productSize);
        product.setCategory(category);
        
        ProductDB.insert(product);
        String url = "/manage?action=manageproduct";
        request.getRequestDispatcher(url).forward(request, response);
    }
    protected void LoadCateForProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
//        int pid = Integer.parseInt( request.getParameter("pid"));
//        ProductDB p = new ProductDB();
//        Product product = new Product();
//        product = ProductDB.findProductrById(pid);
        
        CategoryDB c =new CategoryDB();
        List<Category> listc = c.findALL(); 
        request.setAttribute("listc", listc);
        request.getRequestDispatcher("addproduct.jsp").forward(request, response);
    }
    protected void UpdateCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
            int cid = Integer.parseInt(request.getParameter("cid"));     
       
            CategoryDB c =new CategoryDB();
            Category category = c.findCategoryById(cid);

            String categoryName = request.getParameter("categoryName");
  
            category.setCategoryName(categoryName);
            CategoryDB.update(category);
            String url = "/manage?action=managecategory";
            request.getRequestDispatcher(url).forward(request, response);
    }
    protected void EditCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int cid = Integer.parseInt(request.getParameter("cid"));
        CategoryDB c =new CategoryDB();
        Category category = c.findCategoryById(cid);
        request.setAttribute("category", category);
        request.getRequestDispatcher("editcategory.jsp").forward(request, response);
    }
    
    protected void DeleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int cid = Integer.parseInt(request.getParameter("cid"));
         
        
        Category category = CategoryDB.findCategoryById(cid);
       
        List<Product> products = ProductDB.findProductByCategoryId(cid);
        for(Product p : products){
            ProductDB.delete(p);
        }
        CategoryDB.delete(category);
        String url = "manage?action=managecategory";
        request.getRequestDispatcher(url).forward(request, response);
        
    }
    protected void AddCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
                
        String cName = request.getParameter("categoryName");
        Category c = new Category();
        c.setCategoryName(cName);
        CategoryDB.insert(c);
        String url = "/manage?action=managecategory";
        request.getRequestDispatcher(url).forward(request, response);
        
    }
    protected void UpdateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(request.getParameter("id"));     
            UserDB u =new UserDB();
            User user = u.findUserById(id);

            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String sdt = request.getParameter("sdt");
            String address = request.getParameter("address");

            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setName(name);
            user.setSdt(sdt);
            user.setDiachi(address);
            UserDB.update(user);
            String url = "/manage?action=manageuser";
            request.getRequestDispatcher(url).forward(request, response);
    }
    protected void EditUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int uid = Integer.parseInt(request.getParameter("uid"));
        UserDB u =new UserDB();
        User user = u.findUserById(uid);
        request.setAttribute("user", user);
        request.getRequestDispatcher("edituser.jsp").forward(request, response);
    }
    protected void ManegeUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        UserDB u =new UserDB();
        List<User> users = u.findALL();
        
        int page = 1;
        int pageSize = 5; // Number of products per page

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int totalUser = UserDB.getTotalUsers();
        int totalPages = (int) Math.ceil((double) totalUser / pageSize);

        List<User> list = UserDB.getUserByPage(page, pageSize);

        request.setAttribute("totalUser", totalUser);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.setAttribute("users", list);
        request.getRequestDispatcher("manageuser.jsp").forward(request, response);
        
    }
    protected void ManegeProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int pageSize = 3; // Number of products per page

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int totalProduct = ProductDB.getTotalProducts();
        int totalPages = (int) Math.ceil((double) totalProduct / pageSize);

        List<Product> list = ProductDB.getProductByPage(page, pageSize);

        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.setAttribute("products", list);
        request.getRequestDispatcher("ManageProduct.jsp").forward(request, response);
    }
    protected void ManegeOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        OrderDB od =new OrderDB();
        List<Order> orders = od.findALL();
        
        int page = 1;
        int pageSize = 5; // Number of products per page

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int totalOrder = OrderDB.getTotalOrders();
        int totalPages = (int) Math.ceil((double) totalOrder / pageSize);

        List<Order> list = OrderDB.getOrderByPage(page, pageSize);

        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.setAttribute("orders", list);
//        String url="/pagingorder";
        request.getRequestDispatcher("ManageOrder.jsp").forward(request, response);
    }
    protected void ManegeCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        CategoryDB c = new CategoryDB();
        List<Category> categories = c.findALL();
        
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("ManagerCategory.jsp").forward(request, response);
        
    }
    protected void DeleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        User user = UserDB.findUserById(uid);
        UserDB.delete(user);
        String url = "/manage?action=manageuser";
        request.getRequestDispatcher(url).forward(request, response);
        
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
