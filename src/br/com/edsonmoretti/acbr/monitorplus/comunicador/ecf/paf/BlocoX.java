/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.estoque.DadosEstoque;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz.DadosDaReducaoZ;

/**
 *
 * @author Edson
 */
public class BlocoX {

    public enum SITUACAO_TRIBUTARIA {
        Isento("Isento"),
        Nao_tributado("Nao tributado"),
        Substituicao_tributaria("Substituicao tributaria"),
        Tributado_pelo_ICMS("Tributado pelo ICMS"),
        Tributado_pelo_ISSQN("Tributado pelo ISSQN");

        String codigo;

        private SITUACAO_TRIBUTARIA(String c) {
            this.codigo = c;
        }

        @Override
        public String toString() {
            return codigo;
        }
    }

    public enum IAT {
        TRUNCA(false), ARREDONDA(true);

        boolean arredonda;

        private IAT(boolean b) {
            arredonda = b;
        }

        public String isArredonda() {
            return arredonda ? "true" : "false";
        }

        @Override
        public String toString() {
            return isArredonda();
        }
    }

    public enum CodigoTipo {
        GTIN("GTIN"),
        EAN("EAD");

        String codigo;

        private CodigoTipo(String c) {
            codigo = c;
        }

        @Override
        public String toString() {
            return codigo;
        }
    }

    public enum IPPT {
        Proprio("Proprio"),
        Terceiros("Terceiros");

        String codigo;

        private IPPT(String c) {
            codigo = c;
        }

        @Override
        public String toString() {
            return codigo;
        }
    }

    public enum SITUACAO_ESTOQUE {

        Positivo("Positivo"),
        Negativo("Negativo");

        String codigo;

        private SITUACAO_ESTOQUE(String cod) {
            codigo = cod;
        }

        @Override
        public String toString() {
            return codigo;
        }
    }
    private final DadosEstoque dadosEstoque = new DadosEstoque();
    private final DadosDaReducaoZ dadosDaReducaoZ = new DadosDaReducaoZ();
    private String inscricaoEstadualEstabelecimento = "";
    private String cnpjEstabelecimento = "";
    private String razaoSocialEstabelecimento = "";
    private String numeroDoCredenciamentoPafEcf = "";
    private String nomeDoPafEcf = "";
    private String versaoDoPafEcf = "";
    private String cnpjEmpresaDesenvolvedora = "";
    private String razaoSocialEmpresarialDesenvolvedora = "";

    public String getXMLDadozDaReducaoZ() {
        return dadosEstoque.toString().replace("_IE_", inscricaoEstadualEstabelecimento)
                .replace("_CNPJ_", cnpjEstabelecimento)
                .replace("_RAZAO_SOCIAL_", razaoSocialEstabelecimento)
                .replace("_NUMERO_CREDENCIAMENTO_", numeroDoCredenciamentoPafEcf)
                .replace("_NOME_PAF_", nomeDoPafEcf)
                .replace("_VERSAO_", versaoDoPafEcf)
                .replace("_CNPJSH_", cnpjEmpresaDesenvolvedora)
                .replace("_RAZAOSOCIAL_SH_", razaoSocialEmpresarialDesenvolvedora);
    }

    public String getXMLEstoque() {
        return dadosEstoque.toString().replace("_IE_", inscricaoEstadualEstabelecimento)
                .replace("_CNPJ_", cnpjEstabelecimento)
                .replace("_RAZAO_SOCIAL_", razaoSocialEstabelecimento)
                .replace("_NUMERO_CREDENCIAMENTO_", numeroDoCredenciamentoPafEcf)
                .replace("_NOME_PAF_", nomeDoPafEcf)
                .replace("_VERSAO_", versaoDoPafEcf)
                .replace("_CNPJSH_", cnpjEmpresaDesenvolvedora)
                .replace("_RAZAOSOCIAL_SH_", razaoSocialEmpresarialDesenvolvedora);
    }

    public String getInscricaoEstadualEstabelecimento() {
        return inscricaoEstadualEstabelecimento;
    }

    public void setInscricaoEstadualEstabelecimento(String inscricaoEstadualEstabelecimento) {
        this.inscricaoEstadualEstabelecimento = inscricaoEstadualEstabelecimento;
    }

    public String getCnpjEstabelecimento() {
        return cnpjEstabelecimento;
    }

    public void setCnpjEstabelecimento(String cnpjEstabelecimento) {
        this.cnpjEstabelecimento = cnpjEstabelecimento;
    }

    public String getRazaoSocialEstabelecimento() {
        return razaoSocialEstabelecimento;
    }

    public void setRazaoSocialEstabelecimento(String razaoSocialEstabelecimento) {
        this.razaoSocialEstabelecimento = razaoSocialEstabelecimento;
    }

    public String getNumeroDoCredenciamentoPafEcf() {
        return numeroDoCredenciamentoPafEcf;
    }

    public void setNumeroDoCredenciamentoPafEcf(String numeroDoCredenciamentoPafEcf) {
        this.numeroDoCredenciamentoPafEcf = numeroDoCredenciamentoPafEcf;
    }

    public String getNomeDoPafEcf() {
        return nomeDoPafEcf;
    }

    public void setNomeDoPafEcf(String nomeDoPafEcf) {
        this.nomeDoPafEcf = nomeDoPafEcf;
    }

    public String getVersaoDoPafEcf() {
        return versaoDoPafEcf;
    }

    public void setVersaoDoPafEcf(String versaoDoPafEcf) {
        this.versaoDoPafEcf = versaoDoPafEcf;
    }

    public String getCnpjEmpresaDesenvolvedora() {
        return cnpjEmpresaDesenvolvedora;
    }

    public void setCnpjEmpresaDesenvolvedora(String cnpjEmpresaDesenvolvedora) {
        this.cnpjEmpresaDesenvolvedora = cnpjEmpresaDesenvolvedora;
    }

    public String getRazaoSocialEmpresarialDesenvolvedora() {
        return razaoSocialEmpresarialDesenvolvedora;
    }

    public void setRazaoSocialEmpresarialDesenvolvedora(String razaoSocialEmpresarialDesenvolvedora) {
        this.razaoSocialEmpresarialDesenvolvedora = razaoSocialEmpresarialDesenvolvedora;
    }

    public DadosEstoque getDadosEstoque() {
        return dadosEstoque;
    }

    public DadosDaReducaoZ getDadosDaReducaoZ() {
        return dadosDaReducaoZ;
    }

}
