/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.aac;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrAACException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/**
 *
 * @author Edson
 */
public class ArquivoCriptografado {

    private File arquivo;
    private final ECFs ecfs;
    private FormatoDoArquivo formatoDoArquivo = FormatoDoArquivo.XML;
    private Properties properties;
    private String comentarioDoArquivo = "";
    private String MD5Principal;

    public ArquivoCriptografado() {
        arquivo = new File("arquivo_criptografado");
        ecfs = new ECFs();
    }

    /**
     * por padrão: arquivo_criptografado.txt
     *
     * @return
     */
    public File getArquivo() {
        return arquivo;
    }

    /**
     * por padrão arquivo_criptografado.txt
     *
     * @param arquivo
     */
    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * Lista de ECFs
     *
     * @return
     */
    public ECFs getEcfs() {
        return ecfs;
    }

    public FormatoDoArquivo getFormatoDoArquivo() {
        return formatoDoArquivo;
    }

    public void setFormatoDoArquivo(FormatoDoArquivo formatoDoArquivo) {
        this.formatoDoArquivo = formatoDoArquivo;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties p) {
        this.properties = p;
    }

    public String getComentarioDoArquivo() {
        return comentarioDoArquivo;
    }

    public void setComentarioDoArquivo(String comentarioDoArquivo) {
        this.comentarioDoArquivo = comentarioDoArquivo;
    }

    public void setMD5Principal(String MD5Principal) {
        this.MD5Principal = MD5Principal;
    }

    public String getMD5Principal() {
        return MD5Principal;
    }

    public boolean isEcfAutorizado(ACBrECF ecf) throws ACBrAACException {
        try {
            return isEcfAutorizado(ecf.getVariaveis().getEquipamento().getNumSerie(), ecf.getVariaveis().getMapaResumo().getGrandeTotal(), ecf.getVariaveis().getEquipamento().getCnpj());
        } catch (ACBrECFException ex) {
            throw new ACBrAACException(ex.getMessage());
        }
    }

    /**
     * Verifica se o ECF está autorizado no Arquivo Auxiliar Criptografado
     *
     * @param serieEcf
     * @param totalizadorGeral
     * @param cnpj
     * @return true se Confere
     * @throws ACBrAACException <br>
     * ACBrAACException: ECF Não autorizado. Serie Não encontradao.<br>
     * ACBrAACException: Totalizador Geral / Grande Total não confere no
     * arquivo.<br>
     * ACBrAACException: CNPJ do ECF não confere com CNPJ cadastrado em algum
     * ECF no Arquivo Criptografado.<br>
     */
    public boolean isEcfAutorizado(String serieEcf, BigDecimal totalizadorGeral, String cnpj) throws ACBrAACException {
        carregarArquivo();
        cnpj = cnpj.replaceAll("[^0-9]", "");
        boolean confereSerie = false;
        boolean confereGt = false;
        String keyGt = "";
        for (Object object : properties.keySet()) {
            String p = (String) object;
            if (p.startsWith("ECF")) {
                String serieComCNPJ = properties.getProperty(p);
                if (getCNPJDeMD5comCNPJEscondido(serieComCNPJ).equals(cnpj)) {
                } else {
                    throw new ACBrAACException("CNPJ do ECF não confere com CNPJ cadastrado em algum ECF no Arquivo Criptografado.");
                }
                if (!confereSerie) {
                    try {
                        confereSerie = inserirCNPJemMD5(TextUtils.MD5String(serieEcf), cnpj).equals(serieComCNPJ);
                        if (confereSerie) {
                            keyGt = "GT" + p.substring(p.length() - 1);
                            break;
                        }
                    } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                        throw new ACBrAACException(ex.getMessage());
                    }
                }
            }
        }

        String md5Totalizador = properties.getProperty(keyGt);
        try {
            confereGt = TextUtils.MD5String(cnpj + totalizadorGeral).equals(md5Totalizador);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new ACBrAACException(ex.getMessage());
        }

        if (!confereSerie) {
            throw new ACBrAACException("ECF Não autorizado. Serie Não encontradao.");
        }

        if (!confereGt) {
            throw new ACBrAACException("Totalizador Geral / Grande Total não confere no arquivo.");
        }
        return true;
    }

    public void recomporGT(ACBrECF ecf, String croDoBanco, String crzDoBanco) throws ACBrAACException {
        try {
            carregarArquivo();
            //Requisito XXIV, se CRO foi incrementado (teve intervencao) em 1, recomponhe GT
            boolean achou = false;
            String keyGt = "";
            String cnpj = ecf.getVariaveis().getEquipamento().getCnpj().replaceAll("[^0-9]", "");
            for (Object object : properties.keySet()) {
                String p = (String) object;
                if (p.startsWith("ECF")) {
                    String serieComCNPJ = properties.getProperty(p);
                    try {
                        achou = inserirCNPJemMD5(TextUtils.MD5String(ecf.getVariaveis().getEquipamento().getNumSerie()), cnpj).equals(serieComCNPJ);
                        if (achou) {
                            keyGt = "GT" + p.substring(p.length() - 1);
                            break;
                        }
                    } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                        throw new ACBrAACException(ex.getMessage());
                    }
                }
            }
            if (Integer.parseInt(ecf.getVariaveis().getMapaResumo().getNumCRO()) - Integer.parseInt(croDoBanco) == 1) {
                carregarArquivo();
                if (!keyGt.isEmpty()) {
                    properties.setProperty(keyGt, TextUtils.MD5String(cnpj + ecf.getVariaveis().getMapaResumo().getGrandeTotal()));
                }
            } else if (Integer.parseInt(ecf.getVariaveis().getMapaResumo().getNumCRO()) == Integer.parseInt(croDoBanco)
                    //se CRZ e CRO do ECF estiver igual ao do banco de dados, recupera.
                    && Integer.parseInt(ecf.getVariaveis().getMapaResumo().getNumCRZ()) == Integer.parseInt(crzDoBanco)) {
                if (!keyGt.isEmpty()) {
                    properties.setProperty(keyGt, TextUtils.MD5String(cnpj + ecf.getVariaveis().getMapaResumo().getGrandeTotal()));
                }
            }
            if (formatoDoArquivo == FormatoDoArquivo.TXT) {
                properties.store(new FileOutputStream(arquivo), comentarioDoArquivo);
            } else if (formatoDoArquivo == FormatoDoArquivo.XML) {
                properties.storeToXML(new FileOutputStream(arquivo), comentarioDoArquivo);
            }
        } catch (ACBrECFException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new ACBrAACException(ex.getMessage());
        } catch (FileNotFoundException ex) {
            throw new ACBrAACException(ex.getMessage());
        } catch (IOException ex) {
            throw new ACBrAACException(ex.getMessage());
        }
    }

    /**
     *
     * @throws ACBrAACException
     * @deprecated Mesmo que carregarArquivo
     */
    public void abrirArquivo() throws ACBrAACException {
        carregarArquivo();
    }

    public void carregarArquivo() throws ACBrAACException {
        properties = new Properties();
        try {
            if (getFormatoDoArquivo() == FormatoDoArquivo.XML) {
                properties.loadFromXML(new FileInputStream(arquivo));
            } else if (formatoDoArquivo == FormatoDoArquivo.TXT) {
                properties.load(new FileInputStream(arquivo));
            }
        } catch (FileNotFoundException ex) {
            throw new ACBrAACException(ex.getMessage());
        } catch (IOException ex) {
            throw new ACBrAACException(ex.getMessage());
        }
    }

    public void criarArquivo(ACBrECF ecf) throws ACBrAACException {
        try {
            criarArquivo(ecf.getVariaveis().getEquipamento().getCnpj());
        } catch (ACBrECFException ex) {
            throw new ACBrAACException(ex.getMessage());
        }
    }

    public void criarArquivo(String cnpjDaEmpresaCadastradaNoECF) throws ACBrAACException {
        try {
            cnpjDaEmpresaCadastradaNoECF = cnpjDaEmpresaCadastradaNoECF.replaceAll("[^0-9]", "");
            properties = new Properties();
            properties.setProperty("MD-5", MD5Principal);
            for (int i = 1; i <= ecfs.size(); i++) {//<= pq estou iniciando do 1 para salvar cont ECF1, ECF2... e no get de ecfs eu uso i-1 para o index começar do 0
                properties.setProperty("ECF" + i, inserirCNPJemMD5(TextUtils.MD5String(ecfs.get(i - 1).getSerieEcf()), cnpjDaEmpresaCadastradaNoECF));
                properties.setProperty("GT" + i, TextUtils.MD5String(cnpjDaEmpresaCadastradaNoECF + ecfs.get(i - 1).getTotalizadorGeral()));
            }
            if (formatoDoArquivo == FormatoDoArquivo.XML) {
                properties.storeToXML(new FileOutputStream(arquivo), comentarioDoArquivo);
            } else if (formatoDoArquivo == FormatoDoArquivo.TXT) {
                properties.store(new FileOutputStream(arquivo), comentarioDoArquivo);
            }
        } catch (IOException | NoSuchAlgorithmException ex) {
            throw new ACBrAACException(ex.getMessage());
        }
    }

    private String getCNPJDeMD5comCNPJEscondido(String md5comCnpj) throws ACBrAACException {
        //ignora o primeira char, pois o CNPJ foi inserido no segundo
        md5comCnpj = md5comCnpj.substring(1);
        String cnpj = "";
        for (int i = 0; i < md5comCnpj.toCharArray().length; i++, i++, i++) { //a cada 3 Is foi inserido um char do CNPJ
            cnpj += md5comCnpj.toCharArray()[i];
            if (cnpj.length() == 14) {
                break;
            }
        }
        return cnpj;
    }

    private String inserirCNPJemMD5(String md5, String cnpj) throws ACBrAACException {
        cnpj = cnpj.replaceAll("[^0-9]", "");
        if (md5.length() != 32) {
            throw new ACBrAACException("MD5 inválido != 32 caracteres.");
        }
        if (cnpj.length() != 14) {
            throw new ACBrAACException("CNPJ inválido != 14 caracteres.");
        }
        String cript = "";
        int j = 0;
        for (int i = 0; i < md5.toCharArray().length; i++) {
            if (i % 2 == 0 && j < 14) {
                cript += md5.toCharArray()[i] + "" + cnpj.toCharArray()[j];
                j++;
                continue;
            }
            cript += md5.toCharArray()[i];
        }
        return cript;
    }

    public void atualizaGT(ACBrECF ecf) throws ACBrAACException {
        try {
            carregarArquivo();
            //Requisito XXIV, se CRO foi incrementado (teve intervencao) em 1, recomponhe GT
            boolean achou = false;
            String keyGt = "";
            String cnpj = ecf.getVariaveis().getEquipamento().getCnpj().replaceAll("[^0-9]", "");
            for (Object object : properties.keySet()) {
                String p = (String) object;
                if (p.startsWith("ECF")) {
                    String serieComCNPJ = properties.getProperty(p);
                    try {
                        achou = inserirCNPJemMD5(TextUtils.MD5String(ecf.getVariaveis().getEquipamento().getNumSerie()), cnpj).equals(serieComCNPJ);
                        if (achou) {
                            keyGt = "GT" + p.substring(p.length() - 1);
                            break;
                        }
                    } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                        throw new ACBrAACException(ex.getMessage());
                    }
                }
            }

            if (!keyGt.isEmpty()) {
                properties.setProperty(keyGt, TextUtils.MD5String(cnpj + ecf.getVariaveis().getMapaResumo().getGrandeTotal()));
            }

            if (formatoDoArquivo == FormatoDoArquivo.TXT) {
                properties.store(new FileOutputStream(arquivo), comentarioDoArquivo);
            } else if (formatoDoArquivo == FormatoDoArquivo.XML) {
                properties.storeToXML(new FileOutputStream(arquivo), comentarioDoArquivo);
            }
        } catch (ACBrECFException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new ACBrAACException(ex.getMessage());
        } catch (FileNotFoundException ex) {
            throw new ACBrAACException(ex.getMessage());
        } catch (IOException ex) {
            throw new ACBrAACException(ex.getMessage());
        }
    }
}
