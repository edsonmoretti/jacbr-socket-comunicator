/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.relatorios;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;

/**
 *
 * @author Edson
 */
public class RelatorioGerencial {

    /**
     * Emite o Relatório Gerencial referente ao índice informado no parâmetro. A
     * emissão é automaticamente encerrada 2 minutos após abertura (Tempo máximo
     * de emissão).
     *
     *
     * @throws ACBrECFException
     */
    public void abreRelatorioGerencial() throws ACBrECFException {
        ACBrECF.comandoECF("AbreRelatorioGerencial");
    }

    /**
     * Emite o Relatório Gerencial referente ao índice informado no parâmetro. A
     * emissão é automaticamente encerrada 2 minutos após abertura (Tempo máximo
     * de emissão).
     *
     *
     * @param indice Indice do relatorio gerencial a ser impresso. Parâmetro
     * pode ser omitido e será considerado o indice padrão de cada modelo de
     * ECF.
     *
     * @throws ACBrECFException
     */
    public void abreRelatorioGerencial(int indice) throws ACBrECFException {
        ACBrECF.comandoECF("AbreRelatorioGerencial(" + indice + ")");
    }

    /**
     * Emite o Relatório Gerencial referente ao índice informado no parâmetro. A
     * emissão é automaticamente encerrada 2 minutos após abertura (Tempo máximo
     * de emissão).
     *
     *
     * @param indice Indice do relatorio gerencial a ser impresso. Parâmetro
     * pode ser omitido e será considerado o indice padrão de cada modelo de
     * ECF.
     *
     * @throws ACBrECFException
     */
    public void abreRelatorioGerencial(String indice) throws ACBrECFException {
        ACBrECF.comandoECF("AbreRelatorioGerencial(" + indice + ")");
    }

    /**
     * Emite Relatório Gerencial padrão contendo o texto e quantidade de vias
     * informado nos parâmetros.
     *
     * @param txtRelatorio Texto que será impresso no corpo do relatório
     * gerencial.(Para imprimir várias linhas separar o texto com pipe "|" ).
     * @param nVias Quantidade de vias a ser impressa.
     *
     * @throws ACBrECFException
     */
    public void relatorioGerencial(String txtRelatorio, int nVias) throws ACBrECFException {
        ACBrECF.comandoECF("RelatorioGerencial(" + txtRelatorio + "," + nVias + ")");
    }

    /**
     * Emite Relatório Gerencial padrão contendo o texto e quantidade de vias
     * informado nos parâmetros.
     *
     * @param txtRelatorio Texto que será impresso no corpo do relatório
     * gerencial.(Para imprimir várias linhas separar o texto com pipe "|" ).
     * @throws ACBrECFException
     */
    public void relatorioGerencial(String txtRelatorio) throws ACBrECFException {
        relatorioGerencial(txtRelatorio, 1);
    }

    /**
     * Imprimi no final do cupom vinculado o texto informado no parâmetro.<br>
     * <b>Nota: </b>A impressão só é realizada com o relatório gerencial em
     * estado aberto, portanto depende do comando ECF.AbreRelatorioGerencial ser
     * executado primeiro.
     *
     * @param linha Texto a ser impresso no final do relatório gerencial. (Para
     * imprimir várias linhas separar o texto com pipe "|" ).
     * @throws ACBrECFException
     */
    public void linhaRelatorioGerencial(String linha) throws ACBrECFException {
        ACBrECF.comandoECF("LinhaRelatorioGerencial(" + linha + ")");
    }
}
