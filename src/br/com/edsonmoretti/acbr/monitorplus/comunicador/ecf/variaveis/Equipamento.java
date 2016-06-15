/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.Estado;
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrUtils;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edson
 */
public class Equipamento {

    /**
     * Retorna o getEstado atual do ECF<br>
     * Tipo de getEstado de retorno:
     * <br><br>
     * <b>estNaoInicializada</b>, Porta Serial ainda não foi aberta;
     *
     * <br><br>
     * <b>estDesconhecido</b>, Porta aberta, mas getEstado ainda não definido;
     *
     * <br><br>
     * <b>estLivre</b>, Impressora Livre, sem nenhum cupom aberto pronta para
     * nova venda, Redução Z e Leitura X ok, pode ou não já ter ocorrido 1ª
     * venda no dia...;
     *
     * <br><br>
     * <b>estVenda</b>, Cupom de Venda Aberto com ou sem venda do 1º Item;
     *
     * <br><br>
     * <b>estPagamento</b>, Iniciado Fechamento de Cupom com Formas Pagamento
     * pode ou não ter efetuado o 1º pagamento. Não pode mais vender itens, ou
     * alterar Sub-contadorDoDia;
     *
     * <br><br>
     * <b>estRelatorio</b>, Imprimindo Cupom Fiscal Vinculado ou Relatório
     * Gerencial;
     *
     * <br><br>
     * <b>estBloqueada</b>, Redução Z já emitida, bloqueada até as 00:00;
     *
     * <br><br>
     * <b>estRequerZ</b>, Redução Z do dia anterior ainda não foi emitida.
     * Emitir agora;
     *
     * <br><br>
     * <b>estRequerX</b>, Esta impressora requer Leitura X todo inicio de dia. É
     * necessário imprimir uma Leitura X para poder vender
     * <br><br>
     *
     * @return ENUM com estados, podenco ser acessado:
     * <b>ACBrECF.Estado</b>.
     * @throws ACBrECFException
     */
    public Estado getEstado() throws ACBrECFException {
        switch (comandoECF("Estado")) {
            case "estNaoInicializada":
                return Estado.estNaoInicializada;
            case "estDesconhecido":
                return Estado.estDesconhecido;
            case "estLivre":
                return Estado.estLivre;
            case "estVenda":
                return Estado.estVenda;
            case "estPagamento":
                return Estado.estPagamento;
            case "estRelatorio":
                return Estado.estRelatorio;
            case "estBloqueada":
                return Estado.estBloqueada;
            case "estRequerZ":
                return Estado.estRequerZ;
            case "estRequerX":
                return Estado.estRequerX;
            case "estNaoFiscal":
                return Estado.estNaoFiscal;
            default:
                throw new ACBrECFException("Estado desconhecido.");
        }
    }

    /**
     * Retorna a data e hora do ECF.
     *
     * @return Date com data e hora do ECF
     * @throws ACBrECFException
     */
    public Date getDataHora() throws ACBrECFException {
        try {
            return ACBrUtils.strDataEHoraToDateBR(comandoECF("DataHora"));
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna Modelo STR do ECF.
     *
     * @return String com marca EX: Daruma
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public String getMarcaStr() throws ACBrECFException {
        return getModeloStr();
    }

    /**
     * Retorna Modelo STR do ECF.
     *
     * @return String com marca EX: Daruma
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public String getModeloStr() throws ACBrECFException {
        return comandoECF("ModeloStr");
    }

    /**
     * Retorna Submodelo do ECF (Informações mais específicas sobre o Modelo).
     *
     * @return String com modelo ex: FS-700
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public String getSubModeloECF() throws ACBrECFException {
        return comandoECF("SubModeloECF");
    }

    /**
     * Retorna o Número do ECF.
     *
     * @return String com numero do ECF. EX: 001
     * @throws ACBrECFException
     */
    public String getNumECF() throws ACBrECFException {
        return comandoECF("NumECF");
    }

    /**
     * Retorna o Número da Loja.
     *
     * @return String com numero da loja ex: 001
     * @throws ACBrECFException
     */
    public String getNumLoja() throws ACBrECFException {
        return comandoECF("NumLoja");
    }

    /**
     * Retorna o Número de Série do ECF.
     *
     * @return String com numero serie. <br>EX: DR0208BR000000000000
     * @throws ACBrECFException
     */
    public String getNumSerie() throws ACBrECFException {
        return comandoECF("NumSerie");
    }

    /**
     * Retorna o MD5 do Número de Série do ECF.
     *
     * @return String com numero serie. <br>EX: fb76c603070c7dd8c502a0c36a5465cc
     * @throws ACBrECFException
     */
    public String getNumSerieEmMD5() throws ACBrECFException {
        try {
            return ACBrUtils.MD5(getNumSerie());
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna o Número de Série MFD.
     *
     * @return String com a serie da MFD. EX: MFDSW00000000001
     * @throws ACBrECFException
     */
    public String getNumSerieMFD() throws ACBrECFException {
        return comandoECF("NumSerieMFD");
    }

    /**
     * Retorna o Número da versão do software do ECF.
     *
     * @return String com numero da versao. EX: 01.00.01
     * @throws ACBrECFException
     */
    public String getNumVersao() throws ACBrECFException {
        return comandoECF("NumVersao");
    }

    /**
     * Retorna o CNPJ cadastrado no ECF.
     *
     * @return String com getCnpj. EX: 10.493.367/0001-48
     * @throws ACBrECFException
     */
    public String getCnpj() throws ACBrECFException {
        return comandoECF("CNPJ");
    }

    /**
     * Retorna a Inscrição Estadual cadastrada no ECF.
     *
     * @return String com IE na impressora. EX: 687.138.770
     * @throws ACBrECFException
     */
    public String getIe() throws ACBrECFException {
        return comandoECF("IE");
    }

    /**
     * Retorna a Inscrição Municipal cadastrada no ECF.
     *
     * @return String com IM do ECF: 21098765432
     * @throws ACBrECFException
     */
    public String getIm() throws ACBrECFException {
        return comandoECF("IM");
    }

    /**
     * Retorna informações PAF como número de MD5, nome e versão do aplicativo
     * fiscal.
     * <br><br><b>NOTA: Não está disponível em todos os ECFs
     * </b><br><br>
     *
     * @return String com Dados: ex: MD-5:22C5D38B8C715038C66FF34F459072F5 DJPDV
     * 1.2.1
     * @throws ACBrECFException
     */
    public String getPaf() throws ACBrECFException {
        return comandoECF("PAF");
    }

    /**
     * Retorna o número do usuário atual do ECF.
     *
     * @return String com numero do usuario do ecf. EX: 01
     * @throws ACBrECFException
     */
    public String getUsuarioAtual() throws ACBrECFException {
        return comandoECF("UsuarioAtual");
    }

    /**
     * Retorna as linhas do getCliche do proprietário cadastrado no ECF
     * (Cabeçalho).
     *
     * @return String com Cabeçalho do ECF. EX:<br>
     * GERALDO JOAO DA SILVA ME Rua Alferes Jorge, 176 Indianopolis 55024-130
     * Caruaru-PE.
     * @throws ACBrECFException
     */
    public String getCliche() throws ACBrECFException {
        return comandoECF("Cliche");
    }

    /**
     * Retorna a data e hora da Gravação do Software Básico do ECF.
     * <br><br><b>NOTA: Não está disponível em todos os ECFs
     * </b><br><br>
     *
     * @return Um Date com data hora do SB do ECF. EX: 07/12/12 08:59:36
     * @throws ACBrECFException
     */
    public Date getDataHoraSwBasico() throws ACBrECFException {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/YY HH:mm:ss");
        try {
            return s.parse(comandoECF("DataHoraSB"));
        } catch (ParseException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna a quantidade de casas decimais para a Quantidade.
     *
     * @return int com a quantidade de casas decimais. EX: 3
     * @throws ACBrECFException
     */
    public int getDecimaisQtd() throws ACBrECFException {
        return Integer.parseInt(comandoECF("DecimaisQtd"));
    }

    /**
     * Retorna a quantidade de casas decimais para o Preço.
     *
     * @return int com a quantidade de casas decimais. EX: 3
     * @throws ACBrECFException
     */
    public int getDecimaisPreco() throws ACBrECFException {
        return Integer.parseInt(comandoECF("DecimaisPreco"));
    }

    /**
     * Retorna número de getColunas do ECF.
     *
     * @return ex: 48
     * @throws ACBrECFException
     */
    public String getColunas() throws ACBrECFException {
        return comandoECF("Colunas");
    }

    /**
     * Retorna se a ECF tem MF adicional. Geralmente as ECF identificam se ECF
     * possui MF adicional através no Nº de Série e ao final a letra indicativa.
     * Se não existe retornará OK.
     *
     * @return Exemplo de MF Adicional: DR0105BR000000054098<b>A</b><br>
     * Exemplo sem a MF Adicional: DR0105BR000000054098
     * @throws ACBrECFException
     */
    public String getMfAdicional() throws ACBrECFException {
        return comandoECF("MFAdicional");
    }

    /**
     * Retorna Registro de Fita Detalhe.
     *
     * @return String com registro de fita detalhe. EX: DR
     * @throws ACBrECFException
     */
    public String getRfdid() throws ACBrECFException {
        return comandoECF("RFDID");
    }

    /**
     * Retorna Registro de Fita Detalhe.
     *
     * @return String com registro de fita detalhe. EX: DR
     * @throws ACBrECFException
     */
    public String getRegistroFitaDetalhe() throws ACBrECFException {
        return getRfdid();
    }
}
