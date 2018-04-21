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
public class NovoSiteFormBean {
    private String url;
    private String nome;
    private String telefone;
    private String senha;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<String> validar(){
        List<String> mensagens = new ArrayList<String>();
        if(url.trim().length() == 0){
            mensagens.add("Url não pode ser vazia!");
        }
        if(nome.trim().length() == 0){
            mensagens.add("Nome não pode ser vazio!");
        }
        if(telefone.trim().length() == 0){
            mensagens.add("Telefone não pode ser vazio!");
        }
        if(senha.trim().length() == 0){
            mensagens.add("Senha não pode ser vazia!");
        }
       
        return (mensagens.isEmpty() ? null : mensagens);
    }
}
