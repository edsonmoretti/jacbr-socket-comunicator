/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Edson
 */
public class Titulo {

    /*
     NumeroDocumento=000010
     NossoNumero=0000001
     Carteira=20
     ValorDocumento=100,50
     Vencimento=10/09/2010
     ValorMoraJuros=0,50
     DataDocumento=10/08/2010
     DataProcessamento=10/08/2010
     DataAbatimento=05/09/2010
     DataDesconto=07/09/2010
     DataMoraJuros=12/09/2010
     DataProtesto=10/10/2010
     ValorAbatimento=5,00
     ValorDesconto=0,50
     ValorIOF=3,50
     ValorOutrasDespesas=2,50
     PercentualMulta=05,00
     LocalPagamento=Pagável em qualquer agência bancária mesmo após o vencimento
     Especie=DM
     EspecieMod=R$
     Sacado.NomeSacado=Sacado Teste
     Sacado.CNPJCPF=999.999.999.99
     Sacado.Pessoa=0
     Sacado.Logradouro=Rua Jose Rodrigues
     Sacado.Numero=100
     Sacado.Bairro=Jardim Moderno
     Sacado.Complemento=Casa
     Sacado.Cidade=Tatui
     Sacado.UF=SP
     Sacado.CEP=18277.500
     Sacado.Email=teste@email.com
     Mensagem=teste1|teste2
     Instrucao1=10
     Instrucao2=11
     Aceite=1
     OcorrenciaOriginal=0
     Parcela=1
     TotalParcelas=1
     SeuNumero=000020
     TipoDiasProtesto=1
     TipoImpressao=1
     */
    private String numeroDocumento;
    private String nossoNumero;
    private String carteira;
    private String valorDocumento;
    private String vencimento;
    private String valorMoraJuros;
    private String dataDocumento;
    private String dataProcessamento;
    private String dataAbatimento;
    private String dataDesconto;
    private String dataMoraJuros;
    private String dataProtesto;
    private String valorAbatimento;
    private String valorDesconto;
    private String valorIOF;
    private String valorOutrasDespesas;
    private String percentualMulta;
    private String localPagamento;
    private String especie;
    private String especieMod;

    private Sacado sacado;

    private String mensagem;
    private String instrucao1;
    private String instrucao2;
    private Aceite aceite;
    private OcorrenciaOriginal ocorrenciaOriginal;
    private String parcela;
    private String totalParcelas;
    private String seuNumero;
    private TipoDiasProtesto tipoDiasProtesto;
    private TipoImpressao TipoImpressao;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(String valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getValorMoraJuros() {
        return valorMoraJuros;
    }

    public void setValorMoraJuros(String valorMoraJuros) {
        this.valorMoraJuros = valorMoraJuros;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public String getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(String dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public String getDataAbatimento() {
        return dataAbatimento;
    }

    public void setDataAbatimento(String dataAbatimento) {
        this.dataAbatimento = dataAbatimento;
    }

    public String getDataDesconto() {
        return dataDesconto;
    }

    public void setDataDesconto(String dataDesconto) {
        this.dataDesconto = dataDesconto;
    }

    public String getDataMoraJuros() {
        return dataMoraJuros;
    }

    public void setDataMoraJuros(String dataMoraJuros) {
        this.dataMoraJuros = dataMoraJuros;
    }

    public String getDataProtesto() {
        return dataProtesto;
    }

    public void setDataProtesto(String dataProtesto) {
        this.dataProtesto = dataProtesto;
    }

    public String getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(String valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public String getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(String valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getValorIOF() {
        return valorIOF;
    }

    public void setValorIOF(String valorIOF) {
        this.valorIOF = valorIOF;
    }

    public String getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(String valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public String getPercentualMulta() {
        return percentualMulta;
    }

    public void setPercentualMulta(String percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public String getLocalPagamento() {
        return localPagamento;
    }

    public void setLocalPagamento(String localPagamento) {
        this.localPagamento = localPagamento;
    }

    public String getEspecie() {
        return especie;
    }

    /**
     *
     * @param especie Ex.: Especie=DM
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEspecieMod() {
        return especieMod;
    }

    /**
     *
     * @param especieMod Ex.: EspecieMod=R$
     */
    public void setEspecieMod(String especieMod) {
        this.especieMod = especieMod;
    }

    public Sacado getSacado() {
        return sacado;
    }

    public void setSacado(Sacado sacado) {
        this.sacado = sacado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getInstrucao1() {
        return instrucao1;
    }

    public void setInstrucao1(String instrucao1) {
        this.instrucao1 = instrucao1;
    }

    public String getInstrucao2() {
        return instrucao2;
    }

    public void setInstrucao2(String instrucao2) {
        this.instrucao2 = instrucao2;
    }

    public Aceite getAceite() {
        return aceite;
    }

    public void setAceite(Aceite aceite) {
        this.aceite = aceite;
    }

    public OcorrenciaOriginal getOcorrenciaOriginal() {
        return ocorrenciaOriginal;
    }

    public void setOcorrenciaOriginal(OcorrenciaOriginal ocorrenciaOriginal) {
        this.ocorrenciaOriginal = ocorrenciaOriginal;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public String getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(String totalParcelas) {
        this.totalParcelas = totalParcelas;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public TipoDiasProtesto getTipoDiasProtesto() {
        return tipoDiasProtesto;
    }

    public void setTipoDiasProtesto(TipoDiasProtesto tipoDiasProtesto) {
        this.tipoDiasProtesto = tipoDiasProtesto;
    }

    public TipoImpressao getTipoImpressao() {
        return TipoImpressao;
    }

    public void setTipoImpressao(TipoImpressao TipoImpressao) {
        this.TipoImpressao = TipoImpressao;
    }

    @Override
    public String toString() {
        return "[Titulo]\n"
                + "NumeroDocumento=" + numeroDocumento + "\n"
                + "NossoNumero=" + nossoNumero + "\n"
                + "Carteira=" + carteira + "\n"
                + "ValorDocumento=" + valorDocumento + "\n"
                + "Vencimento=" + vencimento + "\n"
                + "ValorMoraJuros=" + valorMoraJuros + "\n"
                + "DataDocumento=" + dataDocumento + "\n"
                + "DataProcessamento=" + dataProcessamento + "\n"
                + "DataAbatimento=" + dataAbatimento + "\n"
                + "DataDesconto=" + dataDesconto + "\n"
                + "DataMoraJuros=" + dataMoraJuros + "\n"
                + "DataProtesto=" + dataProtesto + "\n"
                + "ValorAbatimento=" + valorAbatimento + "\n"
                + "ValorDesconto=" + valorDesconto + "\n"
                + "ValorIOF=" + valorIOF + "\n"
                + "ValorOutrasDespesas=" + valorOutrasDespesas + "\n"
                + "PercentualMulta=" + percentualMulta + "\n"
                + "LocalPagamento=" + localPagamento + "\n"
                + "Especie=" + especie + "\n"
                + "EspecieMod=" + especieMod + "\n"
                + sacado.toString() + "\n"
                + "Mensagem=" + mensagem + "\n"
                + "Instrucao1=" + instrucao1 + "\n"
                + "Instrucao2=" + instrucao2 + "\n"
                + "Aceite=" + aceite + "\n"
                + "OcorrenciaOriginal=" + ocorrenciaOriginal + "\n"
                + "Parcela=" + parcela + "\n"
                + "TotalParcelas=" + totalParcelas + "\n"
                + "SeuNumero=" + seuNumero + "\n"
                + "TipoDiasProtesto=" + tipoDiasProtesto + "\n"
                + "TipoImpressao=" + TipoImpressao + '}';
    }

}
