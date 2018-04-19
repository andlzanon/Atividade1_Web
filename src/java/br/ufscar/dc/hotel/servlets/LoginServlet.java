/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.servlets;

import br.ufscar.dc.hotel.beans.Administrador;
import br.ufscar.dc.hotel.beans.Hotel;
import br.ufscar.dc.hotel.dao.AdministradorDAO;
import br.ufscar.dc.hotel.dao.HotelDAO;
import br.ufscar.dc.hotel.forms.LoginFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Andre
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        LoginFormBean lfb = new LoginFormBean();
        try{
            BeanUtils.populate(lfb, request.getParameterMap());
            System.out.println("Parametro: " +request.getParameter("permissao"));
            System.out.println("Ususario: " +lfb.getUsuario());
            System.out.println("Senha: " +lfb.getSenha());
            //se o parametro permissao for adm verifica se o mesmo existe
            if(request.getParameter("permissao").equals("adm")){
                AdministradorDAO administradorDAO = new AdministradorDAO(dataSource);
                Administrador adm = null;
                adm = administradorDAO.listarAdmPorNome(lfb.getUsuario());
                if(adm != null && adm.getSenha().equals(lfb.getSenha())){
                    System.out.println("Deu bom");
                    //se o segundo parametro for site vai para a tela de cadastro de site
                    //senao vai para a tela de cadastro de hotel
                    if (request.getParameter("acao").equals("site")) {
                        System.out.println("Go to cadastro de site");
                    } else {
                        System.out.println("Go to cadastro de hotel");
                    }
                }
            }
            //se o parametro permissao for hotel
            else if(request.getParameter("permissao").equals("hotel")){
                HotelDAO hotelDAO = new HotelDAO(dataSource);
                Hotel hotel = null;
                hotel = hotelDAO.listarHotelPorNome(lfb.getUsuario());
                if(hotel.getSenha().equals(lfb.getSenha())){
                    if (request.getParameter("acao").equals("cadastro")) {
                        System.out.println("Go to cadastro de promocao");
                    } 
                    else {
                        System.out.println("Go to listagem de promocao de hotel");
                    }
                } 
            }
            //se o parametro permissao for site
            else if(request.getParameter("permissao").equals("site")){
                System.out.println("Go to listagem de promocao de site");
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