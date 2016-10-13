/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edson
 */
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
     * <b>Nota: </b>Esse comando quando executado a primeira vez, se comunica
     * com o ECF a fim de carregar a tabela de Comprovantes não Fiscais. Após a
     * carga, elas são transferidas para a memória do ACBrECF
     * <br><b>NOTA 2:</b> Esse método não traz o contadorDoDia no item
     */
    public List<ComprovanteNaoFiscal> getComprovantesNaoFiscais() throws ACBrECFException {
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
     * Semelhante ao comando ECF.ComprovantesNaoFiscais, porém esse comando
     * sempre se comunica com o ECF a fim de ler novamente todas os Comprovantes
     * não Fiscais cadastrados
     * <br><b>NOTA:</b> Esse método não traz o contadorDoDia no item
     *
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
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
                for (ComprovanteNaoFiscal compro : getComprovantesNaoFiscais()) {
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
     * Retorna Total de cada comprovante não fiscal (CNF) cadastrados no ECF.
     * Onde:<br>
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
     * Retorna informações sobre o Comprovante não Fiscal a ser procurado
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
