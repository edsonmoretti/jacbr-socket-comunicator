
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils.extrarSecaoesDeIni;
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils.lerTagIni;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson
 */
public class TesteTextUtils {
    //USE APENAS PARA TESTES

    public static void main(String[] args) {
        //String ini = "[DESCRICAO]ORIENTACAO=0FONTE=2MULTIPLICADOR_H=2MULTIPLICADOR_V=2VERTICAL=19HORIZONTAL=5[GTIN]ORIENTACAO=0FONTE=1MULTIPLICADOR_H=2MULTIPLICADOR_V=30VERTICAL=13HORIZONTAL=5[R$01]ORIENTACAO=0FONTE=3MULTIPLICADOR_H=3MULTIPLICADOR_V=2VERTICAL=0HORIZONTAL=7[PRECO01]ORIENTACAO=0FONTE=3MULTIPLICADOR_H=4MULTIPLICADOR_V=3VERTICAL=0HORIZONTAL=20[R$02]ORIENTACAO=0FONTE=2MULTIPLICADOR_H=2MULTIPLICADOR_V=2VERTICAL=3HORIZONTAL=5[PRECO02]ORIENTACAO=0FONTE=3MULTIPLICADOR_H=4MULTIPLICADOR_V=3VERTICAL=0HORIZONTAL=40[AMBOSPRECOS][ATACADO]ORIENTACAO=0FONTE=2MULTIPLICADOR_H=2MULTIPLICADOR_V=2VERTICAL=10HORIZONTAL=70[PRECO02]ORIENTACAO=0FONTE=2MULTIPLICADOR_H=2MULTIPLICADOR_V=2VERTICAL=5HORIZONTAL=70";
        String ini = "[STATUS]\n"
                + "Versao=1.07\n"
                + "TpAmb=2\n"
                + "VerAplic=SP_NFE_PL_005c\n"
                + "CStat=107\n"
                + "XMotivo=Serviço em Operação\n"
                + "CUF=35\n"
                + "DhRecbto=2009-03-25T08:44:20\n"
                + "TMed=1\n"
                + "DhRetorno=\n"
                + "DigVal=a8F/F3ibhYYXI5GLhCM82O8yiqc=\n"
                + "XObs=";
        System.out.println(lerTagIni("VeRsAo", ini));
        System.out.println(lerTagIni("tpamb", ini));
        System.out.println(lerTagIni("VERAPLIC", ini));
        System.out.println(lerTagIni("DHRECBto", ini));
//        System.out.println(lerTagIni("xmOTIVO", ini));
        System.out.println(lerTagIni("xmOTIVO", ini, "edson"));
        System.out.println(lerTagIni("xmOTIVO", ini, "moretti"));
        System.out.println(lerTagIni("xmOTIVO", ini, "status"));
        System.out.println(lerTagIni("xmOTIVO", ini));
        System.out.println(lerTagIni("DigVal", ini));

        TreeMap<String, String> extrarSecaoesDeIni = extrarSecaoesDeIni(ini);
        for (String secao : extrarSecaoesDeIni.keySet()) {
            System.out.println(secao);
            System.out.println(extrarSecaoesDeIni.get(secao));
        }
    }
}
