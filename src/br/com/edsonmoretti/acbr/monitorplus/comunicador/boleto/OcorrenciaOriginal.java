/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Junior G3
 */
public enum OcorrenciaOriginal {

    RemessaRegistrar(0),
    RemessaBaixar(1),
    RemessaDebitarEmConta(2),
    RemessaConcederAbatimento(3),
    RemessaCancelarAbatimento(4),
    RemessaConcederDesconto(5),
    RemessaCancelarDesconto(6),
    RemessaAlterarVencimento(7),
    RemessaProtestar(8),
    RemessaSustarProtesto(9),
    RemessaCancelarIntrucaoProtestoBaixa(10),
    RemessaCancelarInstrucaoProtesto(11),
    RemessaDispensarJuros(12),
    RemessaAlterarNomeEnderecoSacado(13),
    RemessaAlterarNumeroControle(14),
    RemessaOutrasOcorrencias(15),
    RemessaAlterarControleParticipante(16),
    RemessaAlterarSeuNumero(17),
    RemessaTransfCessaoCreditoIDProd10(18),
    RemessaTransferenciaCarteira(19),
    RemessaDevTransferenciaCarteira(20),
    RemessaDesagendarDebitoAutomatico(21),
    RemessaAcertarRateioCredito(22),
    RemessaCancelarRateioCredito(23),
    RemessaAlterarUsoEmpresa(24),
    RemessaNaoProtestar(25),
    RemessaProtestoFinsFalimentares(26),
    RemessaBaixaporPagtoDiretoCedente(27),
    RemessaCancelarInstrucao(28),
    RemessaAlterarVencSustarProtesto(29),
    RemessaCedenteDiscordaSacado(30),
    RemessaCedenteSolicitaDispensaJuros(31),
    RemessaOutrasAlteracoes(32),
    RemessaAlterarModalidade(33);

    private final int codigo;

    OcorrenciaOriginal(int cod) {
        this.codigo = cod;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

}
