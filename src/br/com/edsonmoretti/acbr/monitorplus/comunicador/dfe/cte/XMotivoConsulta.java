/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.cte;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.XMotivo;

/**
 *
 * @author Edson
 */
public class XMotivoConsulta extends br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.XMotivoConsulta {

    public XMotivoConsulta(XMotivo re) {
        super(re);
    }

    public XMotivoConsulta(String re) {
        super(re);
    }

    public String getChCTe() {
        return getChNFe();
    }

    public void setChCTe(String ChNFe) {
        setChNFe(ChNFe);
    }
}
