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
public enum tpNF {

    /**
     * 0 - Entrada
     */
    Entrada(0),
    /**
     * 1 - Saida
     */
    Saida(1);

    private final Integer cod;

    private tpNF(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static tpNF valueOf(int codigo) {
        for (tpNF value : tpNF.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }
}
