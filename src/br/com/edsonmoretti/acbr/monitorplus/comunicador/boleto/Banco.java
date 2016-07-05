/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Edson
 */
public class Banco {

    private String numero;
    private CNAB cnab;
    private INDICEACBR indiceacbr;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public CNAB getCnab() {
        return cnab;
    }

    public void setCnab(CNAB cnab) {
        this.cnab = cnab;
    }

    public INDICEACBR getIndiceacbr() {
        return indiceacbr;
    }

    public void setIndiceacbr(INDICEACBR indiceacbr) {
        this.indiceacbr = indiceacbr;
    }

    /*
     * [Banco]<br>
     * Numero=237<br>
     * CNAB=1<br>
     * IndiceACBr=5<br><br>
     */
    @Override
    public String toString() {
        return "[Banco]\n"
                + "Numero=" + numero + "\n"
                + "CNAB=" + cnab + "\n"
                + "IndiceACBR=" + indiceacbr + "\n\n";
    }

}
