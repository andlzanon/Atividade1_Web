/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.forms;

import br.ufscar.dc.hotel.dao.SiteDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Andre
 */
public class NovaPromocaoFormBean {
    
    private String url, cnpj, preco, data_inicial, data_final;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }
 
    public List validar() throws SQLException, NamingException{
        List<String> mensagens = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        if(url.trim().length() == 0){
            mensagens.add("Url não pode ser vazia!");
        }
        if(preco.trim().length() == 0){
            mensagens.add("Preço não pode ser vazio");
        }
        try {
            sdf.parse(data_inicial);
            sdf.parse(data_final);
            
            if(!sdf.parse(data_inicial).before(sdf.parse(data_final))){
                mensagens.add("Data final deve ser posterior a inicial");
            }
            
        } catch (ParseException pe) {
            mensagens.add("Datas devem estar no formato dd/mm/aaaa!");
        }
        
        return (mensagens.isEmpty() ? null : mensagens);
    }
}
