/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class XMotivoStatusDoServico extends XMotivo {

    private String TMed;

    public String getTMed() {
        return TMed;
    }

    public void setTMed(String TMed) {
        this.TMed = TMed;
    }

    @Override
    public String toString() {
        return "XMotivoStatusDoServico{" + "TMed=" + TMed + " - " + super.toString();
    }

}
