/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.servlets;

import br.ufscar.dc.hotel.beans.Hotel;
import br.ufscar.dc.hotel.beans.Promocao;
import br.ufscar.dc.hotel.beans.Site;
import br.ufscar.dc.hotel.dao.PromocaoDAO;
import br.ufscar.dc.hotel.forms.NovaPromocaoFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "GravarPromocaoServlet", urlPatterns = {"/GravarPromocaoServlet"})
public class GravarPromocaoServlet extends HttpServlet {

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
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            
            NovaPromocaoFormBean npfb = (NovaPromocaoFormBean) request.getSession().getAttribute("novaPromocao");
            request.getSession().removeAttribute("novoHotel");
            
            PromocaoDAO promocaoDAO = new PromocaoDAO(dataSource);
            Promocao promocao = new Promocao();
            
            Hotel hotel = new Hotel();
            hotel.setCnpj(npfb.getCnpj());
            
            Site site = new Site();
            site.setUrl(npfb.getUrl());
            
            promocao.setCnpj(hotel);
            promocao.setUrl(site);
            promocao.setPreco(Double.parseDouble(npfb.getPreco()));
            promocao.setData_inicial(fmt.parse(npfb.getData_inicial()));
            promocao.setData_final(fmt.parse(npfb.getData_final()));
            promocao = promocaoDAO.gravarPromocao(promocao);
            
            request.setAttribute("mensagem", "Promoção adicionada com sucesso");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
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
