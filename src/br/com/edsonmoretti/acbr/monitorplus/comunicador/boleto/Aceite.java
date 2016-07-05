/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Junior G3
 */
public enum Aceite {

    SIM(0),
    NAO(1);

    private final int codigo;

    Aceite(int cod) {
        this.codigo = cod;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

}
