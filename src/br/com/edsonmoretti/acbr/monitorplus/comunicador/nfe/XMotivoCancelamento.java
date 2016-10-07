/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

/**
 *
 * @author Edson
 */
public class XMotivoCancelamento extends XMotivoEvento {

    private String XML;

    public XMotivoCancelamento(String re) {
        super(re);
    }

    public XMotivoCancelamento(XMotivo re) {
        super(re);
    }

    public String getXML() {
        return XML;
    }

    public void setXML(String XML) {
        this.XML = XML;
    }

    @Override
    public String toString() {
        return "XMotivoCancelamento{" + "XML=" + XML + " - " + super.toString() + '}';
    }

}
