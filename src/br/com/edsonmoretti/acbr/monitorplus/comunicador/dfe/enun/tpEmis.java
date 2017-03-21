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
public enum tpEmis {
    /**
     * 1=Emissão normal (não em contingência);
     */
    NORMAL(1),
    /**
     * 2=Contingência FS-IA, com impressão do DANFE em formulário de segurança;
     */
    CONTIGENCIA_FS_IA(2),
    /**
     * 3=Contingência SCAN (Sistema de Contingência do Ambiente Nacional);
     */
    CONTIGENCIA_SCAN(3),
    /**
     * 4=Contingência DPEC (Declaração Prévia da Emissão em Contingência);
     */
    CONTIGENCIA_DPEC(4),
    /**
     * 5=Contingência FS-DA, com impressão do DANFE em formulário de segurança;
     */
    CONTIGENCIA_FS_DA(5),
    /**
     * 6=Contingência SVC-AN (SEFAZ Virtual de Contingência do AN);
     */
    CONTIGENCIA_SVC_AN(6),
    /**
     * 7=Contingência SVC-RS (SEFAZ Virtual de Contingência do RS);
     */
    CONTIGENCIA_SVC_RS(7);

    private final Integer cod;

    private tpEmis(Integer cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static tpEmis valueOf(int codigo) {
        for (tpEmis value : tpEmis.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }
}
