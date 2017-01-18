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
public class Aliquota {

    private char tipo;
    private String indice;
    private BigDecimal percentualImposto;
    private BigDecimal total;

    public String getTotalizador() {
        return indice + String.valueOf(tipo) + (percentualImposto.compareTo(BigDecimal.TEN) == -1 ? "0" : "") + String.format("%.2f", percentualImposto).replace(",", "");//Será que vai existir
    }

    /**
     *
     * @return Tipo da Alíquota, ( "T" = ICMS, "S" = ISS)
     */
    public char getTipo() {
        return tipo;
    }

    protected void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPercentualImposto() {
        return percentualImposto;
    }

    protected void setPercentualImposto(BigDecimal percentualImposto) {
        this.percentualImposto = percentualImposto;
    }

    public BigDecimal getTotal() {
        if (total == null) {
            throw new NullPointerException("Total == null. \nVerifique se foi executado o comando para ler os totais das aliquotas da impressora.");
        } else {
            return total;
        }
    }

    protected void setTotal(BigDecimal total) {
        this.total = total;
    }

    protected void setIndice(String indice) {
        this.indice = indice;
    }

    public String getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        return getTotalizador();
    }

}
