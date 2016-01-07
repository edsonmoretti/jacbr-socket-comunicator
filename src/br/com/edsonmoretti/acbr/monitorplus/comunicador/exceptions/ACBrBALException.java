/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrBALException extends Exception {

    /**
     * Creates a new instance of <code>BalancaInativaException</code> without
     * detail message.
     */
    public ACBrBALException() {
    }

    /**
     * Constructs an instance of <code>BalancaInativaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ACBrBALException(String msg) {
        super(msg);
    }
}
