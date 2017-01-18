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
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class Numeros {

    /**
     * BigDecimal 100
     */
    public final static BigDecimal CEM = parseToBig("100");

    /**
     * BigDecimal 0,01, normalmente utilizado para calcular porcentagem: Ex:
     * (new BigDecimal("90").multiply(new
     * BigDecimal("10")).multiply(Numeros._0_01)); Valor 90, taxa 10, retorno 9;
     */
    public final static BigDecimal _0_01 = parseToBig("0.01");

    /**
     *
     * @param valor Valor usado para base
     * @param taxa Taxa em % para calcular
     * @return resultado da equação: valor.multiply(taxa).multiply(_0_01); sendo
     * _0_01 = parseToBig("100");
     */
    public static BigDecimal valorDeTaxa(BigDecimal valor, BigDecimal taxa) {
        if (taxa.compareTo(BigDecimal.ZERO) == 0) {
            return taxa; //Se a taxa for 0 retorna 0, ué!
        }
        return valor.multiply(taxa).multiply(_0_01);
    }

    /**
     *
     * @param valor Valor usado para base
     * @param taxa Taxa em % para calcular
     * @return resultado da equação: valor.multiply(taxa).multiply(_0_01); sendo
     * _0_01 = parseToBig("100");
     */
    public static BigDecimal valorParaTaxa(BigDecimal total, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) == 0 || total.compareTo(BigDecimal.ZERO) == 0) {
            return valor;
        }
        return valor.multiply(CEM).divide(total, 6, RoundingMode.HALF_DOWN);

    }

    /**
     *
     * @param obj que pode ser String,Double ou Integer.
     * @return um BigDecimal na Scale(4, RoundingMode.HALF_DOWN)
     * @throws NumberFormatException
     */
    public static BigDecimal parseToBig(Object obj) throws NumberFormatException {
        return parseToBig(obj, false);
    }

    public static BigDecimal parseToBig(Object obj, boolean seStringRemoverLetrasEcaracteresEspeciais) throws NumberFormatException {
        return parseToBig(obj, 4, seStringRemoverLetrasEcaracteresEspeciais);
    }

    public static BigDecimal parseToBig(Object obj, int scl) throws NumberFormatException {
        return parseToBig(obj, scl, false);
    }

    public static BigDecimal parseToBig(Object obj, int scl, boolean seStringRemoverLetrasEcaracteresEspeciais) throws NumberFormatException {
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
        } else if (obj.getClass() == JFormattedTextField.class) {
            return parseToBig(((JFormattedTextField) obj).getText());
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
        if (seStringRemoverLetrasEcaracteresEspeciais) {
            str = str.replaceAll("[^0-9.]", "");
        }
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
