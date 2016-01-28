package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBr;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.listener.ACBrEvent;
import java.util.ArrayList;
import java.util.Collection;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.listener.ACBrEventListener;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrECF {

    private final Collection<ACBrEventListener> acbrPoucoPapelListeners;

    private Variaveis variaveis;
    private Relatorios relatorios;
    private CupomFiscal cupomFiscal;

    public ACBrECF(boolean ativar) throws ACBrECFException {
        this.acbrPoucoPapelListeners = new ArrayList<>();
        if (ativar && !ativo()) {
            ativar();
        }
    }

    /**
     *
     * @return Retorna True para ECF ativo e False para ECF desativado
     *
     * @throws ACBrECFException
     */
    public final boolean ativo() throws ACBrECFException {
        return comandoECF("Ativo").toLowerCase().equals("true");
    }

    /**
     * Este procedimento ativa a ECF.
     *
     * @throws ACBrECFException
     */
    public final void ativar() throws ACBrECFException {
        comandoECF("Ativar");
    }

    /**
     * Este procedimento Desativa a ECF.
     *
     * @throws ACBrECFException
     */
    public void desativar() throws ACBrECFException {
        comandoECF("Desativar");
    }

    /**
     * Realiza o corte parcial do papel no ECF para equipamentos com guilhotina.
     */
    public void cortaPapelParcial() throws ACBrECFException {
        comandoECF("CortaPapel(true)");
    }

    /**
     * Realiza o corte do papel no ECF para equipamentos com guilhotina.
     */
    public void cortaPapel() throws ACBrECFException {
        comandoECF("CortaPapel");
    }

    public static String comandoECF(String s) throws ACBrECFException {
        try {
            return ACBr.getInstance().comandoAcbr("ECF." + s);
        } catch (ACBrException ex) {
            throw new ACBrECFException(ex.getMessage());
        }
    }

    public Variaveis getVariaveis() {
        return variaveis == null ? variaveis = new Variaveis() : variaveis;
    }

    public CupomFiscal getCupomFiscal() {
        return cupomFiscal == null ? cupomFiscal = new CupomFiscal() : cupomFiscal;
    }

    public Relatorios getRelatorios() {
        return relatorios == null ? relatorios = new Relatorios() : relatorios;
    }

    public synchronized void addOnPoucoPapel(ACBrEventListener l) {
        if (!acbrPoucoPapelListeners.contains(l)) {
            acbrPoucoPapelListeners.add(l);
        }
    }

    public synchronized void removeOnPoucoPapel(ACBrEventListener l) {
        acbrPoucoPapelListeners.remove(l);
    }

    private void disparaOnPoucoPapel() {
        Collection<ACBrEventListener> tl;
        synchronized (this) {
            tl = (Collection) (((ArrayList) acbrPoucoPapelListeners).clone());
        }
        ACBrEvent evento = new ACBrEvent(this);
        for (ACBrEventListener t : tl) {
            t.msgPoucoPapel(evento);
        }
    }

}
