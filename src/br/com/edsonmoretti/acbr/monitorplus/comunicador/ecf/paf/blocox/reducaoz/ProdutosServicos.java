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

    private final List<Produto> produtos = new ArrayList<>();
    private final List<Servico> servicos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    @Override
    public String toString() {
        String xml = "<ProdutosServicos>\n";
        for (Produto produto : produtos) {
            xml += produto.toString() + "\n";
        }
        for (Servico servico : servicos) {
            xml += servico.toString() + "\n";
        }
        xml += "</ProdutosServicos>";
        return xml;
    }

}
