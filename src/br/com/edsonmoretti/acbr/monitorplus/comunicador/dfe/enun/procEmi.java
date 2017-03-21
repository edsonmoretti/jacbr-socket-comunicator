/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun;

/**
 *
 * @author Edson
 */
public enum procEmi {
    /**
     * 0=Emissão de NF-e com aplicativo do contribuinte;
     */
    APLICATIVO_CONTRIBUINTE(0),
    /**
     * 1=Emissão de NF-e avulsa pelo Fisco;
     */
    AVULSA_FISCO(1),
    /**
     * 2=Emissão de NF - e avulsa, pelo contribuinte com seu certificado *
     * digital, através do site do Fisco;
     */
    AVULSA_CONTRIBUINTE(2),
    /**
     * 3=Emissão NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
     */
    APLICATIVO_FISCO(3);

    private final Integer cod;

    private procEmi(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static procEmi valueOf(int codigo) {
        for (procEmi value : procEmi.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }

}
