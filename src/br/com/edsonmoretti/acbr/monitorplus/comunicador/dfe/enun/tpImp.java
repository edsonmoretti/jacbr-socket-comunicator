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
public enum tpImp {

    /**
     * 0=Sem geração de DANFE;
     */
    SEM_DANFE(0),
    /**
     * 1=DANFE normal, Retrato;
     */
    RETRATO(1),
    /**
     * 2=DANFE normal, Paisagem;
     */
    PAISAGEM(2),
    /**
     * 3=DANFE Simplificado;
     */
    SIMPLIFICADO(3),
    /**
     * 4=DANFE NFC-e;
     */
    NFCe(4),
    /**
     * 5=DANFE NFC-e em mensagem eletrônica (o envio de mensagem eletrônica pode
     * ser feita de forma simultânea com a impressão do DANFE; usar o tpImp=5
     * quando esta for a única forma de disponibilização do DANFE).
     */
    NFCe5(5);

    private final Integer cod;

    private tpImp(Integer cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return cod.toString();
    }

    public static tpImp valueOf(int codigo) {
        for (tpImp value : tpImp.values()) {
            if (codigo == value.cod) {
                return value;
            }
        }
        return null;
    }
}
