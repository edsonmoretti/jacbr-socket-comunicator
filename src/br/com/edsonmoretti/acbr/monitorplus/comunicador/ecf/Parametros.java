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
public class Parametros {

    private final String TRUE = "TRUE";

    /**
     * Retorna modelo no formato usado no componente ACBrECF
     *
     * @return
     * @throws ACBrECFException
     */
    public String getModelo() throws ACBrECFException {
        return ACBrECF.comandoECF("ECF.Modelo");
    }

    /**
     * Retorna a porta que ECF está configurada no componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getPorta() throws ACBrECFException {
        return ACBrECF.comandoECF("Porta");
    }

    /**
     * Retorna TimeOut que o componente está configurado.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getTimeOut() throws ACBrECFException {
        return ACBrECF.comandoECF("TimeOut");
    }

    /**
     * Muda o valor do TimeOut do componente ECF.
     *
     * @param time Valor do TimeOut
     * @throws ACBrECFException
     */
    public void setTimeOut(Integer time) throws ACBrECFException {
        ACBrECF.comandoECF("SetTimeOut(" + time + ")");
    }

    /**
     * Retorna o intervalo que está configurada no componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getIntervaloAposComando() throws ACBrECFException {
        return ACBrECF.comandoECF("IntervaloAposComando");
    }

    /**
     * Retorna se aceitar Descrição Grande.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getDescricaoGrande() throws ACBrECFException {
        return ACBrECF.comandoECF("DescricaoGrande");
    }

    /**
     * Retorna se sinal da gaveta esta invertido no componente ACBrECF.
     *
     * @return true se sim, false se não
     * @throws ACBrECFException
     */
    public boolean isGavetaSinalInvertido() throws ACBrECFException {
        return ACBrECF.comandoECF("GavetaSinalInvertido").equalsIgnoreCase(TRUE);
    }

    /**
     * Retorna se ignora tags de formatação no componente ACBrECF.
     *
     * @return true se sim, false se não
     * @throws ACBrECFException
     */
    public String isIgnorarTagsFormatacao() throws ACBrECFException {
        return ACBrECF.comandoECF("IgnorarTagsFormatacao");
    }

    /**
     * Retorna o operador configurado no parâmetro do componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getOperador() throws ACBrECFException {
        return ACBrECF.comandoECF("Operador");
    }

    /**
     * Retorna a Mensagem de Aguarde configurada no componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getMsgAguarde() throws ACBrECFException {
        return ACBrECF.comandoECF("MsgAguarde");
    }

    /**
     * Retorna a Mensagem de Trabalhando configurada no componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getMsgTrabalhando() throws ACBrECFException {
        return ACBrECF.comandoECF("MsgTrabalhando");
    }

    /**
     * Retorna o tempo em segundos configurado para apresentar a mensagem de
     * pouco papel que está configurada no componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getMsgPoucoPapel() throws ACBrECFException {
        return ACBrECF.comandoECF("MsgPoucoPapel");
    }

    /**
     * Retorna se está habilitado para exibir mensagem no componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isExibeMensagem() throws ACBrECFException {
        return ACBrECF.comandoECF("ExibeMensagem").equalsIgnoreCase(TRUE);
    }

    /**
     * Retorna se o ECF realiza o arredondamento por quantidade.
     *
     * @return
     * @return @throws ACBrECFException
     */
    public boolean isArredondaPorQtd() throws ACBrECFException {
        return ACBrECF.comandoECF("ArredondaPorQtd").equalsIgnoreCase(TRUE);
    }

    /**
     * Retorna se o ECF realiza o arredondamento de itens por MFD.
     *
     * @return
     * @throws ACBrECFException
     */
    public boolean isArredondaItemMFD() throws ACBrECFException {
        return ACBrECF.comandoECF("ArredondaItemMFD").equalsIgnoreCase(TRUE);
    }

    /**
     * Atribui valor para o parâmetro de arredondamento de Item por MFD.
     *
     * @param b Informar "True" se deseja arredondar por MFD ou "False".
     * @throws ACBrECFException
     */
    public void setArredondaItemMFD(boolean b) throws ACBrECFException {
        ACBrECF.comandoECF("SetArredondaItemMFD(" + b + ")");
    }

    /**
     * Retorna se está habilitado para bloquear o mouse e o teclado no
     * componente ACBrECF.
     *
     * @param b
     * @return
     * @throws ACBrECFException
     */
    public boolean isBloqueiaMouseTeclado(boolean b) throws ACBrECFException {
        return ACBrECF.comandoECF("BloqueiaMouseTeclado").equalsIgnoreCase(TRUE);
    }

    /**
     * Retorna o número de linhas entre os cupons que está configurada no
     * componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getLinhasEntreCupons() throws ACBrECFException {
        return ACBrECF.comandoECF("LinhasEntreCupons");
    }

    /**
     * Retorna o número máximo de Linhas a ser impressa simultaneamente em
     * Relatórios Gerenciais ou Comprovantes Vinculados
     *
     * @return
     * @throws ACBrECFException
     */
    public String getMaxLinhasBuffer() throws ACBrECFException {
        return ACBrECF.comandoECF("MaxLinhasBuffer");
    }

    /**
     * Retorna a página de código que está configurada no componente ACBrECF.
     *
     * @param numLinhas
     * @throws ACBrECFException
     */
    public void setMaxLinhasBuffer(Integer numLinhas) throws ACBrECFException {
        ACBrECF.comandoECF("SetMaxLinhasBuffer(" + numLinhas + ")");
    }

    /**
     * Retorna a página de código que está configurada no componente ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public String getPaginaDeCodigo() throws ACBrECFException {
        return ACBrECF.comandoECF("PaginaDeCodigo");
    }

    /**
     * Muda o valor do TimeOut do componente ECF.
     *
     * @param valorAltura Valor da Altura
     * @param valorLargura Valor da Largura da Linha
     * @return
     * @throws ACBrECFException
     */
    public String setConfigBarras(Integer valorAltura, Integer valorLargura) throws ACBrECFException {
        return ACBrECF.comandoECF("ConfigBarras(" + valorAltura + "," + valorLargura + ")");
    }
}
