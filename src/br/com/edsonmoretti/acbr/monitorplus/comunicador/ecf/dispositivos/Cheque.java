/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.dispositivos;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Edson
 */
public class Cheque {

    /**
     * Retorna “True” se cheque está pronto.
     *
     * @throws ACBrECFException
     */
    public void isChequePronto() throws ACBrECFException {
        ACBrECF.comandoECF("ChequePronto");
    }

    /**
     * Realiza a impressão do cheque conforme os dados informados nos
     * parâmetros.
     *
     * @param banco Número do Banco.
     * @param valor Valor do cheque.
     * @param favorecido Nome o Favorecido
     * @param cidade Cidade
     * @param data Data formato "dd/mm/aaaa".
     * @param obs Parâmetro opcional. Se desejar colocar alguma observação no
     * cheque.
     * @throws ACBrECFException
     */
    public void imprimeCheque(String banco, BigDecimal valor, String favorecido, String cidade, Date data, String obs) throws ACBrECFException {
        ACBrECF.comandoECF("ImprimeCheque(" + banco + "," + valor + "," + favorecido + "," + cidade + "," + data + "," + obs + ")");
    }

    /**
     * Realiza a impressão do cheque conforme os dados informados nos
     * parâmetros.
     *
     * @param banco Número do Banco.
     * @param valor Valor do cheque.
     * @param favorecido Nome o Favorecido
     * @param cidade Cidade
     * @param data Data formato "dd/mm/aaaa".
     * @throws ACBrECFException
     */
    public void imprimeCheque(String banco, BigDecimal valor, String favorecido, String cidade, Date data) throws ACBrECFException {
        imprimeCheque(banco, valor, favorecido, cidade, data, "");
    }

    /**
     * Cancela a impressão do cheque.
     *
     * @throws ACBrECFException
     */
    public void cancelaImpressaoCheque() throws ACBrECFException {
        ACBrECF.comandoECF("ChequePronto");
    }

    /**
     * Retorna a leitura CMC7 do cheque (Caracteres Magnéticos Codificados em 7
     * barras).<br>
     * <b>Nota:</b> Comando Disponível para modelos SwedaSTX, Sweda, Fiscnet e
     * Epson
     *
     * @throws ACBrECFException
     */
    public void leituraCMC7() throws ACBrECFException {
        ACBrECF.comandoECF("LeituraCMC7");
    }
}
