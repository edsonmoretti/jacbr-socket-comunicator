/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

/**
 *
 * @author Edson
 */
public class RelatorioGerencial {

    private String indice;
    private String descricao;
    private Integer contadorDoDia;
    private Integer contadorGeral;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public Integer getContadorDoDia() {
        return contadorDoDia;
    }

    public void setContadorDoDia(Integer contadorDoDia) {
        this.contadorDoDia = contadorDoDia;
    }

    public Integer getContadorGeral() {
        if (contadorGeral == null) {
            throw new NullPointerException("Total geral NULL. \nVerifique se foi executado o comando e.getVariaveis().getRelatoriosGerenciais().lerTotaisRelatoriosGerenciais()");
        } else {
            return contadorGeral;
        }
    }

    public void setContadorGeral(Integer contadorGeral) {
        this.contadorGeral = contadorGeral;
    }

    @Override
    public String toString() {
        return indice + " " + descricao + " TD: " + contadorDoDia + (contadorGeral == null ? "" : " TG: " + contadorGeral);
    }

}
