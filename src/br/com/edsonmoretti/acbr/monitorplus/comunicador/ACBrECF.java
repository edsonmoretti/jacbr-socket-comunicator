package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.CupomFiscal;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.Dispositivos;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.NaoFiscal;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.PAF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.Parametros;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.Relatorios;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.Utilitarios;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.Variaveis;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrAACException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.listener.ACBrEvent;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.listener.ACBrEventListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrECF {

    private final Collection<ACBrEventListener> acbrPoucoPapelListeners;

    private Variaveis variaveis;
    private Relatorios relatorios;
    private CupomFiscal cupomFiscal;
    private Dispositivos dispositivos;
    private PAF paf;
    private NaoFiscal naoFiscal;
    private Parametros parametros;
    private Utilitarios utilitarios;
    private static final String ECF = "ECF.";
    private boolean temGuilhotina = true;
    private ACBrAAC aac;

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
        if (this.getVariaveis().getMapaResumo().getFlags().isPoucoPapel()) {
            disparaOnPoucoPapel();
        }
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
     *
     * @throws ACBrECFException
     */
    public void cortaPapelParcial() throws ACBrECFException {
        if (temGuilhotina) {
            comandoECF("CortaPapel(true)");
        }
    }

    /**
     * Realiza o corte do papel no ECF para equipamentos com guilhotina.
     *
     * @throws ACBrECFException
     */
    public void cortaPapel() throws ACBrECFException {
        if (temGuilhotina) {
            comandoECF("CortaPapel");
        }
    }

    public boolean isTemGuilhotina() {
        return temGuilhotina;
    }

    public void setTemGuilhotina(boolean temGuilhotina) {
        this.temGuilhotina = temGuilhotina;
    }

    private static int numTentativas = 1;

    public static String comandoECF(String s) throws ACBrECFException {
        try {
            String retorno = (ACBr.getInstance().comandoAcbr(ECF + s));
            numTentativas = 1;
            return retorno;
        } catch (ACBrException ex) {
//            if (ex.getMessage().contains("FIM DE PAPEL")) {//Essa mensagem sá acontece uma vez, após isso ao continuar ele retorna fora de linha, entrando no IF a baixo.
//                Object opcoes[] = {"Tentar novamente", "Cancelar"}; //0 1 2
//                int i = JOptionPane.showOptionDialog(
//                        null, "<html><b>FIM DE PAPEL</b> na Impressora Fiscal, troque a bobina.</html>", "",
//                        0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
//                switch (i) {
//                    case 0:
//                        return comandoECF(s);
//                    case 1:
//                        break;
//                }
//            }
//            if (ex.getMessage().endsWith("não está em linha") && comandoECF("Ativo").equalsIgnoreCase("true")) { //Se o retorno foi não está em linha, mas o ECF está ativado no monitor...
//                Object opcoes[] = {"Tentar novamente", "Cancelar"}; //0 1 2
//                int i = JOptionPane.showOptionDialog(
//                        null, "Impressora Fiscal Não está em Linha.", "",
//                        0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
//                switch (i) {
//                    case 0:
//                        return comandoECF(s);
//                    case 1:
//                        break;
//                }
//            }
            if (ex.getMessage().contains("Connection refused: connect") || ex.getMessage().contains("Connection reset")) {
                if (numTentativas <= 3) {
                    try {
                        for (int i = 5; i > 0; i--) {
                            System.err.println((mensagem = traduzMensagem(ex.getMessage())) + "\nVerifique se o ACBrMonitorPlus Está ativo.\nTentando novamente em " + i + " segundos. (Tentativa " + numTentativas + ")");
                            Thread.sleep(1000);
                        }
                        System.out.println("Resetando conexão e tentando novamente...");
                        ACBr.getInstance().resetarConexao();
                    } catch (InterruptedException ex1) {
                        throw new ACBrECFException(ex1.getMessage());
                    }
                    numTentativas++;
                    ArrayList a;
                    return comandoECF(s);
                }
            }
            throw new ACBrECFException(ex.getMessage());
        }
    }

    private static String mensagem = "";

    public synchronized String getMensagem() {
        return traduzMensagem(mensagem);
    }

    public Variaveis getVariaveis() {
        return variaveis == null ? variaveis = new Variaveis() : variaveis;
    }

    public CupomFiscal getCupomFiscal() {
        return cupomFiscal == null ? cupomFiscal = new CupomFiscal(aac, this) : cupomFiscal;
    }

    public Relatorios getRelatorios() {
        return relatorios == null ? relatorios = new Relatorios(this) : relatorios;
    }

    public Dispositivos getDispositivos() {
        return dispositivos == null ? dispositivos = new Dispositivos() : dispositivos;
    }

    public PAF getPaf() {
        return paf == null ? paf = new PAF() : paf;
    }

    public NaoFiscal getNaoFiscal() {
        return naoFiscal == null ? naoFiscal = new NaoFiscal() : naoFiscal;
    }

    public Parametros getParametros() {
        return parametros == null ? parametros = new Parametros() : parametros;
    }

    public Utilitarios getUtilitarios() {
        return utilitarios == null ? utilitarios = new Utilitarios() : utilitarios;
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

    private static String traduzMensagem(String mensagem) {
        switch (mensagem) {
            case "Connection refused: connect":
                return "Conexão rejeitada: Conectar";
            case "Connection reset":
                return "Conexão resetada.";
            default:
                return mensagem;
        }
    }

    public char getSufixoAliquota() {
        return getCupomFiscal().getSufixoAliquota();
    }

    public void setSufixoAliquota(char sufixoAliquota) {
        getCupomFiscal().setSufixoAliquota(sufixoAliquota);
    }

    public ACBrAAC getAac() {
        return aac;
    }

    public void setAac(ACBrAAC aac) {
        this.aac = aac;
    }

}
