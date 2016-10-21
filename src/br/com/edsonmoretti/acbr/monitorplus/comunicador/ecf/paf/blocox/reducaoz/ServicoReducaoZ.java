/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;

/**
 *
 * @author Edson
 */
public class ServicoReducaoZ extends ProdutoReducaoZ {

    @Override
    public String toString() {
        return super.toString().replace("<Produto>", "<Servico>").replace("</Produto>", "</Servico>");
//        return "<Servico>\n"
//                + "                                <Descricao>" + getDescricao() + "</Descricao>\n"
//                + "                                <Codigo>" + getCodigo() + "</Codigo>\n"
//                + "                                <CodigoTipo>" + getCodigoTipo() + "</CodigoTipo>\n"
//                + "                                <Quantidade>" + Numeros.fmtBig(getQuantidade(), 2) + "</Quantidade>\n"
//                + "                                <Unidade>" + getUnidade() + "</Unidade>\n"
//                + "                                <ValorUnitario>" + Numeros.fmtBig(getValorUnitario(), 2) + "</ValorUnitario>\n"
//                + "                            </Servico>";
    }

}
