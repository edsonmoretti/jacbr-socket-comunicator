/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

/**
 *
 * @author DANIEL
 */
public class NFRef extends MembroList {

    private final String Tipo;
    private final String refNFe;
    private final String cUF;
    private final String AAMM;
    private final String CNPJ;
    private final String mod;
    private final String Serie;
    private final String nNF;
    private final String CNPJCPF;
    private final String IE;
    private final String refCTe;
    private final String ModECF;
    private final String nECF;
    private final String nCOO;

    public NFRef(String Tipo, String refNFe, String cUF, String AAMM, String CNPJ, String mod, String Serie, String nNF, String CNPJCPF, String IE, String refCTe, String ModECF, String nECF, String nCOO) {
        this.Tipo = Tipo;
        this.refNFe = refNFe;
        this.cUF = cUF;
        this.AAMM = AAMM;
        this.CNPJ = CNPJ;
        this.mod = mod;
        this.Serie = Serie;
        this.nNF = nNF;
        this.CNPJCPF = CNPJCPF;
        this.IE = IE;
        this.refCTe = refCTe;
        this.ModECF = ModECF;
        this.nECF = nECF;
        this.nCOO = nCOO;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getRefNFe() {
        return refNFe;
    }

    public String getcUF() {
        return cUF;
    }

    public String getAAMM() {
        return AAMM;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getMod() {
        return mod;
    }

    public String getSerie() {
        return Serie;
    }

    public String getnNF() {
        return nNF;
    }

    public String getCNPJCPF() {
        return CNPJCPF;
    }

    public String getIE() {
        return IE;
    }

    public String getRefCTe() {
        return refCTe;
    }

    public String getModECF() {
        return ModECF;
    }

    public String getnECF() {
        return nECF;
    }

    public String getnCOO() {
        return nCOO;
    }

    @Override
    public String toString() {
        return "[NFRef" + super.getInd() + "]\n"
                + "Tipo=" + Tipo + "\n"
                + "refNFe=" + refNFe + "\n"
                + "cUF=" + cUF + "\n"
                + "AAMM=" + AAMM + "\n"
                + "CNPJ=" + CNPJ + "\n"
                + "mod=" + mod + "\n"
                + "Serie=" + Serie + "\n"
                + "nNF=" + nNF + "\n"
                + "CNPJCPF=" + CNPJCPF + "\n"
                + "IE=" + IE + "\n"
                + "refCTe=" + refCTe + "\n"
                + "ModECF=" + ModECF + "\n"
                + "nECF=" + nECF + "\n"
                + "nCOO=" + nCOO + "\n";
    }

}
