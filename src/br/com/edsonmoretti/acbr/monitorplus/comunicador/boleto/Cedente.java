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
public class Cedente {

    private String nome;
    private String CNPJCPF;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String CEP;
    private String complemento;
    private String UF;
    private RespEmis respEmis;
    private TipoPessoa tipoPessoa;
    private String codigoCedente;
    private LayoutBol layoutBol;
    private CaracTitulo caracTitulo;

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public RespEmis getRespEmis() {
        return respEmis;
    }

    public void setRespEmis(RespEmis respEmis) {
        this.respEmis = respEmis;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getCodigoCedente() {
        return codigoCedente;
    }

    public void setCodigoCedente(String codigoCedente) {
        this.codigoCedente = codigoCedente;
    }

    public LayoutBol getLayoutBol() {
        return layoutBol;
    }

    public void setLayoutBol(LayoutBol layoutBol) {
        this.layoutBol = layoutBol;
    }

    public CaracTitulo getCaracTitulo() {
        return caracTitulo;
    }

    public void setCaracTitulo(CaracTitulo caracTitulo) {
        this.caracTitulo = caracTitulo;
    }

    /*
     [Cedente]<br>
     * Nome=São João LTDA.<br>
     * CNPJCPF= 99.999.999/9999-99<br>
     * Logradouro=Rua Evaristo Mendes<br>
     * Numero=200<br>
     * Bairro=Centro<br>
     * Cidade=Tatui<br>
     * CEP=18.270-000<br>
     * Complemento=Sala 10<br>
     * UF=SP<br>
     * RespEmis=0<br>
     * TipoPessoa=1<br>
     * CodigoCedente=123456<br>
     * LayoutBol=3<br>
     * CaracTitulo=0<br><br>
     */
    @Override
    public String toString() {
        return "[Cendente]\n"
                + "" + "Nome=" + nome + "\n"
                + "CNPJCPF=" + CNPJCPF + "\n"
                + "Logradouro=" + logradouro + "\n"
                + "Numero=" + numero + "\n"
                + "Bairro=" + bairro + "\n"
                + "Cidade=" + cidade + "\n"
                + "CEP=" + CEP + "\n"
                + "Complemento=" + complemento + "\n"
                + "UF=" + UF + "\n"
                + "RespEmis=" + respEmis + "\n"
                + "TipoPessoa=" + tipoPessoa + "\n"
                + "CodigoCedente=" + codigoCedente + "\n"
                + "LayoutBol=" + layoutBol + "\n"
                + "CaracTitulo=" + caracTitulo + "\n\n";
    }

}
