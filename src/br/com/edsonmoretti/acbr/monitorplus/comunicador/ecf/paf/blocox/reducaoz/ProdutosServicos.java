/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edson
 */
public class ProdutosServicos {

    private final List<ProdutoReducaoZ> produtos = new ArrayList<>();
    private final List<ServicoReducaoZ> servicos = new ArrayList<>();

    public List<ProdutoReducaoZ> getProdutos() {
        return produtos;
    }

    public List<ServicoReducaoZ> getServicos() {
        return servicos;
    }

    @Override
    public String toString() {
        String xml = "<ProdutosServicos>\n";
        for (ProdutoReducaoZ produto : produtos) {
            xml += produto.toString() + "\n";
        }
        for (ServicoReducaoZ servico : servicos) {
            xml += servico.toString() + "\n";
        }
        xml += "</ProdutosServicos>";
        return xml;
    }

}
