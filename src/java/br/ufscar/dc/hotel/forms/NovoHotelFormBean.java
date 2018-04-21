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
public class NovoHotelFormBean {
    
    private String cnpj;
    private String nome;
    private String cidade;
    private String senha;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List validar(){
        List<String> mensagens = new ArrayList<String>();
        if(nome.trim().length() == 0){
            mensagens.add("Nome não pode ser vazio!");
        }
        if(cnpj.trim().length() == 0){
            mensagens.add("CNPJ não pode ser vazio!");
        }
        if(cidade.trim().length() == 0){
            mensagens.add("Cidade não pode ser vazia!");
        }
        if(senha.trim().length() == 0){
            mensagens.add("Senha não pode ser vazia!");
        }
        return (mensagens.isEmpty() ? null : mensagens);
    }
    
    
}
