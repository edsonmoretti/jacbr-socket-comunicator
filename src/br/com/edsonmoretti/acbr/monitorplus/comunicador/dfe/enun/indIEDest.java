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
public enum indIEDest {
    /**
     * 1=Contribuinte ICMS (informar a IE do destinatário);
     */
    CONTRIBUINTE(1),
    /**
     * 2=Contribuinte isento de Inscrição no cadastro de Contribuintes do ICMS
     */
    INSENTO(2),
    /**
     * 9=Não Contribuinte, que pode ou não possuir Inscrição Estadual no
     * Cadastro de Contribuintes do ICMS. Nota 1: No caso de NFC-e informar
     * indIEDest=9 e não informar a tag IE do destinatário; Nota 2: No caso de
     * operação com o Exterior informar indIEDest=9 e não informar a tag IE do
     * destinatário; Nota 3: No caso de Contribuinte Isento de Inscrição
     * (indIEDest=2), não informar a tag IE do destinatário
     */
    NAO_CONTRIBUINTE(9);
    private final Integer codigo;

    private indIEDest(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return codigo.toString();
    }

    public static indIEDest valueOf(int codigo) {
        for (indIEDest value : indIEDest.values()) {
            if (codigo == value.codigo) {
                return value;
            }
        }
        return null;
    }

}
