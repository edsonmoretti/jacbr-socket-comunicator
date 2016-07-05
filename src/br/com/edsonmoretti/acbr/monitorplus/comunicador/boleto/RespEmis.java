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
public enum RespEmis {

    ClienteEmite(0),
    BancoEmite(1),
    BancoReemite(2),
    BancoNaoReemite(3);

    private final int codigo;

    RespEmis(int cod) {
        this.codigo = cod;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

}
