/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@WebServlet(name = "submit", urlPatterns = {"/submit"})
public class submit extends HttpServlet {

      private Connection conn;
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
    
    //parsing input 
        Boolean valid = false;
        String author, emailaddress, messages;

        Matcher matcher;
        
        Pattern pattern = Pattern.compile("[;:,#&'\".!?]");
        matcher = pattern.matcher(request.getParameter ("name"));
        author = matcher.replaceAll("|");
        matcher = pattern.matcher(request.getParameter ("email"));
        emailaddress = matcher.replaceAll("|");
        matcher = pattern.matcher(request.getParameter ("message"));
        messages = matcher.replaceAll("|");

        
        try{
                  
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/assignment3";
            conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
            Statement st = conn.createStatement();
            String q1 = new String("INSERT INTO message (name, email, message)"+
                " VALUES ('" +
                author+"','"+
                emailaddress+"', '" +
                messages + "')");
                System.out.println(q1);
                st.execute(q1);
                valid=true;
                conn.close();
                
            ub.setStatus("Message Successfully Submitted");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmation.jsp");
            rd.forward(request, response);
       
        }        
        catch (SQLException se)
        {
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(submit.class.getName()).log(Level.SEVERE, null, ex);
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
