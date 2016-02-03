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
public class LMFC {

    private Impressao impressao;
    private Espelho espelho;
    private Cotepe1704 cotepe1704;

    public Impressao getImpressao() {
        return impressao == null ? impressao = new Impressao() : impressao;
    }

    public Espelho getEspelho() {
        return espelho == null ? espelho = new Espelho() : espelho;
    }

    public Cotepe1704 getCotepe1704() {
        return cotepe1704 == null ? cotepe1704 = new Cotepe1704() : cotepe1704;
    }

    public class Impressao {

        /**
         * Imprime na ECF a leitura da memória fiscal completa por período de
         * data.
         *
         * @param dataIni - Data Inicial. (dd/mm/aaaa)
         * @param dataFim - Data final. (dd/mm/aaaa)
         * @throws ACBrECFException
         */
        public void porPeriodo(Date dataIni, Date dataFim) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFC_Impressao(" + ACBr.formatDataBR(dataIni) + ", " + ACBr.formatDataBR(dataFim) + ")");
        }

        /**
         * Imprime na ECF a leitura da memória fiscal completa por intervalo de
         * CRZ.
         *
         * @param cooIni - Redução Z inicial.
         * @param cooFim - Redução Z final.
         * @throws ACBrECFException
         */
        public void porCRZ(int cooIni, int cooFim) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFC_Impressao(" + cooIni + ", " + cooFim + ")");
        }
    }

    public class Espelho {

        /**
         * Imprime na ECF a leitura da memória fiscal completa por período de
         * data.
         *
         * @param dataIni - Data Inicial. (dd/mm/aaaa)
         * @param dataFim - Data final. (dd/mm/aaaa)
         * @param caminho Local onde será gerado o arquivo
         * @throws ACBrECFException
         */
        public void porPeriodo(Date dataIni, Date dataFim, String caminho) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFC_Espelho(" + ACBr.formatDataBR(dataIni) + ", " + ACBr.formatDataBR(dataFim) + "," + caminho + ")");
        }

        /**
         * Gera arquivo do espelho da Leitura Memória Fiscal Completa por
         * período de Data e assina digitalmente, inserindo ao final do arquivo
         * uma linha com o registro tipo EAD( Assinatura Digital ).
         *
         * @param cooIni - Redução Z inicial.
         * @param cooFim - Redução Z final.
         * @param caminho Local onde será gerado o arquivo
         * @throws ACBrECFException
         */
        public void porCRZ(int cooIni, int cooFim, String caminho) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFC_Espelho(" + cooIni + ", " + cooFim + "," + caminho + ")");
        }
    }

    public class Cotepe1704 {

        /**
         * Gera o arquivo da Leitura da Memória Fiscal completa no formato
         * estabelecido no Ato COTEPE/ICMS 17/04 por período de Data e assina
         * digitalmente, inserindo ao final do arquivo uma linha com o registro
         * tipo EAD( Assinatura Digital ).
         *
         * @param dataIni - Data Inicial. (dd/mm/aaaa)
         * @param dataFim - Data final. (dd/mm/aaaa)
         * @param caminho Local onde será gerado o arquivo
         * @throws ACBrECFException
         */
        public void porPeriodo(Date dataIni, Date dataFim, String caminho) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFC_Cotepe1704(" + ACBr.formatDataBR(dataIni) + ", " + ACBr.formatDataBR(dataFim) + "," + caminho + ")");
        }

        /**
         * Gera o arquivo no formato estabelecido no Ato COTEPE/ICMS 17/04 por
         * intervalo de Redução Z e assina digitalmente, inserindo ao final do
         * arquivo uma linha com o registro tipo EAD( Assinatura Digital ).
         *
         * @param cooIni - Redução Z inicial.
         * @param cooFim - Redução Z final.
         * @param caminho Local onde será gerado o arquivo
         * @throws ACBrECFException
         */
        public void porCRZ(int cooIni, int cooFim, String caminho) throws ACBrECFException {
            ACBrECF.comandoECF("PafMF_LMFC_Cotepe1704(" + cooIni + ", " + cooFim + "," + caminho + ")");
        }
    }
}
