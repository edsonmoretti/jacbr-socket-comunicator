/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.produto.DI;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.produto.NVE;

/**
 *
 * @author DANIEL
 */
public class Produto extends MembroList {

    private final String cProd;
    private final String cEAN;
    private final String xProd;
    private final String NCM;
    private final String EXTIPI;
    private final String CFOP;
    private final String uCom;
    private final String qCom;
    private final String vUnCom;
    private final String vProd;
    private final String cEANTrib;
    private final String uTrib;
    private final String qTrib;
    private final String vUnTrib;
    private final String vFrete;
    private final String vSeg;
    private final String vDesc;
    private final String vOutro;
    private final String indTot;
    private final String xPed;
    private final String nItemPed;
    private final String nFCI;
    private final String nRECOPI;
    private final String pDevol;
    private final String vIPIDevol;
    private final String vTotTrib;
    private final String infAdProd;
    private final ListVO<NVE> list_NVE;
    private final ListVO<DI> list_DI;

    public Produto(String cProd, String cEAN, String xProd, String NCM, String EXTIPI, String CFOP, String uCom, String qCom, String vUnCom, String vProd, String cEANTrib, String uTrib, String qTrib, String vUnTrib, String vFrete, String vSeg, String vDesc, String vOutro, String indTot, String xPed, String nItemPed, String nFCI, String nRECOPI, String pDevol, String vIPIDevol, String vTotTrib, String infAdProd) {
        this.cProd = cProd;
        this.cEAN = cEAN;
        this.xProd = xProd;
        this.NCM = NCM;
        this.EXTIPI = EXTIPI;
        this.CFOP = CFOP;
        this.uCom = uCom;
        this.qCom = qCom;
        this.vUnCom = vUnCom;
        this.vProd = vProd;
        this.cEANTrib = cEANTrib;
        this.uTrib = uTrib;
        this.qTrib = qTrib;
        this.vUnTrib = vUnTrib;
        this.vFrete = vFrete;
        this.vSeg = vSeg;
        this.vDesc = vDesc;
        this.vOutro = vOutro;
        this.indTot = indTot;
        this.xPed = xPed;
        this.nItemPed = nItemPed;
        this.nFCI = nFCI;
        this.nRECOPI = nRECOPI;
        this.pDevol = pDevol;
        this.vIPIDevol = vIPIDevol;
        this.vTotTrib = vTotTrib;
        this.infAdProd = infAdProd;
        this.list_NVE = new ListVO<>();
        this.list_DI = new ListVO<>();
    }

    public String getcProd() {
        return cProd;
    }

    public String getcEAN() {
        return cEAN;
    }

    public String getxProd() {
        return xProd;
    }

    public String getNCM() {
        return NCM;
    }

    public String getEXTIPI() {
        return EXTIPI;
    }

    public String getCFOP() {
        return CFOP;
    }

    public String getuCom() {
        return uCom;
    }

    public String getqCom() {
        return qCom;
    }

    public String getvUnCom() {
        return vUnCom;
    }

    public String getvProd() {
        return vProd;
    }

    public String getcEANTrib() {
        return cEANTrib;
    }

    public String getuTrib() {
        return uTrib;
    }

    public String getqTrib() {
        return qTrib;
    }

    public String getvUnTrib() {
        return vUnTrib;
    }

    public String getvFrete() {
        return vFrete;
    }

    public String getvSeg() {
        return vSeg;
    }

    public String getvDesc() {
        return vDesc;
    }

    public String getvOutro() {
        return vOutro;
    }

    public String getIndTot() {
        return indTot;
    }

    public String getxPed() {
        return xPed;
    }

    public String getnItemPed() {
        return nItemPed;
    }

    public String getnFCI() {
        return nFCI;
    }

    public String getnRECOPI() {
        return nRECOPI;
    }

    public String getpDevol() {
        return pDevol;
    }

    public String getvIPIDevol() {
        return vIPIDevol;
    }

    public String getvTotTrib() {
        return vTotTrib;
    }

    public String getInfAdProd() {
        return infAdProd;
    }

    /**
     * NOMENCLATURA DE VALOR ADUANEIRO E ESTATÍSTICA - NVE
     *
     * @param indice
     * @return NVE
     */
    public NVE getNVE(int indice) {
        return list_NVE.get(indice);
    }

    public Produto addNVE(NVE NVE) {
        NVE.setInd_PAI(this.getInd());
        list_NVE.add(NVE);
        return this;
    }

    /**
     * Declaração de importação - DI
     *
     * @param indice
     * @return DI
     */
    public DI getDI(int indice) {
        return list_DI.get(indice);
    }

    public Produto addDI(DI DI) {
        DI.setInd_PAI(this.getInd());
        list_DI.add(DI);
        return this;
    }

    @Override
    public String toString() {
        return "[Produto" + super.getInd() + "]\n"
                + "cProd=" + cProd + "\n"
                + "cEAN=" + cEAN + "\n"
                + "xProd=" + xProd + "\n"
                + "NCM=" + NCM + "\n"
                + "EXTIPI=" + EXTIPI + "\n"
                + "CFOP=" + CFOP + "\n"
                + "uCom=" + uCom + "\n"
                + "qCom=" + qCom + "\n"
                + "vUnCom=" + vUnCom + "\n"
                + "vProd=" + vProd + "\n"
                + "cEANTrib=" + cEANTrib + "\n"
                + "uTrib=" + uTrib + "\n"
                + "qTrib=" + qTrib + "\n"
                + "vUnTrib=" + vUnTrib + "\n"
                + "vFrete=" + vFrete + "\n"
                + "vSeg=" + vSeg + "\n"
                + "vDesc=" + vDesc + "\n"
                + "vOutro=" + vOutro + "\n"
                + "indTot=" + indTot + "\n"
                + "xPed=" + xPed + "\n"
                + "nItemPed=" + nItemPed + "\n"
                + "nFCI=" + nFCI + "\n"
                + "nRECOPI=" + nRECOPI + "\n"
                + "pDevol=" + pDevol + "\n"
                + "vIPIDevol=" + vIPIDevol + "\n"
                + "vTotTrib=" + vTotTrib + "\n"
                + "infAdProd=" + infAdProd + "\n"
                + list_NVE.toString()
                + list_DI.toString();
    }

}
