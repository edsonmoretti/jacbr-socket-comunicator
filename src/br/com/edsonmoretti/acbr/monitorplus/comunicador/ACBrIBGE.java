/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.vo.Ibge;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Edson
 */
public class ACBrIBGE {

    /**
     * Consulta informações do Municicio de Acordo com ACBrMonitorPlus
     *
     * @param cod
     * @return Objeto IBGE com dados
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException
     */
    public Ibge buscarPorCodigo(String cod) throws ACBrException {
        String s = ACBr.getInstance().comandoAcbr("IBGE.BuscarPorCodigo(" + cod + ")");
        Properties p = new Properties();
        try {
            Ibge i = new Ibge();
            p.load(new ByteArrayInputStream(s.getBytes()));
            i.setMunicipio(p.getProperty("Municipio"));
            i.setUf(p.getProperty("UF"));
            i.setCodMunicipio(p.getProperty("CodMunicio"));
            i.setCodUF(p.getProperty("CodUF"));
            i.setAreaMunicipio(Numeros.parseToBig(p.getProperty("Area")));
            return i;
        } catch (IOException ex) {
            throw new ACBrException(ex.getMessage());
        }
    }

    /**
     * Consulta informações do Municicio por nome de Acordo com ACBrMonitorPlus
     *
     * @param nomeMunicipio
     * @return lista de Objeto IBGE com dados
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException
     */
    public List<Ibge> buscarPorNome(String nomeMunicipio) throws ACBrException {
        String s = ACBr.getInstance().comandoAcbr("IBGE.BuscarPorNome(" + nomeMunicipio + ")");
        List<Ibge> lista = new ArrayList<>();
        for (String str : s.split("OK:")) {
            if (str.trim().isEmpty()) {
                continue;
            }
            for (String string : str.split("Cidade")) {
                string = string.replace("[", "").replace("]", "");
                if (string.trim().isEmpty()) {
                    continue;
                }
                Properties p = new Properties();
                try {
                    Ibge i = new Ibge();
                    p.load(new ByteArrayInputStream(string.getBytes()));
                    i.setMunicipio(p.getProperty("Municipio"));
                    i.setUf(p.getProperty("UF"));
                    i.setCodMunicipio(p.getProperty("CodMunicio"));
                    i.setCodUF(p.getProperty("CodUF"));
                    i.setAreaMunicipio(Numeros.parseToBig(p.getProperty("Area")));
                    lista.add(i);
                } catch (IOException ex) {
                    throw new ACBrException(ex.getMessage());
                }
            }
        }
        return lista;
    }
}
