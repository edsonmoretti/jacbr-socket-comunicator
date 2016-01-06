/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 *
 * @author Edson
 */
public class Numeros {

    /**
     *
     * @param obj que pode ser String,Double ou Integer.
     * @return um BigDecimal na Scale(4, RoundingMode.HALF_DOWN)
     * @throws NumberFormatException
     */
    public static BigDecimal parseToBig(Object obj) throws NumberFormatException {
        return parseToBig(obj, 4);
    }

    public static BigDecimal parseToBig(Object obj, int scl) throws NumberFormatException {
        String str;
        if (obj == null) {
            obj = BigDecimal.ZERO;
        }

        if (obj.getClass() == BigDecimal.class) {
            return ((BigDecimal) obj).setScale(scl, RoundingMode.HALF_DOWN);
        } else if (obj.getClass() == String.class) {
            str = (String) obj;
        } else if (obj.getClass() == Double.class) {
            str = ((Double) obj).toString();
        } else if (obj.getClass() == Integer.class) {
            str = ((Integer) obj).toString();
        } else if (obj.getClass() == BigInteger.class) {
            str = ((BigInteger) obj).toString();
        } else if (obj.getClass() == Float.class) {
            str = ((Float) obj).toString();
        } else if (obj.getClass() == JTextField.class) {
            return parseToBig(((JTextField) obj).getText());
        } else if (obj.getClass() == Long.class) {
            return parseToBig(((Long) obj).toString());
        } else {
            throw new NumberFormatException("Tipo de dado inválido.");
        }
        str = str.trim();
        if (str.isEmpty()) {
            str = BigDecimal.ZERO.toString();
        }
        str = (str.contains(",") ? str.replace(".", "").replace(",", ".") : str);
        return new BigDecimal(str).setScale(scl, RoundingMode.HALF_DOWN);
    }

    /**
     *
     * @param big Valor a ser formatado
     * @param qtd_casas_decimais Quantidade de casas decimais da string
     * retornada
     * @return Valor formatado(String)
     */
    public static String fmtBig(Object big, int qtd_casas_decimais) {
        return fmtBig(parseToBig(big), qtd_casas_decimais);
    }

    public static String fmtBigRS(BigDecimal big, int qtd_casas_decimais) {
        return "R$" + fmtBig(big, qtd_casas_decimais);
    }

    public static String fmtBig(BigDecimal big, int qtd_casas_decimais) {
        if (big == null) {
            big = BigDecimal.ZERO;
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(qtd_casas_decimais);
        df.setMinimumFractionDigits(qtd_casas_decimais);
        df.setGroupingUsed(true);

        return df.format(big.setScale(qtd_casas_decimais, RoundingMode.HALF_DOWN));
    }

}
