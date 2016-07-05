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
public class Conta {

    private Integer conta;
    private Integer digitoConta;
    private Integer agencia;
    private Integer digitoAgencia;

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(Integer digitoConta) {
        this.digitoConta = digitoConta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(Integer digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    /*
     [Conta]<br>
     * Conta=99999<br>
     * DigitoConta=9<br>
     * Agencia=9999<br>
     * DigitoAgencia=9<br><br>
     */
    @Override
    public String toString() {
        return "[Conta]\n"
                + "Conta=" + conta + "\n"
                + "DigitoConta=" + digitoConta + "\n"
                + "Agencia=" + agencia + "\n"
                + "DigitoAgencia=" + digitoAgencia + "\n\n";
    }

}
