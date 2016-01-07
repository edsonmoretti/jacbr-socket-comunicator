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
public class ACBrECFException extends Exception {
    //TODO: Quando sobrar tempo catalogar os ERROS
//    public enum CodigoERRO {
//
//        /**
//         * Erro desconhecido, não catalogado ainda.
//         */
//        ERRO_DESCONHECIDO,
//        /**
//         * Redução Z de dia anterior não emitida
//         */
//        REDUCAO_Z_JA_EMITIDA;
//    }

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
//    CodigoERRO codigoERRO = CodigoERRO.ERRO_DESCONHECIDO;
//
//    public void setCodigoERRO(CodigoERRO codigoERRO) {
//        this.codigoERRO = codigoERRO;
//    }
//
//    public CodigoERRO getCodigoDoErro() {
//        return codigoERRO;
//    }
}
