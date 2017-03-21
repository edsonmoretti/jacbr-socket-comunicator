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
public enum indFinal {

    /**
     * 0=Normal;
     */
    NORMAL(0),
    /**
     * 1=Consumidor final;
     */
    CONSUMIDOR_FINAL(1);

    private final Integer cod;

    private indFinal(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static indFinal valueOf(int codigo) {
        for (indFinal value : indFinal.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }

}
