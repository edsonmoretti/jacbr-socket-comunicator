package br.com.edsonmoretti.acbr.monitorplus.comunicador.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class TextUtils {

    public static String lerTagIni(String ler, String deOnde) {
        ler = ler.toLowerCase() + "=";
        deOnde = deOnde + "\n";
        int index = deOnde.indexOf(ler);
        String temp = deOnde.substring(index + ler.length());
        String retorno = "";
        int i = 0;
        if (index > -1) {
            while (temp.charAt(i) != '\n') {
                retorno += temp.charAt(i++);
            }
        }
        return retorno.trim().replace("\r", "");
    }
}
