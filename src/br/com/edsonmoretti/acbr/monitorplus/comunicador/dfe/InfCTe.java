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
public class InfCTe extends br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.InfNfe {

    private final String versao = "3.00"/* ou 2.00 ? final ou não?*/;

    @Override
    public String toString() {
        return "[infNFe]\n"
                + "versao=" + versao + "\n";
    }
}
