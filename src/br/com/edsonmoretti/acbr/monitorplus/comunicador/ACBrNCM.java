/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrNCM {

    /**
     * Retorna True se o NCM informado existir. URL de Busca:
     * http://www4.receita.fazenda.gov.br/simulador/PesquisarNCM.jsp
     *
     * @param codigo
     * @return true ou false
     * @throws ACBrException
     */
    public boolean validarNCM(String codigo) throws ACBrException {
        return ACBr.getInstance().comandoAcbr("NCM.Validar(" + codigo + ")").equals("NCM Valido");
    }

    /**
     * Retorna Se NCM válido retorna a descrição.
     * http://www4.receita.fazenda.gov.br/simulador/PesquisarNCM.jsp
     *
     * @param codigo
     * @return true ou false
     * @throws ACBrException Caso não encontre o NCM, ou qlqr outra coisa :P.
     */
    public String descricaoNCM(String codigo) throws ACBrException {
        return ACBr.getInstance().comandoAcbr("NCM.DescricaoNCM(" + codigo + ")");
    }

    /**
     * Salva a lista de NCM no formato CSV, em um nome de arquivo especificado.
     *
     * @param arquivo
     * @return BufferedReader do arquivo baixado.
     * @throws ACBrException
     * @throws FileNotFoundException
     */
    public BufferedReader baixarLista(File arquivo) throws ACBrException, FileNotFoundException {
        ACBr.getInstance().comandoAcbr("NCM.BaixarLista(" + arquivo + ")");
        return new BufferedReader(new FileReader(arquivo));
    }
}
