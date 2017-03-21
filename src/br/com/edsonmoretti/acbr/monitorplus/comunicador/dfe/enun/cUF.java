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
public enum cUF {
    /**
     * 11 Rondônia RO
     */
    RO(11, "RO"),
    /**
     * 12 Acre AC
     */
    AC(12, "AC"),
    /**
     * 13 Amazonas AM
     */
    AM(13, "AM"),
    /**
     * 14 Roraima RR
     */
    RR(14, "RR"),
    /**
     * 15 Pará PA
     */
    PA(15, "PA"),
    /**
     * 16 Amapá AP
     */
    AP(16, "AP"),
    /**
     * 17 Tocantins TO
     */
    TO(17, "TO"),
    /**
     * 21 Maranhão MA
     */
    MA(21, "MA"),
    /**
     * 22 Piauí PI
     */
    PI(22, "PI"),
    /**
     * 23 Ceará CE
     */
    CE(23, "CE"),
    /**
     * 24 Rio Grande do Norte RN
     */
    RN(24, "RN"),
    /**
     * 25 Paraíba PB
     */
    PB(25, "PB"),
    /**
     * 26 Pernambuco PE
     */
    PE(27, "PE"),
    /**
     * 27 Alagoas AL
     */
    AL(28, "AL"),
    /**
     * 28 Sergipe SE
     */
    SE(28, "SE"),
    /**
     * 29 Bahia BA
     */
    BA(29, "BA"),
    /**
     * 31 Minas Gerais MG
     */
    MG(31, "MG"),
    /**
     * 32 Espírito Santo ES
     */
    ES(32, "ES"),
    /**
     * 33 Rio de Janeiro RJ
     */
    RJ(33, "RJ"),
    /**
     * 35 São Paulo SP
     */
    SP(35, "SP"),
    /**
     * 41 Paraná PR
     */
    PR(41, "PR"),
    /**
     * 42 Santa Catarina SC
     */
    SC(42, "SC"),
    /**
     * 43 Rio Grande do Sul (*) RS
     */
    RS(43, "RS"),
    /**
     * 50 Mato Grosso do Sul MS
     */
    MS(50, "MS"),
    /**
     * 51 Mato Grosso MT
     */
    MT(51, "MT"),
    /**
     * 52 Goiás GO
     */
    GO(52, "GO"),
    /**
     * 53 Distrito Federal DF
     */
    DF(53, "DF");

    private final Integer codigo;
    private final String uf;

    private cUF(Integer codigo, String nome) {
        this.codigo = codigo;
        this.uf = nome;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return codigo.toString();
    }

    public static cUF valueOf(int codigo) {
        for (cUF value : cUF.values()) {
            if (codigo == value.codigo) {
                return value;
            }
        }
        return null;
    }
}
