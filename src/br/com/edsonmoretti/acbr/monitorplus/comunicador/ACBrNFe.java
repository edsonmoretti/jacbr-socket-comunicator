/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeInvalidaException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.Cadastro;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.XMotivoCancelamento;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.XMotivoConsulta;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.XMotivoInutilizar;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.nfe.XMotivoStatusDoServico;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.TextUtils;
import java.io.File;
import java.util.Date;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBrNFe {

    private static String NFE = "NFE.";

    public ACBrNFe() {
    }

    public static String comandoNFe(String s) throws ACBrNFeException {
        try {
            String retorno = (ACBr.getInstance().comandoAcbr(NFE + s));
            return retorno;
        } catch (ACBrException ex) {
            throw new ACBrNFeException(ex);
        }
    }

    private String enviarEvento(String iniEvento) throws ACBrNFeException {
        return comandoNFe("EnviarEvento(\"" + iniEvento + "\")");
    }

    /**
     * Verifica o Status do Serviço dos WebServices da Receita
     *
     * @return String com resultado no formato INI
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrNFeException
     *
     */
    public XMotivoStatusDoServico getStatusServico() throws ACBrNFeException {
        String re = comandoNFe("StatusServico");
        XMotivoStatusDoServico sds = new XMotivoStatusDoServico(re);

        sds.setTMed(TextUtils.lerTagIni("TMed", re));
        return sds;
    }

    /**
     * Valida arquivo da NFe. Arquivo deve estar assinado.
     *
     * @param arquivo Caminho do arquivo a ser validado.
     * @throws ACBrNFeInvalidaException
     */
    public void validarNFe(String arquivo) throws ACBrNFeInvalidaException {
        try {
            comandoNFe("ValidarNFe(\"" + arquivo + "\")");
        } catch (ACBrNFeException ex) {
            throw new ACBrNFeInvalidaException(ex);
        }
    }

    /**
     * Valida arquivo da NFe. Arquivo deve estar assinado.
     *
     * @param arquivo Caminho do arquivo a ser validado.
     * @throws ACBrNFeInvalidaException
     */
    public void validarNFe(File arquivo) throws ACBrNFeInvalidaException {
        try {
            comandoNFe("ValidarNFe(\"" + arquivo + "\")");
        } catch (ACBrNFeException ex) {
            throw new ACBrNFeInvalidaException(ex);
        }
    }

    /**
     * Assina uma NFe. Arquivo assinado será salvo na pasta configurada na aba
     * WebService na opção "Salvar Arquivos de Envio e Resposta".
     *
     * @param arquivo Caminho do arquivo a ser assinado.
     * @throws ACBrNFeException
     */
    public void assinarNFe(String arquivo) throws ACBrNFeException {
        comandoNFe("AssinarNFe(\"" + arquivo + "\")");
    }

    /**
     * Assina uma NFe. Arquivo assinado será salvo na pasta configurada na aba
     * WebService na opção "Salvar Arquivos de Envio e Resposta".
     *
     * @param arquivo Caminho do arquivo a ser assinado.
     * @throws ACBrNFeException
     */
    public void assinarNFe(File arquivo) throws ACBrNFeException {
        comandoNFe("AssinarNFe(\"" + arquivo + "\")");
    }

    /**
     * Cria XML da NFe baseado em um arquivo INI. <br>
     * NFe.CriarNFe(cIniNFe,[bRetornaXML])<br>
     *
     * @param iniNFe Texto no formato de arquivo INI com informações da NFe.
     * @param betornaXML Coloque o valor 1 se quiser que o ACBrNFeMonitor
     * retorne além do Path de onde o arquivo foi criado, o XML gerado. Por
     * default não retorna o XML.
     * @return
     * @throws ACBrNFeException
     * @deprecated Mudar para HashMap<File,String> com File e String XML, por
     * enquanto use o criarNFe(String iniNFe) retorno File.<br><br>
     * <b>Observações</b><br>
     * A maioria dos campos utiliza a nomenclatura do manual disponibilizado
     * pelo SEFAZ apenas os grupos(o que está entre []) segue a nomenclatura
     * interna do ACBrNFeMonitor. A literal XXX indica grupos que podem ocorrer
     * mais de uma vez(produtos por exemplo) e quando existir YYY ou KKK indica
     * grupos que são filhos de grupos com mais de uma ocorrência. Por exemplo,
     * no caso da Declaração de Importação podemos ter 0-100 ocorrências e cada
     * Declaração de Importação pode conter de 1-100 Adições, então temos o
     * grupo [DI001] e após ele podemos ter [LADI001YYY] onde YYY pode ser de
     * 001 a 100.<br><br>
     * - Algumas grupos podem ser repetidos. Ex: Para incluir dois produtos,
     * existirão uma chave Produto001 e Produto002 e assim sucessivamente. As
     * chaves de imposto (ICMS,IPI,COFINS, etc) devem ter o memo número do
     * produto, ou seja, o ICMS da chave Produto0002 deve ser ICMS002.<br>
     * - Acentos podem causar problemas na criação do NFe. Ao tentar criar uma
     * NFe, caso receba o erro "Unable to Parse" verifique se não existem
     * caracteres acentuados nos campos.<br><br>
     * O conteúdo do parâmetro cIniNFe, deve possuir o seguinte formato:<br><br>
     * <b>[infNFe]</b><br>
     * versao=<br>3.10<br><br>
     * <b>[Identificacao]</b><br>
     * cNF=<br>
     * natOp=<br>
     * indPag=<br>
     * mod=<br>
     * serie=<br>
     * nNF=<br>
     * dhEmi=<br>
     * dhSaiEnt=<br>
     * tpNF=<br>
     * idDest=<br>
     * tpImp=<br>
     * tpEmis=<br>
     * finNFe=<br>
     * indFinal=<br>
     * indPres=<br>
     * procEmi=<br>
     * verProc=<br>
     * dhCont=<br>
     * xJust=<br><br>
     * <b>[NFRefXXX]</b><br>
     * Tipo=<br>
     * refNFe=<br>
     * cUF=<br>
     * AAMM=<br>
     * CNPJ=<br>
     * mod=<br>
     * Serie=<br>
     * nNF=<br>
     * CNPJCPF=<br>
     * IE=<br>
     * refCTe=<br>
     * ModECF=<br>
     * nECF=<br>
     * nCOO=<br><br>
     * <b>[Emitente]</b><br>
     * CNPJCPF=<br>
     * xNome=<br>
     * xFant=<br>
     * IE=<br>
     * IEST=<br>
     * IM=<br>
     * CNAE=<br>
     * CRT=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br>
     * CEP=<br>
     * cPais=<br>
     * xPais=<br>
     * Fone=<br>
     * cUF=<br>
     * cMunFG=<br><br>
     * <b>[Avulsa]</b><br>
     * CNPJ=<br>
     * xOrgao=<br>
     * matr=<br>
     * xAgente=<br>
     * fone=<br>
     * UF=<br>
     * nDAR=<br>
     * dEmi=<br>
     * vDAR=<br>
     * repEmi=<br>
     * dPag=<br><br>
     * <b>[Destinatario]</b><br>
     * idEstrangeiro=<br>
     * CNPJCPF=<br>
     * xNome=<br>
     * indIEDest=<br>
     * IE=<br>
     * ISUF=<br>
     * Email=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br>
     * CEP=<br>
     * cPais=<br>
     * xPais=<br>
     * Fone=<br><br>
     * <b>[Retirada]</b><br>
     * CNPJCPF=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br><br>
     * <b>[Entrega]</b><br>
     * CNPJCPF=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br><br>
     * <b>[autXMLXXX]</b><br>
     * CNPJCPF=<br><br>
     * <b>[ProdutoXXX]</b><br>
     * cProd=<br>
     * cEAN=<br>
     * xProd=<br>
     * NCM=<br>
     * EXTIPI=<br>
     * CFOP=<br>
     * uCom=<br>
     * qCom=<br>
     * vUnCom=<br>
     * vProd=<br>
     * cEANTrib=<br>
     * uTrib=<br>
     * qTrib=<br>
     * vUnTrib=<br>
     * vFrete=<br>
     * vSeg=<br>
     * vDesc=<br>
     * vOutro=<br>
     * indTot=<br>
     * xPed=<br>
     * nItemPed=<br>
     * nFCI=<br>
     * nRECOPI=<br>
     * pDevol=<br>
     * vIPIDevol=<br>
     * vTotTrib=<br>
     * infAdProd=<br><br>
     * <b>[NVEXXXYYY]</b><br>
     * NVE=<br><br>
     * <b>[DIXXXYYY]</b><br>
     * nDi=<br>
     * dDi=<br>
     * xLocDesemb=<br>
     * UFDesemb=<br>
     * dDesemb=<br>
     * tpViaTransp=<br>
     * vAFRMM=<br>
     * tpIntermedio=<br>
     * CNPJ=<br>
     * UFTerceiro=<br>
     * cExportador=<br><br>
     * <b>[LADIXXXYYYKKK]</b><br>
     * nAdicao=<br>
     * nSeqAdi=<br>
     * cFabricante=<br>
     * vDescDI=<br>
     * nDraw=<br><br>
     * <b>[detExportXXXYYY]</b><br>
     * nDraw=<br>
     * nRE=<br>
     * chNFe=<br>
     * qExport=<br><br>
     * <b>[impostoDevolXXX]</b><br>
     * pDevol=<br>
     * vIPIDevol=<br><br>
     * <b>[VeiculoXXX]</b><br>
     * chassi=<br>
     * tpOP=<br>
     * cCor=<br>
     * xCor=<br>
     * pot=<br>
     * Cilin=<br>
     * pesoL=<br>
     * pesoB=<br>
     * nSerie=<br>
     * tpComb=<br>
     * nMotor=<br>
     * CMT=<br>
     * dist=<br>
     * anoMod=<br>
     * anoFab=<br>
     * tpPint=<br>
     * tpVeic=<br>
     * espVeic=<br>
     * VIN=<br>
     * condVeic=<br>
     * cMod=<br>
     * cCorDENATRAN=<br>
     * lota=<br>
     * tpRest=<br><br>
     * <b>[MedicamentoXXXYYY]</b><br>
     * nLote=<br>
     * qLote=<br>
     * dFab=<br>
     * dVal=<br>
     * vPMC=<br><br>
     * <b>[ArmaXXXYYY]</b><br>
     * nSerie=<br>
     * tpArma=<br>
     * nCano=<br>
     * descr=<br><br>
     * <b>[CombustivelXXX]</b><br>
     * cProdANP=<br>
     * pMixGN=<br>
     * CODIF=<br>
     * qTemp=<br>
     * UFCons=<br><br>
     * <b>[CIDEXXX]</b><br>
     * qBCprod=<br>
     * vAliqProd=<br>
     * vCIDE=<br><br>
     * <b>[ICMSCombXXX]</b><br>
     * vBCICMS=<br>
     * vICMS=<br>
     * vBCICMSST=<br>
     * vICMSST=<br><br>
     * <b>[ICMSInterXXX]</b><br>
     * vBCICMSSTDest=<br>
     * vICMSSTDest=<br><br>
     * <b>[ICMSConsXXX]</b><br>
     * vBCICMSSTCons=<br>
     * vICMSSTCons=<br>
     * UFCons=<br><br>
     * <b>[ICMSXXX]</b><br>
     * orig=<br>
     * CST=<br>
     * CSOSN=<br>
     * modBC=<br>
     * pRedBC=<br>
     * vBC=<br>
     * pICMS=<br>
     * vICMS=<br>
     * modBCST=<br>
     * pMVAST=<br>
     * pRedBCST=<br>
     * vBCST=<br>
     * pICMSST=<br>
     * vICMSST=<br>
     * UFST=<br>
     * pBCOp=<br>
     * vBCSTRet=<br>
     * vICMSSTRet=<br>
     * motDesICMS=<br>
     * pCredSN=<br>
     * vCredICMSSN=<br>
     * vBCSTDest=<br>
     * vICMSSTDest=<br>
     * vICMSDeson=<br>
     * vICMSOp=<br>
     * pDif=<br>
     * vICMSDif=<br><br>
     * <b>[IPIXXX]</b><br>
     * CST=<br>
     * clEnq=<br>
     * CNPJProd=<br>
     * cSelo=<br>
     * qSelo=<br>
     * cEnq=<br>
     * vBC=<br>
     * qUnid=<br>
     * vUnid=<br>
     * pIPI=<br>
     * vIPI=<br><br>
     * <b>[IIXXX]</b><br>
     * vBC=<br>
     * vDespAdu=<br>
     * vII=<br>
     * vIOF=<br><br>
     * <b>[PISXXX]</b><br>
     * CST=<br>
     * vBC=<br>
     * pPIS=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vPIS=<br><br>
     * <b>[PISSTXXX]</b><br>
     * vBC=<br>
     * pPis=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vPIS=<br><br>
     * <b>[COFINSXXX]</b><br>
     * CST=<br>
     * vBC=<br>
     * pCOFINS=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vCOFINS=<br><br>
     * <b>[COFINSSTXXX]</b><br>
     * vBC=<br>
     * pCOFINS=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vCOFINS=<br><br>
     * <b>[ISSQNXXX]</b><br>
     * vBC=<br>
     * vAliq=<br>
     * vISSQN=<br>
     * cMunFG=<br>
     * cListServ=<br>
     * cSitTrib=<br>
     * vDeducao=<br>
     * vDeducao=<br>
     * vOutro=<br>
     * vDescIncond=<br>
     * vDescCond=<br>
     * vISSRet=<br>
     * indISS=<br>
     * cServico=<br>
     * cMun=<br>
     * cPais=<br>
     * nProcesso=<br>
     * indIncentivo=<br><br>
     * <b>[Total]</b><br>
     * vBC=<br>
     * vICMS=<br>
     * vICMSDeson=<br>
     * vBCST=<br>
     * vST=<br>
     * vProd=<br>
     * vFrete=<br>
     * vSeg=<br>
     * vDesc=<br>
     * vII=<br>
     * vIPI=<br>
     * vPIS=<br>
     * vCOFINS=<br>
     * vOutro=<br>
     * vNF=<br>
     * vTotTrib=<br><br>
     * <b>[ISSQNtot]</b><br>
     * vServ=<br>
     * vBC=<br>
     * vISS=<br>
     * vPIS=<br>
     * vCOFINS=<br>
     * dCompet=<br>
     * vDeducao=<br>
     * vOutro=<br>
     * vDescIncond=<br>
     * vDescCond=<br>
     * vISSRet=<br>
     * cRegTrib=<br><br>
     * <b>[retTrib]</b><br>
     * vRetPIS=<br>
     * vRetCOFINS=<br>
     * vRetCSLL=<br>
     * vBCIRRF=<br>
     * vIRRF=<br>
     * vBCRetPrev=<br>
     * vRetPrev=<br><br>
     * <b>[Transportador]</b><br>
     * modFrete=<br>
     * CNPJCPF=<br>
     * xNome=<br>
     * IE=<br>
     * xEnder=<br>
     * xMun=<br>
     * UF=<br>
     * vServ=<br>
     * vBCRet=<br>
     * pICMSRet=<br>
     * vICMSRet=<br>
     * CFOP=<br>
     * cMunFG=<br>
     * Placa=<br>
     * UFPlaca=<br>
     * RNTC=<br>
     * vagao=<br>
     * balsa=<br><br>
     * <b>[ReboqueXXX]</b><br>
     * placa=<br>
     * UF=<br>
     * RNTC=<br><br>
     * <b>[VolumeXXX]</b><br>
     * qVol=<br>
     * esp=<br>
     * Marca=<br>
     * nVol=<br>
     * pesoL=<br>
     * pesoB=<br><br>
     * <b>[LacreXXXYYY]</b><br>
     * nLacre=<br><br>
     * <b>[Fatura]</b><br>
     * nFat=<br>
     * vOrig=<br>
     * vDesc=<br>
     * vLiq=<br><br>
     * <b>[DuplicataXXX]</b><br>
     * nDup=<br>
     * dVenc=<br>
     * vDup=<br><br>
     * <b>[PAGXXX]</b><br>
     * tpag=<br>
     * vPag=<br>
     * CNPJ=<br>
     * tBand=<br>
     * cAut=<br><br>
     * <b>[DadosAdicionais]</b><br>
     * infAdFisco=<br>
     * infCpl=<br><br>
     * <b>[InfAdicXXX]</b><br>
     * xCampo=<br>
     * xTexto=<br><br>
     * <b>[ObsFiscoXXX]</b><br>
     * xCampo=<br>
     * xTexto=<br><br>
     * <b>[procRefXXX]</b><br>
     * nProc=<br>
     * indProc=<br><br>
     * <b>[Exporta]</b><br>
     * UFSaidaPais=<br>
     * xLocExporta=<br>
     * xLocDespacho=<br><br>
     * <b>[Compra]</b><br>
     * xNEmp=<br>
     * xPed=<br>
     * xCont=<br><br>
     * <b>[cana]</b><br>
     * safra=<br>
     * ref=<br>
     * qTotMes=<br>
     * qTotAnt=<br>
     * qTotGer=<br>
     * vFor=<br>
     * vTotDed=<br>
     * vLiqFor=<br><br>
     * <b>[forDiaXXX]</b><br>
     * dia=<br>
     * qtde=<br><br>
     * <b>[deducXXX]</b><br>
     * xDed=<br>
     * vDed=<br>
     */
    public /*HashMap<File,String>*/ String criarNFeXML(String iniNFe, boolean betornaXML) throws ACBrNFeException {
        return comandoNFe("CriarNFe(\"" + iniNFe + "\"," + betornaXML + ")");
    }

    /**
     * Cria XML da NFe baseado em um arquivo INI. <br>
     * NFe.CriarNFe(cIniNFe,[bRetornaXML])<br>
     *
     * @param iniNFe Texto no formato de arquivo INI com informações da NFe.
     * @return
     * @throws ACBrNFeException
     * <b>Observações</b><br>
     * A maioria dos campos utiliza a nomenclatura do manual disponibilizado
     * pelo SEFAZ apenas os grupos(o que está entre []) segue a nomenclatura
     * interna do ACBrNFeMonitor. A literal XXX indica grupos que podem ocorrer
     * mais de uma vez(produtos por exemplo) e quando existir YYY ou KKK indica
     * grupos que são filhos de grupos com mais de uma ocorrência. Por exemplo,
     * no caso da Declaração de Importação podemos ter 0-100 ocorrências e cada
     * Declaração de Importação pode conter de 1-100 Adições, então temos o
     * grupo [DI001] e após ele podemos ter [LADI001YYY] onde YYY pode ser de
     * 001 a 100.<br><br>
     * - Algumas grupos podem ser repetidos. Ex: Para incluir dois produtos,
     * existirão uma chave Produto001 e Produto002 e assim sucessivamente. As
     * chaves de imposto (ICMS,IPI,COFINS, etc) devem ter o memo número do
     * produto, ou seja, o ICMS da chave Produto0002 deve ser ICMS002.<br>
     * - Acentos podem causar problemas na criação do NFe. Ao tentar criar uma
     * NFe, caso receba o erro "Unable to Parse" verifique se não existem
     * caracteres acentuados nos campos.<br>
     * <b>Exemplo de Resposta</b>: OK: NFe criada em:
     * C:\ACBrNFeMonitor\logs\35XXXXXXXXXXXXXXXX550010000000190000000193-nfe.xml<br><br>
     * O conteúdo do parâmetro cIniNFe, deve possuir o seguinte formato:<br><br>
     * <b>[infNFe]</b><br>
     * versao=<br>3.10<br><br>
     * <b>[Identificacao]</b><br>
     * cNF=<br>
     * natOp=<br>
     * indPag=<br>
     * mod=<br>
     * serie=<br>
     * nNF=<br>
     * dhEmi=<br>
     * dhSaiEnt=<br>
     * tpNF=<br>
     * idDest=<br>
     * tpImp=<br>
     * tpEmis=<br>
     * finNFe=<br>
     * indFinal=<br>
     * indPres=<br>
     * procEmi=<br>
     * verProc=<br>
     * dhCont=<br>
     * xJust=<br><br>
     * <b>[NFRefXXX]</b><br>
     * Tipo=<br>
     * refNFe=<br>
     * cUF=<br>
     * AAMM=<br>
     * CNPJ=<br>
     * mod=<br>
     * Serie=<br>
     * nNF=<br>
     * CNPJCPF=<br>
     * IE=<br>
     * refCTe=<br>
     * ModECF=<br>
     * nECF=<br>
     * nCOO=<br><br>
     * <b>[Emitente]</b><br>
     * CNPJCPF=<br>
     * xNome=<br>
     * xFant=<br>
     * IE=<br>
     * IEST=<br>
     * IM=<br>
     * CNAE=<br>
     * CRT=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br>
     * CEP=<br>
     * cPais=<br>
     * xPais=<br>
     * Fone=<br>
     * cUF=<br>
     * cMunFG=<br><br>
     * <b>[Avulsa]</b><br>
     * CNPJ=<br>
     * xOrgao=<br>
     * matr=<br>
     * xAgente=<br>
     * fone=<br>
     * UF=<br>
     * nDAR=<br>
     * dEmi=<br>
     * vDAR=<br>
     * repEmi=<br>
     * dPag=<br><br>
     * <b>[Destinatario]</b><br>
     * idEstrangeiro=<br>
     * CNPJCPF=<br>
     * xNome=<br>
     * indIEDest=<br>
     * IE=<br>
     * ISUF=<br>
     * Email=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br>
     * CEP=<br>
     * cPais=<br>
     * xPais=<br>
     * Fone=<br><br>
     * <b>[Retirada]</b><br>
     * CNPJCPF=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br><br>
     * <b>[Entrega]</b><br>
     * CNPJCPF=<br>
     * xLgr=<br>
     * nro=<br>
     * xCpl=<br>
     * xBairro=<br>
     * cMun=<br>
     * xMun=<br>
     * UF=<br><br>
     * <b>[autXMLXXX]</b><br>
     * CNPJCPF=<br><br>
     * <b>[ProdutoXXX]</b><br>
     * cProd=<br>
     * cEAN=<br>
     * xProd=<br>
     * NCM=<br>
     * EXTIPI=<br>
     * CFOP=<br>
     * uCom=<br>
     * qCom=<br>
     * vUnCom=<br>
     * vProd=<br>
     * cEANTrib=<br>
     * uTrib=<br>
     * qTrib=<br>
     * vUnTrib=<br>
     * vFrete=<br>
     * vSeg=<br>
     * vDesc=<br>
     * vOutro=<br>
     * indTot=<br>
     * xPed=<br>
     * nItemPed=<br>
     * nFCI=<br>
     * nRECOPI=<br>
     * pDevol=<br>
     * vIPIDevol=<br>
     * vTotTrib=<br>
     * infAdProd=<br><br>
     * <b>[NVEXXXYYY]</b><br>
     * NVE=<br><br>
     * <b>[DIXXXYYY]</b><br>
     * nDi=<br>
     * dDi=<br>
     * xLocDesemb=<br>
     * UFDesemb=<br>
     * dDesemb=<br>
     * tpViaTransp=<br>
     * vAFRMM=<br>
     * tpIntermedio=<br>
     * CNPJ=<br>
     * UFTerceiro=<br>
     * cExportador=<br><br>
     * <b>[LADIXXXYYYKKK]</b><br>
     * nAdicao=<br>
     * nSeqAdi=<br>
     * cFabricante=<br>
     * vDescDI=<br>
     * nDraw=<br><br>
     * <b>[detExportXXXYYY]</b><br>
     * nDraw=<br>
     * nRE=<br>
     * chNFe=<br>
     * qExport=<br><br>
     * <b>[impostoDevolXXX]</b><br>
     * pDevol=<br>
     * vIPIDevol=<br><br>
     * <b>[VeiculoXXX]</b><br>
     * chassi=<br>
     * tpOP=<br>
     * cCor=<br>
     * xCor=<br>
     * pot=<br>
     * Cilin=<br>
     * pesoL=<br>
     * pesoB=<br>
     * nSerie=<br>
     * tpComb=<br>
     * nMotor=<br>
     * CMT=<br>
     * dist=<br>
     * anoMod=<br>
     * anoFab=<br>
     * tpPint=<br>
     * tpVeic=<br>
     * espVeic=<br>
     * VIN=<br>
     * condVeic=<br>
     * cMod=<br>
     * cCorDENATRAN=<br>
     * lota=<br>
     * tpRest=<br><br>
     * <b>[MedicamentoXXXYYY]</b><br>
     * nLote=<br>
     * qLote=<br>
     * dFab=<br>
     * dVal=<br>
     * vPMC=<br><br>
     * <b>[ArmaXXXYYY]</b><br>
     * nSerie=<br>
     * tpArma=<br>
     * nCano=<br>
     * descr=<br><br>
     * <b>[CombustivelXXX]</b><br>
     * cProdANP=<br>
     * pMixGN=<br>
     * CODIF=<br>
     * qTemp=<br>
     * UFCons=<br><br>
     * <b>[CIDEXXX]</b><br>
     * qBCprod=<br>
     * vAliqProd=<br>
     * vCIDE=<br><br>
     * <b>[ICMSCombXXX]</b><br>
     * vBCICMS=<br>
     * vICMS=<br>
     * vBCICMSST=<br>
     * vICMSST=<br><br>
     * <b>[ICMSInterXXX]</b><br>
     * vBCICMSSTDest=<br>
     * vICMSSTDest=<br><br>
     * <b>[ICMSConsXXX]</b><br>
     * vBCICMSSTCons=<br>
     * vICMSSTCons=<br>
     * UFCons=<br><br>
     * <b>[ICMSXXX]</b><br>
     * orig=<br>
     * CST=<br>
     * CSOSN=<br>
     * modBC=<br>
     * pRedBC=<br>
     * vBC=<br>
     * pICMS=<br>
     * vICMS=<br>
     * modBCST=<br>
     * pMVAST=<br>
     * pRedBCST=<br>
     * vBCST=<br>
     * pICMSST=<br>
     * vICMSST=<br>
     * UFST=<br>
     * pBCOp=<br>
     * vBCSTRet=<br>
     * vICMSSTRet=<br>
     * motDesICMS=<br>
     * pCredSN=<br>
     * vCredICMSSN=<br>
     * vBCSTDest=<br>
     * vICMSSTDest=<br>
     * vICMSDeson=<br>
     * vICMSOp=<br>
     * pDif=<br>
     * vICMSDif=<br><br>
     * <b>[IPIXXX]</b><br>
     * CST=<br>
     * clEnq=<br>
     * CNPJProd=<br>
     * cSelo=<br>
     * qSelo=<br>
     * cEnq=<br>
     * vBC=<br>
     * qUnid=<br>
     * vUnid=<br>
     * pIPI=<br>
     * vIPI=<br><br>
     * <b>[IIXXX]</b><br>
     * vBC=<br>
     * vDespAdu=<br>
     * vII=<br>
     * vIOF=<br><br>
     * <b>[PISXXX]</b><br>
     * CST=<br>
     * vBC=<br>
     * pPIS=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vPIS=<br><br>
     * <b>[PISSTXXX]</b><br>
     * vBC=<br>
     * pPis=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vPIS=<br><br>
     * <b>[COFINSXXX]</b><br>
     * CST=<br>
     * vBC=<br>
     * pCOFINS=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vCOFINS=<br><br>
     * <b>[COFINSSTXXX]</b><br>
     * vBC=<br>
     * pCOFINS=<br>
     * qBCProd=<br>
     * vAliqProd=<br>
     * vCOFINS=<br><br>
     * <b>[ISSQNXXX]</b><br>
     * vBC=<br>
     * vAliq=<br>
     * vISSQN=<br>
     * cMunFG=<br>
     * cListServ=<br>
     * cSitTrib=<br>
     * vDeducao=<br>
     * vDeducao=<br>
     * vOutro=<br>
     * vDescIncond=<br>
     * vDescCond=<br>
     * vISSRet=<br>
     * indISS=<br>
     * cServico=<br>
     * cMun=<br>
     * cPais=<br>
     * nProcesso=<br>
     * indIncentivo=<br><br>
     * <b>[Total]</b><br>
     * vBC=<br>
     * vICMS=<br>
     * vICMSDeson=<br>
     * vBCST=<br>
     * vST=<br>
     * vProd=<br>
     * vFrete=<br>
     * vSeg=<br>
     * vDesc=<br>
     * vII=<br>
     * vIPI=<br>
     * vPIS=<br>
     * vCOFINS=<br>
     * vOutro=<br>
     * vNF=<br>
     * vTotTrib=<br><br>
     * <b>[ISSQNtot]</b><br>
     * vServ=<br>
     * vBC=<br>
     * vISS=<br>
     * vPIS=<br>
     * vCOFINS=<br>
     * dCompet=<br>
     * vDeducao=<br>
     * vOutro=<br>
     * vDescIncond=<br>
     * vDescCond=<br>
     * vISSRet=<br>
     * cRegTrib=<br><br>
     * <b>[retTrib]</b><br>
     * vRetPIS=<br>
     * vRetCOFINS=<br>
     * vRetCSLL=<br>
     * vBCIRRF=<br>
     * vIRRF=<br>
     * vBCRetPrev=<br>
     * vRetPrev=<br><br>
     * <b>[Transportador]</b><br>
     * modFrete=<br>
     * CNPJCPF=<br>
     * xNome=<br>
     * IE=<br>
     * xEnder=<br>
     * xMun=<br>
     * UF=<br>
     * vServ=<br>
     * vBCRet=<br>
     * pICMSRet=<br>
     * vICMSRet=<br>
     * CFOP=<br>
     * cMunFG=<br>
     * Placa=<br>
     * UFPlaca=<br>
     * RNTC=<br>
     * vagao=<br>
     * balsa=<br><br>
     * <b>[ReboqueXXX]</b><br>
     * placa=<br>
     * UF=<br>
     * RNTC=<br><br>
     * <b>[VolumeXXX]</b><br>
     * qVol=<br>
     * esp=<br>
     * Marca=<br>
     * nVol=<br>
     * pesoL=<br>
     * pesoB=<br><br>
     * <b>[LacreXXXYYY]</b><br>
     * nLacre=<br><br>
     * <b>[Fatura]</b><br>
     * nFat=<br>
     * vOrig=<br>
     * vDesc=<br>
     * vLiq=<br><br>
     * <b>[DuplicataXXX]</b><br>
     * nDup=<br>
     * dVenc=<br>
     * vDup=<br><br>
     * <b>[PAGXXX]</b><br>
     * tpag=<br>
     * vPag=<br>
     * CNPJ=<br>
     * tBand=<br>
     * cAut=<br><br>
     * <b>[DadosAdicionais]</b><br>
     * infAdFisco=<br>
     * infCpl=<br><br>
     * <b>[InfAdicXXX]</b><br>
     * xCampo=<br>
     * xTexto=<br><br>
     * <b>[ObsFiscoXXX]</b><br>
     * xCampo=<br>
     * xTexto=<br><br>
     * <b>[procRefXXX]</b><br>
     * nProc=<br>
     * indProc=<br><br>
     * <b>[Exporta]</b><br>
     * UFSaidaPais=<br>
     * xLocExporta=<br>
     * xLocDespacho=<br><br>
     * <b>[Compra]</b><br>
     * xNEmp=<br>
     * xPed=<br>
     * xCont=<br><br>
     * <b>[cana]</b><br>
     * safra=<br>
     * ref=<br>
     * qTotMes=<br>
     * qTotAnt=<br>
     * qTotGer=<br>
     * vFor=<br>
     * vTotDed=<br>
     * vLiqFor=<br><br>
     * <b>[forDiaXXX]</b><br>
     * dia=<br>
     * qtde=<br><br>
     * <b>[deducXXX]</b><br>
     * xDed=<br>
     * vDed=<br>
     */
    public File criarNFe(String iniNFe) throws ACBrNFeException {
        String r = comandoNFe("CriarNFe(\"" + iniNFe + "\")");
        return new File(r.substring(r.indexOf(":\\") - 1));
    }

    /**
     * Envia NFe. <br>
     * <b>Exemplo:</b><br>
     * ENVIARNFE("c:\35XXXXXXXXXXXXXXXX550010000000050000000058-nfe.xml",1,1,1,1)<br>
     *
     * @param arqXML Caminho do arquivo a ser enviado.
     * @param lote Número do Lote
     * @param assina Coloque 0 se não quiser que o componente assine o arquivo.
     * - Parâmetro Opcional
     * @param imprime Coloque 1 se quiser que o DANFe seja impresso logo após a
     * autorização - Parâmetro Opcional
     * @param impressora
     * @param sincrono Coloque 1 para indicar modo síncrono e 0 para modo
     * assíncrono.
     * @throws ACBrNFeException
     */
    public void enviarNFe(String arqXML, int lote, boolean assina, boolean imprime, String impressora, boolean sincrono) throws ACBrNFeException {
        comandoNFe("EnviarNFe(\"" + arqXML + "\"," + lote + "," + assina + "," + imprime + "," + impressora + "," + sincrono + ")");
    }

    /**
     * Envia NFe. <br>
     * <b>Exemplo:</b><br>
     * ENVIARNFE("c:\35XXXXXXXXXXXXXXXX550010000000050000000058-nfe.xml",1,1,1,1)<br>
     *
     * @param arqXML Caminho do arquivo a ser enviado.
     * @param lote Número do Lote
     * @param assina Coloque 0 se não quiser que o componente assine o arquivo.
     * - Parâmetro Opcional
     * @param imprime Coloque 1 se quiser que o DANFe seja impresso logo após a
     * autorização - Parâmetro Opcional
     * @param impressora
     * @param sincrono Coloque 1 para indicar modo síncrono e 0 para modo
     * assíncrono.
     * @throws ACBrNFeException
     */
    public void enviarNFe(File arqXML, int lote, boolean assina, boolean imprime, String impressora, boolean sincrono) throws ACBrNFeException {
        comandoNFe("EnviarNFe(\"" + arqXML + "\"," + lote + "," + assina + "," + imprime + "," + impressora + "," + sincrono + ")");
    }

    /**
     * Envia NFe. <br>
     * <b>Exemplo:</b><br>
     * ENVIARNFE("c:\35XXXXXXXXXXXXXXXX550010000000050000000058-nfe.xml",1,1,1,1)<br>
     *
     * @param arqXML Caminho do arquivo a ser enviado.
     * @param lote Número do Lote
     * @throws ACBrNFeException
     */
    public void enviarNFe(String arqXML, int lote) throws ACBrNFeException {
        comandoNFe("EnviarNFe(\"" + arqXML + "\"," + lote + ")");
    }

    /**
     * Envia NFe. <br>
     * <b>Exemplo:</b><br>
     * ENVIARNFE("c:\35XXXXXXXXXXXXXXXX550010000000050000000058-nfe.xml",1,1,1,1)<br>
     *
     * @param arqXML Caminho do arquivo a ser enviado.
     * @param lote Número do Lote
     * @throws ACBrNFeException
     */
    public void enviarNFe(File arqXML, int lote) throws ACBrNFeException {
        comandoNFe("EnviarNFe(" + arqXML + "," + lote + ")");
    }

    /**
     * Consulta uma NFe.<br><br>
     * <b>Exemplo:</b><br>
     * CONSULTARNFE("c:\35XXXXXXXXXXXXXXXX550010000000050000000058-nfe.xml")
     *
     * @param arquivo Caminho do arquivo a ser consultado.
     * @return
     * @throws ACBrNFeException
     */
    public XMotivoConsulta consultarNFe(String arquivo) throws ACBrNFeException {
        String re = comandoNFe("ConsultarNFe(" + arquivo + ")");
        XMotivoConsulta consulta = new XMotivoConsulta(re);
        consulta.setChNFe(TextUtils.lerTagIni("ChNFe", re));
        consulta.setNProt(TextUtils.lerTagIni("NProt", re));
        consulta.setDigVal(TextUtils.lerTagIni("DigVal", re));
        return consulta;
    }

    /**
     * Consulta uma NFe.<br><br>
     * <b>Exemplo:</b><br>
     * CONSULTARNFE("c:\35XXXXXXXXXXXXXXXX550010000000050000000058-nfe.xml")
     *
     * @param arquivo Caminho do arquivo a ser consultado.
     * @return
     * @throws ACBrNFeException
     */
    public XMotivoConsulta consultarNFe(File arquivo) throws ACBrNFeException {
        return consultarNFe(arquivo.toString());
    }

    /**
     * Cancela um NFe já autorizada.
     * <br>
     * <b>Exemplo:</b>
     * NFE.CANCELARNFE("35XXXXXXXXXXXXXXXX550010000000050000000058","Teste de
     * Cancelamento,99999999000191")
     *
     * @param chaveNFe
     * @param justificativa
     * @param CNPJ
     * @param evento
     * @return
     * @throws ACBrNFeException
     */
    public XMotivoCancelamento cancelarNFe(String chaveNFe, String justificativa, String CNPJ, String evento) throws ACBrNFeException {
        String re = comandoNFe("CancelarNFe(" + chaveNFe + ",\"" + justificativa + "\"," + CNPJ + ",\"" + evento + "\")");
        XMotivoCancelamento c = new XMotivoCancelamento(re);
        c.setChNFe(TextUtils.lerTagIni("ChNFe", re));
        c.setNProt(TextUtils.lerTagIni("NProt", re));
        c.setTpEvento(TextUtils.lerTagIni("TpEvento", re));
        c.setxEvento(TextUtils.lerTagIni("xEvento", re));
        c.setnSeqEvento(TextUtils.lerTagIni("nSeqEvento", re));
        c.setCNPJDest(TextUtils.lerTagIni("CNPJDest", re));
        c.setEmailDest(TextUtils.lerTagIni("EmailDest", re));
        c.setXML(TextUtils.lerTagIni("XML", re));
        return c;
    }

    /**
     *
     * @param UF
     * @param documento
     * @param IE
     * @return
     * @throws ACBrNFeException
     * @deprecated Em desenvolvimento, não usar pois esta retornando
     * ACBrNFeException: URL não definida para: TNFeConsultaCadastro
     */
    public Cadastro consultaCadastro(String UF, String documento, String IE) throws ACBrNFeException {
        return new Cadastro(comandoNFe("ConsultaCadastro(" + UF + "," + documento + "," + IE + ")"));
    }

    /**
     *
     * @param UF
     * @param documento
     * @return
     * @throws ACBrNFeException
     * @deprecated Em desenvolvimento, não usar pois esta retornando
     * ACBrNFeException: URL não definida para: TNFeConsultaCadastro
     */
    public Cadastro consultaCadastro(String UF, String documento) throws ACBrNFeException {
        return new Cadastro(comandoNFe("ConsultaCadastro(" + UF + "," + documento + ")"));
    }

    /**
     * Inutiliza uma faixa de numeração de NFe.
     *
     * @param CNPJ CNPJ do contribuinte
     * @param justificativa Justificativa para inutilização
     * @param ano Ano que foi inutilizado a numeração
     * @param modelo Modelo da Nota Fiscal
     * @param serie Série da Nota Fiscal
     * @param numInicial Número Inicial a ser inutilizado
     * @param numFinal Número Final a ser inutilizado
     * @return
     * @throws ACBrNFeException
     */
    public XMotivoInutilizar inutilizarNFe(String CNPJ, String justificativa, String ano, String modelo, String serie, String numInicial, String numFinal) throws ACBrNFeException {
        String re = comandoNFe("InutilizarNFe(" + CNPJ + ",\"" + justificativa + "\"," + ano + "," + modelo + "," + serie + "," + numInicial + "," + numFinal + ")");
        XMotivoInutilizar c = new XMotivoInutilizar(re);
        c.setNProt(TextUtils.lerTagIni("NProt", re));
        return c;
    }

    public void enviarCartaDeCorrecao(String idLote, String chNFe, String ccOrgao,
            String cCNPJ, String cdhEvento, String cnSeqEvento,
            String cversaoEvento, String cxCorrecao, String cxCondUso) throws ACBrNFeException {
        String evt = "[CCE]\n"
                + "idLote=" + idLote + "\n"
                + "[EVENTO001]\n"
                + "chNFe=" + chNFe + "\n"
                + "cOrgao=" + ccOrgao + "\n"
                + "CNPJ=" + cCNPJ + "\n"
                + "dhEvento=" + cdhEvento + "\n"
                + "nSeqEvento=" + cnSeqEvento + 1 + "\n"
                + "xCorrecao=" + cxCorrecao + "\n";
        enviarEvento(evt);
    }

    /**
     * Retorna a data de vencimento do certificado configurado no
     * ACBrNFeMonitor(funciona apenas na versão CAPICOM).
     *
     * @return
     * @throws ACBrNFeException
     */
    public Date getDataVencimentoCertificado() throws ACBrNFeException {
        try {
            return ACBrUtils.strDataRedToDateBR(comandoNFe("CertificadoDataVencimento"));
        } catch (ACBrException ex) {
            throw new ACBrNFeException(ex);
        }
    }

    /**
     * Retorna o CNPJ do Certificado Configurado
     *
     * @return
     * @throws ACBrNFeException
     */
    public String getCNPJDoCertificado() throws ACBrNFeException {
        return comandoNFe("CNPJCertificado");
    }
}
