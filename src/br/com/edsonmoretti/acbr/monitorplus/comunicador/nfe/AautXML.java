/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

/**
 *
 * @author DANIEL
 */
public class AautXML extends MembroList {

    private final String CNPJCPF;

    public AautXML(String CNPJCPF) {
        this.CNPJCPF = CNPJCPF;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    @Override
    public String toString() {
        return "[autXML" + super.getInd() + "]\n"
                + "CNPJCPF=" + CNPJCPF + "\n";
    }

}
