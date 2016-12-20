/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.nfe;

/**
 *
 * @author DANIEL
 */
public class Destinatario  extends br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.Destinatario {
    
    public Destinatario(String idEstrangeiro, String CNPJCPF, String xNome, String indIEDest, String IE, String ISUF, String Email, String xLgr, String nro, String xCpl, String xBairro, String cMun, String xMun, String UF, String CEP, String cPais, String xPais, String Fone) {
        super(idEstrangeiro, CNPJCPF, xNome, indIEDest, IE, ISUF, Email, xLgr, nro, xCpl, xBairro, cMun, xMun, UF, CEP, cPais, xPais, Fone);
    }
    
}