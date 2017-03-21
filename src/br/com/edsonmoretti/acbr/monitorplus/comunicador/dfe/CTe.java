/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

/**
 *
 * @author DANIEL
 */
public class CTe extends br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.DFe {

    private LocColeta locColeta;

    public CTe() {
        super();
    }

    public CTe(InfCTe infCTe, Identificacao Identificacao, Emitente Emitente, Avulsa Avulsa, Destinatario Destinatario, Retirada Retirada, Entrega Entrega) {
        super(infCTe, Identificacao, Emitente, Avulsa, Destinatario, Retirada, Entrega);
    }

    public LocColeta getLocColeta() {
        return locColeta;
    }

    public void setLocColeta(LocColeta locColeta) {
        this.locColeta = locColeta;
    }

}
