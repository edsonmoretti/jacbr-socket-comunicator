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
public enum indPres {
    /**
     * 0=Não se aplica (por exemplo, Nota Fiscal complementar ou de ajuste);
     */
    NAO_SE_APLICA(0),
    /**
     * 1=Operação presencial;
     */
    PRESENCIAL(1),
    /**
     * 2=Operação não presencial, pela Internet;
     */
    INTERNET(2),
    /**
     * 3=Operação não presencial, Teleatendimento;
     */
    TELEATENDIMENTO(3),
    /**
     * 4=NFC-e em operação com entrega a domicílio;
     */
    NFCe_ENTREGA_DOMICILIO(2),
    /**
     * 9=Operação não presencial, outros;
     */
    N_PRESENCIAL_OUTROS(9);

    private final Integer cod;

    private indPres(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static indPres valueOf(int codigo) {
        for (indPres value : indPres.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }

}
