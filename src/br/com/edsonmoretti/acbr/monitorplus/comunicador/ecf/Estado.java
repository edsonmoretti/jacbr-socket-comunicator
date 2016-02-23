/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

/**
 * Tipo de estado de retorno: <br>
 * estNaoInicializada, Porta Serial ainda não foi aberta; <br>
 * estDesconhecido, Porta aberta, mas estado ainda não definido;  <br>
 * estLivre, Impressora Livre, sem nenhum cupom aberto pronta para nova venda,
 * Redução Z e Leitura X ok, pode ou não já ter ocorrido 1ª venda no dia...;
 * <br>
 * estVenda, Cupom de Venda Aberto com ou sem venda do 1º Item;  <br>
 * estPagamento, Iniciado Fechamento de Cupom com Formas Pagamento pode ou não
 * ter efetuado o 1º pagamento. Não pode mais vender itens, ou alterar
 * Sub-total;  <br>
 * estRelatorio, Imprimindo Cupom Fiscal Vinculado ou Relatório Gerencial;
 * <br>
 * estBloqueada, Redução Z já emitida, bloqueada até as 00:00;  <br>
 * estRequerZ, Redução Z do dia anterior ainda não foi emitida. Emitir agora;
 * <br>
 * estRequerX, Esta impressora requer Leitura X todo inicio de dia. É necessário
 * imprimir uma Leitura X para poder vender
 *
 * @author Edson
 */
public enum Estado {
    estNaoInicializada, estDesconhecido, estLivre, estVenda, estPagamento, estRelatorio, estBloqueada, estRequerZ, estRequerX, estNaoFiscal
}
