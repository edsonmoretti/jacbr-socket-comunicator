/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;

/**
 *
 * @author Edson
 */
public class TotalizadorParcial {

    private String nome;
    private BigDecimal valor;
    private final ProdutosServicos produtosServicos = new ProdutosServicos();

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ProdutosServicos getProdutosServicos() {
        return produtosServicos;
    }

    @Override
    public String toString() {
        String xml = "<TotalizadorParcial>\n"
                + "                        <Nome>" + nome + "</Nome>\n"
                + "                        <Valor>" + Numeros.fmtBig(valor, 2) + "</Valor>\n"
                //produtos e serviços vai sai assim:
                /*
                <ProdutosServicos>
                            <Produto>
                                <Descricao>Guaraná</Descricao>
                                <Codigo>1234</Codigo>
                                <CodigoTipo>GTIN</CodigoTipo>
                                <Quantidade>30,00</Quantidade>
                                <Unidade>Un</Unidade>
                                <ValorUnitario>310,00</ValorUnitario>
                            </Produto>
                            <Servico>
                                <Descricao>Descricao</Descricao>
                                <Codigo>123456</Codigo>
                                <CodigoTipo>GTIN</CodigoTipo>
                                <Quantidade>12,00</Quantidade>
                                <Unidade>Un</Unidade>
                                <ValorUnitario>1,00</ValorUnitario>
                            </Servico>
                        </ProdutosServicos>
                 */
                + produtosServicos
                + "             </TotalizadorParcial>";
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
