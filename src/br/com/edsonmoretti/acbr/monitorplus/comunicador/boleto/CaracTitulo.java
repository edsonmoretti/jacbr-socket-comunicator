/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Edson
 */
public enum CaracTitulo {

    CobrancaSimples(0),
    CobrancaVinculada(1),
    CobrancaCaucionada(2),
    CobrancaDescontada(3),
    CobrancaVendor(4);

    private final int codigo;

    private CaracTitulo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }
}
