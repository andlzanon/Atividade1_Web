/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.servlets;

import br.ufscar.dc.hotel.beans.Hotel;
import br.ufscar.dc.hotel.dao.HotelDAO;
import br.ufscar.dc.hotel.forms.NovoHotelFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Andre
 */
@WebServlet(name = "GravarHotelServlet", urlPatterns = {"/GravarHotelServlet"})
public class GravarHotelServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Resource(name="jdbc/ReservaHotelDBLocal")
    DataSource dataSource;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            NovoHotelFormBean nhfb = (NovoHotelFormBean)request.getSession().getAttribute("novoHotel");
            request.getSession().removeAttribute("novoHotel");
            
            HotelDAO hotelDAO = new HotelDAO(dataSource);
            Hotel hotel = new Hotel();
            hotel.setNome(nhfb.getNome());
            hotel.setCnpj(nhfb.getCnpj());
            hotel.setCidade(nhfb.getCidade());
            hotel.setSenha(nhfb.getSenha());
            hotel = hotelDAO.gravarHotel(hotel);
            
            request.setAttribute("mensagem", "Hotel adicionado com sucesso");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }catch(Exception e){
           request.setAttribute("mensagem", e.getLocalizedMessage());
           request.getRequestDispatcher("erro.jsp").forward(request, response);
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
