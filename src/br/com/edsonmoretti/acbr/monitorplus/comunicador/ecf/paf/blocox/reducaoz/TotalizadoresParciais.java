/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.reducaoz;

/**
 *
 * @author Edson
 */
public class TotalizadoresParciais extends java.util.ArrayList<TotalizadorParcial> {

    @Override
    public String toString() {
        String xml = "<TotalizadoresParciais>\n";
        for (TotalizadorParcial thi : this) {
            xml += thi + "\n";
        }
        xml += "                </TotalizadoresParciais>";
        return xml;
    }

}
