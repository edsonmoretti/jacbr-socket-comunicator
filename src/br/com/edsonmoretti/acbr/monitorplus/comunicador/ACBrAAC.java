/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ArquivoCriptografado;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.aac.ArquivosAutenticados;

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

}
