package br.com.edsonmoretti.acbr.monitorplus.comunicador.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public static void main(String[] args) {
        
    }

    public static TreeMap<String, String> extrarSecaoesDeIni(String deOnde) {
        TreeMap<String, String> t = new TreeMap<>();
        Pattern pattern = Pattern.compile("\\[[\\w]+\\]");
        Matcher matcher = pattern.matcher(deOnde);
        while (matcher.find()) {
            String secao = matcher.group(0);
            String ini = deOnde.split("\\" + secao)[1];
            try {
                ini = ini.substring(0, ini.indexOf("["));
            } catch (java.lang.StringIndexOutOfBoundsException e) {
                //nada tentou achar index of [ e não achou, presumi-se fim de leitura já que a string tem q ta no formato ini
            }
            if (!ini.isEmpty()) {
                t.put(secao, ini.trim());
            }
        }
        return t;
    }

    public static String lerTagIni(String chave, String deOnde, String secao) {
        if (secao.endsWith("]") && secao.startsWith("[")) {
            secao = secao.toLowerCase(); //deixando minuscula pra ignorar o case e adicionado o =
        } else {
            secao = "[" + secao.toLowerCase() + "]"; //deixando minuscula pra ignorar o case e adicionado o =
        }
        String original = deOnde; //guarando a string deOnde original para pegar os dados no formato normal
        deOnde = deOnde.toLowerCase() + "\n"; //deixando minuscula o conteudo do ini pra poder usar a tag minuscula e dando um enter no final para pegar a ultima tag caso n tenha \n, pois o char \n eh usado para saber o final da tag ini
        original = deOnde = original.substring(deOnde.indexOf(secao) + 1);
        try {
            original = "[" + original.substring(0, deOnde.indexOf("\n["));
        } catch (Exception e) {

        }
        return lerTagIni(chave, original);
    }

    public static String lerTagIni(String ler, String deOnde) {
        ler = ler.toLowerCase() + "="; //deixando minuscula pra ignorar o case e adicionado o =
        String original = deOnde; //guarando a string deOnde original para pegar os dados no formato normal
        deOnde = deOnde.toLowerCase() + "\n"; //deixando minuscula o conteudo do ini pra poder usar a tag minuscula e dando um enter no final para pegar a ultima tag caso n tenha \n, pois o char \n eh usado para saber o final da tag ini
        int index = deOnde.indexOf(ler); //pegando o index no conteudo INI minusculo
        String temp = original.substring(index + ler.length()); //usando o (index + variavelIni lenght) em minusculo para pegar o conteúdo do INI original

        if (!temp.endsWith("\n")) {
            temp = temp + "\n";
        }

        String retorno = "";
        if (index > -1) {
            int i = 0;
            while (temp.charAt(i) != '\n') { //ler o conteúdo até o achar o \n (final da String da variavel do INI)
                retorno += temp.charAt(i++);
            }
//            System.out.println(ler + retorno);
        }
        return retorno.trim().replace("\r", "");
    }

    public static String lpadZero(int tamanho, int numero) {
        return String.format("%0" + tamanho + "d", numero);
    }

    public static String normalizar(String s) {
        return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    private static String fd(double valor) {
        return String.format("%.2f", valor).replace(",", ".");

    }

    /**
     *
     * @param valor
     * @param numRepete
     * @return Formato Zeros alinhados a esquerda, ex: numrepet = 6 , numpassado
     * =110 retorno 000110
     */
    public static String formatoACBrN(double valor, int numRepete) {
        String s = fd(valor).replace(".", "");
        int i = s.length();
        if (i > numRepete) {
            return s.substring(0, i);
        }
        return (i < numRepete ? TextUtils.repete("0", numRepete - i) + s : s).toUpperCase();
    }

    /**
     *
     * @param valor
     * @param numRepete
     * @return Formato Zeros alinhados a esquerda, ex: numrepet = 6 , numpassado
     * =110 retorno 000110
     */
    public static String formatoACBrN(String valor, int numRepete) {
        valor = (valor == null ? "" : valor);
        int i = valor.length();
        if (i > numRepete) {
            return valor.substring(0, i);
        }
        return (i < numRepete ? TextUtils.repete("0", numRepete - i) + valor : valor).toUpperCase();
    }

    /**
     *
     * @param valor
     * @param numRepete
     * @return Formato Zeros alinhados a direita, ex: numrepet = 6 , numpassado
     * =110 retorno 110000
     */
    public static String formatoACBrX(String valor, int numRepete) {
        valor = (valor == null ? "" : valor);
        int i = valor.length();
        if (i > numRepete) {
            return valor.substring(0, i);
        }
        return (i < numRepete ? valor + TextUtils.repete(" ", numRepete - i) : valor).toUpperCase();
    }

    public static String repete(String string, int quantidade) {
        StringBuilder retorno = new StringBuilder();
        for (int j = 0; j < quantidade; j++) {
            retorno.append(string);
        }
        return retorno.toString();
    }

    public static String MD5File(File f)
            throws NoSuchAlgorithmException, FileNotFoundException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        InputStream is = new FileInputStream(f);
        byte[] buffer = new byte[8192];
        int read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            return output;
        } catch (IOException e) {
            throw new RuntimeException("Impossível processar o arquivo.", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    public static String MD5String(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }
}
