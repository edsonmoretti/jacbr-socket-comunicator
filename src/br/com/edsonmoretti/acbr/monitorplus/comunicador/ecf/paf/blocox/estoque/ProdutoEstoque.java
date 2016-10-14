package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.estoque;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.CodigoTipo;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.IAT;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.IPPT;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.SITUACAO_ESTOQUE;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.SITUACAO_TRIBUTARIA;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson
 */
public class ProdutoEstoque {

    private String descricao;
    private String codigo;
    private CodigoTipo codigoTipo = CodigoTipo.GTIN;
    private BigDecimal quantidade;
    private String unidade;
    private BigDecimal valorUnitario;
    private SITUACAO_TRIBUTARIA situacaoTributaria;
    private BigDecimal aliquota;
    private IAT iat;
    private IPPT ippt;
    private SITUACAO_ESTOQUE situacaoEstoque;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public CodigoTipo getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(CodigoTipo codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public SITUACAO_TRIBUTARIA getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public void setSituacaoTributaria(SITUACAO_TRIBUTARIA situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public IAT getIat() {
        return iat;
    }

    public void setIat(IAT iat) {
        this.iat = iat;
    }

    public IPPT getIppt() {
        return ippt;
    }

    public void setIppt(IPPT ippt) {
        this.ippt = ippt;
    }

    public SITUACAO_ESTOQUE getSituacaoEstoque() {
        return situacaoEstoque;
    }

    public void setSituacaoEstoque(SITUACAO_ESTOQUE situacaoEstoque) {
        this.situacaoEstoque = situacaoEstoque;
    }

    @Override
    public String toString() {
        //https://www.confaz.fazenda.gov.br/legislacao/despacho/2016/dp154_16
        return "<Produto>\n"
                + "                       <Descricao>" + (descricao.length() < 4000 ? descricao : descricao.substring(0, 3999)) + "</Descricao>\n"
                + "                       <Codigo>" + codigo + "</Codigo>\n"
                + "                       <CodigoTipo>" + codigoTipo + "</CodigoTipo>\n"
                + "                       <Quantidade>" + Numeros.fmtBig(quantidade, 2) + "</Quantidade>\n"
                + "                       <Unidade>" + unidade + "</Unidade>\n"
                + "                       <ValorUnitario>" + Numeros.fmtBig(valorUnitario, 2) + "</ValorUnitario>\n"
                + "                       <SituacaoTributaria>" + situacaoTributaria + "</SituacaoTributaria>\n"
                + "                       <Aliquota>" + Numeros.fmtBig(aliquota, 2) + "</Aliquota>\n"
                + "                       <IsArredondado>" + iat + "</IsArredondado>\n"
                + "                       <Ippt>" + ippt + "</Ippt>\n"
                + "                       <SituacaoEstoque>" + situacaoEstoque + "</SituacaoEstoque>\n"
                + "                </Produto>";
    }

}
