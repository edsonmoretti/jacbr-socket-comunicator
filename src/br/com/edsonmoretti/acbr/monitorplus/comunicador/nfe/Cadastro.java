/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Edson
 */
public class Cadastro {

    private final String verAplic;
    private final String cStat;
    private final String xMotivo;
    private final String UF;
    private final String IE;
    private final String CNPJ;
    private final String CPF;
    private final String DhCons;
    private final String cUF;
    private final List<INFCAD> informacoesCadastrais = new ArrayList<>();

    public Cadastro(String ini) {
        verAplic = TextUtils.lerTagIni("verAplic", ini);
        cStat = TextUtils.lerTagIni("cStat", ini);
        xMotivo = TextUtils.lerTagIni("xMotivo", ini);
        UF = TextUtils.lerTagIni("UF", ini);
        IE = TextUtils.lerTagIni("IE", ini);
        CNPJ = TextUtils.lerTagIni("CNPJ", ini);
        CPF = TextUtils.lerTagIni("CPF", ini);
        DhCons = TextUtils.lerTagIni("DhCons", ini);
        cUF = TextUtils.lerTagIni("cUF", ini);

        boolean um = true;
        for (String string : ini.split("INFCAD")) {
            if (um) {
                um = false;
                continue;
            }
            informacoesCadastrais.add(new INFCAD(string));
        }
    }

    public String getVerAplic() {
        return verAplic;
    }

    public String getcStat() {
        return cStat;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public String getUF() {
        return UF;
    }

    public String getIE() {
        return IE;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public String getDhCons() {
        return DhCons;
    }

    public String getcUF() {
        return cUF;
    }

    public List<INFCAD> getInformacoesCadastrais() {
        return informacoesCadastrais;
    }

    public class INFCAD {

        private final String IE;
        private final String CNPJ;
        private final String CPF;
        private final String UF;
        private final String cSit;
        private final String xNome;
        private final String xFant;
        private final String xRegApur;
        private final String CNAE;
        private final String dIniAtiv;
        private final String dUltSit;
        private final String dBaixa;
        private final String IEUnica;
        private final String IEAtual;
        private final String xLgr;
        private final String nro;
        private final String xCpl;
        private final String xBairro;
        private final String cMun;
        private final String xMun;
        private final String CEP;

        public INFCAD(String iniInf) {
            IE = TextUtils.lerTagIni("IE", iniInf);
            CNPJ = TextUtils.lerTagIni("CNPJ", iniInf);
            CPF = TextUtils.lerTagIni("CPF", iniInf);
            UF = TextUtils.lerTagIni("UF", iniInf);
            cSit = TextUtils.lerTagIni("cSit", iniInf);
            xNome = TextUtils.lerTagIni("xNome", iniInf);
            xFant = TextUtils.lerTagIni("xFant", iniInf);
            xRegApur = TextUtils.lerTagIni("xRegApur", iniInf);
            CNAE = TextUtils.lerTagIni("CNAE", iniInf);
            dIniAtiv = TextUtils.lerTagIni("dIniAtiv", iniInf);
            dUltSit = TextUtils.lerTagIni("dUltSit", iniInf);
            dBaixa = TextUtils.lerTagIni("dBaixa", iniInf);
            IEUnica = TextUtils.lerTagIni("IEUnica", iniInf);
            IEAtual = TextUtils.lerTagIni("IEAtual", iniInf);
            xLgr = TextUtils.lerTagIni("xLgr", iniInf);
            nro = TextUtils.lerTagIni("nro", iniInf);
            xCpl = TextUtils.lerTagIni("xCpl", iniInf);
            xBairro = TextUtils.lerTagIni("xBairro", iniInf);
            cMun = TextUtils.lerTagIni("cMun", iniInf);
            xMun = TextUtils.lerTagIni("xMun", iniInf);
            CEP = TextUtils.lerTagIni("CEP", iniInf);
        }

        public String getIE() {
            return IE;
        }

        public String getCNPJ() {
            return CNPJ;
        }

        public String getCPF() {
            return CPF;
        }

        public String getUF() {
            return UF;
        }

        public String getcSit() {
            return cSit;
        }

        public String getxNome() {
            return xNome;
        }

        public String getxFant() {
            return xFant;
        }

        public String getxRegApur() {
            return xRegApur;
        }

        public String getCNAE() {
            return CNAE;
        }

        public String getdIniAtiv() {
            return dIniAtiv;
        }

        public String getdUltSit() {
            return dUltSit;
        }

        public String getdBaixa() {
            return dBaixa;
        }

        public String getIEUnica() {
            return IEUnica;
        }

        public String getIEAtual() {
            return IEAtual;
        }

        public String getxLgr() {
            return xLgr;
        }

        public String getNro() {
            return nro;
        }

        public String getxCpl() {
            return xCpl;
        }

        public String getxBairro() {
            return xBairro;
        }

        public String getcMun() {
            return cMun;
        }

        public String getxMun() {
            return xMun;
        }

        public String getCEP() {
            return CEP;
        }
        
    }
}
