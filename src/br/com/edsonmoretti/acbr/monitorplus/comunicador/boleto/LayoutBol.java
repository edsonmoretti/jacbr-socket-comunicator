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
public enum LayoutBol {
    Padrao(0),
    Carne(1),
    /**
     * Não implementado = Padrão
     *
     * @deprecated Não implementado = Padrão
     */
    Fatura(2),
    Entrega(3);

    private final int codigo;

    private LayoutBol(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

}
