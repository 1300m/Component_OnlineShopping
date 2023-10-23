/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductsTable;
import model.Shoppingcart;
import model.ShoppingcartTable;

/**
 *
 * @author jiapat
 */
public class AddToShoppingCart extends HttpServlet {

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
        try {
            String[] movies = request.getParameterValues("movies");
            String[] quantity = request.getParameterValues("quantity");     
            Shoppingcart cart;
            int j = 0;
            for(int i = 0; i < movies.length; i++) {
                if(quantity[i].equals("")) {
                    j++;
                }
                if(movies[i] != null) {
                    cart = new Shoppingcart(i, Integer.parseInt(quantity[j]), 
                            ProductsTable.findProductsById(Integer.parseInt(movies[i])));
                    ShoppingcartTable.insertShoppingcart(cart);
                }
                j++;
            }
            request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
        }
        catch(NullPointerException e) {
            String errMsg = "Please select a product.";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("error_page.jsp").forward(request, response);
        }
        catch(NumberFormatException e) {
            String errMsg = "Please specify the quantity.";
            request.setAttribute("errMsg", errMsg);
            request.getRequestDispatcher("error_page.jsp").forward(request, response);
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
