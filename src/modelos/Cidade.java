/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cleyslane
 */
public class Cidade {

    private String nomeCidade;
    private UnidadeFederacao unidadeFederacao;
    private final Map<String, Bairro> bairros;

    public Cidade() {
        this.bairros = new HashMap<>();
    }

    public Cidade(String nomeCidade, UnidadeFederacao uf) {
        this();
        this.nomeCidade = nomeCidade;
        this.unidadeFederacao = uf;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public UnidadeFederacao getUnidadeFederacao() {
        return unidadeFederacao;
    }

    public void setUnidadeFederacao(UnidadeFederacao unidadeFederacao) {
        this.unidadeFederacao = unidadeFederacao;
    }

    public Map<String, Bairro> getBairros() {
        return bairros;
    }
    
    public void adicionarBairros(Bairro ba){
        this.bairros.put(ba.getNomeBairro(), ba);
    }

}
