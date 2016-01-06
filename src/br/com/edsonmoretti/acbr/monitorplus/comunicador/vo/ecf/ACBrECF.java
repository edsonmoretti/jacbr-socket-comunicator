/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.vo.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBr;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Edson
 */
public class ACBrECF {

    public enum Estado {
        estNaoInicializada, estDesconhecido, estLivre, estVenda, estPagamento, estRelatorio, estBloqueada, estRequerZ, estRequerX;
    }
    private Variaveis variaveis;

    /**
     *
     * @return Retorna True para ECF ativo e False para ECF desativado
     *
     * @throws ACBrECFException
     */
    public boolean ativo() throws ACBrECFException {
        return comandoECF("Ativo").toLowerCase().equals("true");
    }

    /**
     * Este procedimento ativa a ECF.
     *
     * @throws ACBrECFException
     */
    public void ativar() throws ACBrECFException {
        comandoECF("Ativar");
    }

    /**
     * Este procedimento Desativa a ECF.
     *
     * @throws ACBrECFException
     */
    public void Desativar() throws ACBrECFException {
        comandoECF("Desativar");
    }

    private String comandoECF(String s) throws ACBrECFException {
        try {
            return ACBr.getInstance().comandoAcbr("ECF." + s);
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    public Variaveis getVariaveis() {
        return variaveis == null ? variaveis = new Variaveis() : variaveis;
    }

    public class Variaveis {

        private Equipamento equipamento;
        private MapaResumo mapaResumo;
        private Aliquotas aliquotas;
        private FormasDePagamento formasDePagamento;
        private ComprovantesNaoFiscais comprovantesNaoFiscais;
        private RelatoriosGerenciais relatoriosGerenciais;

        public Equipamento getEquipamento() {
            return equipamento == null ? equipamento = new Equipamento() : equipamento;
        }

        public MapaResumo getMapaResumo() {
            return mapaResumo == null ? mapaResumo = new MapaResumo() : mapaResumo;
        }

        public Aliquotas getAliquotas() {
            return aliquotas == null ? aliquotas = new Aliquotas() : aliquotas;
        }

        public FormasDePagamento getFormasDePagamento() {
            return formasDePagamento == null ? formasDePagamento = new FormasDePagamento() : formasDePagamento;
        }

        public ComprovantesNaoFiscais getComprovantesNaoFiscais() {
            return comprovantesNaoFiscais == null ? comprovantesNaoFiscais = new ComprovantesNaoFiscais() : comprovantesNaoFiscais;
        }

        public RelatoriosGerenciais getRelatoriosGerenciais() {
            return relatoriosGerenciais == null ? relatoriosGerenciais = new RelatoriosGerenciais() : relatoriosGerenciais;
        }

        public class Equipamento {

            /**
             * Retorna o estado atual do ECF<br>
             * Tipo de estado de retorno:
             * <br><br>
             * <b>estNaoInicializada</b>, Porta Serial ainda não foi aberta;
             *
             * <br><br>
             * <b>estDesconhecido</b>, Porta aberta, mas estado ainda não
             * definido;
             *
             * <br><br>
             * <b>estLivre</b>, Impressora Livre, sem nenhum cupom aberto pronta
             * para nova venda, Redução Z e Leitura X ok, pode ou não já ter
             * ocorrido 1ª venda no dia...;
             *
             * <br><br>
             * <b>estVenda</b>, Cupom de Venda Aberto com ou sem venda do 1º
             * Item;
             *
             * <br><br>
             * <b>estPagamento</b>, Iniciado Fechamento de Cupom com Formas
             * Pagamento pode ou não ter efetuado o 1º pagamento. Não pode mais
             * vender itens, ou alterar Sub-contadorDoDia;
             *
             * <br><br>
             * <b>estRelatorio</b>, Imprimindo Cupom Fiscal Vinculado ou
             * Relatório Gerencial;
             *
             * <br><br>
             * <b>estBloqueada</b>, Redução Z já emitida, bloqueada até as
             * 00:00;
             *
             * <br><br>
             * <b>estRequerZ</b>, Redução Z do dia anterior ainda não foi
             * emitida. Emitir agora;
             *
             * <br><br>
             * <b>estRequerX</b>, Esta impressora requer Leitura X todo inicio
             * de dia. É necessário imprimir uma Leitura X para poder vender
             * <br><br>
             *
             * @return ENUM com estados, podenco ser acessado:
             * <b>ACBrECF.Estado</b>.
             * @throws ACBrECFException
             */
            public Estado estado() throws ACBrECFException {
                switch (comandoECF("Estado")) {
                    case "estNaoInicializada":
                        return ACBrECF.Estado.estNaoInicializada;
                    case "estDesconhecido":
                        return ACBrECF.Estado.estDesconhecido;
                    case "estLivre":
                        return ACBrECF.Estado.estLivre;
                    case "estVenda":
                        return ACBrECF.Estado.estVenda;
                    case "estPagamento":
                        return ACBrECF.Estado.estPagamento;
                    case "estRelatorio":
                        return ACBrECF.Estado.estRelatorio;
                    case "estBloqueada":
                        return ACBrECF.Estado.estBloqueada;
                    case "estRequerZ":
                        return ACBrECF.Estado.estRequerZ;
                    case "estRequerX":
                        return ACBrECF.Estado.estRequerX;
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
            public Date dataHora() throws ACBrECFException {
                SimpleDateFormat s = new SimpleDateFormat("dd/MM/YY HH:mm:ss");
                try {
                    return s.parse(comandoECF("DataHora"));
                } catch (ParseException ex) {
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
            public String marcaStr() throws ACBrECFException {
                return modeloStr();
            }

            /**
             * Retorna Modelo STR do ECF.
             *
             * @return String com marca EX: Daruma
             * @throws
             * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
             */
            public String modeloStr() throws ACBrECFException {
                return comandoECF("ModeloStr");
            }

            /**
             * Retorna Submodelo do ECF (Informações mais específicas sobre o
             * Modelo).
             *
             * @return String com modelo ex: FS-700
             * @throws
             * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
             */
            public String subModeloECF() throws ACBrECFException {
                return comandoECF("SubModeloECF");
            }

            /**
             * Retorna o Número do ECF.
             *
             * @return String com numero do ECF. EX: 001
             * @throws ACBrECFException
             */
            public String numECF() throws ACBrECFException {
                return comandoECF("NumECF");
            }

            /**
             * Retorna o Número da Loja.
             *
             * @return String com numero da loja ex: 001
             * @throws ACBrECFException
             */
            public String numLoja() throws ACBrECFException {
                return comandoECF("NumLoja");
            }

            /**
             * Retorna o Número de Série do ECF.
             *
             * @return String com numero serie. <br>EX: DR0208BR000000000000
             * @throws ACBrECFException
             */
            public String numSerie() throws ACBrECFException {
                return comandoECF("NumSerie");
            }

            /**
             * Retorna o Número de Série MFD.
             *
             * @return String com a serie da MFD. EX: MFDSW00000000001
             * @throws ACBrECFException
             */
            public String numSeriaMFD() throws ACBrECFException {
                return comandoECF("NumSerieMFD");
            }

            /**
             * Retorna o Número da versão do software do ECF.
             *
             * @return String com numero da versao. EX: 01.00.01
             * @throws ACBrECFException
             */
            public String numVersao() throws ACBrECFException {
                return comandoECF("NumVersao");
            }

            /**
             * Retorna o CNPJ cadastrado no ECF.
             *
             * @return String com cnpj. EX: 10.493.367/0001-48
             * @throws ACBrECFException
             */
            public String cnpj() throws ACBrECFException {
                return comandoECF("CNPJ");
            }

            /**
             * Retorna a Inscrição Estadual cadastrada no ECF.
             *
             * @return String com IE na impressora. EX: 687.138.770
             * @throws ACBrECFException
             */
            public String ie() throws ACBrECFException {
                return comandoECF("IE");
            }

            /**
             * Retorna a Inscrição Municipal cadastrada no ECF.
             *
             * @return String com IM do ECF: 21098765432
             * @throws ACBrECFException
             */
            public String im() throws ACBrECFException {
                return comandoECF("IM");
            }

            /**
             * Retorna informações PAF como número de MD5, nome e versão do
             * aplicativo fiscal.
             * <br><br><b>NOTA: Não está disponível em todos os ECFs
             * </b><br><br>
             *
             * @return String com Dados: ex:
             * MD-5:22C5D38B8C715038C66FF34F459072F5 DJPDV 1.2.1
             * @throws ACBrECFException
             */
            public String paf() throws ACBrECFException {
                return comandoECF("PAF");
            }

            /**
             * Retorna o número do usuário atual do ECF.
             *
             * @return String com numero do usuario do ecf. EX: 01
             * @throws ACBrECFException
             */
            public String usuarioAtual() throws ACBrECFException {
                return comandoECF("UsuarioAtual");
            }

            /**
             * Retorna as linhas do cliche do proprietário cadastrado no ECF
             * (Cabeçalho).
             *
             * @return String com Cabeçalho do ECF. EX:<br>
             * GERALDO JOAO DA SILVA ME Rua Alferes Jorge, 176 Indianopolis
             * 55024-130 Caruaru-PE.
             * @throws ACBrECFException
             */
            public String cliche() throws ACBrECFException {
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
            public Date dataHoraSwBasico() throws ACBrECFException {
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
            public int decimaisQtd() throws ACBrECFException {
                return Integer.parseInt(comandoECF("DecimaisQtd"));
            }

            /**
             * Retorna a quantidade de casas decimais para o Preço.
             *
             * @return int com a quantidade de casas decimais. EX: 3
             * @throws ACBrECFException
             */
            public int decimaisPreco() throws ACBrECFException {
                return Integer.parseInt(comandoECF("DecimaisPreco"));
            }

            /**
             * Retorna número de colunas do ECF.
             *
             * @return ex: 48
             * @throws ACBrECFException
             */
            public String colunas() throws ACBrECFException {
                return comandoECF("Colunas");
            }

            /**
             * Retorna se a ECF tem MF adicional. Geralmente as ECF identificam
             * se ECF possui MF adicional através no Nº de Série e ao final a
             * letra indicativa. Se não existe retornará OK.
             *
             * @return Exemplo de MF Adicional: DR0105BR000000054098<b>A</b><br>
             * Exemplo sem a MF Adicional: DR0105BR000000054098<s>A</s>, no
             * caso: DR0105BR000000054098
             * @throws ACBrECFException
             */
            public String mfAdicional() throws ACBrECFException {
                return comandoECF("MFAdicional");
            }

            /**
             * Retorna Registro de Fita Detalhe.
             *
             * @return String com registro de fita detalhe. EX: DR
             * @throws ACBrECFException
             */
            public String rfdid() throws ACBrECFException {
                return comandoECF("RFDID");
            }

            /**
             * Retorna Registro de Fita Detalhe.
             *
             * @return String com registro de fita detalhe. EX: DR
             * @throws ACBrECFException
             */
            public String registroFitaDetalhe() throws ACBrECFException {
                return rfdid();
            }
        }

        public class MapaResumo {

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
             * Retorna número do CRO (Contador de Reinicio de Operações
             * (Intervenções) ).
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
             * Retorna número do CCDC (Contador Comprovante de Credito ou
             * Débito).
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
             * Retorna número do NCN (Número de Comprovantes de Crédito ou
             * Débito Não Emitidos).
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
        }

        public class Aliquotas {

            /**
             * Retorna todas as alíquotas cadastradas no ECF.
             * <br>
             * IIIIT999.99|IIIIT999.99|IIIIT999.99|....
             * <br>Onde: I = índice da Alíquota usado pelo ACBrECF
             * <br>T = Tipo da Alíquota, ( "T" = ICMS, "S" = ISS)
             * <br>999.99 = Valor da Alíquota
             * <br><br><b>Nota:</b> Esse comando quando executado a primeira
             * vez, se comunica com o ECF a fim de carregar a tabela de
             * alíquotas. Após a carga, elas são transferidas para a memória do
             * <b>ACBrECF</b>
             *
             *
             * @return List com Aliquotas
             * @throws ACBrECFException
             */
            public List<Aliquota> aliquotas() throws ACBrECFException {
                return listaAliquotas("Aliquotas");
            }

            /**
             * Retorna todas as alíquotas cadastradas no ECF. Semelhante ao
             * comando ECF.Aliquotas, porém esse comando sempre se comunica com
             * o ECF a fim de ler novamente todas as alíquotas cadastradas.
             * <br>
             * IIIIT999.99|IIIIT999.99|IIIIT999.99|....
             * <br>Onde: I = índice da Alíquota usado pelo ACBrECF
             * <br>T = Tipo da Alíquota, ( "T" = ICMS, "S" = ISS)
             * <br>999.99 = Valor da Alíquota
             *
             * @return List com Aliquotas
             * @throws ACBrECFException
             */
            public List<Aliquota> carregaAliquotas() throws ACBrECFException {
                return listaAliquotas("CarregaAliquotas");
            }

            /**
             * Retorna os valores totais das alíquotas cadastradas no ECF. OBS:
             * Totalizador ficará null, pois o metodo pega os indices e os
             * valores totais.
             * <br><br>
             * IIII999.99|IIII999.99|IIII999.99|....
             * <br><br>
             * Onde:<br>
             * <b>I</b> = índice da Alíquota usado pelo ACBrECF<br>
             * <b>999.99 </b>= Valor da Alíquota<br>
             *
             * @return List com Aliquotas
             * @throws ACBrECFException
             */
            public List<Aliquota> lerTotaisAliquota() throws ACBrECFException {
                return listaAliquotas("LerTotaisAliquota");
            }

            private List<Aliquota> listaAliquotas(String tipo) throws ACBrECFException {
                List<Aliquota> lista = new ArrayList<>();
                for (String s : comandoECF(tipo).split("\\|")) {
                    s = s.trim();
                    Aliquota a = new Aliquota();
                    a.setTipo(s.charAt(0));
                    a.setIndice(s.substring(1, 3));
                    if (tipo.endsWith("LerTotaisAliquota")) {
                        for (Aliquota aliquota : aliquotas()) {
                            if (aliquota.getIndice() == null ? a.getIndice() == null : aliquota.getIndice().equals(a.getIndice())) {
                                if (aliquota.getTipo() == a.getTipo()) {
                                    a.setPercentualImposto(aliquota.getPercentualImposto());
                                }
                                break;
                            }
                        }
                        a.setTotal(Numeros.parseToBig(s.substring(4)));
                    } else {
                        a.setPercentualImposto(Numeros.parseToBig(s.substring(4)));
                    }
                    lista.add(a);
                }
                return lista;
            }

            /**
             * Procura Alíquota no ECF pelo valor informado e retorna o índice
             * da alíquota.
             *
             * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 ,
             * 2.46
             * @return Objeto Aliquota da busca.
             * @throws ACBrECFException
             */
            public Aliquota acharAliquotaPorValor(Double valor) throws ACBrECFException {
                return acharAliquotaPorValor(String.valueOf(valor));
            }

            /**
             * Procura Alíquota no ECF pelo valor informado e retorna o índice
             * da alíquota.
             *
             * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 ,
             * 2.46
             * @return Objeto Aliquota da busca.
             * @throws ACBrECFException
             */
            public Aliquota acharAliquotaPorValor(String valor) throws ACBrECFException {
                return acharAliquotaPorValor(Numeros.parseToBig(valor));
            }

            /**
             * Procura Alíquota no ECF pelo valor informado e retorna o índice
             * da alíquota.
             *
             * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 ,
             * 2.46
             * @return Objeto Aliquota da busca.
             * @throws ACBrECFException
             */
            public Aliquota acharAliquotaPorValor(BigDecimal valor) throws ACBrECFException {
                return acharAliquotaPorValor(valor, ' ');
            }

            /**
             * Procura Alíquota no ECF pelo valor informado e retorna o índice
             * da alíquota.
             *
             * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 ,
             * 2.46
             * @param tipo Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS.
             * Pode ser omitido, nesse caso retorna a primeira alíquota
             * encontrada.
             * @return Objeto Aliquota da busca.
             * @throws ACBrECFException
             */
            public Aliquota acharAliquotaPorValor(Double valor, char tipo) throws ACBrECFException {
                return acharAliquotaPorValor(String.valueOf(valor), tipo);
            }

            /**
             * Procura Alíquota no ECF pelo valor informado e retorna o índice
             * da alíquota.
             *
             * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 ,
             * 2.46
             * @param tipo Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS.
             * Pode ser omitido, nesse caso retorna a primeira alíquota
             * encontrada.
             * @return Objeto Aliquota da busca.
             * @throws ACBrECFException
             */
            public Aliquota acharAliquotaPorValor(String valor, char tipo) throws ACBrECFException {
                return acharAliquotaPorValor(Numeros.parseToBig(valor, tipo));
            }

            /**
             * Procura Alíquota no ECF pelo valor informado e retorna o índice
             * da alíquota.
             *
             * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 ,
             * 2.46
             * @param tipo Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS.
             * Pode ser omitido, nesse caso retorna a primeira alíquota
             * encontrada.
             * @return Objeto Aliquota da busca.
             * @throws ACBrECFException
             */
            public Aliquota acharAliquotaPorValor(BigDecimal valor, char tipo) throws ACBrECFException {
                String r = comandoECF("AchaIcmsAliquota(" + valor + "," + tipo + ")");
                Aliquota a = new Aliquota();
                a.setIndice(r.substring(1, 3));
                a.setTipo(r.charAt(0));
                a.setPercentualImposto(Numeros.parseToBig(r.substring(4)));
                return a;
            }
        }

        public class FormasDePagamento {

            /**
             * Retorna todas as Formas de Pagamento Cadastradas na ECF. <br>
             * <b>Nota:</b>
             * Esse comando quando executado a primeira vez, se comunica com o
             * ECF a fim de carregar a tabela de Formas de Pagamento. Após a
             * carga, elas são transferidas para a memória do ACBrECF.
             * <br>
             * <br><b>Nota: </b>Não inclui os totais vendidos.
             *
             * @return List de Objetos de forma de pagamento.
             * @throws
             * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
             */
            public List<FormaDePagamento> formasPagamento() throws ACBrECFException {
                return formasPgto("FormasPagamento");
            }

            /**
             * Retorna todas as Formas de Pagamento Cadastradas na ECF. <br>
             * Semelhante ao comando ECF.FormasPagamento, porém esse comando
             * sempre se comunica com o ECF a fim de ler novamente todas as
             * Formas de Pagamento cadastradas
             * <br><b>Nota: </b>Não inclui os totais vendidos.
             *
             * @return
             * @throws ACBrECFException
             */
            public List<FormaDePagamento> carregaFormasPagamento() throws ACBrECFException {
                return formasPgto("CarregaFormasPagamento");
            }

            /**
             * Retorna Total de cada Forma de Pagamento cadastradas no ECF
             *
             * @return List FormaDePagamento acrescido do contadorDoDia vendido
             * pela forma.
             * @throws ACBrECFException
             */
            public List<FormaDePagamento> lerTotaisFormaPagamento() throws ACBrECFException {
                return formasPgto("LerTotaisFormaPagamento");
            }

            private List<FormaDePagamento> formasPgto(String tipo) throws ACBrECFException {
                List<FormaDePagamento> lista = new ArrayList<>();
                for (String s : comandoECF(tipo).split("\\|")) {
                    s = s.trim();
                    FormaDePagamento f = new FormaDePagamento();
                    f.setIndice(Integer.parseInt(s.substring(0, 2)));
                    if (tipo.equals("LerTotaisFormaPagamento")) {
                        f.setTotal(Numeros.parseToBig(s.substring(2)));
                        for (FormaDePagamento formaDePagamento : formasPagamento()) {
                            if (formaDePagamento.getIndice() == f.getIndice()) {
                                f.setDescricao(formaDePagamento.getDescricao());
                                f.setImprimeVinculado(formaDePagamento.isImprimeVinculado());
                                break;
                            }
                        }
                    } else {
                        f.setImprimeVinculado(s.charAt(2) == 'V' || s.charAt(3) == 'v');
                        f.setDescricao(s.substring(3).trim());
                    }
                    lista.add(f);
                }
                return lista;
            }

            /**
             * Retorna informações sobre a Forma de Pagamento a ser procurada.
             *
             * @param descricao Descrição da forma de pagamento
             * @return Objeto FormaDePagamento
             * @throws ACBrECFException se não encontrar ou tiver qualquer outro
             * erro de comunicacao com acbr monitor.
             */
            public FormaDePagamento achaFPGDescricao(String descricao) throws ACBrECFException {
                String s = comandoECF("AchaFPGDescricao(" + descricao + ")").trim();
                FormaDePagamento f = new FormaDePagamento();
                f.setIndice(Integer.parseInt(s.substring(0, 2)));
                f.setImprimeVinculado(s.charAt(2) == 'V' || s.charAt(3) == 'v');
                f.setDescricao(s.substring(3).trim());
                return f;
            }
        }

        public class ComprovantesNaoFiscais {

            /**
             * Retorna todas os CNFs cadastrados na ECF.<br>
             * IIIITDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDFFFF|....*<br>
             * Onde:
             * <br>
             * I = índice do comprovante não fiscal usado pelo ACBrECF
             * <br>
             * T = Permite vinculado ( "V" = Sim, "Vazio" = Não)
             * <br>
             * D = Descrição do comprovante não fiscal
             * <br>
             * F = Forma de pagamento associada (apenas na Schalter).
             *
             * <b>Nota: </b>Esse comando quando executado a primeira vez, se
             * comunica com o ECF a fim de carregar a tabela de Comprovantes não
             * Fiscais. Após a carga, elas são transferidas para a memória do
             * ACBrECF
             * <br><b>NOTA 2:</b> Esse método não traz o contadorDoDia no item
             */
            public List<ComprovanteNaoFiscal> comprovantesNaoFiscais() throws ACBrECFException {
                return compNFiscal("ComprovantesNaoFiscais");
            }

            /**
             * Retorna todas os CNFs cadastrados na ECF.<br>
             * IIIITDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDFFFF|....*<br>
             * Onde:
             * <br>
             * I = índice do comprovante não fiscal usado pelo ACBrECF
             * <br>
             * T = Permite vinculado ( "V" = Sim, "Vazio" = Não)
             * <br>
             * D = Descrição do comprovante não fiscal
             * <br>
             * F = Forma de pagamento associada (apenas na Schalter).
             *
             * Semelhante ao comando ECF.ComprovantesNaoFiscais, porém esse
             * comando sempre se comunica com o ECF a fim de ler novamente todas
             * os Comprovantes não Fiscais cadastrados
             * <br><b>NOTA:</b> Esse método não traz o contadorDoDia no item
             */
            public List<ComprovanteNaoFiscal> carregaComprovantesNaoFiscais() throws ACBrECFException {
                return compNFiscal("CarregaComprovantesNaoFiscais");
            }

            private List<ComprovanteNaoFiscal> compNFiscal(String comando) throws ACBrECFException {
                String r = comandoECF(comando);
                List<ComprovanteNaoFiscal> lista = new ArrayList<>();
                for (String string : r.split("\\|")) {
                    string = string.trim();
                    ComprovanteNaoFiscal c = new ComprovanteNaoFiscal();
                    c.setIndice(string.substring(0, 2).trim());
                    if (comando.equals("lerTotaisComprovanteNaoFiscal")) {
                        c.setTotal(Numeros.parseToBig(string.substring(3)));
                        for (ComprovanteNaoFiscal compro : comprovantesNaoFiscais()) {
                            if (compro.getIndice().equals(c.getIndice())) {
                                c.setDescricao(compro.getDescricao());
                                c.setEntrada(compro.isEntrada());
                                c.setSaida(compro.isSaida());
                                c.setPermiteVinculado(compro.isPermiteVinculado());
                                break;
                            }
                        }
                    } else {
                        c.setPermiteVinculado(string.charAt(2) == 'V' || string.charAt(2) == 'v');
                        c.setDescricao(string.substring(4).trim());
                        c.setSaida(c.getDescricao().contains("-"));
                        c.setEntrada(c.getDescricao().contains("+"));
                    }
                    lista.add(c);
                }
                return lista;
            }

            /**
             * Retorna Total de cada comprovante não fiscal (CNF) cadastrados no
             * ECF. Onde:<br>
             * I = índice do CNF usado pelo ACBrECF<br>
             * 999.99 = Valor contadorDoDia do CNF.
             * <br><b>NOTA:</b> Esse método traz o contadorDoDia no item.
             *
             * @return @throws ACBrECFException
             */
            public List<ComprovanteNaoFiscal> lerTotaisComprovanteNaoFiscal() throws ACBrECFException {
                return compNFiscal("lerTotaisComprovanteNaoFiscal");
            }

            /**
             * Retorna informações sobre o Comprovante não Fiscal a ser
             * procurado
             *
             * @param descricaoCNF Descrição do comprovante não fiscal.
             *
             * @return Retorna: IIIITDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDFFFF *<br>
             * Onde:
             * <br>
             * I = índice do comprovante não fiscal usado pelo ACBrECF
             * <br>
             * T = Permite vinculado ( "V" = Sim, "Vazio" = Não)
             * <br>
             * D = Descrição do comprovante não fiscal
             * <br>
             * F = Forma de pagamento associada (apenas na Schalter).
             * @throws ACBrECFException
             */
            public ComprovanteNaoFiscal achaCNFDescricao(String descricaoCNF) throws ACBrECFException {
                String string = comandoECF("AchaCNFDescricao(" + descricaoCNF + ")").trim();
                ComprovanteNaoFiscal c = new ComprovanteNaoFiscal();
                c.setIndice(string.substring(0, 2).trim());
                c.setPermiteVinculado(string.charAt(2) == 'V' || string.charAt(2) == 'v');
                c.setDescricao(string.substring(4).trim());
                c.setSaida(c.getDescricao().contains("-"));
                c.setEntrada(c.getDescricao().contains("+"));
                return c;
            }
        }

        public class RelatoriosGerenciais {

            /**
             * Retorna todas os Relatorios Gerenciais cadastrados na ECF.<br>
             * <b>Nota:</b> Esse comando quando executado a primeira vez, se
             * comunica com o ECF a fim de carregar a tabela de Relatórios
             * Gerenciais. Após a carga, elas são transferidas para a memória do
             * ACBrECF.
             *
             * @return
             * @throws ACBrECFException
             */
            public List<RelatorioGerencial> relatoriosGerenciais() throws ACBrECFException {
                return relatoriosGer("RelatoriosGerenciais");
            }

            /**
             * Retorna todas os Relatorios Gerenciais cadastrados na ECF.<br>
             * <b>Nota:</b> Semelhante ao comando ECF.RelatoriosGerencial, porém
             * esse comando sempre se comunica com o ECF a fim de ler novamente
             * todos os Relatórios Gerenciais cadastrados.
             *
             * @return @throws ACBrECFException
             */
            public List<RelatorioGerencial> carregaRelatoriosGerenciais() throws ACBrECFException {
                return relatoriosGer("CarregaRelatoriosGerenciais");
            }

            /**
             * Retorna além do TOTAL do dia o TOTAL de cada relatório gerencial
             * cadastrados no ECF.
             *
             * @return @throws ACBrECFException
             */
            public List<RelatorioGerencial> lerTotaisRelatoriosGerenciais() throws ACBrECFException {
                return relatoriosGer("LerTotaisRelatoriosGerenciais");
            }

            /**
             * Retorna informações sobre o Relatório Gerencial a ser procurado
             *
             * @param descricao Descrição do relatório gerencial.
             * @return
             * @throws ACBrECFException
             */
            public RelatorioGerencial achaRGDescricao(String descricao) throws ACBrECFException {
                return relatoriosGer("AchaRGDescricao(" + descricao + ")").get(0);
            }

            private List<RelatorioGerencial> relatoriosGer(String comando) throws ACBrECFException {
                String r = comandoECF(comando).trim();
                List<RelatorioGerencial> lista = new ArrayList<>();
                for (String s : r.split("\\|")) {
                    s = s.trim();
                    RelatorioGerencial rg = new RelatorioGerencial();
                    rg.setIndice(s.substring(0, 2));
                    if (comando.equals("LerTotaisRelatoriosGerenciais")) {
                        rg.setContadorGeral(Integer.parseInt(s.substring(2)));
                        for (RelatorioGerencial relatoriosGerenciai : relatoriosGerenciais()) {
                            if (relatoriosGerenciai.getIndice().equals(rg.getIndice())) {
                                rg.setDescricao(relatoriosGerenciai.getDescricao());
                                rg.setContadorDoDia(relatoriosGerenciai.getContadorDoDia());
                                break;
                            }
                        }
                    } else {
                        rg.setDescricao(s.substring(3, s.length() - 5).trim());
                        rg.setContadorDoDia(Integer.parseInt(s.substring(s.length() - 5)));
                    }
                    lista.add(rg);
                }
                return lista;
            }
        }

        /**
         * Retorna todas Unidades de Medida Cadastradas na ECF.<br>
         * IIIIDDDD|IIIIDDDD|IIIIDDDD|....<br>
         *
         * Onde:
         * <br>
         * I = índice da unidade de medida usada pelo ACBrECF
         * <br>
         * D = Descrição da unidade de medida<br>
         * <b>Nota:</b> Esse comando quando executado a primeira vez, se
         * comunica com o ECF a fim de carregar a tabela de Unidades de medida.
         * Após a carga, elas são transferidas para a memória do ACBrECF<br>
         *
         * @return
         * @throws ACBrECFException
         */
        public String unidadesMedida() throws ACBrECFException {
            return comandoECF("UnidadesMedida");
        }

        /**
         * Retorna todas Unidades de Medida Cadastradas na ECF.<br>
         * Semelhante ao comando ECF.UnidadesMedidas, porém esse comando sempre
         * se comunica com o ECF a fim de ler novamente todas as Unidades de
         * Medidas cadastradas.
         *
         * @return
         * @throws ACBrECFException
         */
        public String carregaUnidadesMedida() throws ACBrECFException {
            return comandoECF("CarregaUnidadesMedida");
        }
    }

    public class ReducaoZ {

        //dados do ECF
        private Date dataMovimento;
        private String numSerie;
        private String numECF;
        private String numLoja;
        private String numCOOInicial;
        private String numCOO;
        private String numCRZ;
        private String numCRO;
        //Totalizadores
        private BigDecimal vendaBruta;
        private BigDecimal grandeTotal;
        private BigDecimal totalDescontos;
        private BigDecimal totalCancelamentos;
        private BigDecimal totalAcrescimos;
        private BigDecimal totalNaoFiscal;
        //Aliquotas
        private HashMap<String, BigDecimal> totaisAliquotas;
        //Outras ICMS
        private BigDecimal totalSubstituicaoTributaria;
        private BigDecimal totalNaoTributado;
        private BigDecimal totalIsencao;
        //Nao Fiscal
        private BigDecimal totalSangria;
        private BigDecimal totalSuprimento;

        public Date getDataMovimento() {
            return dataMovimento;
        }

        protected void setDataMovimento(Date dataMovimento) {
            this.dataMovimento = dataMovimento;
        }

        public String getNumSerie() {
            return numSerie;
        }

        protected void setNumSerie(String numSerie) {
            this.numSerie = numSerie;
        }

        public String getNumECF() {
            return numECF;
        }

        protected void setNumECF(String numECF) {
            this.numECF = numECF;
        }

        public String getNumLoja() {
            return numLoja;
        }

        protected void setNumLoja(String numLoja) {
            this.numLoja = numLoja;
        }

        public String getNumCOOInicial() {
            return numCOOInicial;
        }

        protected void setNumCOOInicial(String numCOOInicial) {
            this.numCOOInicial = numCOOInicial;
        }

        public String getNumCOO() {
            return numCOO;
        }

        protected void setNumCOO(String numCOO) {
            this.numCOO = numCOO;
        }

        public String getNumCRZ() {
            return numCRZ;
        }

        protected void setNumCRZ(String numCRZ) {
            this.numCRZ = numCRZ;
        }

        public String getNumCRO() {
            return numCRO;
        }

        protected void setNumCRO(String numCRO) {
            this.numCRO = numCRO;
        }

        public BigDecimal getVendaBruta() {
            return vendaBruta;
        }

        protected void setVendaBruta(BigDecimal vendaBruta) {
            this.vendaBruta = vendaBruta;
        }

        public BigDecimal getGrandeTotal() {
            return grandeTotal;
        }

        protected void setGrandeTotal(BigDecimal grandeTotal) {
            this.grandeTotal = grandeTotal;
        }

        public BigDecimal getTotalDescontos() {
            return totalDescontos;
        }

        protected void setTotalDescontos(BigDecimal totalDescontos) {
            this.totalDescontos = totalDescontos;
        }

        public BigDecimal getTotalCancelamentos() {
            return totalCancelamentos;
        }

        protected void setTotalCancelamentos(BigDecimal totalCancelamentos) {
            this.totalCancelamentos = totalCancelamentos;
        }

        public BigDecimal getTotalAcrescimos() {
            return totalAcrescimos;
        }

        protected void setTotalAcrescimos(BigDecimal totalAcrescimos) {
            this.totalAcrescimos = totalAcrescimos;
        }

        public BigDecimal getTotalNaoFiscal() {
            return totalNaoFiscal;
        }

        protected void setTotalNaoFiscal(BigDecimal totalNaoFiscal) {
            this.totalNaoFiscal = totalNaoFiscal;
        }

        public HashMap<String, BigDecimal> getTotaisAliquotas() {
            return totaisAliquotas;
        }

        protected void setTotaisAliquotas(HashMap<String, BigDecimal> totaisAliquotas) {
            this.totaisAliquotas = totaisAliquotas;
        }

        public BigDecimal getTotalSubstituicaoTributaria() {
            return totalSubstituicaoTributaria;
        }

        protected void setTotalSubstituicaoTributaria(BigDecimal totalSubstituicaoTributaria) {
            this.totalSubstituicaoTributaria = totalSubstituicaoTributaria;
        }

        public BigDecimal getTotalNaoTributado() {
            return totalNaoTributado;
        }

        protected void setTotalNaoTributado(BigDecimal totalNaoTributado) {
            this.totalNaoTributado = totalNaoTributado;
        }

        public BigDecimal getTotalIsencao() {
            return totalIsencao;
        }

        protected void setTotalIsencao(BigDecimal totalIsencao) {
            this.totalIsencao = totalIsencao;
        }

        public BigDecimal getTotalSangria() {
            return totalSangria;
        }

        protected void setTotalSangria(BigDecimal totalSangria) {
            this.totalSangria = totalSangria;
        }

        public BigDecimal getTotalSuprimento() {
            return totalSuprimento;
        }

        protected void setTotalSuprimento(BigDecimal totalSuprimento) {
            this.totalSuprimento = totalSuprimento;
        }

        @Override
        public String toString() {
            String s = "{";
            for (String string : totaisAliquotas.keySet()) {
                s += string + " = " + totaisAliquotas.get(string) + "\n";
            }
            s += "}";
            return "ReducaoZ{" + "dataMovimento=" + dataMovimento + ",\nnumSerie=" + numSerie + ",\nnumECF=" + numECF + ",\nnumLoja=" + numLoja + ",\nnumCOOInicial=" + numCOOInicial + ",\nnumCOO=" + numCOO + ",\nnumCRZ=" + numCRZ + ",\nnumCRO=" + numCRO + ",\nvendaBruta=" + vendaBruta + ",\ngrandeTotal=" + grandeTotal + ",\ntotalDescontos=" + totalDescontos + ",\ntotalCancelamentos=" + totalCancelamentos + ",\ntotalAcrescimos=" + totalAcrescimos + ",\ntotalNaoFiscal=" + totalNaoFiscal + ",\ntotaisAliquotas=" + s + ",\ntotalSubstituicaoTributaria=" + totalSubstituicaoTributaria + ",\ntotalNaoTributado=" + totalNaoTributado + ",\ntotalIsencao=" + totalIsencao + ",\ntotalSangria=" + totalSangria + ",\ntotalSuprimento=" + totalSuprimento + '}';
        }
    }

    public class Aliquota {

        private char tipo;
        private String indice;
        private BigDecimal percentualImposto;
        private BigDecimal total;

        public String getTotalizador() {
            return indice + String.valueOf(tipo) + (percentualImposto.compareTo(BigDecimal.TEN) == -1 ? "0" : "") + String.format("%.2f", percentualImposto).replace(",", "");//Será que vai existi
        }

        /**
         *
         * @return Tipo da Alíquota, ( "T" = ICMS, "S" = ISS)
         */
        public char getTipo() {
            return tipo;
        }

        protected void setTipo(char tipo) {
            this.tipo = tipo;
        }

        public BigDecimal getPercentualImposto() {
            return percentualImposto;
        }

        protected void setPercentualImposto(BigDecimal percentualImposto) {
            this.percentualImposto = percentualImposto;
        }

        public BigDecimal getTotal() {
            if (total == null) {
                throw new NullPointerException("Total == null. \nVerifique se foi executado o comando para ler os totais das aliquotas da impressora.");
            } else {
                return total;
            }
        }

        protected void setTotal(BigDecimal total) {
            this.total = total;
        }

        protected void setIndice(String indice) {
            this.indice = indice;
        }

        public String getIndice() {
            return indice;
        }

        @Override
        public String toString() {
            return getTotalizador();
        }

    }

    public class FormaDePagamento {

        private int indice;
        private String descricao;
        boolean imprimeVinculado;
        private BigDecimal total;

        public int getIndice() {
            return indice;
        }

        protected void setIndice(int indice) {
            this.indice = indice;
        }

        public String getDescricao() {
            return descricao;
        }

        protected void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public boolean isImprimeVinculado() {
            return imprimeVinculado;
        }

        protected void setImprimeVinculado(boolean imprimeVinculado) {
            this.imprimeVinculado = imprimeVinculado;
        }

        public BigDecimal getTotal() {
            if (total == null) {
                throw new NullPointerException("Total NULL verifique se já foi rodado o comando: ecf..getVariaveis().getFormasDePagamento().lerTotaisFormaPagamento()");
            }
            return total;
        }

        protected void setTotal(BigDecimal total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return String.format("%02d", indice) + (imprimeVinculado ? "V" : "") + " " + descricao + (total == null ? "" : " T" + total);
        }

    }

    public class ComprovanteNaoFiscal {

        private String indice;
        private String descricao;
        private boolean permiteVinculado;
        private boolean entrada;
        private boolean saida;
        private BigDecimal total;

        public String getIndice() {
            return indice;
        }

        protected void setIndice(String indice) {
            this.indice = indice;
        }

        public String getDescricao() {
            return descricao;
        }

        protected void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public boolean isPermiteVinculado() {
            return permiteVinculado;
        }

        protected void setPermiteVinculado(boolean permiteVinculado) {
            this.permiteVinculado = permiteVinculado;
        }

        public BigDecimal getTotal() {
            if (total == null) {
                throw new NullPointerException("Total ==null. \nVerifique se foi rodado o comando para carregar os totais.");
            } else {
                return total;
            }
        }

        protected void setTotal(BigDecimal total) {
            this.total = total;
        }

        public boolean isEntrada() {
            return entrada;
        }

        public void setEntrada(boolean entrada) {
            this.entrada = entrada;
        }

        public boolean isSaida() {
            return saida;
        }

        public void setSaida(boolean saida) {
            this.saida = saida;
        }

        @Override
        public String toString() {
            return (indice.length() == 1 ? indice + " " : indice) + (permiteVinculado ? "V" : "") + " " + descricao + " E:" + entrada + " S:" + saida;
        }

    }

    public class RelatorioGerencial {

        private String indice;
        private String descricao;
        private Integer contadorDoDia;
        private Integer contadorGeral;

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getIndice() {
            return indice;
        }

        public void setIndice(String indice) {
            this.indice = indice;
        }

        public Integer getContadorDoDia() {
            return contadorDoDia;
        }

        public void setContadorDoDia(Integer contadorDoDia) {
            this.contadorDoDia = contadorDoDia;
        }

        public Integer getContadorGeral() {
            if (contadorGeral == null) {
                throw new NullPointerException("Total geral NULL. \nVerifique se foi executado o comando e.getVariaveis().getRelatoriosGerenciais().lerTotaisRelatoriosGerenciais()");
            } else {
                return contadorGeral;
            }
        }

        public void setContadorGeral(Integer contadorGeral) {
            this.contadorGeral = contadorGeral;
        }

        @Override
        public String toString() {
            return indice + " " + descricao + " TD: " + contadorDoDia + (contadorGeral == null ? "" : " TG: " + contadorGeral);
        }

    }
}
