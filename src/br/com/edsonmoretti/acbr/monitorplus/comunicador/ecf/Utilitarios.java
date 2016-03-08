/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;

/**
 *
 * @author Edson
 */
public class Utilitarios {

    /**
     * Permite gravar no ECF informações sobre operadores.
     *
     * @param operador Nome do operador.
     * @throws ACBrECFException
     */
    public void identificaOperador(String operador) throws ACBrECFException {
        ACBrECF.comandoECF("IdentificaOperador(\"" + operador + "\")");
    }

    /**
     *Permite gravar no ECF, informações sobre o Programa Aplicativo Fiscal (PAF) em operação. Esta informação deve ser impressa em todos os cupons, de acordo com a lei atual.
     * @param nomVersao Nome e versão do aplicativo fiscal. 
     * @param md5 Numero do MD5.
     * @throws ACBrECFException
     */
    public void identificaPAF(String nomVersao, String md5) throws ACBrECFException {
        ACBrECF.comandoECF("IdentificaPAF(\"" + nomVersao + "\",\"" + md5 + "\")");
    }
}
