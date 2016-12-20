/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.nfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.Avulsa;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.Destinatario;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.Emitente;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.Entrega;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.Identificacao;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.InfNfe;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.Retirada;

/**
 *
 * @author DANIEL
 */
public class NFeVO extends br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.NFeVO {

    public NFeVO(InfNfe infNfe, Identificacao Identificacao, Emitente Emitente, Avulsa Avulsa, Destinatario Destinatario, Retirada Retirada, Entrega Entrega) {
        super(infNfe, Identificacao, Emitente, Avulsa, Destinatario, Retirada, Entrega);
    }

}
