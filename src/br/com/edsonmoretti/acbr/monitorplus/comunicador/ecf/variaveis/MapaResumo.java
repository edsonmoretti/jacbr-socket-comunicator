/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.TipoDocumento;
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Edson
 */
public class MapaResumo {

    private Flags flags;

    public Flags getFlags() {
        return flags == null ? flags = new Flags() : flags;
    }

    public Date dataMovimento() throws ACBrECFException {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/YY");
        try {
            return s.parse(comandoECF("DataMovimento"));
        } catch (ParseException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna dados da Redução Z
     *
     * @return Objeto ReducaoZ com os Dados da Reducao Z
     * @throws ACBrECFException
     */
    public ReducaoZ dadosReducaoZ() throws ACBrECFException {
        return reducaoZ("DadosReducaoZ");
    }

    /**
     * Retorna dados da Ultima Redução Z
     *
     * @return Objeto ReducaoZ com os Dados da Reducao Z
     * @throws ACBrECFException
     */
    public ReducaoZ dadosUltimaReducaoZ() throws ACBrECFException {
        return reducaoZ("DadosUltimaReducaoZ");
    }

    private ReducaoZ reducaoZ(String tipo) throws ACBrECFException {
        Properties p = new Properties();
        String retorno = "";
        try {
            p.load(new ByteArrayInputStream((retorno = comandoECF(tipo)).getBytes()));
        } catch (IOException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/YY");
        try {
            ReducaoZ r = new ReducaoZ();
            //dados ecf
            r.setDataMovimento(s.parse(p.getProperty("DataMovimento")));
            r.setNumSerie(p.getProperty("NumSerie"));
            r.setNumECF(p.getProperty("NumECF"));
            r.setNumLoja(p.getProperty("NumLoja"));
            r.setNumCOOInicial(p.getProperty("NumCOOInicial"));
            r.setNumCOO(p.getProperty("NumCOO"));
            r.setNumCRZ(p.getProperty("NumCRZ"));
            r.setNumCRO(p.getProperty("NumCRO"));
            //totalizadores
            r.setVendaBruta(Numeros.parseToBig(p.getProperty("VendaBruta")));
            r.setGrandeTotal(Numeros.parseToBig(p.getProperty("GrandeTotal")));
            r.setTotalDescontos(Numeros.parseToBig(p.getProperty("TotalDescontos")));
            r.setTotalCancelamentos(Numeros.parseToBig(p.getProperty("TotalCancelamentos")));
            r.setTotalAcrescimos(Numeros.parseToBig(p.getProperty("TotalAcrescimos")));
            r.setTotalNaoFiscal(Numeros.parseToBig(p.getProperty("TotalNaoFiscal")));
            //Outras ICMS
            r.setTotalSubstituicaoTributaria(Numeros.parseToBig(p.getProperty("TotalSubstituicaoTributaria")));
            r.setTotalNaoTributado(Numeros.parseToBig(p.getProperty("TotalNaoTributado")));
            r.setTotalIsencao(Numeros.parseToBig(p.getProperty("TotalIsencao")));
            //Nao Fiscal
            r.setTotalSangria(Numeros.parseToBig(p.getProperty("SA_Sangria")));
            r.setTotalSuprimento(Numeros.parseToBig(p.getProperty("SU_Suprimento")));
            //Aliquotas
            retorno = retorno.substring(retorno.indexOf("[Aliquotas]") + "[Aliquotas]".length(), retorno.indexOf("[OutrasICMS]")).trim().replace("\n", "=");
            String ret[] = retorno.split("=");
            HashMap<String, BigDecimal> h = new HashMap<>();
            for (int i = 0; i < ret.length;) {
                h.put(ret[i++].trim(), Numeros.parseToBig(ret[i++]));
            }
            r.setTotaisAliquotas(h);
            return r;
        } catch (ParseException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    /**
     * Retorna o número de reduções Z restantes.
     *
     * @return int com numero de reducao z restante. EX: 1834
     * @throws ACBrECFException
     */
    public int numReducoesZRestantes() throws ACBrECFException {
        return Integer.parseInt(comandoECF("NumReducoesZRestantes"));
    }

    /**
     * Retorna numero do COO (Contador de Ordem de Operação).
     *
     * @return String com numero COO ex: 002435
     * @throws ACBrECFException
     */
    public String numCOO() throws ACBrECFException {
        return comandoECF("NumCOO");
    }

    /**
     * Retorna número do CRZ (Contador de Reduções Z).
     *
     * @return String com numero CRZ ex: 00001
     * @throws ACBrECFException
     */
    public String numCRZ() throws ACBrECFException {
        return comandoECF("NumCRZ");
    }

    /**
     * Retorna número do CRO (Contador de Reinicio de Operações (Intervenções)
     * ).
     *
     * @return String com numero CRO ex: 001
     * @throws ACBrECFException
     */
    public String numCRO() throws ACBrECFException {
        return comandoECF("NumCRO");
    }

    /**
     * Retorna número do CCF (Contador de Cupom Fiscal).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String com numero CCF ex: 000010
     * @throws ACBrECFException
     */
    public String numCCF() throws ACBrECFException {
        return comandoECF("NumCCF");
    }

    /**
     * Retorna Numero COO Inicial.
     *
     * @return String com num COO Inicial. EX: 2434
     * @throws ACBrECFException
     */
    public String numCOOInicial() throws ACBrECFException {
        return comandoECF("NumCOOInicial");
    }

    /**
     * Retorna número do GNF (Geral de Operação Não-Fiscal)
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String com numero GNF. EX: 000017
     * @throws ACBrECFException
     */
    public String numGNF() throws ACBrECFException {
        return comandoECF("NumGNF");
    }

    /**
     * Retorna número do GNF (Contador Geral de Operação Não-Fiscal)
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String com numGNFC. EX: 000000
     * @throws ACBrECFException
     */
    public String numGNFC() throws ACBrECFException {
        return comandoECF("NumGNFC");
    }

    /**
     * Retorna número do GRG (Contador Geral de Relatório Gerencial).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String com numero GRG
     * @throws ACBrECFException
     */
    public String numGRG() throws ACBrECFException {
        return comandoECF("NumGRG");
    }

    /**
     * Retorna número do CDC (Comprovante de Credito ou Débito).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String com numero CDC
     * @throws ACBrECFException
     */
    public String numCDC() throws ACBrECFException {
        return comandoECF("NumCDC");
    }

    /**
     * Retorna número do contador de Cupom Fiscal Cancelado.
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String com numCFC. EX: 0002
     * @throws ACBrECFException
     */
    public String numCFC() throws ACBrECFException {
        return comandoECF("NumCFC");
    }

    /**
     * Retorna número do CCDC (Contador Comprovante de Credito ou Débito).
     * <br><b>NOTA: Não está disponível em todos os ECFs</b>
     *
     * @return String com num CCDC.EX: 000000
     * @throws ACBrECFException
     */
    public String numCCDC() throws ACBrECFException {
        return comandoECF("NumCCDC");
    }

    /**
     * Retorna número do CFD (Contador de Fita Detalhe).
     *
     * @return String com numCFD. EX: 000000
     * @throws ACBrECFException
     */
    public String numCFD() throws ACBrECFException {
        return comandoECF("NumCFD");
    }

    /**
     * Retorna número do NCN (Número de Comprovantes de Crédito ou Débito Não
     * Emitidos).
     *
     * @return Sting com numero NCN.EX: 0010.
     * @throws ACBrECFException
     */
    public String numNCN() throws ACBrECFException {
        return comandoECF("NumNCN");
    }

    /**
     * Retorna o valor da Venda Bruta .
     *
     * @return @throws ACBrECFException
     */
    public BigDecimal vendaBruta() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("VendaBruta"));
    }

    /**
     * Retorna o Valor do Grande Total .
     *
     * @return
     * @throws ACBrECFException
     */
    public BigDecimal grandeTotal() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("GrandeTotal"));
    }

    /**
     * Retorna o Valor Total do Troco.
     *
     * @return @throws ACBrECFException
     */
    public BigDecimal totalTroco() throws ACBrECFException {
        return Numeros.parseToBig(comandoECF("TotalTroco"));
    }

    public class Flags {

        /**
         * Retorna o tipo do último documento emitido pelo ECF.
         * <b>Nota:</b> Comando disponível apenas para Epson e FiscNet, os
         * demais modelos de ECF irá retornar "docNenhum".<br><br>
         * <b>Tipo de documento:</b> <br>
         * <b>docRZ</b> - Redução Z; <br>
         * <b>docLX</b> - Leitura X; <br>
         * <b>docCF</b> - Cupom Fiscal; <br>
         * <b>docCFBP</b> - Cupom Fiscal Bilhete de Passagem; <br>
         * <b>docCupomAdicional</b> - Cupom Adicional; <br>
         * <b>docCFCancelamento</b> - Cancelamento Cupom Fiscal; <br>
         * <b>docCCD</b> - Comprovante de Crédito ou Débito; <br>
         * <b>docAdicionalCCD</b> - Adicional de Comprovante de Crédito ou
         * Débito; <br>
         * <b>docSegViaCCD</b> - Segunda Via de Comprovante de Crédito ou
         * Débito; <br>
         * <b>docReimpressaoCCD</b> - Reimpressão de Comprovante de Crédito ou
         * Débito;
         * <br>
         * <b>docEstornoCCD</b> - Estorno de Comprovante de Crédito ou Débito;
         * <br>
         * <b>docCNF</b> - Comprovante Não Fiscal; <br>
         * <b>docCNFCancelamento</b> - Cancelamento Comprovante Não Fiscal;
         * <br>
         * <b>docSangria</b> - Sangria; <br>
         * <b>docSuprimento</b> - Suprimento; <br>
         * <b>docEstornoPagto</b> - Estorno Pagamento; <br>
         * <b>docRG</b> - Relatório Gerencial; <br>
         * <b>docLMF</b> - Leitura da Memória Fiscal; <br>
         * <b>docTodos</b> - Todos; <br>
         * <b>docNenhum</b> - Nenhum documento; <br>
         *
         * @return Tipo de Documento
         * @throws ACBrECFException
         */
        public TipoDocumento tipoUltimoDocumento() throws ACBrECFException {
            switch (comandoECF("TipoUltimoDocumento")) {
                case "docRZ":
                    return TipoDocumento.docRZ;
                case "docLX":
                    return TipoDocumento.docLX;
                case "docCF":
                    return TipoDocumento.docCF;
                case "docCFBP":
                    return TipoDocumento.docCFBP;
                case "docCupomAdicional":
                    return TipoDocumento.docCupomAdicional;
                case "docCFCancelamento":
                    return TipoDocumento.docCFCancelamento;
                case "docCCD":
                    return TipoDocumento.docCCD;
                case "docAdicionalCCD":
                    return TipoDocumento.docAdicionalCCD;
                case "docSegViaCCD":
                    return TipoDocumento.docSegViaCCD;
                case "docReimpressaoCCD":
                    return TipoDocumento.docReimpressaoCCD;
                case "docEstornoCCD":
                    return TipoDocumento.docEstornoCCD;
                case "docCNF":
                    return TipoDocumento.docCNF;
                case "docCNFCancelamento":
                    return TipoDocumento.docCNFCancelamento;
                case "docSangria":
                    return TipoDocumento.docSangria;
                case "docSuprimento":
                    return TipoDocumento.docSuprimento;
                case "docEstornoPagto":
                    return TipoDocumento.docEstornoPagto;
                case "docLMF":
                    return TipoDocumento.docLMF;
                case "docRG":
                    return TipoDocumento.docRG;
                case "docTodos":
                    return TipoDocumento.docTodos;
                case "docNenhum":
                    return TipoDocumento.docNenhum;
                default:
                    throw new ACBrECFException("Tipo de Documento não reconhecido.");
            }
        }

        /**
         * Retorna se o ECF está com pouco papel.
         *
         * @return
         * @throws ACBrECFException
         */
        public boolean isPoucoPapel() throws ACBrECFException {
            return comandoECF("PoucoPapel").equalsIgnoreCase("true");
        }

        /**
         * Retorna se o ECF está em Horário de Verão.
         * <b>Nota:</b> Isso também pode ser constatado observando a letra “V”
         * ao lado da Hora no rodapé do Cupom Fiscal - Exemplo: 10:16:32V
         *
         * @return
         * @throws ACBrECFException
         */
        public boolean isHorarioVerao() throws ACBrECFException {
            return comandoECF("HorarioVerao").equalsIgnoreCase("true");
        }

        /**
         * Retorna se o ECF arredonda os valores do "Total por Item" durante a
         * Venda.<br>
         * <br>Exemplo: Qtd 1 x Preço Unit. 1,207 = 1,21 com Arredondamento no
         * ECF
         * <br>= 1,20 sem Arredondamento no ECF.<br>
         * <br>
         * <b>Nota: </b>
         * Na maioria dos ECFs o Arredondamento deve ser programado, o que pode
         * ser feito com o comando ECF.MudaArredondamento
         * <br>
         * Em alguns ECFs o arredondamento é definido de acordo com o comando
         * enviado para a Venda de Item, nesse caso, o ACBr procura usar o
         * Arredondamento sempre que possível.
         * <br>
         * Após o convênio do ICMS 56/94 o arredondamento não é mais permitido,
         * portanto todos os novos ECFs apenas Truncam o Total por Item.
         *
         * @return
         * @throws ACBrECFException
         */
        public boolean isArredonda() throws ACBrECFException {
            return comandoECF("Arredonda").equalsIgnoreCase("true");
        }

        /**
         * Retorna se a ECF tem MFD( Memória Fita Detalhe).
         *
         * @return
         * @throws ACBrECFException
         */
        public boolean isMFD() throws ACBrECFException {
            return comandoECF("MFD").equalsIgnoreCase("true");
        }

        /**
         * Retorna se a ECF possui impressão Térmica.
         *
         * @return @throws ACBrECFException
         */
        public boolean isTermica() throws ACBrECFException {
            return comandoECF("Termica").equalsIgnoreCase("true");
        }

        /**
         * Retorna se a ECF Identifica Consumidor no rodapé do cupom.
         *
         * @return
         * @throws ACBrECFException
         */
        public boolean isIdentificaConsumidorRodape() throws ACBrECFException {
            return comandoECF("IdentificaConsumidorRodape").equalsIgnoreCase("true");
        }

        /**
         * Retorna se ECF permite desconto em ISSQN.
         *
         * @return
         * @throws ACBrECFException
         */
        public boolean isParamDescontoISSQN() throws ACBrECFException {
            return comandoECF("ParamDescontoISSQN").equalsIgnoreCase("true");
        }
    }

    public class TotalNaoFiscal {

        /**
         * Retorna Valor Total de Comprovantes Não Fiscal.
         *
         * @return BigDecimal ex: 60
         * @throws ACBrECFException
         */
        public BigDecimal TotalNaoFiscal() throws ACBrECFException {
            return Numeros.parseToBig(comandoECF("TotalNaoFiscal"));
        }

        /**
         * Retorna Total de Cancelamentos Operações Não Fiscal.
         *
         * @throws ACBrECFException
         */
        public BigDecimal TotalCancelamentosOPNF() throws ACBrECFException {
            return Numeros.parseToBig(comandoECF("TotalCancelamentosOPNF"));
        }

        /**
         * Retorna Total de Descontos de Operações Não Fiscais
         *
         * @return BigDecimal ex: 60
         * @throws ACBrECFException
         */
        public BigDecimal TotalDescontosOPNF() throws ACBrECFException {
            return Numeros.parseToBig(comandoECF("TotalDescontosOPNF"));
        }

        /**
         * Retorno Total de Acréscimos de Operações Não Fiscais.
         *
         * @return BigDecimal ex: 60
         * @throws ACBrECFException
         */
        public BigDecimal TotalAcrescimosOPNF() throws ACBrECFException {
            return Numeros.parseToBig(comandoECF("TotalAcrescimosOPNF"));
        }
    }

    public class TotaisISSQN {

        public BigDecimal totalCancelamentosISSQN() throws ACBrECFException {
            return Numeros.parseToBig(comandoECF("TotalCancelamentosISSQN"));
        }
    }
}
