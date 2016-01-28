/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.ComprovantesNaoFiscais;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.FormasDePagamento;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.Equipamento;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.MapaResumo;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.RelatoriosGerenciais;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.variaveis.Aliquotas;
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;

/**
 *
 * @author Edson
 */
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

    /**
     * Retorna todas Unidades de Medida Cadastradas na ECF.<br>
     * IIIIDDDD|IIIIDDDD|IIIIDDDD|....<br>
     *
     * Onde:
     * <br>
     * I = índice da unidade de medida usada pelo ACBrECF
     * <br>
     * D = Descrição da unidade de medida<br>
     * <b>Nota:</b> Esse comando quando executado a primeira vez, se comunica
     * com o ECF a fim de carregar a tabela de Unidades de medida. Após a carga,
     * elas são transferidas para a memória do ACBrECF<br>
     *
     * @return
     * @throws ACBrECFException
     */
    public String unidadesMedida() throws ACBrECFException {
        return comandoECF("UnidadesMedida");
    }

    /**
     * Retorna todas Unidades de Medida Cadastradas na ECF.<br>
     * Semelhante ao comando ECF.UnidadesMedidas, porém esse comando sempre se
     * comunica com o ECF a fim de ler novamente todas as Unidades de Medidas
     * cadastradas.
     *
     * @return
     * @throws ACBrECFException
     */
    public String carregaUnidadesMedida() throws ACBrECFException {
        return comandoECF("CarregaUnidadesMedida");
    }
}
