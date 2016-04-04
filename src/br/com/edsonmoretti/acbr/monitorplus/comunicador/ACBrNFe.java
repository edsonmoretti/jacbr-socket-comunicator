/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeInvalidaException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.StatusDoServico;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrNFe {

    private static String NFE = "NFE.";

    public ACBrNFe() {
    }

    public static String comandoNFe(String s) throws ACBrNFeException {
        try {
            String retorno = (ACBr.getInstance().comandoAcbr(NFE + s));
            return retorno;
        } catch (ACBrException ex) {
            throw new ACBrNFeException(ex);
        }
    }

    /**
     * Verifica o Status do Serviço dos WebServices da Receita
     *
     * @return String com resultado no formato INI
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException
     *
     */
    public StatusDoServico getStatusServico() throws ACBrNFeException {
        String re = comandoNFe("StatusServico");
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
    }

    /**
     * Valida arquivo da NFe. Arquivo deve estar assinado.
     *
     * @param arquivo Caminho do arquivo a ser validado.
     * @throws ACBrNFeInvalidaException
     */
    public void validarNFe(String arquivo) throws ACBrNFeInvalidaException {
        try {
            comandoNFe("ValidarNFe(\"" + arquivo + "\")");
        } catch (ACBrNFeException ex) {
            throw new ACBrNFeInvalidaException(ex);
        }
    }

    /**
     * Valida arquivo da NFe. Arquivo deve estar assinado.
     *
     * @param arquivo Caminho do arquivo a ser validado.
     * @throws ACBrNFeInvalidaException
     */
    public void validarNFe(File arquivo) throws ACBrNFeInvalidaException {
        try {
            comandoNFe("ValidarNFe(\"" + arquivo + "\")");
        } catch (ACBrNFeException ex) {
            throw new ACBrNFeInvalidaException(ex);
        }
    }

    /**
     * Assina uma NFe. Arquivo assinado será salvo na pasta configurada na aba
     * WebService na opção "Salvar Arquivos de Envio e Resposta".
     *
     * @param arquivo Caminho do arquivo a ser assinado.
     * @throws ACBrNFeException
     */
    public void assinarNFe(String arquivo) throws ACBrNFeException {
        comandoNFe("AssinarNFe(" + arquivo + ")");
    }

    /**
     * Assina uma NFe. Arquivo assinado será salvo na pasta configurada na aba
     * WebService na opção "Salvar Arquivos de Envio e Resposta".
     *
     * @param arquivo Caminho do arquivo a ser assinado.
     * @throws ACBrNFeException
     */
    public void assinarNFe(File arquivo) throws ACBrNFeException {
        comandoNFe("AssinarNFe(" + arquivo + ")");
    }
}
