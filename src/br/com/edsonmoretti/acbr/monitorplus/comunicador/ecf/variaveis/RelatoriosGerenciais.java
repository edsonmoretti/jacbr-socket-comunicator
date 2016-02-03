/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.RelatorioGerencial;
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edson
 */
public class RelatoriosGerenciais {

    /**
     * Retorna todas os Relatorios Gerenciais cadastrados na ECF.<br>
     * <b>Nota:</b> Esse comando quando executado a primeira vez, se comunica
     * com o ECF a fim de carregar a tabela de Relatórios Gerenciais. Após a
     * carga, elas são transferidas para a memória do ACBrECF.
     *
     * @return
     * @throws ACBrECFException
     */
    public List<RelatorioGerencial> getRelatoriosGerenciais() throws ACBrECFException {
        return relatoriosGer("RelatoriosGerenciais");
    }

    /**
     * Retorna todas os Relatorios Gerenciais cadastrados na ECF.<br>
     * <b>Nota:</b> Semelhante ao comando ECF.RelatoriosGerencial, porém esse
     * comando sempre se comunica com o ECF a fim de ler novamente todos os
     * Relatórios Gerenciais cadastrados.
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
                for (RelatorioGerencial relatoriosGerenciai : getRelatoriosGerenciais()) {
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
