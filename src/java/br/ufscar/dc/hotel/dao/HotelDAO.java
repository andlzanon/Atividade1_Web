/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.dao;

import br.ufscar.dc.hotel.beans.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Andre
 */
public class HotelDAO {
    
    private final static String CADASTRAR_HOTEL_SQL = 
            "insert into Hotel(cnpj, nome, cidade, senha) values(?,?,?,?)";
    
    private final static String LISTAR_HOTEIS_SQL = 
            "select cnpj, nome, cidade from Hotel order by nome";
    
    private final static String LISTAR_HOTEIS_CIDADE_SQL = 
            "select cnpj, nome, cidade from Hotel where cidade = ?";
    
    private final static String LISTAR_HOTEL_NOME_SQL = 
            "select cnpj, nome, cidade, senha from Hotel where cnpj = ?";
    
    private DataSource dataSource;

    public HotelDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Hotel gravarHotel(Hotel h) throws SQLException, NamingException{
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CADASTRAR_HOTEL_SQL);) {
            ps.setString(1, h.getCnpj());
            ps.setString(2, h.getNome());
            ps.setString(3, h.getCidade());
            ps.setString(4, h.getSenha());
            ps.execute();
        }
        
        return h;
    }
    
    public List<Hotel> listarTodosHoteis() throws SQLException, NamingException{
        List<Hotel> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_HOTEIS_SQL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel h = new Hotel();
                    h.setCnpj(rs.getString("cnpj"));
                    h.setNome(rs.getString("nome"));
                    h.setCidade(rs.getString("cidade"));
                    ret.add(h);
                }
            }
        }
        return ret;
    }
    
    public List<Hotel> listarHoteisPorCidade(String cidade) throws SQLException, NamingException{
        List<Hotel> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_HOTEIS_CIDADE_SQL)) {
            ps.setString(1, cidade);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel h = new Hotel();
                    h.setCnpj(rs.getString("cnpj"));
                    h.setNome(rs.getString("nome"));
                    h.setCidade(rs.getString("cidade"));
                    ret.add(h);
                }
            }
        }
        return ret;
    }
    
    
    public Hotel listarHotelPorNome(String nome) throws SQLException, NamingException{
        Hotel ret = null;
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_HOTEL_NOME_SQL)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ret = new Hotel();
                    ret.setCnpj(rs.getString("cnpj"));
                    ret.setNome(rs.getString("nome"));
                    ret.setCidade(rs.getString("cidade"));
                    ret.setSenha(rs.getString("senha"));
                }
            }
        }
        return ret;
    }
           
}
