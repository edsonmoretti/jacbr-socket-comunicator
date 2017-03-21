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
public enum tpAmb {

    /**
     * 1 - Producao
     */
    Producao(1),
    /**
     * 2 - Homologação
     */
    Homologacao(2);

    private final Integer cod;

    private tpAmb(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static tpAmb valueOf(int codigo) {
        for (tpAmb value : tpAmb.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }
}
