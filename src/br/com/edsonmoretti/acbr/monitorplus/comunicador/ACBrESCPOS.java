/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrESCPOSException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;

/**
 *
 * @author Edson
 */
public class ACBrESCPOS {

    private static final String ESCPOS = "ESCPOS.";

    public static String comandoESCPOS(String s) throws ACBrESCPOSException {
        try {
            String retorno = (ACBr.getInstance().comandoAcbr(ESCPOS + s));
            return retorno;
        } catch (ACBrException ex) {
            throw new ACBrESCPOSException(ex.getMessage());
        }
    }

    /**
     * Comando para ler a porta utilizada para a comunicação.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getPorta() throws ACBrESCPOSException {
        return comandoESCPOS("porta");
    }

    /**
     * Altera a porta de comunicação com a impressora.
     * <br>NOTA: A impressora não pode estar ativa para a utilização desse
     * comando.
     *
     * @param porta
     * @throws ACBrESCPOSException
     */
    public void setPorta(String porta) throws ACBrESCPOSException {
        comandoESCPOS("setporta(\"" + porta + "\")");
    }

    /**
     * Retorna a quantidade de colunas que a impressora está configurada.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getColunas() throws ACBrESCPOSException {
        return comandoESCPOS("colunas");
    }

    /**
     * Altera a quantidade impressa de colunas na impressora.
     *
     * @param colunasFonteNormal
     * @return
     * @throws ACBrESCPOSException
     */
    public String setColunasFonteNormal(String colunasFonteNormal) throws ACBrESCPOSException {
        return comandoESCPOS("setcolunasfontenormal(\"" + colunasFonteNormal + "\"");
    }

    /**
     * Retorna a quantidade de colunas com a fonte normal.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getColunasFonteNormal() throws ACBrESCPOSException {
        return comandoESCPOS("colunasfontenormal");
    }

    /**
     * Retorna a quantidade de colunas com a letra condensada
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getColunasFonteCondensada() throws ACBrESCPOSException {
        return comandoESCPOS("colunasfontecondensada");
    }

    /**
     * Retorna quantidade de colunas com a fonte expandida.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getColunasFonteExpandida() throws ACBrESCPOSException {
        return comandoESCPOS("colunasfonteexpandida");
    }

    /**
     * Ativa a comunicação com a Impressora.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String ativar() throws ACBrESCPOSException {
        return comandoESCPOS("ativar");
    }

    /**
     * Desativa a comunicação com a Impressora.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String desativar() throws ACBrESCPOSException {
        return comandoESCPOS("desativar");
    }

    /**
     * Verifica se a comunicação com a impressora está ativada
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public boolean isAtivo() throws ACBrESCPOSException {
        return comandoESCPOS("ativo").trim().equalsIgnoreCase("true");
    }

    /**
     * Comando para imprimir linha a linha o desejado. <br><br>
     * <b>Exemplos:</b>
     * <br>
     * ESCPOS.imprimirlinha("</zera>")
     * <br>
     * ESCPOS.imprimirlinha("</linha_dupla>")
     * <br>
     * ESCPOS.imprimirlinha("TEXTO NORMAL")
     * <br>
     * ESCPOS.imprimirlinha("</fn></ce>ALINHADO NO CENTRO 1 2 3 TESTANDO")
     * <br>
     * ESCPOS.imprimirlinha("<n>FONTE NEGRITO</N>")
     * <br>
     * ESCPOS.imprimirlinha("<e>FONTE EXPANDIDA</e>")
     * <br>
     * ESCPOS.imprimirlinha("<c>FONTE CONDENSADA</e>")
     * <br>
     * ESCPOS.imprimirlinha("<in>FONTE INVERTIDA</in>")
     * <br>
     * ESCPOS.imprimirlinha("<S>FONTE SUBLINHADA</s>")
     * <br>
     * ESCPOS.imprimirlinha("<i>FONTE ITALICO</i>")
     * <br>
     * ESCPOS.imprimirlinha("</pular_linhas>")
     * <br>
     * ESCPOS.imprimirlinha("</corte_total>")
     *
     *
     * @param linha comandos em tags, que deseja imprimir.
     * @throws ACBrESCPOSException
     */
    public void imprimirLinha(String linha) throws ACBrESCPOSException {
        comandoESCPOS("imprimirlinha(\"" + linha + "\"");
    }

    /**
     * Exemplos:
     *
     * ESCPOS.imprimir("</zera></linha_dupla>FONTE NORMAL: 48
     * Colunas</lf>....+....1....+....2....+....3....+....4....+...</lf><e>EXPANDIDO:
     * 24 Colunas</lf>....+....1....+....2....</lf></e><c>CONDENSADO: 64
     * Colunas</lf>....+....1....+....2....+....3....+....4....+....5....+....6....</lf></pular_linhas></corte_total>")
     *
     * Exemplo de resposta:
     *
     * OK:
     *
     * Imprimir QRCode:
     *
     * ESCPOS.imprimir("</zera></linha_dupla></lf><qrcode>http://projetoacbr.com.br</qrcode></lf></ce><qrcode>http://www.projetoacbr.com.br/forum/index.php?/page/SAC/sobre_o_sac.html</qrcode></lf></ad><qrcode>http://www.projetoacbr.com.br/forum/index.php?/page/SAC/questoes_importantes.html</qrcode></pular_linhas></corte_total>")
     *
     * Exemplo de resposta:
     *
     * OK: Imprimir Código de Barras:
     *
     * ESCPOS.imprimir("</zera></ce></linha_dupla></lf>EAN 8:
     * 1234567</lf><ean8>1234567</ean8></pular_linhas></corte_total>")
     *
     * Exemplo de resposta:
     *
     * OK:
     *
     * @param dadosEParamentros nParametro- comandos em tags, que deseja
     * imprimir.
     *
     * @throws ACBrESCPOSException
     */
    public void imprimir(String dadosEParamentros) throws ACBrESCPOSException {
        comandoESCPOS("imprimir(\"" + dadosEParamentros + "\")");
    }

    /**
     * Imprime QRCode
     *
     * @param dados que será convertido em QRCode
     * @throws ACBrESCPOSException
     */
    public void imprimirQRCode(String dados) throws ACBrESCPOSException {
        imprimir("<qrcode>" + dados + "</qrcode>");
    }

    /**
     * Imprime Código de Barra EAN13
     *
     * @param ean13
     * @throws ACBrESCPOSException
     */
    public void imprimirEAN13(String ean13) throws ACBrESCPOSException {
        imprimir("<ean13>" + ean13 + "</ean13>");
    }
    /**
     * Imprime Código de Barra Code128
     *
     * @param code128
     * @throws ACBrESCPOSException
     */
    public void imprimirCode128(String code128) throws ACBrESCPOSException {
        imprimir("<code128>" + code128 + "</code128>");
    }

    /**
     * Imprime Código de Barra EAN8
     *
     * @param ean8
     * @throws ACBrESCPOSException
     */
    public void imprimirEAN8(String ean8) throws ACBrESCPOSException {
        imprimir("<ean8>" + ean8 + "</ean8>");
    }

    /**
     * Retorna se está configurada para corta o papel automático ou não
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public boolean isCortaPapel() throws ACBrESCPOSException {
        return comandoESCPOS("cortapapel").trim().equalsIgnoreCase("true");
    }

    /**
     * Configura para cortar o papel automáticamente ou não
     *
     * @param cortaOuNao
     * @throws ACBrESCPOSException
     */
    public void setCortaPapel(boolean cortaOuNao) throws ACBrESCPOSException {
        comandoESCPOS("SetCortaPapel(" + cortaOuNao + ")");
    }

    /**
     * Comando para imprimir os comandos sem "traduzi-los".
     *
     * @param linha o que deseja imprimir.
     * @throws ACBrESCPOSException
     */
    public void imprimirLinhaIgnorandoTags(String linha) throws ACBrESCPOSException {
        comandoESCPOS("imprimircmd(\"" + linha + "\")");
    }

    /**
     * Comando para imprimir os comandos sem "traduzi-los". Retorna as TAGS e
     * suas descrições que são aceitas.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String imprimirTags() throws ACBrESCPOSException {
        return comandoESCPOS("imprimirtags");
    }

    public void abreGaveta() throws ACBrESCPOSException {
        imprimir("</abre_gaveta>");
    }

    public void beep() throws ACBrESCPOSException {
        imprimir("</beep>");
    }

    /**
     * Retorna as informações da impressora, disponível apenas para Porta
     * Serial.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getStatusImpressora() throws ACBrESCPOSException {
        return comandoESCPOS("lerstatusimpressora");
    }

    /**
     * Retorna o Status da impressora.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getInfoImpressora() throws ACBrESCPOSException {
        return comandoESCPOS("lerinfoimpressora");
    }

    /**
     * Retorna o Modelo da impressora.
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getModelo() throws ACBrESCPOSException {
        return comandoESCPOS("modelo");
    }

    /**
     * Retorna a página de código configurada.
     *
     * Possíveis respostas:
     *
     * pcNone, pc437, pc850, pc852, pc860, pcUTF8, pc1252.
     *
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getPaginaDeCodigo() throws ACBrESCPOSException {
        return comandoESCPOS("paginadecodigo");
    }

    /**
     * Retorna a quantidade de linhas entre um cupom e outro
     *
     * @return
     * @throws ACBrESCPOSException
     */
    public String getLinhaEntreCupons() throws ACBrESCPOSException {
        return comandoESCPOS("linhasentrecupons");
    }
}
