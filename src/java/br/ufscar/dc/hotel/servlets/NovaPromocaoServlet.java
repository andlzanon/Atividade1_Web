/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.servlets;

import br.ufscar.dc.hotel.beans.Promocao;
import br.ufscar.dc.hotel.dao.PromocaoDAO;
import br.ufscar.dc.hotel.dao.SiteDAO;
import br.ufscar.dc.hotel.forms.NovaPromocaoFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "NovaPromocaoServlet", urlPatterns = {"/NovaPromocaoServlet"})
public class NovaPromocaoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Resource(name = "jdbc/ReservaHotelDBLocal")
    DataSource dataSource;
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        NovaPromocaoFormBean npfb = new NovaPromocaoFormBean();
        SiteDAO siteDAO = new SiteDAO(dataSource);
        PromocaoDAO promocaoDAO = new PromocaoDAO(dataSource);
        try{
            BeanUtils.populate(npfb, request.getParameterMap());
            List<String> mensagens = npfb.validar();
            //seta no form o cnpj ja que o mesmo nao e digitado e nao pode ser editado
            npfb.setCnpj((String)request.getSession().getAttribute("cnpj_hotel"));
            request.getSession().setAttribute("novaPromocao", npfb);
            //acessa promocoes de um hotel e verifica se as datas sao iguais
            List<Promocao> promocoes = promocaoDAO.listarPromocaoHotel(npfb.getCnpj());
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            boolean datas_iguais = false;
            for(Promocao promocao : promocoes){
                String form_data_inicial = npfb.getData_inicial();
                String form_data_final = npfb.getData_final();
                String db_data_inicial = fmt.format(promocao.getData_inicial());
                String db_data_final = fmt.format(promocao.getData_final());
                System.out.println("Form: Data Incial: " +form_data_inicial + " Data Final: " +form_data_final);
                System.out.println("BD: Data Inicial: " +fmt.format(promocao.getData_inicial()) + 
                        " Data final: " +fmt.format(promocao.getData_final()));
                
                if(form_data_inicial.equals(db_data_inicial) && form_data_final.equals(db_data_final)){
                    datas_iguais = true;
                }
            }
            //se datas_iguais, entao existem um campo no bd em que as datas batem com as digitadas
            if(datas_iguais == true){
                if(mensagens == null){
                    mensagens = new ArrayList<String>();
                    mensagens.add("Não podem existir duas promoções de um mesmo hotel com datas iguais");
                }
                else{
                    mensagens.add("Não podem existir duas promoções de um mesmo hotel com datas iguais");
                }
            }
            //verifica se existe um site no banco de dados para associar a promocao 
            //se nao existir verifica se existem mais erros
            if(siteDAO.listaSitePorUrl(npfb.getUrl()) == null){
                if(mensagens == null){
                    mensagens = new ArrayList<String>();
                    mensagens.add("Não existe o site digitado no sistema");
                }
                else{
                    mensagens.add("Não existe o site digitado no sistema");
                }
            }
            if(mensagens == null){
                request.getRequestDispatcher("confirmarNovaPromocao.jsp").forward(request, response);
            }
            else{
                request.setAttribute("mensagens", mensagens);
                request.getRequestDispatcher("promocaoForm.jsp").forward(request, response);
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
