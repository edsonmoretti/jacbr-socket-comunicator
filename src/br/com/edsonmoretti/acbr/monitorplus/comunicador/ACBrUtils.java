/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Edson
 */
public class ACBrUtils {

    /**
     * "yyyy-MM-dd"
     */
    private static SimpleDateFormat dateFormatDB;
    /**
     * "dd/MM/yyyy"
     */
    private static SimpleDateFormat dateFormatBR;
    /**
     * "dd/MM/yyyy HH:mm:ss"
     */
    private static SimpleDateFormat dateTimeFormatBRAno;
    /**
     * "yyyy-MM-dd HH:mm:ss"
     */
    private static SimpleDateFormat dateTimeFormatDBAno;
    /**
     * "dd/MM/yy HH:mm:ss"
     */
    private static SimpleDateFormat dateTimeFormatBRAnoReduzido;
    /**
     * "yy-MM-dd HH:mm:ss"
     */
    private static SimpleDateFormat dateTimeFormatDBAnoReduzido;
    /**
     * "dd/MM/yy"
     */
    private static SimpleDateFormat dateFormatBRAnoReduzido;
    /**
     * "HH:mm:ss"
     */
    private static SimpleDateFormat dateFormatHora;

    public static String MD5(char[] text) throws ACBrException {
        return MD5(String.valueOf(text));
    }

    public static String MD5(String text) throws ACBrException {
        try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            byte[] md5hash = new byte[32];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            md5hash = md.digest();
            return convertToHex(md5hash);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            throw new ACBrException(ex.getMessage());
        }
    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
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

    /**
     * Formata um Date em String no formato yyyy-MM-dd
     *
     * @param d
     * @return
     */
    public static String formatDataDB(Date d) {
        return (dateFormatDB == null ? dateFormatDB = new SimpleDateFormat("yyyy-MM-dd") : dateFormatDB).format(d);
    }

    /**
     * Formata um Date em String no formato dd/MM/yyyy
     *
     * @param d
     * @return
     */
    public static String formatDataBR(Date d) {
        return (dateFormatBR == null ? dateFormatBR = new SimpleDateFormat("dd/MM/yyyy") : dateFormatBR).format(d);
    }

    /**
     * Formata um Date para Hora no formato: HH:mm:ss
     *
     * @param d
     * @return
     */
    public static String formatHora(Date d) {
        return (dateFormatHora == null ? dateFormatHora = new SimpleDateFormat("HH:mm:ss") : dateFormatHora).format(d);
    }

    /**
     * Converte String para Date, String no formato: Converte String para Date,
     * String no formato:
     *
     * @param dataHoraBRRed
     * @return
     */
    public static Date strDataEHoraToDateBR(String dataHoraBR) throws ACBrException {
        try {
            if (dataHoraBR.matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]")) {//"yyyy-MM-dd HH:mm:ss"
                return (dateTimeFormatDBAno == null ? dateTimeFormatDBAno = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") : dateTimeFormatDBAno).parse(dataHoraBR);
            } else if (dataHoraBR.matches("[0-9][0-9]-[0-9][0-9]-[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]")) { // yy-MM-dd HH:mm:ss
                return (dateTimeFormatDBAnoReduzido == null ? dateTimeFormatDBAnoReduzido = new SimpleDateFormat("yy-MM-dd HH:mm:ss") : dateTimeFormatDBAnoReduzido).parse(dataHoraBR);
            } else if (dataHoraBR.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]")) {//"dd/MM/yyyy HH:mm:ss"
                return (dateTimeFormatBRAno == null ? dateTimeFormatBRAno = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") : dateTimeFormatBRAno).parse(dataHoraBR);
            } else if (dataHoraBR.matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9] [0-9][0-9]:[0-9][0-9]:[0-9][0-9]")) {//"dd/MM/yy HH:mm:ss"
                return (dateTimeFormatBRAnoReduzido == null ? dateTimeFormatBRAnoReduzido = new SimpleDateFormat("dd/MM/yy HH:mm:ss") : dateTimeFormatBRAnoReduzido).parse(dataHoraBR);
            } else {
                throw new ParseException("Formato inválido: " + dataHoraBR, 0);
            }
        } catch (ParseException ex) {
            throw new ACBrException("Erro ao tentar dar o parse na data. " + ex.getMessage());
        }
    }

    /**
     * Converte String para Date, String no formato: dd/MM/yyyy
     *
     * @param dataBR
     * @throws ACBrException
     * @return
     */
    public static Date strDataToDateBR(String dataBR) throws ACBrException {
        try {
            return (dateFormatBR == null ? dateFormatBR = new SimpleDateFormat("dd/MM/yyyy") : dateFormatBR).parse(dataBR);
        } catch (ParseException ex) {
            throw new ACBrException("Erro ao tentar dar o parse na data. " + ex.getMessage());
        }
    }

    /**
     * Converte String para Date, String no formato: dd/MM/YY
     *
     * @param dataBRRed
     * @throws ACBrException
     * @return
     */
    public static Date strDataRedToDateBR(String dataBRRed) throws ACBrException {
        try {
            return (dateFormatBRAnoReduzido == null ? dateFormatBRAnoReduzido = new SimpleDateFormat("dd/MM/yy") : dateFormatBRAnoReduzido).parse(dataBRRed);
        } catch (ParseException ex) {
            throw new ACBrException("Erro ao tentar dar o parse na data. " + ex.getMessage());
        }
    }

    /**
     * Formata um Date para Data e Hora no formato: dd/MM/yyyy HH:mm:ss
     *
     * @param d
     * @return
     */
    public static String formatDataHora(Date d) {
        return formatDataBR(d) + " " + formatHora(d);
    }

    public static void adicionarLinhaEmArquivoTXT(File file, String linha) throws FileNotFoundException, IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file);
        pw.println(linha);
    }
}
