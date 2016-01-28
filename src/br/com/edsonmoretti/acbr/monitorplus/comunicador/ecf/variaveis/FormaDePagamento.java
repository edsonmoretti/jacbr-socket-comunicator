/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import java.math.BigDecimal;

/**
 *
 * @author Edson
 */
public class FormaDePagamento {

    private int indice;
    private String descricao;
    boolean imprimeVinculado;
    private BigDecimal total;

    public int getIndice() {
        return indice;
    }

    protected void setIndice(int indice) {
        this.indice = indice;
    }

    public String getDescricao() {
        return descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isImprimeVinculado() {
        return imprimeVinculado;
    }

    protected void setImprimeVinculado(boolean imprimeVinculado) {
        this.imprimeVinculado = imprimeVinculado;
    }

    public BigDecimal getTotal() {
        if (total == null) {
            throw new NullPointerException("Total NULL verifique se já foi rodado o comando: ecf..getVariaveis().getFormasDePagamento().lerTotaisFormaPagamento()");
        }
        return total;
    }

    protected void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format("%02d", indice) + (imprimeVinculado ? "V" : "") + " " + descricao + (total == null ? "" : " T" + total);
    }

}
