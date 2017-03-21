/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun;

/**
 *
 * @author Edson
 */
public enum indTot {
    /**
     * 0=Valor do item (vProd) não compõe o valor total da NF-e
     */
    N_COMPOE_TOTAL_DA_NF(1),
    /**
     * 1=Valor do item (vProd) compõe o valor total da NF-e (vProd) (v2.0)
     */
    COMPOE_TOTAL_DA_NF(2);

    private final Integer codigo;

    private indTot(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return codigo.toString();
    }

    public static indTot valueOf(int codigo) {
        for (indTot value : indTot.values()) {
            if (codigo == value.codigo) {
                return value;
            }
        }
        return null;
    }

}
