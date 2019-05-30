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
public class UnidadeFederacao {

    private String siglaUnidadeFederacao;
    private final HashMap<String, Cidade> cidades;

    public UnidadeFederacao(){
        this.cidades = new HashMap<>();
    }

    public UnidadeFederacao(String uf) {
        this();
        this.siglaUnidadeFederacao = uf;
    }

    public Map<String, Cidade> getCidades() {
        return cidades;
    }

    public String getSiglaUnidadeFederacao() {
        return siglaUnidadeFederacao;
    }

    public void setSiglaUnidadeFederacao(String siglaUnidadeFederacao) {
        this.siglaUnidadeFederacao = siglaUnidadeFederacao;
    }

    public void adicionaCidade(Cidade city){
        this.cidades.put(city.getNomeCidade(), city);
    }


}
