/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Edson
 */
public enum Bancos {
    BancoDoBrasil(1),
    Santander(2),
    CaixaEconomicaFederal_ConvenioSIGCB(3),
    CaixaEconomicaFederal_ConvenioSICOB(4),
    Bradesco(5),
    Itau(6),
    BancoMercantil(7),
    Sicred(8),
    Bancoob(9),
    Banrisul(10),
    HSBC(11),
    Banestes(12),
    BancoDoNordeste(13),
    BancoBRB(14);
    private final int codigo;

    private Bancos(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

}
