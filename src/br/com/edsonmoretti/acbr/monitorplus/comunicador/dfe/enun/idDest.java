/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun;

/**
 * Identificador de local de destino da operação
 *
 * @author Edson
 */
public enum idDest {

    /**
     * 1=Operação interna;
     */
    Operacao_Interna(1),
    /**
     * 2=Operação interestadual;
     */
    Operacao_Interestadual(2),
    /**
     * 3=Operação com exterior.
     */
    Operacao_com_exterior(3);

    private final Integer cod;

    private idDest(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static idDest valueOf(int codigo) {
        for (idDest value : idDest.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }
}
