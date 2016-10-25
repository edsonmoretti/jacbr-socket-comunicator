/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrUtils;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.maparesumo.Flags;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.maparesumo.TotaisICMS;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.maparesumo.TotaisISSQN;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.maparesumo.TotalNaoFiscal;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Edson
 */
public class MapaResumo {

    private Flags flags;
    private TotaisICMS totaisICMS;
    private TotaisISSQN totaisISSQN;
    private TotalNaoFiscal totalNaoFiscal;

    public Flags getFlags() {
        return flags == null ? flags = new Flags() : flags;
    }

    public TotaisICMS getTotaisICMS() {
        return totaisICMS == null ? totaisICMS = new TotaisICMS() : totaisICMS;
    }

    public TotaisISSQN getTotaisISSQN() {
        return totaisISSQN == null ? totaisISSQN = new TotaisISSQN() : totaisISSQN;
    }

    public TotalNaoFiscal getTotalNaoFiscal() {
        return totalNaoFiscal == null ? totalNaoFiscal = new TotalNaoFiscal() : totalNaoFiscal;
    }

    public Date getDataMovimento() throws ACBrECFException {
        try {
            return ACBrUtils.strDataRedToDateBR(comandoECF("DataMovimento"));
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna dados da Redução Z
     *
     * @return Objeto ReducaoZ com os Dados da Reducao Z
     * @throws ACBrECFException
     */
    public ReducaoZ getDadosReducaoZ() throws ACBrECFException {
        return getReducaoZ("DadosReducaoZ");
    }

    /**
     * Retorna dados da Ultima Redução Z
     *
     * @return Objeto ReducaoZ com os Dados da Reducao Z
     * @throws ACBrECFException
     */
    public ReducaoZ getDadosUltimaReducaoZ() throws ACBrECFException {
        return getReducaoZ("DadosUltimaReducaoZ");
    }

    private ReducaoZ getReducaoZ(String tipo) throws ACBrECFException {
        Properties p = new Properties();
        String retorno = "";
        try {
            p.load(new ByteArrayInputStream((retorno = comandoECF(tipo)).getBytes()));
        } catch (IOException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
        try {
            ReducaoZ r = new ReducaoZ();
            //dados ecf
            r.setDataMovimento(p.getProperty("DataMovimento") == null ? new Date() : ACBrUtils.strDataRedToDateBR(p.getProperty("DataMovimento")));
            r.setNumSerie(p.getProperty("NumSerie"));
            r.setNumECF(p.getProperty("NumECF"));
            r.setNumLoja(p.getProperty("NumLoja"));
            r.setNumCOOInicial(p.getProperty("NumCOOInicial"));
            r.setNumCOO(p.getProperty("NumCOO"));
            r.setNumCRZ(p.getProperty("NumCRZ"));
            r.setNumCRO(p.getProperty("NumCRO"));

            r.setNumGNF(p.getProperty("NumGNF"));
            r.setNumCCF(p.getProperty("NumCCF"));
            r.setNumCFD(p.getProperty("NumCFD"));
            r.setNumCDC(p.getProperty("NumCDC"));
            r.setNumGRG(p.getProperty("NumGRG"));
            r.setNumNFC(p.getProperty("NumNFC"));
            r.setNumGNFC(p.getProperty("NumGNFC"));
            r.setNumCFC(p.getProperty("NumCFC"));
            r.setNumNCN(p.getProperty("NumNCN"));
            r.setNumCCDC(p.getProperty("NumCCDC"));

            //totalizadores
            r.setVendaBruta(Numeros.parseToBig(p.getProperty("VendaBruta")));
            r.setVendaLiquida(Numeros.parseToBig(p.getProperty("VendaLiquida")));
            r.setGrandeTotal(Numeros.parseToBig(p.getProperty("GrandeTotal")));
            r.setTotalDescontos(Numeros.parseToBig(p.getProperty("TotalDescontos")));
            r.setTotalCancelamentos(Numeros.parseToBig(p.getProperty("TotalCancelamentos")));
            r.setTotalAcrescimos(Numeros.parseToBig(p.getProperty("TotalAcrescimos")));
            r.setTotalNaoFiscal(Numeros.parseToBig(p.getProperty("TotalNaoFiscal")));
            r.setTotalDescontosISSQN(Numeros.parseToBig(p.getProperty("TotalDescontosISSQN")));
            r.setTotalCancelamentosISSQN(Numeros.parseToBig(p.getProperty("TotalCancelamentosISSQN")));
            r.setTotalAcrescimosISSQN(Numeros.parseToBig(p.getProperty("TotalAcrescimosISSQN")));
            r.setTotalDescontosOPNF(Numeros.parseToBig(p.getProperty("TotalDescontosOPNF")));
            r.setTotalCancelamentosOPNF(Numeros.parseToBig(p.getProperty("TotalCancelamentosOPNF")));
            r.setTotalAcrescimosOPNF(Numeros.parseToBig(p.getProperty("TotalAcrescimosOPNF")));
            r.setTotalTroco(Numeros.parseToBig(p.getProperty("TotalTroco")));

            //Outras ICMS
            r.setTotalSubstituicaoTributariaICMS(Numeros.parseToBig(p.getProperty("TotalSubstituicaoTributaria")));
            r.setTotalNaoTributadoICMS(Numeros.parseToBig(p.getProperty("TotalNaoTributado")));
            r.setTotalIsencaoICMS(Numeros.parseToBig(p.getProperty("TotalIsencao")));
            //Outras ISSQN
            r.setTotalSubstituicaoTributariaISSQN(Numeros.parseToBig(p.getProperty("TotalSubstituicaoTributariaISSQN")));
            r.setTotalNaoTributadoISSQN(Numeros.parseToBig(p.getProperty("TotalNaoTributadoISSQN")));
            r.setTotalIsencaoISSQN(Numeros.parseToBig(p.getProperty("TotalIsencaoISSQN")));
            //Nao Fiscal
            r.setTotalSangria(Numeros.parseToBig(p.getProperty("SA_Sangria")));
            r.setTotalSuprimento(Numeros.parseToBig(p.getProperty("SU_Suprimento")));
            //Aliquotas
            retorno = retorno.substring(retorno.indexOf("[Aliquotas]") + "[Aliquotas]".length(), retorno.indexOf("[OutrasICMS]")).trim().replace("\n", "=");
            String ret[] = retorno.split("=");
            HashMap<String, BigDecimal> h = new HashMap<>();
            for (int i = 0;
                    i < ret.length;) {
                h.put(ret[i++].trim(), Numeros.parseToBig(ret[i++]));
            }
            r.setTotaisAliquotas(h);
            return r;
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna o número de reduções Z restantes.
     *
     * @return int com numero de reducao z restante. EX: 1834
     * @throws ACBrECFException
     */
    public int getNumReducoesZRestantes() throws ACBrECFException {
        return Integer.parseInt(comandoECF("NumReducoesZRestantes"));
    }

    /**
     * Retorna numero do COO (Contador de Ordem de Operação).
     *
     * @return String getcom numero COO ex: 002435
     * @throws ACBrECFException
     */
    public String getNumCOO() throws ACBrECFException {
        return comandoECF("NumCOO");
    }

    /**
     * Retorna número do CRZ (Contador de Reduções Z).
     *
     * @return String getcom numero CRZ ex: 00001
     * @throws ACBrECFException
     */
    public String getNumCRZ() throws ACBrECFException {
        return comandoECF("NumCRZ");
    }

    /**
     * Retorna número do CRO (Contador de Reinicio de Operações (Intervenções)
     * ).
     *
     * @return String getcom numero CRO ex: 001
     * @throws ACBrECFException
     */
    public String getNumCRO() throws ACBrECFException {
        return comandoECF("NumCRO");
    }

    /**
     * Retorna número do CCF (Contador de Cupom Fiscal).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String getcom numero CCF ex: 000010
     * @throws ACBrECFException
     */
    public String getNumCCF() throws ACBrECFException {
        return comandoECF("NumCCF");
    }

    /**
     * Retorna Numero COO Inicial.
     *
     * @return String getcom num COO Inicial. EX: 2434
     * @throws ACBrECFException
     */
    public String getNumCOOInicial() throws ACBrECFException {
        return comandoECF("NumCOOInicial");
    }

    /**
     * Retorna número do GNF (Geral de Operação Não-Fiscal)
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String getcom numero GNF. EX: 000017
     * @throws ACBrECFException
     */
    public String getNumGNF() throws ACBrECFException {
        return comandoECF("NumGNF");
    }

    /**
     * Retorna número do GNF (Contador Geral de Operação Não-Fiscal)
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String getcom numGNFC. EX: 000000
     * @throws ACBrECFException
     */
    public String getNumGNFC() throws ACBrECFException {
        return comandoECF("NumGNFC");
    }

    /**
     * Retorna número do GRG (Contador Geral de Relatório Gerencial).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String getcom numero GRG
     * @throws ACBrECFException
     */
    public String getNumGRG() throws ACBrECFException {
        return comandoECF("NumGRG");
    }

    /**
     * Retorna número do CDC (Comprovante de Credito ou Débito).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String getcom numero CDC
     * @throws ACBrECFException
     */
    public String getNumCDC() throws ACBrECFException {
        return comandoECF("NumCDC");
    }

    /**
     * Retorna número do contador de Cupom Fiscal Cancelado.
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String getcom numCFC. EX: 0002
     * @throws ACBrECFException
     */
    public String getNumCFC() throws ACBrECFException {
        return comandoECF("NumCFC");
    }

    /**
     * Retorna número do CCDC (Contador Comprovante de Credito ou Débito).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String getcom num CCDC.EX: 000000
     * @throws ACBrECFException
     */
    public String getNumCCDC() throws ACBrECFException {
        return comandoECF("NumCCDC");
    }

    /**
     * Retorna número do CFD (Contador de Fita Detalhe).
     *
     * @return String getcom numCFD. EX: 000000
     * @throws ACBrECFException
     */
    public String getNumCFD() throws ACBrECFException {
        return comandoECF("NumCFD");
    }

    /**
     * Retorna número do NCN (Número de Comprovantes de Crédito ou Débito Não
     * Emitidos).
     *
     * @return Sting com numero NCN.EX: 0010.
     * @throws ACBrECFException
     */
    public String getNumNCN() throws ACBrECFException {
        return comandoECF("NumNCN");
    }

    /**
     * Retorna o valor da Venda Bruta .
     *
     * @return @throws ACBrECFException
     */
    public BigDecimal getVendaBruta() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("VendaBruta"));
    }

    /**
     * Retorna o Valor do Grande Total .
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal getGrandeTotal() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("GrandeTotal"));
    }

    /**
     * Retorna o MD5 do Valor do Grande Total .
     *
     * @return
     * @throws ACBrECFException
     */
    public String getGrandeTotalMD5() throws ACBrECFException {
        try {
            return ACBrUtils.MD5(Numeros.parseToBig(comandoECF("GrandeTotal")).toString());
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna o Valor Total do Troco.
     *
     * @return @throws ACBrECFException
     */
    public BigDecimal getTotalTroco() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalTroco"));
    }

}
