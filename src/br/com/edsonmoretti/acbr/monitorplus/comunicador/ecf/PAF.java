/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrUtils;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.LMFC;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.LMFS;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.MFD;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.io.File;
import java.util.Date;

/**
 *
 * @author Edson
 */
public class PAF {

    private LMFC lmfc;
    private LMFS lmfs;
    private MFD mfd;

    /**
     * Impressão de uma Leitura X.<br>
     * <b>Nota:</b> em alguns estados, é necessário imprimir uma Leitura X todo
     * inicio de dia e cada inicio de Bobina
     *
     * @throws ACBrECFException
     */
    public void lx() throws ACBrECFException {
        ACBrECF.comandoECF("PafMF_LX_Impressao");
    }

    /**
     * Gera o CAT52 por período de data.
     *
     * @param dataInicial Data Inicial. (dd/mm/aaaa)
     * @param dataFinal Data final. (dd/mm/aaaa)
     * @param dirArquivos Diretório onde será gerado o arquivo CAT52.
     * @throws ACBrECFException
     */
    public void cat52(Date dataInicial, Date dataFinal, String dirArquivos) throws ACBrECFException {
        ACBrECF.comandoECF("PafMF_LX_Impressao(" + ACBrUtils.formatDataBR(dataInicial) + "," + ACBrUtils.formatDataBR(dataFinal) + "," + dirArquivos + ")");
    }

    /**
     * Essa função retornará dois arquivos, um binário e um outro arquivo texto
     * com a assintatura EAD.
     *
     * @param arquivo Nome do arquivo binário a ser assinado.
     * @throws ACBrECFException
     */
    public void arqMF(File arquivo) throws ACBrECFException {
        ACBrECF.comandoECF("PafMF_ArqMF(\"" + arquivo.getAbsolutePath() + "\")");
    }

    /**
     * Essa função retornará dois arquivos, um binário e um outro arquivo texto
     * com a assintatura EAD.
     *
     * @param arquivo Nome do arquivo binário a ser assinado.
     * @throws ACBrECFException
     */
    public void arqMF(String arquivo) throws ACBrECFException {
        arqMF(new File(arquivo));
    }

    /**
     * Essa função retornará dois arquivos, um binário e um outro arquivo texto
     * com a assintatura EAD.
     *
     * @param arquivo Nome do arquivo binário a ser assinado.
     * @throws ACBrECFException
     */
    public void arqMFD(File arquivo) throws ACBrECFException {
        ACBrECF.comandoECF("PafMF_ArqMFD(\"" + arquivo.getAbsolutePath() + "\")");
    }

    /**
     * Essa função retornará dois arquivos, um binário e um outro arquivo texto
     * com a assintatura EAD.
     *
     * @param arquivo Nome do arquivo binário a ser assinado.
     * @throws ACBrECFException
     */
    public void arqMFD(String arquivo) throws ACBrECFException {
        arqMFD(new File(arquivo));
    }

    public void EAD() throws ACBrECFException {
        ACBrECF.comandoECF("EAD");
    }

    public LMFC getLmfc() {
        return lmfc == null ? lmfc = new LMFC() : lmfc;
    }

    public LMFS getLmfs() {
        return lmfs == null ? lmfs = new LMFS() : lmfs;
    }

    public MFD getMfd() {
        return mfd == null ? mfd = new MFD() : mfd;
    }

}
