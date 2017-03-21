/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun.indTot;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.produto.DI;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.produto.NVE;
import java.math.BigDecimal;

/**
 *
 * @author DANIEL
 */
public class Produto extends MembroList {

    private String cProd;
    private String cEAN;
    private String xProd;
    private String NCM;
    private String EXTIPI;
    private String CFOP;
    private String uCom;
    private BigDecimal qCom;
    private BigDecimal vUnCom;
    private BigDecimal vProd;
    private String cEANTrib;
    private String uTrib;
    private BigDecimal qTrib;
    private BigDecimal vUnTrib;
    private BigDecimal vFrete;
    private BigDecimal vSeg;
    private BigDecimal vDesc;
    private BigDecimal vOutro;
    private indTot indTot;
    private String xPed;
    private String nItemPed;
    private String nFCI;
    private String nRECOPI;
    private BigDecimal pDevol;
    private BigDecimal vIPIDevol;
    private BigDecimal vTotTrib;
    private String infAdProd;
    private ListVO<NVE> list_NVE;
    private ListVO<DI> list_DI;

    public Produto(String cProd, String cEAN, String xProd, String NCM, String EXTIPI, String CFOP, String uCom, BigDecimal qCom, BigDecimal vUnCom, BigDecimal vProd, String cEANTrib, String uTrib, BigDecimal qTrib, BigDecimal vUnTrib, BigDecimal vFrete, BigDecimal vSeg, BigDecimal vDesc, BigDecimal vOutro, indTot indTot, String xPed, String nItemPed, String nFCI, String nRECOPI, BigDecimal pDevol, BigDecimal vIPIDevol, BigDecimal vTotTrib, String infAdProd, ListVO<NVE> list_NVE, ListVO<DI> list_DI) {
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
        this.list_NVE = list_NVE;
        this.list_DI = list_DI;
    }

    public Produto() {
    }

    public String getcProd() {
        return cProd;
    }

    public void setcProd(String cProd) {
        this.cProd = cProd;
    }

    public String getcEAN() {
        return cEAN;
    }

    public void setcEAN(String cEAN) {
        this.cEAN = cEAN;
    }

    public String getxProd() {
        return xProd;
    }

    public void setxProd(String xProd) {
        this.xProd = xProd;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }

    public String getEXTIPI() {
        return EXTIPI;
    }

    public void setEXTIPI(String EXTIPI) {
        this.EXTIPI = EXTIPI;
    }

    public String getCFOP() {
        return CFOP;
    }

    public void setCFOP(String CFOP) {
        this.CFOP = CFOP;
    }

    public String getuCom() {
        return uCom;
    }

    public void setuCom(String uCom) {
        this.uCom = uCom;
    }

    public BigDecimal getqCom() {
        return qCom;
    }

    public void setqCom(BigDecimal qCom) {
        this.qCom = qCom;
    }

    public BigDecimal getvUnCom() {
        return vUnCom;
    }

    public void setvUnCom(BigDecimal vUnCom) {
        this.vUnCom = vUnCom;
    }

    public BigDecimal getvProd() {
        return vProd;
    }

    public void setvProd(BigDecimal vProd) {
        this.vProd = vProd;
    }

    public String getcEANTrib() {
        return cEANTrib;
    }

    public void setcEANTrib(String cEANTrib) {
        this.cEANTrib = cEANTrib;
    }

    public String getuTrib() {
        return uTrib;
    }

    public void setuTrib(String uTrib) {
        this.uTrib = uTrib;
    }

    public BigDecimal getqTrib() {
        return qTrib;
    }

    public void setqTrib(BigDecimal qTrib) {
        this.qTrib = qTrib;
    }

    public BigDecimal getvUnTrib() {
        return vUnTrib;
    }

    public void setvUnTrib(BigDecimal vUnTrib) {
        this.vUnTrib = vUnTrib;
    }

    public BigDecimal getvFrete() {
        return vFrete;
    }

    public void setvFrete(BigDecimal vFrete) {
        this.vFrete = vFrete;
    }

    public BigDecimal getvSeg() {
        return vSeg;
    }

    public void setvSeg(BigDecimal vSeg) {
        this.vSeg = vSeg;
    }

    public BigDecimal getvDesc() {
        return vDesc;
    }

    public void setvDesc(BigDecimal vDesc) {
        this.vDesc = vDesc;
    }

    public BigDecimal getvOutro() {
        return vOutro;
    }

    public void setvOutro(BigDecimal vOutro) {
        this.vOutro = vOutro;
    }

    public indTot getIndTot() {
        return indTot;
    }

    public void setIndTot(indTot indTot) {
        this.indTot = indTot;
    }

    public String getxPed() {
        return xPed;
    }

    public void setxPed(String xPed) {
        this.xPed = xPed;
    }

    public String getnItemPed() {
        return nItemPed;
    }

    public void setnItemPed(String nItemPed) {
        this.nItemPed = nItemPed;
    }

    public String getnFCI() {
        return nFCI;
    }

    public void setnFCI(String nFCI) {
        this.nFCI = nFCI;
    }

    public String getnRECOPI() {
        return nRECOPI;
    }

    public void setnRECOPI(String nRECOPI) {
        this.nRECOPI = nRECOPI;
    }

    public BigDecimal getpDevol() {
        return pDevol;
    }

    public void setpDevol(BigDecimal pDevol) {
        this.pDevol = pDevol;
    }

    public BigDecimal getvIPIDevol() {
        return vIPIDevol;
    }

    public void setvIPIDevol(BigDecimal vIPIDevol) {
        this.vIPIDevol = vIPIDevol;
    }

    public BigDecimal getvTotTrib() {
        return vTotTrib;
    }

    public void setvTotTrib(BigDecimal vTotTrib) {
        this.vTotTrib = vTotTrib;
    }

    public String getInfAdProd() {
        return infAdProd;
    }

    public void setInfAdProd(String infAdProd) {
        this.infAdProd = infAdProd;
    }

    public ListVO<NVE> getList_NVE() {
        return list_NVE;
    }

    public void setList_NVE(ListVO<NVE> list_NVE) {
        this.list_NVE = list_NVE;
    }

    public ListVO<DI> getList_DI() {
        return list_DI;
    }

    public void setList_DI(ListVO<DI> list_DI) {
        this.list_DI = list_DI;
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
                + (list_NVE == null || list_NVE.isEmpty() ? "" : list_NVE).toString()
                + (list_DI == null || list_DI.isEmpty() ? "" : list_DI).toString();
    }

}
