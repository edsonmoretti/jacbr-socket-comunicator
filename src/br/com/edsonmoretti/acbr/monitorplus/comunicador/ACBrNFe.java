/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.vo.nfe.StatusDoServico;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrNFe {

    private ACBrNFe() {
    }

    /**
     * Verifica o Status do Serviço dos WebServices da Receita
     *
     * @return String com resultado no formato INI
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException
     *
     */
    public StatusDoServico statusServico() throws ACBrNFeException {
        try {
            String re = ACBr.getInstance().comandoAcbr("NFE.StatusServico");
            StatusDoServico sds = new StatusDoServico();
            sds.setCStat(TextUtils.lerTagIni("CStat", re));
            sds.setCUF(TextUtils.lerTagIni("CUF", re));
            sds.setDhRecbto(TextUtils.lerTagIni("DhRecbto", re));
            sds.setTMed(TextUtils.lerTagIni("TMed", re));
            sds.setTpAmb(TextUtils.lerTagIni("TpAmb", re));
            sds.setVerAplic(TextUtils.lerTagIni("VerAplic", re));
            sds.setVersao(TextUtils.lerTagIni("Versao", re));
            sds.setXMotivo(TextUtils.lerTagIni("XMotivo", re));
            return sds;
        } catch (ACBrException ex) {
            throw new ACBrNFeException(ex.getMessage());
        }
    }

    /**
     * Valida arquivo da NFe. Arquivo deve estar assinado.
     *
     * @param f Caminho do arquivo a ser validado
     * @return
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException
     */
    public String validarNFe(File f) throws ACBrNFeException {
        try {
            return ACBr.getInstance().comandoAcbr("NFE.ValidarNFe(" + f + ")");
        } catch (Exception ex) {
            throw new ACBrNFeException(ex.getMessage());
        }
    }

    //asdfsadf botar o objeto retorno
    public String criarNFe(String cIniNFe, boolean bRetornaXML) throws ACBrNFeException {
        try {
            return ACBr.getInstance().comandoAcbr("NFE.CriarNFe(" + cIniNFe + "," + bRetornaXML + ")");
        } catch (Exception ex) {
            throw new ACBrNFeException(ex.getMessage());
        }
    }

    public static ACBrNFe getInstance() {
        return ACBrNFeHolder.INSTANCE;
    }

    private static class ACBrNFeHolder {

        private static final ACBrNFe INSTANCE = new ACBrNFe();
    }
}
