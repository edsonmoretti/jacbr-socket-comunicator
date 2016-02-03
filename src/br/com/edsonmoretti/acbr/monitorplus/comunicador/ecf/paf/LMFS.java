/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.paf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBr;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import java.util.Date;

/**
 *
 * @author Edson
 */
public class LMFS {

    private Impressao impressao;
    private Espelho espelho;

    public Impressao getImpressao() {
        return impressao == null ? impressao = new Impressao() : impressao;
    }

    public Espelho getEspelho() {
        return espelho == null ? espelho = new Espelho() : espelho;
    }

    public class Impressao {

        /**
         * Imprime na ECF a leitura da memória fiscal simplificada por período
         * de data.
         *
         * @param dataIni - Data Inicial. (dd/mm/aaaa)
         * @param dataFim - Data final. (dd/mm/aaaa)
         * @throws ACBrECFException
         */
        public void porPeriodo(Date dataIni, Date dataFim) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFS_Impressao(" + ACBr.formatDataBR(dataIni) + ", " + ACBr.formatDataBR(dataFim) + ")");
        }

        /**
         * Imprime na ECF a leitura da memória fiscal simplificada por intervalo
         * de CRZ.
         *
         * @param cooIni - Redução Z inicial.
         * @param cooFim - Redução Z final.
         * @throws ACBrECFException
         */
        public void porCRZ(int cooIni, int cooFim) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFS_Impressao(" + cooIni + ", " + cooFim + ")");
        }
    }

    public class Espelho {

        /**
         * Imprime na ECF a leitura da memória fiscal Simplificada por período
         * de data.
         *
         * @param dataIni - Data Inicial. (dd/mm/aaaa)
         * @param dataFim - Data final. (dd/mm/aaaa)
         * @param caminho Local onde será gerado o arquivo
         * @throws ACBrECFException
         */
        public void porPeriodo(Date dataIni, Date dataFim, String caminho) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFS_Espelho(" + ACBr.formatDataBR(dataIni) + ", " + ACBr.formatDataBR(dataFim) + "," + caminho + ")");
        }

        /**
         * Gera arquivo do espelho da Leitura Memória Fiscal Simplificada por
         * período de Data e assina digitalmente, inserindo ao final do arquivo
         * uma linha com o registro tipo EAD( Assinatura Digital ).
         *
         * @param cooIni - Redução Z inicial.
         * @param cooFim - Redução Z final.
         * @param caminho Local onde será gerado o arquivo
         * @throws ACBrECFException
         */
        public void porCRZ(int cooIni, int cooFim, String caminho) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFS_Espelho(" + cooIni + ", " + cooFim + "," + caminho + ")");
        }
    }
}
