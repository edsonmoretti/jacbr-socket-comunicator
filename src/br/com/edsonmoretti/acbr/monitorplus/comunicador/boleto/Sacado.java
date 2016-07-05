/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Edson
 */
public class Sacado {

    private String nome;
    private String CNPJCPF;
    private TipoPessoa tipoPessoa;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String UF;
    private String CEP;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    public void setCNPJCPF(String CNPJCPF) {
        this.CNPJCPF = CNPJCPF;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Sacado.NomeSacado=" + nome + "\n"
                + "Sacado.CNPJCPF=" + CNPJCPF + "\n"
                + "Sacado.Pessoa=" + tipoPessoa.toString() + "\n"
                + "Sacado.Logradouro=" + logradouro + "\n"
                + "Sacado.Numero=" + numero + "\n"
                + "Sacado.Bairro=" + bairro + "\n"
                + "Sacado.Complemento=" + complemento + "\n"
                + "Sacado.Cidade=" + cidade + "\n"
                + "Sacado.UF=" + UF + "\n"
                + "Sacado.CEP=" + CEP + "\n"
                + "Sacado.Email=" + email;
    }

}
