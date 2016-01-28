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
public class ComprovanteNaoFiscal {

    private String indice;
    private String descricao;
    private boolean permiteVinculado;
    private boolean entrada;
    private boolean saida;
    private BigDecimal total;

    public String getIndice() {
        return indice;
    }

    protected void setIndice(String indice) {
        this.indice = indice;
    }

    public String getDescricao() {
        return descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPermiteVinculado() {
        return permiteVinculado;
    }

    protected void setPermiteVinculado(boolean permiteVinculado) {
        this.permiteVinculado = permiteVinculado;
    }

    public BigDecimal getTotal() {
        if (total == null) {
            throw new NullPointerException("Total ==null. \nVerifique se foi rodado o comando para carregar os totais.");
        } else {
            return total;
        }
    }

    protected void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isEntrada() {
        return entrada;
    }

    public void setEntrada(boolean entrada) {
        this.entrada = entrada;
    }

    public boolean isSaida() {
        return saida;
    }

    public void setSaida(boolean saida) {
        this.saida = saida;
    }

    @Override
    public String toString() {
        return (indice.length() == 1 ? indice + " " : indice) + (permiteVinculado ? "V" : "") + " " + descricao + " E:" + entrada + " S:" + saida;
    }

}
