/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.dao;

import br.ufscar.dc.hotel.beans.Administrador;
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
public class AdministradorDAO {
    
    private final static String CADASTRAR_ADM_SQL = 
            "insert into Administrador(usuario, senha) values(?,?)";
    
    private DataSource dataSource;

    public AdministradorDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Administrador gravarAdm(Administrador a) throws SQLException, NamingException{
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CADASTRAR_ADM_SQL);) {
            ps.setString(1, a.getUsuario());
            ps.setString(2, a.getSenha());
            ps.execute();
        }
        
        return a;
    }
}
