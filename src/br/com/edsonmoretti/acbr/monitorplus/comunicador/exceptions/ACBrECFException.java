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
public class ACBrECFException extends Exception {

    /**
     * Creates a new instance of <code>ACBrECFException</code> without detail
     * message.
     */
    public ACBrECFException() {
    }

    /**
     * Constructs an instance of <code>ACBrECFException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ACBrECFException(String msg) {
        super(msg);
    }
}
