/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ArquivoCriptografado;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ArquivosAutenticados;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrAACException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edson
 */
public class ACBrAAC {

    private final ArquivosAutenticados arquivosAutenticados;
    private final ArquivoCriptografado arquivoCriptografado;

    public ACBrAAC() {
        this.arquivosAutenticados = new ArquivosAutenticados();
        this.arquivoCriptografado = new ArquivoCriptografado();
    }

    public ArquivosAutenticados getArquivosAutenticados() {
        return arquivosAutenticados;
    }

    public ArquivoCriptografado getArquivoCriptografado() {
        return arquivoCriptografado;
    }

    public void imprimirIdentificacaoDoPaf(ACBrECF ecf, int indiceRel) throws ACBrAACException {
        try {
            ecf.getRelatorios().getRelatorioGerencial().abreRelatorioGerencial(indiceRel);
            if (indiceRel == 1 || indiceRel == 0) {
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>IDENTIFICACAO DO PAF-ECF</n>");
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            }
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>N. LAUDO</n>..........: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getLaudoDoPafEcf());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>EMPRESA DESENVOLVEDORA</n>");
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>CNPJ</n>............: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getCnpj());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>RAZAO SOCIAL</n>....: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getRazaoSocial());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>ENDERECO</n>........: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getEnderecoCompleto());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>TELEFONE</n>.......: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getTelefone());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>CONTATO</n>.........: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getContato());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>IDENTIFICAÇÃO DO PAF-ECF</n>");
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>NOME COMERCIAL</n>..: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getNomeDoPafEcf());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>VERSAO</n>..: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getVersaoDoPafEcf());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>PRICIPAL EXECUTAVEL</n>: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel().getName());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>MD-5 LISTA AAC</n>..: " + TextUtils.MD5File(this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel()));
        } catch (ACBrECFException ex) {
            throw new ACBrAACException(ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
