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
public class AutXML extends MembroList {

    private final String CNPJCPF;

    public AutXML(String CNPJCPF) {
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
