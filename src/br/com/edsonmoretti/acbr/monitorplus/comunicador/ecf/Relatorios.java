/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.relatorios.CupomVinculadoOuCCD;
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edson
 */
public class Relatorios {

    private CupomVinculadoOuCCD cupomVinculadoOuCCD;

    public CupomVinculadoOuCCD getCupomVinculadoOuCCD() {
        return cupomVinculadoOuCCD == null ? cupomVinculadoOuCCD = new CupomVinculadoOuCCD() : cupomVinculadoOuCCD;
    }

    /**
     * Emite o relatório de Leitura X.
     * <b>Nota:</b> em alguns estados, é necessário imprimir uma Leitura X todo
     * inicio de dia e cada inicio de Bobina
     *
     * @throws ACBrECFException
     */
    public void leituraX() throws ACBrECFException {

    }

    /**
     * Emite o relatório de Redução Z. Nota: Se emitido no mesmo dia fiscal,
     * bloqueia o ECF até as 24:00hs.
     * <br>
     * Se não for emitida no mesmo dia fiscal o ECF ficará bloqueado, e o ACBr
     * retornará o Estado como estRequerZ. Nesse caso será necessário emitir a
     * Redução Z pendente (do dia anterior) para liberar o ECF
     * <br>
     * Cuidado: Apenas comande a Redução Z se o estado do ECF for estRequerZ ou
     * se você deseja realmente bloquear o ECF até a meia-noite (fim de dia).
     *
     * @throws ACBrECFException
     */
    public void reducaoZ() throws ACBrECFException {
        reducaoZ(false);
    }

    /**
     * Emite o relatório de Redução Z. Nota: Se emitido no mesmo dia fiscal,
     * bloqueia o ECF até as 24:00hs.
     * <br>
     * Se não for emitida no mesmo dia fiscal o ECF ficará bloqueado, e o ACBr
     * retornará o Estado como estRequerZ. Nesse caso será necessário emitir a
     * Redução Z pendente (do dia anterior) para liberar o ECF
     * <br>
     * Cuidado: Apenas comande a Redução Z se o estado do ECF for estRequerZ ou
     * se você deseja realmente bloquear o ECF até a meia-noite (fim de dia).
     *
     * @param enviarDataHoraDoPC Data / Hora atual do micro. Se dDataHora for
     * informado, o ACBrECF tentará acertar o relógio do ECF (disponível apenas
     * em alguns ECFs), aumentando ou diminuindo o horário no máximo de 5
     * minutos por dia.
     *
     * @throws ACBrECFException
     */
    public void reducaoZ(boolean enviarDataHoraDoPC) throws ACBrECFException {
        comandoECF("ReducaoZ+" + (enviarDataHoraDoPC ? "(" + new SimpleDateFormat("dd/MM/yy HH:mm:ss").format(new Date()) + ")" : ""));
    }

    public void pulaLinha() throws ACBrECFException {
        pulaLinhas(1);
    }

    private void pulaLinhas(int qtdLinhas) throws ACBrECFException {
        comandoECF("PulaLinhas(" + qtdLinhas + ")");
    }

    /**
     * Encerra a emissão de Cupom vinculado (CCD) e Relatório Gerencial (RG).
     *
     * @throws ACBrECFException
     */
    public void fechaRelatorio() throws ACBrECFException {
        comandoECF("FechaRelatorio");
    }
}
