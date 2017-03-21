/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.acbr;

import java.io.Serializable;

/**
 *
 * @author Edson
 */
public class DadosDeConexaoSocket implements Serializable {

    private String nameHost;
    private int porta;

    public DadosDeConexaoSocket(String nameHost, int porta) {
        this.nameHost = nameHost;
        this.porta = porta;
    }

    public String getNameHost() {
        return nameHost;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
}
