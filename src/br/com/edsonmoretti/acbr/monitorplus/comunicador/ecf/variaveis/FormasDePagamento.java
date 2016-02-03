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
public class FormasDePagamento {

    /**
     * Retorna todas as Formas de Pagamento Cadastradas na ECF. <br>
     * <b>Nota:</b>
     * Esse comando quando executado a primeira vez, se comunica com o ECF a fim
     * de carregar a tabela de Formas de Pagamento. Após a carga, elas são
     * transferidas para a memória do ACBrECF.
     * <br>
     * <br><b>Nota: </b>Não inclui os totais vendidos.
     *
     * @return List de Objetos de forma de pagamento.
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException
     */
    public List<FormaDePagamento> getFormasPagamento() throws ACBrECFException {
        return formasPgto("FormasPagamento");
    }

    /**
     * Retorna todas as Formas de Pagamento Cadastradas na ECF. <br>
     * Semelhante ao comando ECF.FormasPagamento, porém esse comando sempre se
     * comunica com o ECF a fim de ler novamente todas as Formas de Pagamento
     * cadastradas
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
     * @return List FormaDePagamento acrescido do contadorDoDia vendido pela
     * forma.
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
                for (FormaDePagamento formaDePagamento : getFormasPagamento()) {
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
     * @throws ACBrECFException se não encontrar ou tiver qualquer outro erro de
     * comunicacao com acbr monitor.
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
