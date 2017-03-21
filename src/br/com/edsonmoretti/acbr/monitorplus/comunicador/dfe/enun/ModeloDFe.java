/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.dfe.enun;

/**
 *
 * @author Edson
 */
public enum ModeloDFe {

    /**
     * Modelo 55
     */
    NFe(55),
    /**
     * Modelo 65
     */
    NFCe(65),
    /**
     * Modelo 55
     *
     * @deprecated
     */
    NFe_55("55"),
    /**
     * Modelo 65
     *
     * @deprecated
     */
    NFCe_65("65");

    private final Integer modelo;

    ModeloDFe(int modelo) {
        this.modelo = modelo;
    }

    /**
     * @deprecated @param modelo
     */
    ModeloDFe(String modelo) {
        this.modelo = Integer.parseInt(modelo);
    }

    @Override
    public String toString() {
        return modelo.toString();
    }

    public static ModeloDFe valueOf(int codigo) {
        for (ModeloDFe value : ModeloDFe.values()) {
            if (codigo == value.modelo) {
                return value;
            }
        }
        return null;
    }
}
