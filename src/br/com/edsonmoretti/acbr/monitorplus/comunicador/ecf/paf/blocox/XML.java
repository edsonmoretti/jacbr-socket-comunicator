/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Edson
 */
public class XML {

    private final String xml;
    private File ultimoArquivoSalvo;

    public XML(String xml) {
        this.xml = xml;
    }

    @Override
    public String toString() {
        return xml;
    }

    public void salvarXML(String f) throws FileNotFoundException {
        salvarXML(new File(f));
    }

    public void salvarXML(File f) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(f)) {
            pw.print(xml);
        }
        ultimoArquivoSalvo = f;
    }

    public String getXml() {
        return xml;
    }

    public File getUltimoArquivoSalvo() {
        return ultimoArquivoSalvo;
    }

}
