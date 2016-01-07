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
public class ACBrNFeException extends Exception {

    /**
     * Creates a new instance of <code>ACBrNFeException</code> without detail
     * message.
     */
    public ACBrNFeException() {
    }

    /**
     * Constructs an instance of <code>ACBrNFeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ACBrNFeException(String msg) {
        super(msg);
    }
}
