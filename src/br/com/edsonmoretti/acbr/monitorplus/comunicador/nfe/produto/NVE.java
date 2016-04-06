/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.produto;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.MembroList;

/**
 *
 * @author DANIEL
 */
public class NVE extends MembroList {

    private final String NVE;

    public NVE(String NVE) {
        this.NVE = NVE;
    }

    public String getNVE() {
        return NVE;
    }

    @Override
    public String toString() {
        return "[NVE" + super.getInd_PAI() + super.getInd() + "]\n"
                + "NVE=" + NVE + "\n";
    }

}
