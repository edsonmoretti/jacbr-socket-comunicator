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
public enum TipoDeSaida {

    PDF("P"),
    Impressora("I"),
    Email("E");

    private final String codigo;

    private TipoDeSaida(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return codigo;
    }

}
