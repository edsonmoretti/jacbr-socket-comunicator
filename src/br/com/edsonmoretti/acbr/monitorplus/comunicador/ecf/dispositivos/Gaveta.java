/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.dispositivos;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;

/**
 *
 * @author Edson
 */
public class Gaveta {

    /**
     * Aciona a abertura da gaveta de dinheiro ligada ao ECF
     *
     * @throws ACBrECFException
     */
    public void abreGaveta() throws ACBrECFException {
        ACBrECF.comandoECF("AbreGaveta");
    }

    /**
     * Retorna “True” se a gaveta de dinheiro está aberta.
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isGavetaAberta() throws ACBrECFException {
        return ACBrECF.comandoECF("GavetaAberta").equalsIgnoreCase("true");
    }
}
