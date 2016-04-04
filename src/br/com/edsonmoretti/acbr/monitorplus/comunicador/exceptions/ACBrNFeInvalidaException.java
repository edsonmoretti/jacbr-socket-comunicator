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
public class ACBrNFeInvalidaException extends Exception {

    /**
     * Creates a new instance of <code>ACBrNFeException</code> without detail
     * message.
     */
    public ACBrNFeInvalidaException() {
    }

    /**
     * Constructs an instance of <code>ACBrNFeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ACBrNFeInvalidaException(String msg) {
        super(msg);
    }

    public ACBrNFeInvalidaException(ACBrException ex) {
        super(ex.getMessage());
    }

    public ACBrNFeInvalidaException(ACBrNFeException ex) {
        super(ex.getMessage());
    }
}
