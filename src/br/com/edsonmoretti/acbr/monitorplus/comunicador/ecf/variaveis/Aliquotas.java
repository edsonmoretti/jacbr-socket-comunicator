package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson
 */
public class Aliquotas {

    /**
     * Retorna todas as alíquotas cadastradas no ECF.
     * <br>
     * IIIIT999.99|IIIIT999.99|IIIIT999.99|....
     * <br>Onde: I = índice da Alíquota usado pelo ACBrECF
     * <br>T = Tipo da Alíquota, ( "T" = ICMS, "S" = ISS)
     * <br>999.99 = Valor da Alíquota
     * <br><br><b>Nota:</b> Esse comando quando executado a primeira vez, se
     * comunica com o ECF a fim de carregar a tabela de alíquotas. Após a carga,
     * elas são transferidas para a memória do
     * <b>ACBrECF</b>
     *
     *
     * @return List com Aliquotas
     * @throws ACBrECFException
     */
    public List<Aliquota> getAliquotas() throws ACBrECFException {
        return listaAliquotas("Aliquotas");
    }

    /**
     * Retorna todas as alíquotas cadastradas no ECF. Semelhante ao comando
     * ECF.Aliquotas, porém esse comando sempre se comunica com o ECF a fim de
     * ler novamente todas as alíquotas cadastradas.
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
     * Totalizador ficará null, pois o metodo pega os indices e os valores
     * totais.
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
                for (Aliquota aliquota : getAliquotas()) {
                    if (aliquota.getIndice().equals(a.getIndice())) {
                        if (aliquota.getTipo() == a.getTipo()) {
                            a.setPercentualImposto(aliquota.getPercentualImposto());
                            break;
                        }
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
     * Procura Alíquota no ECF pelo valor informado e retorna o índice da
     * alíquota.
     *
     * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 , 2.46
     * @return Objeto Aliquota da busca.
     * @throws ACBrECFException
     */
    public Aliquota acharAliquotaPorValor(Double valor) throws ACBrECFException {
        return acharAliquotaPorValor(String.valueOf(valor));
    }

    /**
     * Procura Alíquota no ECF pelo valor informado e retorna o índice da
     * alíquota.
     *
     * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 , 2.46
     * @return Objeto Aliquota da busca.
     * @throws ACBrECFException
     */
    public Aliquota acharAliquotaPorValor(String valor) throws ACBrECFException {
        return acharAliquotaPorValor(Numeros.parseToBig(valor));
    }

    /**
     * Procura Alíquota no ECF pelo valor informado e retorna o índice da
     * alíquota.
     *
     * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 , 2.46
     * @return Objeto Aliquota da busca.
     * @throws ACBrECFException
     */
    public Aliquota acharAliquotaPorValor(BigDecimal valor) throws ACBrECFException {
        return acharAliquotaPorValor(valor, ' ');
    }

    /**
     * Procura Alíquota no ECF pelo valor informado e retorna o índice da
     * alíquota.
     *
     * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 , 2.46
     * @param tipo Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS. Pode
     * ser omitido, nesse caso retorna a primeira alíquota encontrada.
     * @return Objeto Aliquota da busca.
     * @throws ACBrECFException
     */
    public Aliquota acharAliquotaPorValor(Double valor, char tipo) throws ACBrECFException {
        return acharAliquotaPorValor(String.valueOf(valor), tipo);
    }

    /**
     * Procura Alíquota no ECF pelo valor informado e retorna o índice da
     * alíquota.
     *
     * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 , 2.46
     * @param tipo Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS. Pode
     * ser omitido, nesse caso retorna a primeira alíquota encontrada.
     * @return Objeto Aliquota da busca.
     * @throws ACBrECFException
     */
    public Aliquota acharAliquotaPorValor(String valor, char tipo) throws ACBrECFException {
        return acharAliquotaPorValor(Numeros.parseToBig(valor, tipo));
    }

    /**
     * Procura Alíquota no ECF pelo valor informado e retorna o índice da
     * alíquota.
     *
     * @param valor Valor da Alíquota a procurar. Exemplos: 18 , 12 , 2.46
     * @param tipo Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS. Pode
     * ser omitido, nesse caso retorna a primeira alíquota encontrada.
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
