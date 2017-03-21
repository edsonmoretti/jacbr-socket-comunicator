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
public enum CRT {
    /**
     * 1=Simples Nacional;
     */
    Simples(1),
    /**
     * 2=Simples Nacional, excesso sublimite de receita bruta;
     */
    Simples_excesso(2),
    /**
     * 3=Regime Normal. (v2.0).
     */
    Normal(3);

    private final Integer codigo;

    private CRT(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return codigo.toString();
    }

    public static CRT valueOf(int codigo) {
        for (CRT value : CRT.values()) {
            if (codigo == value.codigo) {
                return value;
            }
        }
        return null;
    }

}
