/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.servlets;

import br.ufscar.dc.hotel.beans.Hotel;
import br.ufscar.dc.hotel.dao.HotelDAO;
import br.ufscar.dc.hotel.forms.CidadeFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 *
 * @author Andre
 */
@WebServlet(name = "VerHoteisServlet", urlPatterns = {"/VerHoteisServlet"})
public class VerHoteisServlet extends HttpServlet {
    
    @Resource(name = "jdbc/ReservaHotelDBLocal")
    DataSource dataSource;

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
        try {
            CidadeFormBean cpfb = new CidadeFormBean();
            BeanUtils.populate(cpfb, request.getParameterMap());
            String cidade = cpfb.getCidade();
            HotelDAO hotelDAO = new HotelDAO(dataSource);
            List<Hotel> hoteis = null;
            try{
                if(cidade == null){
                    System.out.println("Cidade=" +cidade);
                    hoteis = hotelDAO.listarTodosHoteis();
                }else{
                    System.out.println("Cidade Completa=" +cidade);
                    hoteis = hotelDAO.listarHoteisPorCidade(cidade);
                }
                request.setAttribute("listaHoteis", hoteis);
                request.getRequestDispatcher("listaHotel.jsp").forward(request, response);
            }catch(Exception e){
                e.printStackTrace();
                //request.setAttribute("erro", e);
                //request.getRequestDispatcher("listaHotel.jsp").forward(request, response);
                ///TO DO: TELA DE ERRO!!!!!
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
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
