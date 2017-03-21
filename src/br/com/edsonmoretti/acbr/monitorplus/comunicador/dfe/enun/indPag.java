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
public enum indPag {
    /**
     * 0=Pagamento à vista;
     */
    A_VISTA(0),
    /**
     * 1=Pagamento a prazo;
     */
    A_PRAZO(1),
    /**
     * 2=Outros.
     */
    OUTROS(2);

    private final Integer cod;

    private indPag(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static indPag valueOf(int codigo) {
        for (indPag value : indPag.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }

}
