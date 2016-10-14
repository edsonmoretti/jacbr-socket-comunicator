
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.CodigoTipo;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.IAT;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.IPPT;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.SITUACAO_ESTOQUE;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.BlocoX.SITUACAO_TRIBUTARIA;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.estoque.ProdutoEstoque;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz.ProdutoReducaoZ;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz.ServicoReducaoZ;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz.TotalizadorParcial;
import java.math.BigDecimal;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson
 */
public class TesteBlocoX {

    public static void main(String[] args) {
        BlocoX x = new BlocoX();

        x.getDadosEstoque().setDataReferenciaFinal(new Date());
        x.getDadosEstoque().setDataReferenciaInicial(new Date());

        //dados paf-ecf
        x.setCnpjEmpresaDesenvolvedora("10493367000148");
        x.setRazaoSocialEmpresarialDesenvolvedora("geraldo joao");
        x.setVersaoDoPafEcf("2.04");
        x.setNumeroDoCredenciamentoPafEcf("3216546");
        x.setNomeDoPafEcf("GTECH-PAF++");

        //dados empresa
        x.setCnpjEstabelecimento("10493367000148");
        x.setInscricaoEstadualEstabelecimento("123458798");
        x.setRazaoSocialEstabelecimento("razao social esta");

        ProdutoEstoque p = new ProdutoEstoque();
        p.setAliquota(BigDecimal.ZERO);
        p.setCodigo("12456789");
        p.setCodigoTipo(CodigoTipo.GTIN);
        p.setDescricao("descricao");
        p.setIat(IAT.TRUNCA);
        p.setIppt(IPPT.Proprio);
        p.setQuantidade(BigDecimal.ONE);
        p.setSituacaoEstoque(SITUACAO_ESTOQUE.Positivo);
        p.setSituacaoTributaria(SITUACAO_TRIBUTARIA.Substituicao_tributaria);
        p.setUnidade("und");
        p.setValorUnitario(BigDecimal.TEN);

        ProdutoEstoque p2 = new ProdutoEstoque();
        p2.setAliquota(BigDecimal.ZERO);
        p2.setCodigo("12456789");
        p2.setCodigoTipo(CodigoTipo.GTIN);
        p2.setDescricao("descricao");
        p2.setIat(IAT.TRUNCA);
        p2.setIppt(IPPT.Proprio);
        p2.setQuantidade(BigDecimal.ONE);
        p2.setSituacaoEstoque(SITUACAO_ESTOQUE.Positivo);
        p2.setSituacaoTributaria(SITUACAO_TRIBUTARIA.Substituicao_tributaria);
        p2.setUnidade("und");
        p2.setValorUnitario(BigDecimal.TEN);
        x.getDadosEstoque().getProdutos().add(p);
        x.getDadosEstoque().getProdutos().add(p2);

        System.out.println("####### XML ESTOQUE #########");
        System.out.println(x.getXMLEstoque());

        System.out.println("####### XML Dados Z #########");
        x.getDadosDaReducaoZ().setCOO("0");
        x.getDadosDaReducaoZ().setCRO("1");
        x.getDadosDaReducaoZ().setCRZ("2");
        x.getDadosDaReducaoZ().setCaixa("001");
        x.getDadosDaReducaoZ().setDataReferencia(new Date());
        x.getDadosDaReducaoZ().setGT(BigDecimal.ONE);
        x.getDadosDaReducaoZ().setMarcaECF("Daruma");
        x.getDadosDaReducaoZ().setModeloECF("FS700");
        x.getDadosDaReducaoZ().setNumeroFabricacaoECF("DR00154s4f65466654654");
        x.getDadosDaReducaoZ().setTipoECF("ECF-IF");

        for (int i = 0; i < 2; i++) {
            TotalizadorParcial tp = new TotalizadorParcial();
            tp.setNome("F");
            tp.setValor(BigDecimal.ONE);
            for (int j = 0; j < 2; j++) {
                ServicoReducaoZ s = new ServicoReducaoZ();
                s.setCodigo("123");
                s.setCodigoTipo(CodigoTipo.GTIN);
                s.setDescricao("descricao");
                s.setQuantidade(BigDecimal.ONE);
                s.setUnidade("UND");
                s.setValorUnitario(BigDecimal.TEN);
                ProdutoReducaoZ pro = s;
                tp.getProdutosServicos().getProdutos().add(pro);
                tp.getProdutosServicos().getServicos().add(s);
            }
            x.getDadosDaReducaoZ().getTotalizadoresParciais().add(tp);
        }
        x.getDadosDaReducaoZ().setVendaBrutaDiaria(BigDecimal.TEN);
        x.getDadosDaReducaoZ().setVersaoECF("1.01");

        System.out.println(x.getXMLDadozDaReducaoZ());
    }
}
