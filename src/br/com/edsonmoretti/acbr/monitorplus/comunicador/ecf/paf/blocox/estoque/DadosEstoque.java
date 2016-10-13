/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf.blocox.estoque;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edson
 */
public class DadosEstoque {

    private Date dataReferenciaInicial;
    private Date dataReferenciaFinal;
    private Produtos produtos = new Produtos();

    public Date getDataReferenciaInicial() {
        return dataReferenciaInicial;
    }

    public void setDataReferenciaInicial(Date dataReferenciaInicial) {
        this.dataReferenciaInicial = dataReferenciaInicial;
    }

    public Date getDataReferenciaFinal() {
        return dataReferenciaFinal;
    }

    public void setDataReferenciaFinal(Date dataReferenciaFinal) {
        this.dataReferenciaFinal = dataReferenciaFinal;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        String xmlExemplo = "";
        InputStream in = getClass().getResourceAsStream("/br/com/edsonmoretti/acbr/monitorplus/comunicador/ecf/paf/blocox/EnvioEstoque.xml");
        try {
            Reader fr = new InputStreamReader(in, "utf-8");
            while (fr.ready()) {
                xmlExemplo += String.valueOf(((char) fr.read()));
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DadosEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DadosEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        String xml = xmlExemplo.replace("_DATA_REFERENCIA_INICIAL_", ACBrUtils.formatDataDB(dataReferenciaInicial))
                .replace("_DATA_REFERENCIA_FINAL_", ACBrUtils.formatDataDB(dataReferenciaFinal)).replace("_PRODUTOS_", produtos.toString());
        return xml;
    }

}
