/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.aac;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edson
 */
public class RelacaoDosArquivos extends ArrayList<File> {

    private final String tipoDeRegistro = "N3";

    public String getTipoDeRegistro() {
        return tipoDeRegistro;
    }

    @Override
    public String toString() {
        String tmp = "";
        for (File f : this) {
            try {
                tmp += TextUtils.formatoACBrX(tipoDeRegistro, 2)
                        + TextUtils.formatoACBrX(f.getName(), 50)
                        + TextUtils.formatoACBrX(TextUtils.MD5File(f), 32) + "\n";
            } catch (NoSuchAlgorithmException | FileNotFoundException ex) {
                Logger.getLogger(RelacaoDosArquivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tmp.isEmpty() ? "" : tmp.substring(0, tmp.length() - 1);
    }
}
