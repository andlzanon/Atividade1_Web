/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.forms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class LoginFormBean {
    private String usuario, senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List validar(){
        List<String> mensagens = new ArrayList<String>();
        if(usuario.trim().length() == 0){
            mensagens.add("Usuario não pode ser vazio!");
        }
        if(senha.trim().length() == 0){
            mensagens.add("Senha não pode ser vazia!");
        }
        return (mensagens.isEmpty() ? null : mensagens);
    }
}
