/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.aac;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrAACException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Edson
 */
public class ArquivosAutenticados {

    private final String tipoDeRegistro = "N9";
    private File arquivoQueContemAListaDeArquivosAutenticados = new File("ArquivoMD5.txt");
    private final EmpresaDesenvolvedora empresaDesenvolvedora;
    private final IdentificacaoDoPAF identificacaoDoPAF;
    private final RelacaoDosArquivos relacaoDosArquivos;

    public ArquivosAutenticados() {
        this.empresaDesenvolvedora = new EmpresaDesenvolvedora();
        this.identificacaoDoPAF = new IdentificacaoDoPAF();
        this.relacaoDosArquivos = new RelacaoDosArquivos();
    }

    public EmpresaDesenvolvedora getEmpresaDesenvolvedora() {
        return empresaDesenvolvedora;
    }

    public IdentificacaoDoPAF getIdentificacaoDoPAF() {
        return identificacaoDoPAF;
    }

    public RelacaoDosArquivos getRelacaoDosArquivos() {
        return relacaoDosArquivos;
    }

    public File getArquivoQueContemAListaDeArquivosAutenticados() {
        return arquivoQueContemAListaDeArquivosAutenticados;
    }

    public void setArquivoQueContemAListaDeArquivosAutenticados(File arquivoQueContemAListaDeArquivosAutenticados) {
        this.arquivoQueContemAListaDeArquivosAutenticados = arquivoQueContemAListaDeArquivosAutenticados;
    }

    /**
     * OBS: A Assinatura deve ser feita por fora. Ainda não está disponível.
     * Estamos usando o jACBrFramework para assinar em nossa aplicação.
     *
     * @throws ACBrAACException
     */
    public void salvarArquivo() throws ACBrAACException {
        try {
            if (!arquivoQueContemAListaDeArquivosAutenticados.exists()) {
                arquivoQueContemAListaDeArquivosAutenticados.createNewFile();
            }
            PrintWriter pw = new PrintWriter(arquivoQueContemAListaDeArquivosAutenticados);
            pw.print(this);
            pw.flush();
            pw.close();
            System.err.println("OBS: A assinatura EAD do arquivo deve ser feita de forma manual. Ainda não está implementado.");
        } catch (IOException ex) {
            throw new ACBrAACException(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return empresaDesenvolvedora + "\n"
                + identificacaoDoPAF + "\n"
                + relacaoDosArquivos + "\n"
                + TextUtils.formatoACBrX(tipoDeRegistro, 2)
                + TextUtils.formatoACBrN(empresaDesenvolvedora.getCnpj(), 14)
                + TextUtils.formatoACBrX(empresaDesenvolvedora.getInscricaoEstadual(), 14)
                + TextUtils.formatoACBrN(relacaoDosArquivos.size() + "", 6);
    }
}
