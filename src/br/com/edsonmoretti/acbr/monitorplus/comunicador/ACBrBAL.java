/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import java.math.BigDecimal;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrBAL {

    public ACBrBAL() {
    }

    /**
     * @return “true” se a comunicação com a Balança está ativa
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     */
    public boolean isAtivo() throws ACBrBALException {
        try {
            return ACBr.getInstance().comandoAcbr("BAL.Ativo").equalsIgnoreCase("True");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    /**
     * Ativa a comunicação com a Balança conectada na getPorta Serial.
     *
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     */
    public void ativar() throws ACBrBALException {
        try {
            ACBr.getInstance().comandoAcbr("BAL.Ativar");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    /**
     * Desativa a comunicação com a Balança.
     *
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     */
    public void desativar() throws ACBrBALException {
        try {
            ACBr.getInstance().comandoAcbr("BAL.Desativar");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    /**
     * Retorna Texto descritivo do Modelo da Balança que está conectado
     *
     * @return Exemplo de Resposta: Filizola
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     *
     */
    public String getModeloStr() throws ACBrBALException {
        try {
            return ACBr.getInstance().comandoAcbr("BAL.ModeloStr");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    /**
     * Retorna Texto com o valor da propriedade “Modelo” de ACBrBAL
     *
     * @return EX de retorno: balFilizola
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     */
    public String getModelo() throws ACBrBALException {
        try {
            return ACBr.getInstance().comandoAcbr("BAL.Modelo");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    /**
     * Retorna Texto com a Porta utilizada para a comunicação serial / paralela
     *
     * @return Exemplo de Resposta: COM4
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     *
     */
    public String getPorta() throws ACBrBALException {
        try {
            return ACBr.getInstance().comandoAcbr("BAL.Porta");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    /**
     * Muda o valor do Intervalo do componente Balança.
     *
     * @param intervalo Valor do Intervalo. <br> Exemplos: bal.setIntervalo(50)
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     *
     */
    public void setIntervalo(int intervalo) throws ACBrBALException {
        try {
            ACBr.getInstance().comandoAcbr("BAL.SetIntervalo(" + intervalo + ")");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    /**
     *
     * @return Retorna o Peso capturado pela balança.
     * @throws ACBrBALException
     */
    public synchronized BigDecimal lePeso() throws ACBrBALException {
        if (!isAtivo()) {
            ativar();
            if (isAtivo()) {
                return lePeso();
            }
            throw new ACBrBALException("Balança desativada, após configurar, use o BAL.Ativar");
        }
        BigDecimal b = null;
        try {
            String r = ACBr.getInstance().comandoAcbr("BAL.LePeso");
            b = Numeros.parseToBig(r);
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
        return b;
    }

    /**
     * Retorna o Peso capturado pela balança.
     *
     * @param timeOut Tempo limite para tentar ler o peso válido. Se omitido
     * será considerado 3000 millisec
     * @return Retorna o Peso capturado pela balança.
     * @throws ACBrBALException
     */
    public BigDecimal lePeso(int timeOut) throws ACBrBALException {
        if (!isAtivo()) {
            ativar();
            if (isAtivo()) {
                return lePeso();
            }
            throw new ACBrBALException("Balança desativada, após configurar, use o BAL.Ativar");
        }
        BigDecimal b = null;
        try {
            String r = ACBr.getInstance().comandoAcbr("BAL.LePeso(" + timeOut + ")");
            b = Numeros.parseToBig(r);
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
        return b;
    }

    /**
     * Retorna o Último Peso lido pela balança
     *
     * @return
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException
     */
    public BigDecimal getUltimoPesoLido() throws ACBrException {
        return Numeros.parseToBig(ACBr.getInstance().comandoAcbr("BAL.UltimoPesoLido"));
    }

    /**
     * Retorna a Última Resposta obtida pela balança
     *
     * @return
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBALException
     */
    public String getUltimaResposta() throws ACBrBALException {
        try {
            return ACBr.getInstance().comandoAcbr("BAL.UltimoPesoLido");
        } catch (ACBrException ex) {
            throw new ACBrBALException();
        }
    }

    /**
     * Retorna “True” se a balança esta sendo monitorada
     *
     * @return
     * @throws ACBrBALException
     */
    public boolean isMonitorarBalanca() throws ACBrBALException {
        try {
            return ACBr.getInstance().comandoAcbr("BAL.MonitorarBalanca").equalsIgnoreCase("true");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    public boolean isTemBalancaConfigurada() throws ACBrBALException {
        try {
            if (ACBr.getInstance().comandoAcbr("BAL.Modelo").equalsIgnoreCase("balNenhum")) {
                return false;
            }
            return !ACBr.getInstance().comandoAcbr("BAL.ModeloStr").equalsIgnoreCase("Não Definida");
        } catch (ACBrException ex) {
            throw new ACBrBALException(ex.getMessage());
        }
    }

    public static ACBrBAL getInstance() {
        return ACBrBALHolder.INSTANCE;
    }

    private static class ACBrBALHolder {

        private static final ACBrBAL INSTANCE = new ACBrBAL();
    }
}
