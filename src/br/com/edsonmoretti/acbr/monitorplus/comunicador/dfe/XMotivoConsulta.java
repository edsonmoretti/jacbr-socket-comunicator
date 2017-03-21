/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

/**
 *
 * @author Edson
 */
public class XMotivoConsulta extends XMotivo {

    private String ChNFe;
    private String NProt;
    private String DigVal;

    public XMotivoConsulta(String re) {
        super(re);
    }

    public XMotivoConsulta(XMotivo re) {
        super(re);
    }

    public String getChNFe() {
        return ChNFe;
    }

    public void setChNFe(String ChNFe) {
        this.ChNFe = ChNFe;
    }

    public void setChCTe(String ChNFe) {
        setChNFe(ChNFe);
    }

    public String getNProt() {
        return NProt;
    }

    public void setNProt(String NProt) {
        this.NProt = NProt;
    }

    public String getDigVal() {
        return DigVal;
    }

    public void setDigVal(String DigVal) {
        this.DigVal = DigVal;
    }

    @Override
    public String toString() {
        return "XMotivoConsulta{" + "ChNFe=" + ChNFe + ", NProt=" + NProt + ", DigVal=" + DigVal + " - " + super.toString();
    }

}
