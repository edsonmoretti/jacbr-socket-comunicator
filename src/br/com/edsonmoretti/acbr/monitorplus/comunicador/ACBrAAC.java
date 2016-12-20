/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ArquivoCriptografado;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ArquivosAutenticados;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrAACException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.File;
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
    private String MD5Principal;

    public ACBrAAC() {
        this.arquivosAutenticados = new ArquivosAutenticados();
        this.arquivoCriptografado = new ArquivoCriptografado();
    }

    public ArquivosAutenticados getArquivosAutenticados() {
        return arquivosAutenticados;
    }

    public ArquivoCriptografado getArquivoCriptografado() {
        try {
            if (arquivoCriptografado.getMD5Principal() == null || arquivoCriptografado.getMD5Principal().isEmpty()) {
                setMD5Principal(MD5Principal == null || MD5Principal.isEmpty() //se não foi setado manualmente o MD5, ele gera do arquivo.
                        ? this.getArquivosAutenticados().getArquivoQueContemAListaDeArquivosAutenticados().exists()
                        ? TextUtils.MD5File(this.getArquivosAutenticados().getArquivoQueContemAListaDeArquivosAutenticados())
                        : ""
                        : MD5Principal);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivoCriptografado;
    }

    public String getMD5Principal() {
        return MD5Principal;
    }

    public void setMD5Principal(String MD5Principal) {
        this.MD5Principal = MD5Principal;
        arquivoCriptografado.setMD5Principal(MD5Principal);
    }

    public void imprimirIdentificacaoDoPaf(ACBrECF ecf, int indiceRel) throws ACBrAACException {
        try {
            ecf.getRelatorios().getRelatorioGerencial().abreRelatorioGerencial(indiceRel);
            if (indiceRel == 1 || indiceRel == 0) {
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>IDENTIFICACAO DO PAF-ECF</n>");
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            }
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>N. LAUDO</n>........: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getLaudoDoPafEcf());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            ecf.getRelatorios().pulaLinha();
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>EMPRESA DESENVOLVEDORA</n>");
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>CNPJ</n>............: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getCnpj());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>RAZAO SOCIAL</n>....: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getRazaoSocial());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>ENDERECO</n>........: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getEnderecoCompleto());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>TELEFONE</n>........: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getTelefone());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>CONTATO</n>.........: " + this.getArquivosAutenticados().getEmpresaDesenvolvedora().getContato());
            ecf.getRelatorios().pulaLinha();
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>IDENTIFICACAO DO PAF-ECF</n>");
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>NOME COMERCIAL</n>..: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getNomeDoPafEcf());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>VERSAO SW</n>.......: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getVersaoDoPafEcf());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>PRICIPAL EXE</n>....: " + this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel().getName());
            if (this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel().exists()) {
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>MD5 DO PRICIPAL EXE</n>:\n        " + TextUtils.MD5File(this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel()));
            }
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>NOME DO ARQUIVO AAC.</n>:\n        " + this.getArquivosAutenticados().getArquivoQueContemAListaDeArquivosAutenticados().getName());
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>MD-5 LISTA AAC</n>..:\n        " + ((MD5Principal == null || MD5Principal.isEmpty()) /*se não foi setado manualmente o MD5, ele gera do arquivo.          */ ? MD5Principal = TextUtils.MD5File(this.getArquivosAutenticados().getArquivoQueContemAListaDeArquivosAutenticados()) : MD5Principal));
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>VERSAO DA ER</n>..: 02.04");
            ecf.getRelatorios().pulaLinha();
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>RELACAO DE ARQUIVOS UTILIZADOS E RESPECTIVOS MD-5</n>\n");
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            if (this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel().exists()) {
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>" + this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel().getName() + "</n>\n" + TextUtils.MD5File(this.getArquivosAutenticados().getIdentificacaoDoPAF().getPrincipalExecutavel()));
            }
            for (File arqAut : this.getArquivosAutenticados().getRelacaoDosArquivos()) {
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>" + arqAut.getName() + "</n>\n" + TextUtils.MD5File(arqAut));
            }

            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial("<n>RELACAO DE NUMERO DE FABRICACAO DOS ECF</n>");
            ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(TextUtils.repete("=", 48));
            for (ECF ecf1 : this.getArquivoCriptografado().getEcfs()) {
                ecf.getRelatorios().getRelatorioGerencial().linhaRelatorioGerencial(String.format("%03d", ecf1.getNumCaixa()) + " - " + ecf1.getSerieEcf());
            }
            ecf.getRelatorios().pulaLinha();
            ecf.getRelatorios().fechaRelatorio();
        } catch (ACBrECFException ex) {
            throw new ACBrAACException(ex.getMessage());
        } catch (NoSuchAlgorithmException | FileNotFoundException ex) {
            Logger.getLogger(ACBrAAC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
