
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        String id = request.getParameter("txtUid");
        String ps = request.getParameter("txtPass");
        String em;
        em = request.getParameter("txtEmail");
        String co = request.getParameter("txtCon");
        try {
            /* TODO output your page here. You may use following sample code. */
            String url="jdbc.odbc:logindb";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/logindb","root1","root1234");
            PreparedStatement PreparedStatementpst = con.prepareStatement("insert into user values(?,?,?,?)");
            pst.setString(1,id);
            pst.setString(2,ps);
            pst.setString(1,em);
            pst.setString(1,co);
            int row = pst.executeUpdate();
            outprintln("<h1>"+row+"Inserted Succesfullyyyy");
        }
        catch(ClassNotFoundException | SQLException e)
        {        }
    }

    private void outprintln(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


    
    





