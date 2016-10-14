/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.CodigoTipo;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;

/**
 *
 * @author Edson
 */
public class ProdutoReducaoZ {

    private String descricao;
    private String codigo;
    private CodigoTipo codigoTipo;
    private BigDecimal quantidade;
    private String unidade;
    private BigDecimal valorUnitario;

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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
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

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "<Produto>\n"
                + "                                <Descricao>" + descricao + "</Descricao>\n"
                + "                                <Codigo>" + codigo + "</Codigo>\n"
                + "                                <CodigoTipo>" + codigoTipo + "</CodigoTipo>\n"
                + "                                <Quantidade>" + Numeros.fmtBig(quantidade, 2) + "</Quantidade>\n"
                + "                                <Unidade>" + unidade + "</Unidade>\n"
                + "                                <ValorUnitario>" + Numeros.fmtBig(valorUnitario, 2) + "</ValorUnitario>\n"
                + "                            </Produto>";
    }

}
