/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.cte.InfCTe;

/**
 *
 * @author DANIEL
 */
public class NFeVO {

    //membros
    private InfNfe infNfe;
    private Identificacao identificacao;
    private ListVO<NFRef> listNFRef;
    private Emitente emitente;
    private Avulsa avulsa;
    private Destinatario destinatario;
    private Retirada retirada;
    private Entrega entrega;
    private ListVO<AautXML> listAutXML;
    private ListVO<Produto> listProduto;

    public NFeVO() {
    }

    public NFeVO(InfNfe infNfe, Identificacao Identificacao, Emitente Emitente, Avulsa Avulsa, Destinatario Destinatario, Retirada Retirada, Entrega Entrega) {
        this.infNfe = infNfe;
        this.identificacao = Identificacao;
        this.listNFRef = new ListVO<>();
        this.emitente = Emitente;
        this.avulsa = Avulsa;
        this.destinatario = Destinatario;
        this.retirada = Retirada;
        this.entrega = Entrega;
        this.listAutXML = new ListVO<>();
        this.listProduto = new ListVO<>();
    }

    public NFeVO addNFRef(NFRef NFRef) {
        this.listNFRef.add(NFRef);
        return this;
    }

    public NFeVO addautXML(AautXML autXML) {
        this.listAutXML.add(autXML);
        return this;
    }

    public NFeVO addProduto(Produto Produto) {
        this.listProduto.add(Produto);
        return this;
    }

    public InfNfe getInfNfe() {
        return infNfe;
    }

    public void setInfCTe(InfCTe infCTe) {
        this.infNfe = infCTe;
    }

    public Identificacao getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Identificacao identificacao) {
        this.identificacao = identificacao;
    }

    public ListVO<NFRef> getListNFRef() {
        return listNFRef;
    }

    public void setListNFRef(ListVO<NFRef> listNFRef) {
        this.listNFRef = listNFRef;
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
    }

    public Avulsa getAvulsa() {
        return avulsa;
    }

    public void setAvulsa(Avulsa avulsa) {
        this.avulsa = avulsa;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Retirada getRetirada() {
        return retirada;
    }

    public void setRetirada(Retirada retirada) {
        this.retirada = retirada;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public ListVO<AautXML> getListAutXML() {
        return listAutXML;
    }

    public void setListAutXML(ListVO<AautXML> listAutXML) {
        this.listAutXML = listAutXML;
    }

    public ListVO<Produto> getListProduto() {
        return listProduto;
    }

    public void setListProduto(ListVO<Produto> listProduto) {
        this.listProduto = listProduto;
    }

    @Override 
    public String toString() {
        String retorno = "";
        retorno += (infNfe).toString();
        retorno += (identificacao).toString();
        retorno += (listNFRef).toString();
        retorno += (emitente).toString();
        retorno += (avulsa).toString();
        retorno += (destinatario).toString();
        retorno += (retirada).toString();
        retorno += (entrega).toString();
        retorno += (listAutXML).toString();
        retorno += (listProduto).toString();
        return retorno;
    }
}
