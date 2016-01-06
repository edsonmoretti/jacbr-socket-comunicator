/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.vo.Endereco;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edson
 */
public class ACBrCEP {

    /**
     * Consulta Endereço por CEP de acordo com Webservice configurado no
     * ACBrMonitorPlus
     *
     * @param cep Numero do Cep
     * @return Objeto com endereço do CEP informado.
     * @throws ACBrException
     */
    public Endereco bucarPorCEP(String cep) throws ACBrException {
        List<Endereco> lista = new ArrayList<>();
        String s = ACBr.getInstance().comandoAcbr("CEP.BuscarPorCEP(" + cep + ")");
        for (String string : s.split("OK:")) {
            if (string.trim().isEmpty()) {
                continue;
            }
            Endereco cepVo = new Endereco();
            Properties p = new Properties();
            try {
                p.load(new ByteArrayInputStream(string.getBytes()));
                cepVo.setCep(p.getProperty("CEP"));
                cepVo.setTipoLogradouro(p.getProperty("Tipo_Logradouro"));
                cepVo.setLogradouro(p.getProperty("Logradouro"));
                cepVo.setComplemento(p.getProperty("Complemento"));
                cepVo.setBairro(p.getProperty("Bairro"));
                cepVo.setMunicipio(p.getProperty("Municipio"));
                cepVo.setUf(p.getProperty("UF"));
                cepVo.setCodMunicipio(p.getProperty("IBGE_Municipio"));
                cepVo.setCodUF(p.getProperty("IBGE_UF"));
                lista.add(cepVo);
            } catch (IOException ex) {
                Logger.getLogger(ACBrCEP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (lista.isEmpty()) {
            throw new ACBrException("Nenhum endereço encontrado.");
        } else {
            return lista.get(0);
        }
    }

    /**
     * /**
     * Consulta Endereço/CEP de acordo com Webservice configurado no
     * ACBrMonitorPlus
     *
     * @param cCidade (Obrigatorio) Cidade do endereço
     * @param cTipoLogradouro Tipo de logradouro
     * @param cLogradouro
     * @param cUF (obrigatorio) UD do endereço
     * @param cBairro Bairro
     * @return Lista de Objetos com Endereço da Consulta
     * @throws ACBrException
     */
    public List<Endereco> buscarPorLogradouro(String cCidade, String cTipoLogradouro, String cLogradouro, String cUF, String cBairro) throws ACBrException {
        List<Endereco> lista = new ArrayList<>();
        String s = ACBr.getInstance().comandoAcbr("CEP.BuscarPorLogradouro(" + cCidade + "," + cTipoLogradouro + "," + cLogradouro + "," + cUF + "," + cBairro + ")");
        for (String string : s.split("OK:")) {
            if (string.isEmpty()) {
                continue;
            }
            Endereco cepVo = new Endereco();
            Properties p = new Properties();
            try {
                p.load(new ByteArrayInputStream(string.getBytes()));
                cepVo.setCep(p.getProperty("CEP"));
                cepVo.setTipoLogradouro(p.getProperty("Tipo_Logradouro"));
                cepVo.setLogradouro(p.getProperty("Logradouro"));
                cepVo.setComplemento(p.getProperty("Complemento"));
                cepVo.setBairro(p.getProperty("Bairro"));
                cepVo.setMunicipio(p.getProperty("Municipio"));
                cepVo.setUf(p.getProperty("UF"));
                cepVo.setCodMunicipio(p.getProperty("IBGE_Municipio"));
                cepVo.setCodUF(p.getProperty("IBGE_UF"));
                lista.add(cepVo);
            } catch (IOException ex) {
                Logger.getLogger(ACBrCEP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
