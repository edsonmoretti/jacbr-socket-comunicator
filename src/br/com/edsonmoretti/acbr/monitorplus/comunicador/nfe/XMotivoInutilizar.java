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
public class XMotivoInutilizar extends XMotivo {

    private String NProt;

    public XMotivoInutilizar(String re) {
        super(re);
    }

    public XMotivoInutilizar(XMotivo re) {
        super(re);
    }

    public String getNProt() {
        return NProt;
    }

    public void setNProt(String NProt) {
        this.NProt = NProt;
    }

    @Override
    public String toString() {
        return "XMotivoInutilizar{" + "NProt=" + NProt + '}';
    }

}
