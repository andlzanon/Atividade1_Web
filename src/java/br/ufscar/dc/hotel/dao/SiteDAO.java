/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.dao;

import br.ufscar.dc.hotel.beans.Hotel;
import br.ufscar.dc.hotel.beans.Site;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Andre
 */
public class SiteDAO {
    
    private final static String CADASTRAR_SITE_SQL = 
            "insert into Site(url, nome, telefone, senha) values(?,?,?,?)";
    
    private DataSource dataSource;

    public SiteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Site gravarSite(Site s) throws SQLException, NamingException{
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CADASTRAR_SITE_SQL);) {
            ps.setString(1, s.getUrl());
            ps.setString(2, s.getNome());
            ps.setString(3, s.getTelefone());
            ps.setString(4, s.getSenha());
            ps.execute();
        }
        
        return s;
    }
}
