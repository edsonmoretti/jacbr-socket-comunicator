/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;

/**
 *
 * @author Edson
 */
public class ACBrETQ {

    private String comandoEtq(String s) throws ACBrECFException {
        try {
            return ACBr.getInstance().comandoAcbr("ETQ." + s);
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna “True” se a comunicação com a Impressora de etiqueta estiver
     * ativa.
     *
     * @return true se ok
     * @throws ACBrECFException
     */
    public boolean isAtivo() throws ACBrECFException {
        return comandoEtq("Ativo").toLowerCase().equals("true");
    }

    /**
     * Ativa a comunicação com a Impressora de etiqueta.
     *
     * @throws ACBrECFException
     */
    public void ativar() throws ACBrECFException {
        comandoEtq("Ativar");
    }

    /**
     * Desativa a comunicação com a Impressora de etiqueta.
     *
     * @throws ACBrECFException
     */
    public void desativar() throws ACBrECFException {
        comandoEtq("Desativar");
    }

    /**
     * Retorna Texto descritivo do Modelo da Impressora de Etiqueta que está
     * conectado.
     *
     * @return Exemplo: PPLA
     * @throws ACBrECFException
     */
    public String modeloStr() throws ACBrECFException {
        return comandoEtq("ModeloStr");
    }

    /**
     * Retorna Texto com o valor da propriedade “Modelo” de ACBrETQ.
     *
     * @return EX: etqPpla
     * @throws ACBrECFException
     */
    public String getModelo() throws ACBrECFException {
        return comandoEtq("Modelo");
    }

    /**
     * Retorna a Porta utilizada para a comunicação serial / paralela.
     *
     * @return EX: "COM4";
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public String getPorta() throws ACBrECFException {
        return comandoEtq("Porta");
    }

    /**
     * Altera a getPorta de comunicação com a impressora de etiqueta.
     *
     * @param porta Valor da getPorta, ex: COM3
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public void setPorta(String porta) throws ACBrECFException {
        comandoEtq("SetAvanco(" + porta + ")");
    }

    /**
     * Retorna a Temperatura da Impressora.
     *
     * @return EX: "10";
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public int getTemperatura() throws ACBrECFException {
        return Integer.parseInt(comandoEtq("Temperatura"));
    }

    /**
     * Altera a getTemperatura da Impressora.
     *
     * @param valor Valor da getTemperatura. ex: 15
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public void setTemperatura(int valor) throws ACBrECFException {
        comandoEtq("SetTemperatura(" + valor + ")");
    }

    /**
     * Retorna o número de avanços.
     *
     * @return EX: "0";
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public int getAvanco() throws ACBrECFException {
        return Integer.parseInt(comandoEtq("Avanco"));
    }

    /**
     * Altera o valor de avanço da Impressora.
     *
     * @param valor Valor do avanço. Ex: 3
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public void setAvanco(int valor) throws ACBrECFException {
        comandoEtq("SetAvanco(" + valor + ")");
    }

    /**
     * Prepara o texto a ser impresso na etiqueta.
     * <b>Nota:</b> É necessário chamar o comando ETQ.Imprimir para realizar a
     * impressão.<br>
     * <b>Tabela de Orientação:</b><br>
     * 0 para Normal<br>
     * 1 para 270º<br>
     * 2 para 180º<br>
     * 3 para 90º<br>
     *
     * @param orientacao Tipo de orientação do texto. Informar conforme tabela
     * de orientação.
     * @param fonte Número da fonte.
     * @param multiplicadorH Multiplicador Horizontal (Número da fonte *
     * multiplicador Horizontal).
     * @param multiplicadorV Multiplicador Vertical (Número da fonte *
     * multiplicador Vertical).
     * @param vertical Posição Inicial Vertical.
     * @param horizontal Posição Inicial Horizontal.
     * @param texto Texto a ser Impresso.
     * @throws ACBrECFException
     */
    public void imprimirTexto(int orientacao, int fonte, int multiplicadorH, int multiplicadorV, int vertical, int horizontal, String texto) throws ACBrECFException {
        imprimirTexto(orientacao, fonte, multiplicadorH, multiplicadorV, vertical, horizontal, texto, 0);
    }

    /**
     * Prepara o texto a ser impresso na etiqueta.
     * <b>Nota:</b> É necessário chamar o comando ETQ.Imprimir para realizar a
     * impressão.<br>
     * <b>Tabela de Orientação:</b><br>
     * 0 para Normal<br>
     * 1 para 270º<br>
     * 2 para 180º<br>
     * 3 para 90º<br>
     *
     * @param orientacao Tipo de orientação do texto. Informar conforme tabela
     * de orientação.
     * @param fonte Número da fonte.
     * @param multiplicadorH Multiplicador Horizontal (Número da fonte *
     * multiplicador Horizontal).
     * @param multiplicadorV Multiplicador Vertical (Número da fonte *
     * multiplicador Vertical).
     * @param vertical Posição Inicial Vertical.
     * @param horizontal Posição Inicial Horizontal.
     * @param texto Texto a ser Impresso.
     * @param subFonte Valor da Subfonte. Se omitido será considerado "0".
     * @throws ACBrECFException
     */
    public void imprimirTexto(int orientacao, int fonte, int multiplicadorH, int multiplicadorV, int vertical, int horizontal, String texto, int subFonte) throws ACBrECFException {
        comandoEtq("ImprimirTexto(" + orientacao + "," + fonte + "," + multiplicadorH + "," + multiplicadorV + "," + vertical + "," + horizontal + ",\"" + texto + "\"," + subFonte + ")");
    }

    /**
     *
     * @param orientacao
     * @param tipoBarras
     * @param larguraBarraLarga
     * @param larguraBarraFina
     * @param vertical
     * @param horizontal
     * @param texto
     * @param alturaCodBarras
     * @throws ACBrECFException
     */
    public void imprimirBarras(int orientacao, String tipoBarras, String larguraBarraLarga, String larguraBarraFina, int vertical, int horizontal, String texto, int alturaCodBarras) throws ACBrECFException {
        comandoEtq("ImprimirBarras(" + orientacao + "," + tipoBarras + "," + larguraBarraLarga + "," + larguraBarraFina + "," + vertical + "," + horizontal + "," + texto + "," + alturaCodBarras + ")");
    }

    public void imprimirLinha(int vertical, int horizontal, int largura, int altura) throws ACBrECFException {
        comandoEtq("ImprimirLinha(" + vertical + "," + horizontal + "," + largura + "," + altura + ")");
    }

    public void imprimirCaixa(int vertical, int horizontal, int largura, int altura, int espessuraVertical, int espessuraHorizontal) throws ACBrECFException {
        comandoEtq("ImprimirCaixa(" + vertical + "," + horizontal + "," + largura + "," + altura + "," + espessuraVertical + "," + espessuraHorizontal + ")");
    }

    public void imprimir(int copias, int avancoEtq) throws ACBrECFException {
        comandoEtq("Imprimir(" + copias + "," + avancoEtq + ")");
    }

    /**
     * Retorna se o flag "ETQ.LimparMemoria" está ligado ou desligado
     *
     * @return Ex: False
     * @throws ACBrECFException
     */
    public boolean isLimparMemoria() throws ACBrECFException {
        return comandoEtq("LimparMemoria").toLowerCase().equals("true");
    }

    /**
     * Atribui valor para o parâmetro Limpeza de Memória do ETQ.<br>
     * Quando verdadeiro o ACBrETQ enviará a impressora comando de Limpeza de
     * memória, antes de iniciar a Impressão. Utilizado apenas nos modelos EPL2
     * e PPLA
     *
     * @param b Informar "True" para habilitar a Limpeza de Memória antes da
     * Impressão ou "False" para desabilitar
     * @throws ACBrECFException
     */
    public void setLimparMemoria(boolean b) throws ACBrECFException {
        comandoEtq("SetLimparMemoria(" + b + ")");
    }
}
