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
public enum finNFe {

    /**
     * 1=NF-e normal;
     */
    NORMAL(1),
    /**
     * 2=NF-e complementar;
     */
    COMPLEMENTAR(2),
    /**
     * 3=NF-e de ajuste;
     */
    AJUSTE(3),
    /**
     * 4=Devolução de mercadoria.
     */
    DEVOLUCAO(4);

    private final Integer cod;

    private finNFe(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static finNFe valueOf(int codigo) {
        for (finNFe value : finNFe.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }

}
