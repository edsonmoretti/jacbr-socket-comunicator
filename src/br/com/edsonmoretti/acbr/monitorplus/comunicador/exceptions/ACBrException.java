/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions;

/**
 *
 * @author Edson
 */
public class ACBrException extends Exception {

    /**
     * Creates a new instance of <code>ACBrException</code> without detail
     * message.
     */
    public ACBrException() {
    }

    /**
     * Constructs an instance of <code>ACBrException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ACBrException(String msg) {
        super(msg);
    }
}
