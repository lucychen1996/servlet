/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletpackage;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Lucyc
 */
@WebServlet(name = "review", urlPatterns = {"/review"})
public class review extends HttpServlet {
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
        
    //session bean
        HttpSession session=request.getSession(true);
        bean ub = new bean();
        session.setAttribute("ub",ub);
        ub.setName(request.getParameter("name"));
        ub.setEmail(request.getParameter("email"));
        ub.setMessage(request.getParameter("message"));
        
    //check to see if all fields are filled in
        if(!request.getParameter("name").equals("") && !request.getParameter("email").equals("")  && !request.getParameter("message").equals("") ) {
           
            ub.setStatus("REVIEW");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/review.jsp");
            rd.forward(request, response);
        }
    //send to missing fields page 
        else{
            ub.setStatus("MISSING FIELDS, TRY AGAIN");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/edit.jsp");
            rd.forward(request, response);
        }
            
    }
        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
