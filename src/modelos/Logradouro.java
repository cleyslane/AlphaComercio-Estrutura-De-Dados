/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


/**
 *
 * @author cleyslane
 */
public class Logradouro {

    private String cep;
    private Cidade cidade;
    private UnidadeFederacao unidadeFederacao;
    private Bairro bairro;
    private String nomeLogradouro;

    public Logradouro(String cep, Cidade cidade, UnidadeFederacao uf, Bairro bairro, String nomeLogradouro) {
        this.cep = cep;
        this.cidade = cidade;
        this.unidadeFederacao = uf;
        this.bairro = bairro;
        this.nomeLogradouro = nomeLogradouro;
    }

    public Logradouro() {
        
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederacao getUnidadeFederacao() {
        return unidadeFederacao;
    }

    public void setUnidadeFederacao(UnidadeFederacao unidadeFederacao) {
        this.unidadeFederacao = unidadeFederacao;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

}
