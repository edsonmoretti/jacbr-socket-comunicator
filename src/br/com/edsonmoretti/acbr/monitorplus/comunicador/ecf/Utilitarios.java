/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;

/**
 *
 * @author Edson
 */
public class Utilitarios {

    /**
     * Permite gravar no ECF informações sobre operadores.
     *
     * @param operador Nome do operador.
     * @throws ACBrECFException
     */
    public void identificaOperador(String operador) throws ACBrECFException {
        ACBrECF.comandoECF("IdentificaOperador(\"" + operador + "\")");
    }

    /**
     * Permite gravar no ECF, informações sobre o Programa Aplicativo Fiscal
     * (PAF) em operação. Esta informação deve ser impressa em todos os cupons,
     * de acordo com a lei atual.
     *
     * @param nomVersao Nome e versão do aplicativo fiscal.
     * @param md5 Numero do MD5.
     * @throws ACBrECFException
     */
    public void identificaPAF(String nomVersao, String md5) throws ACBrECFException {
        ACBrECF.comandoECF("IdentificaPAF(\"" + nomVersao + "\",\"" + md5 + "\")");
    }

    /**
     * Programa a aliquota no ECF conforme os dados informados nos parâmetros.
     * Exemplos:<br>
     * ECF.ProgramaAliquota( 18 ) – Programa a Alíquota de 18% do ICMS<br>
     * ECF.ProgramaAliquota( 2.46 ,"T") – Programa a Alíquota de 2,46% do
     * ICMS<br>
     * ECF.ProgramaAliquota( 2.5, "S" ) – Programa a Alíquota de 2,5% do ISS<br>
     * <b>Notas:</b><br>
     * Na maioria dos ECFs este comando somente é aceito quando o Movimento não
     * foi iniciado, ou seja, após uma Redução Z e antes de uma Venda ou Leitura
     * X<br>
     * Não é possível apagar as alíquotas programadas, portanto CUIDADO ao
     * programar novas Alíquotas. Apenas uma intervenção técnica pode remover as
     * Alíquotas já programadas<br>
     *
     * @param valorAliquota Valor da Alíquota a programar. Exemplos: 18 , 12 ,
     * 2.46
     * @param tipoAliquota Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS.
     * Pode ser omitido, nesse caso assume "T"
     * @param posicaoAliquota Posição de cadastro da Alíquota. Não é aceito em
     * todos os modelos de ECFs, e em alguns outros apenas é aceito em modo de
     * Intervenção. Normalmente esse parâmetro deve ser omitido
     * @throws ACBrECFException
     */
    public void programaAliquota(int valorAliquota, String tipoAliquota, String posicaoAliquota) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaAliquota(" + valorAliquota + "," + tipoAliquota + "," + posicaoAliquota + ")");
    }

    /**
     * Programa a aliquota no ECF conforme os dados informados nos parâmetros.
     * Exemplos:<br>
     * ECF.ProgramaAliquota( 18 ) – Programa a Alíquota de 18% do ICMS<br>
     * ECF.ProgramaAliquota( 2.46 ,"T") – Programa a Alíquota de 2,46% do
     * ICMS<br>
     * ECF.ProgramaAliquota( 2.5, "S" ) – Programa a Alíquota de 2,5% do ISS<br>
     * <b>Notas:</b><br>
     * Na maioria dos ECFs este comando somente é aceito quando o Movimento não
     * foi iniciado, ou seja, após uma Redução Z e antes de uma Venda ou Leitura
     * X<br>
     * Não é possível apagar as alíquotas programadas, portanto CUIDADO ao
     * programar novas Alíquotas. Apenas uma intervenção técnica pode remover as
     * Alíquotas já programadas<br>
     *
     * @param valorAliquota Valor da Alíquota a programar. Exemplos: 18 , 12 ,
     * 2.46
     * @throws ACBrECFException
     */
    public void programaAliquota(int valorAliquota) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaAliquota(" + valorAliquota + ")");
    }

    /**
     * Programa a aliquota no ECF conforme os dados informados nos parâmetros.
     * Exemplos:<br>
     * ECF.ProgramaAliquota( 18 ) – Programa a Alíquota de 18% do ICMS<br>
     * ECF.ProgramaAliquota( 2.46 ,"T") – Programa a Alíquota de 2,46% do
     * ICMS<br>
     * ECF.ProgramaAliquota( 2.5, "S" ) – Programa a Alíquota de 2,5% do ISS<br>
     * <b>Notas:</b><br>
     * Na maioria dos ECFs este comando somente é aceito quando o Movimento não
     * foi iniciado, ou seja, após uma Redução Z e antes de uma Venda ou Leitura
     * X<br>
     * Não é possível apagar as alíquotas programadas, portanto CUIDADO ao
     * programar novas Alíquotas. Apenas uma intervenção técnica pode remover as
     * Alíquotas já programadas<br>
     *
     * @param valorAliquota Valor da Alíquota a programar. Exemplos: 18 , 12 ,
     * 2.46
     * @param tipoAliquota Tipo da Alíquota , Use "T" para ICMS ou "S" para ISS.
     * Pode ser omitido, nesse caso assume "T"
     * @throws ACBrECFException
     */
    public void programaAliquota(int valorAliquota, String tipoAliquota) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaAliquota(" + valorAliquota + "," + tipoAliquota + ")");
    }

    /**
     * Programa a Forma de Pagamento conforme os dados informados nos
     * parâmetros. Exemplos:<br>
     * ECF.ProgramaFormaPagamento("Cartao Debito")<br>
     * ECF.ProgramaFormaPagamento("Cheque",False)<br>
     *
     * @param descricao Descrição da forma de pagamento a programar.
     * @param permitevinculado Permite vinculado "true" ou "false". Pode ser
     * omitido, nesse caso assume "True"
     * @param posicao Posição de cadastro da Forma de Pagamento. Não é aceito em
     * todos os modelos de ECFs, e em alguns outros apenas é aceito em modo de
     * Intervenção. Normalmente esse parâmetro deve ser omitido
     * @throws ACBrECFException
     */
    public void programaFormaPagamento(String descricao, boolean permitevinculado, String posicao) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaFormaPagamento(" + descricao + "," + permitevinculado + "," + posicao + ")");
    }

    /**
     * Programa a Forma de Pagamento conforme os dados informados nos
     * parâmetros. Exemplos:<br>
     * ECF.ProgramaFormaPagamento("Cartao Debito")<br>
     * ECF.ProgramaFormaPagamento("Cheque",False)<br>
     *
     * @param descricao Descrição da forma de pagamento a programar.
     * @param permitevinculado Permite vinculado "true" ou "false". Pode ser
     * omitido, nesse caso assume "True"
     * @throws ACBrECFException
     */
    public void programaFormaPagamento(String descricao, boolean permitevinculado) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaFormaPagamento(" + descricao + "," + permitevinculado + ")");
    }

    /**
     * Programa Comprovante não Fiscal conforme os dados informados nos
     * parâmetros.<br>
     * EX: <br>
     * ECF.ProgramaComprovanteNaoFiscal("Recebimento")
     *
     * @param descricao Descrição do Comprovante Não Fiscal
     * @param permitevinculado Permite vinculado "true" ou "false". Pode ser
     * omitido, nesse caso assume "True"
     * @param posicao Posição de cadastro do CNF. Não é aceito em todos os
     * modelos de ECFs, e em alguns outros apenas é aceito em modo de
     * Intervenção. Normalmente esse parâmetro deve ser omitido
     * @throws ACBrECFException
     */
    public void programaComprovanteNaoFiscal(String descricao, boolean permitevinculado, String posicao) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaComprovanteNaoFiscal(" + descricao + "," + permitevinculado + "," + posicao + ")");
    }

    /**
     * Programa Comprovante não Fiscal conforme os dados informados nos
     * parâmetros.<br>
     * EX: <br>
     * ECF.ProgramaComprovanteNaoFiscal("Recebimento")
     *
     * @param descricao Descrição do Comprovante Não Fiscal
     * @param permitevinculado Permite vinculado "true" ou "false". Pode ser
     * omitido, nesse caso assume "True"
     * @throws ACBrECFException
     */
    public void programaComprovanteNaoFiscal(String descricao, boolean permitevinculado) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaComprovanteNaoFiscal(" + descricao + "," + permitevinculado + ")");
    }

    /**
     * Programa Unidade de Medida com a Descrição informada no parâmetro.
     *
     * @param descricao Descrição da Unidade de Medida.
     * @throws ACBrECFException
     */
    public void programaUnidadeMedida(String descricao) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaUnidadeMedida(" + descricao + ")");
    }

    /**
     * Programa Relatórios Gerenciais conforme os dados informados nos
     * parâmetros.
     *
     * @param descricao Descrição do Relatório Gerencial
     * @param posicao Posição de cadastro do CNF. Não é aceito em todos os
     * modelos de ECFs, e em alguns outros apenas é aceito em modo de
     * Intervenção. Normalmente esse parâmetro deve ser omitido
     * @throws ACBrECFException
     */
    public void programaRelatoriosGerenciais(String descricao, String posicao) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaRelatoriosGerenciais(" + descricao + "," + posicao + ")");
    }

    /**
     * Programa Relatórios Gerenciais conforme os dados informados nos
     * parâmetros.
     *
     * @param descricao Descrição do Relatório Gerencial
     * @throws ACBrECFException
     */
    public void programaRelatoriosGerenciais(String descricao) throws ACBrECFException {
        ACBrECF.comandoECF("ProgramaRelatoriosGerenciais(" + descricao + ")");
    }

    /**
     * Programa Relatórios Gerenciais conforme os dados informados nos
     * parâmetros.
     *
     * @param horarioVerao Descrição do Relatório Gerencial
     * @throws ACBrECFException
     */
    public void mudaHorarioVerao(boolean horarioVerao) throws ACBrECFException {
        ACBrECF.comandoECF("MudaHorarioVerao (" + horarioVerao + ")");
    }

    /**
     * Verifica o estado atual do ECF e efetua as operações necessárias para
     * deixar o ECF no estado livre. Portanto esse método tenta fechar ou
     * cancelar qualquer documento que esteja aberto. Em alguns ECFs comandos
     * adicionais são enviados para tentar “desbloquear” o ECF de alguma
     * condição de erro que impeça a impressão de novos documentos.
     *
     * @param b Parâmetro opcional. Se necessário emitir a redução Z "True" ou
     * "False", se parâmetro for omitido será considerado TRUE..
     * @throws ACBrECFException
     */
    public void mudaArredondamento(boolean b) throws ACBrECFException {
        ACBrECF.comandoECF("MudaHorarioVerao (" + b + ")");
    }

    /**
     * Verifica o estado atual do ECF e efetua as operações necessárias para
     * deixar o ECF no estado livre. Portanto esse método tenta fechar ou
     * cancelar qualquer documento que esteja aberto. Em alguns ECFs comandos
     * adicionais são enviados para tentar “desbloquear” o ECF de alguma
     * condição de erro que impeça a impressão de novos documentos. Se e emite a
     * redução Z
     *
     * @throws ACBrECFException
     */
    public void mudaArredondamento() throws ACBrECFException {
        ACBrECF.comandoECF("MudaHorarioVerao");
    }

    /**
     * Envia comando conforme a sintaxe de cada modelo de ECF. Verificar o
     * manual de cada modelo.
     *
     * @param comando Comando a ser processado. Verificar a sintaxe ou o comando
     * a ser informado no manual de cada ECF
     * @param timeOut Time Out da eCF.
     * @throws ACBrECFException
     */
    public void enviaComando(String comando, int timeOut) throws ACBrECFException {
        ACBrECF.comandoECF("EnviaComando(\"" + comando + "\"," + timeOut + ")");
    }

    /**
     * Envia comando conforme a sintaxe de cada modelo de ECF. Verificar o
     * manual de cada modelo.
     *
     * @param comando Comando a ser processado. Verificar a sintaxe ou o comando
     * a ser informado no manual de cada ECF
     * @throws ACBrECFException
     */
    public void enviaComando(String comando) throws ACBrECFException {
        ACBrECF.comandoECF("EnviaComando(\"" + comando + "\")");
    }

    /**
     * Retorna o último comando enviado para o ECF no formato da sintaxe
     * suportada pelo ECF.
     *
     * @return EX: [STX]815[ETX]
     * @throws ACBrECFException
     */
    public String comandoEnviado() throws ACBrECFException {
        return ACBrECF.comandoECF("ComandoEnviado");
    }

    /**
     * Retorna a resposta exata do ECF sem tratamento, na sintaxe de retorno do
     * ECF
     *
     * @return EX: [STX]815+0000A[ETX]
     * @throws ACBrECFException
     */
    public String respostaComando() throws ACBrECFException {
        return ACBrECF.comandoECF("RespostaComando");
    }

    /**
     * Retorna as informações da ECF conforme o Registrador informado no
     * parâmetro. <br>
     * Exemplos: ECF.RetornaInfoECF("A1")  <br>
     * Registrador A1 da SwedaSTX retorna:<br>
     * Totalizador Geral GT -> 18 bytes<br>
     * Venda Líquida VL -> 14 bytes<br>
     * Venda Bruta Diária VB -> 14 bytes<br>
     *
     * @param registrador Registro para retornar determinada informação. Verificar no manual de programação da ECF para os registros
     * @return EX de retorno:
     * 0000000000021298160000000000000000000000000000[ETX][ACK][STX]234+0000AA[x9B][x80][x82][x80][x80]A1
     * @throws ACBrECFException
     */
    public String retornaInfoECF(String registrador ) throws ACBrECFException {
        return ACBrECF.comandoECF("RetornaInfoECF");
    }
}
