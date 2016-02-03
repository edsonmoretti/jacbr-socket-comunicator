/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.dispositivos.Cheque;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.dispositivos.Gaveta;

/**
 *
 * @author Edson
 */
public class Dispositivos {

    private Gaveta gaveta;
    private Cheque cheque;

    public Gaveta getGaveta() {
        return gaveta == null ? gaveta = new Gaveta() : gaveta;
    }

    public Cheque getCheque() {
        return cheque == null ? cheque = new Cheque() : cheque;
    }

}
