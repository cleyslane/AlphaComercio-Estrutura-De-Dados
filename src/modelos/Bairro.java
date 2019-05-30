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
public class Bairro {

    private String nomeBairro;
    private final Map<String, Logradouro> logradouros; //K = cep, V = Logradouro

    public Bairro() {
        this.logradouros = new HashMap<>();
    }

    public Bairro(String nomeBairro) {
        this();
        this.nomeBairro = nomeBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public Map<String, Logradouro> getLogradouros() {
        return logradouros;
    }

    public void adicionarLogradouro(Logradouro log){
        this.logradouros.put(log.getCep(), log);
    }
}
