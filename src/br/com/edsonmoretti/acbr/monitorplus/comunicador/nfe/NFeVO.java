/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe;

/**
 *
 * @author DANIEL
 */
public class NFeVO {

    //membros
    private InfNfe infNfe;
    private Identificacao identificacao;
    private ListVO<NFRef> listNFRef;
    private Emitente emitente;
    private Avulsa avulsa;
    private Destinatario destinatario;
    private Retirada retirada;
    private Entrega entrega;
    private ListVO<AautXML> listAutXML;
    private ListVO<Produto> listProduto;

    public enum Modelo {

        /**
         * Modelo 55
         */
        NFe(55),
        /**
         * Modelo 65
         */
        NFCe(65),
        /**
         * Modelo 55
         *
         * @deprecated
         */
        NFe_55("55"),
        /**
         * Modelo 65
         *
         * @deprecated
         */
        NFCe_65("65");

        Integer modelo;

        Modelo(int modelo) {
            this.modelo = modelo;
        }

        /**
         * @deprecated @param modelo
         */
        Modelo(String modelo) {
            this.modelo = Integer.parseInt(modelo);
        }

        @Override
        public String toString() {
            return modelo.toString();
        }

    }

    public NFeVO(InfNfe infNfe, Identificacao Identificacao, Emitente Emitente, Avulsa Avulsa, Destinatario Destinatario, Retirada Retirada, Entrega Entrega) {
        this.infNfe = infNfe;
        this.identificacao = Identificacao;
        this.listNFRef = new ListVO<>();
        this.emitente = Emitente;
        this.avulsa = Avulsa;
        this.destinatario = Destinatario;
        this.retirada = Retirada;
        this.entrega = Entrega;
        this.listAutXML = new ListVO<>();
        this.listProduto = new ListVO<>();
    }

    public NFeVO addNFRef(NFRef NFRef) {
        this.listNFRef.add(NFRef);
        return this;
    }

    public NFeVO addautXML(AautXML autXML) {
        this.listAutXML.add(autXML);
        return this;
    }

    public NFeVO addProduto(Produto Produto) {
        this.listProduto.add(Produto);
        return this;
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno += (infNfe).toString();
        retorno += (identificacao).toString();
        retorno += (listNFRef).toString();
        retorno += (emitente).toString();
        retorno += (avulsa).toString();
        retorno += (destinatario).toString();
        retorno += (retirada).toString();
        retorno += (entrega).toString();
        retorno += (listAutXML).toString();
        retorno += (listProduto).toString();
        return retorno;
    }

//    private static void gerarIndex(List list, Object pai) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i) instanceof Membro_List) {
//                Membro_List mbr = (Membro_List) list.get(i);
//                if (mbr.getInd_XXX() == null) {
//                    mbr.setInd_XXX(TextUtils.lpadZero(3, i + 1));
//                } else if (mbr.getInd_YYY() == null) {
//                    mbr.setInd_YYY(TextUtils.lpadZero(3, i + 1));
//                } else if (mbr.getInd_KKK() == null) {
//                    mbr.setInd_KKK(TextUtils.lpadZero(3, i + 1));
//                }
//
////                mbr.setInd_XXX((pai instanceof Membro_List && ((Membro_List) pai).getInd_XXX() != null) ? ((Membro_List) pai).getInd_XXX() : TextUtils.lpadZero(3, i + 1));
////                mbr.setInd_YYY((pai instanceof Membro_List && ((Membro_List) pai).getInd_YYY() != null) ? ((Membro_List) pai).getInd_YYY() : TextUtils.lpadZero(3, i + 1));
////                mbr.setInd_KKK((pai instanceof Membro_List && ((Membro_List) pai).getInd_KKK() != null) ? ((Membro_List) pai).getInd_KKK() : TextUtils.lpadZero(3, i + 1));
//            } else if (list.get(i) instanceof List) {
//                gerarIndex((List) list.get(i), list.get(i));
//            }
//        }
//        for (int x = 0; x < list.size(); x++) {
//            //filho XXX
//            Membro_List mbrX = (Membro_List) list.get(x);
//            mbrX.setInd_XXX(TextUtils.lpadZero(3, x + 1));
//            if (mbrX instanceof List) {
//                for (int y = 0; y < ((List) mbrX).size(); y++) {
//                    //filho YYY
//                    Membro_List mbrY = (Membro_List) list.get(y);
//                    mbrY.setInd_XXX(TextUtils.lpadZero(3, x + 1));
//                    mbrY.setInd_YYY(TextUtils.lpadZero(3, y + 1));
//                    if (mbrY instanceof List) {
//                        for (int k = 0; k < ((List) mbrY).size(); k++) {
//                            //filho KKK
//                            Membro_List mbrK = (Membro_List) list.get(k);
//                            mbrK.setInd_XXX(TextUtils.lpadZero(3, x + 1));
//                            mbrK.setInd_YYY(TextUtils.lpadZero(3, y + 1));
//                            mbrK.setInd_KKK(TextUtils.lpadZero(3, k + 1));
//                        }
//                    }
//                }
//            }
//        }
//    }
//    public static String objToIni(Object item, Object pai) {
//        StringBuilder sb = new StringBuilder();
//
//        if (item instanceof List) {
//            for (Object mbr : ((List) item)) {
//                sb.append(objToIni(mbr, item));
//            }
//        } else {
//            sb.append(item.toString());
//        }
//
//        String retorno = sb.toString();
//        return retorno;
//    }
}
