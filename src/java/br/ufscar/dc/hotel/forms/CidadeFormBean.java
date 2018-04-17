/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.hotel.forms;

/**
 *
 * @author Andre
 */
public class CidadeFormBean {
    private String cidade;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String validar(){
        if(cidade.trim().length() == 0){
            return "Nao pode ser vazio";
        }else{
            return null;
        }
    }
}
