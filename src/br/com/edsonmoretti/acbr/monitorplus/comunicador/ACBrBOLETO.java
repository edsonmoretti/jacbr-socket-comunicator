/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBoletoException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Edson
 */
public class ACBrBOLETO {

    private String comandoBoleto(String s) throws ACBrBoletoException {
        try {
            return ACBr.getInstance().comandoAcbr("BOLETO." + s);
        } catch (ACBrException ex) {
            throw new ACBrBoletoException(ex.getMessage());
        }
    }

    /**
     * <b>Notas:</b>
     * Apenas devem ser informados os campos que deverão ser modificados, caso
     * exista algum campo com conteúdo vazio, estas propriedades ficaram vazias
     * no componente. Exemplo de Ini com os dados do
     * Cendente\Conta\Banco<br><br>
     *
     * [Cedente]<br>
     * Nome=São João LTDA.<br>
     * CNPJCPF= 99.999.999/9999-99<br>
     * Logradouro=Rua Evaristo Mendes<br>
     * Numero=200<br>
     * Bairro=Centro<br>
     * Cidade=Tatui<br>
     * CEP=18.270-000<br>
     * Complemento=Sala 10<br>
     * UF=SP<br>
     * RespEmis=0<br>
     * TipoPessoa=1<br>
     * CodigoCedente=123456<br>
     * LayoutBol=3<br>
     * CaracTitulo=0<br><br>
     *
     * [Conta]<br>
     * Conta=99999<br>
     * DigitoConta=9<br>
     * Agencia=9999<br>
     * DigitoAgencia=9<br><br>
     *
     * [Banco]<br>
     * Numero=237<br>
     * CNAB=1<br>
     * IndiceACBr=5<br><br>
     *
     * Valores válidos para o campo RespEmis (Responsabilidade Emissão do
     * Boleto)<br>
     * 0 - Cliente Emite<br>
     * 1 - Banco Emite<br>
     * 2 - Banco Reemite<br>
     * 3 - Banco não Reemite<br><br>
     *
     * Caso nenhum desses valores seja passado, será assumido como valor default
     * 0.<br>
     * Valores válidos para o campo TipoPessoa (Fisica,Juridica,Outras)<br>
     * 0 - Pessoa Física<br>
     * 1 - Pessoa Juridica<br>
     * 2 - Outros<br><br>
     *
     * Caso nenhum desses valores seja passado, será assumido como valor default
     * 2.<br>
     * Valores válidos para o campo CNAB (240 e 400)<br>
     * 0 - CNAB240<br>
     * 1 - CNAB400<br><br>
     *
     * Valores válidos para o campo INDICEACBR<br>
     * Este campo não é obrigatório, desde que o número do banco seja
     * informado.<br>
     * Caso ambos sejam informados, o Número terá prioridade.<br><br>
     * 1 - Banco do Brasil<br>
     * 2 - Santander<br>
     * 3 - Caixa Econômica Federal (Convênio SIGCB)<br>
     * 4 - Caixa Econômica Federal (Convênio SICOB) <br>
     * 5 - Bradesco<br>
     * 6 - Itaú<br>
     * 7 - Banco Mercantil<br>
     * 8 - Sicred<br>
     * 9 - Bancoob<br>
     * 10 - Banrisul<br>
     * 11- HSBC<br>
     * 12- Banestes<br>
     * 13- Banco do Nordeste<br>
     * 14- Banco BRB<br><br>
     *
     * Valores válidos para o campo LayoutBol<br><br>
     * 0 - Padrão<br>
     * 1 - Carnê<br>
     * 2 - Fatura (Não implementado = Padrão)<br>
     * 3 - Padrão Entrega<br><br>
     *
     * Valores válidos para o campo CaracTitulo<br><br>
     * 0 - Cobrança Simples<br>
     * 1 - Cobrança Vinculada<br>
     * 2 - Cobrança Caucionada<br>
     * 3 - Cobrança Descontada<br>
     * 4 - Cobrança Vendor<br>
     *
     * @param config conteúdo do arquivo ini, contendo os dados do
     * cedente(Informações do cedente, conta, banco).
     * @throws ACBrBoletoException
     */
    public void configurarDados(String config) throws ACBrBoletoException {
        if (config.isEmpty()) {
            throw new ACBrBoletoException("Arquivo/Valor/Stirng de configuração vazio.");
        }
        comandoBoleto("ConfigurarDados(" + config + ")");
    }

    /**
     * <b>Notas:</b>
     * Apenas devem ser informados os campos que deverão ser modificados, caso
     * exista algum campo com conteúdo vazio, estas propriedades ficaram vazias
     * no componente. Exemplo de Ini com os dados do
     * Cendente\Conta\Banco<br><br>
     *
     * [Cedente]<br>
     * Nome=São João LTDA.<br>
     * CNPJCPF= 99.999.999/9999-99<br>
     * Logradouro=Rua Evaristo Mendes<br>
     * Numero=200<br>
     * Bairro=Centro<br>
     * Cidade=Tatui<br>
     * CEP=18.270-000<br>
     * Complemento=Sala 10<br>
     * UF=SP<br>
     * RespEmis=0<br>
     * TipoPessoa=1<br>
     * CodigoCedente=123456<br>
     * LayoutBol=3<br>
     * CaracTitulo=0<br><br>
     *
     * [Conta]<br>
     * Conta=99999<br>
     * DigitoConta=9<br>
     * Agencia=9999<br>
     * DigitoAgencia=9<br><br>
     *
     * [Banco]<br>
     * Numero=237<br>
     * CNAB=1<br>
     * IndiceACBr=5<br><br>
     *
     * Valores válidos para o campo RespEmis (Responsabilidade Emissão do
     * Boleto)<br>
     * 0 - Cliente Emite<br>
     * 1 - Banco Emite<br>
     * 2 - Banco Reemite<br>
     * 3 - Banco não Reemite<br><br>
     *
     * Caso nenhum desses valores seja passado, será assumido como valor default
     * 0.<br>
     * Valores válidos para o campo TipoPessoa (Fisica,Juridica,Outras)<br>
     * 0 - Pessoa Física<br>
     * 1 - Pessoa Juridica<br>
     * 2 - Outros<br><br>
     *
     * Caso nenhum desses valores seja passado, será assumido como valor default
     * 2.<br>
     * Valores válidos para o campo CNAB (240 e 400)<br>
     * 0 - CNAB240<br>
     * 1 - CNAB400<br><br>
     *
     * Valores válidos para o campo INDICEACBR<br>
     * Este campo não é obrigatório, desde que o número do banco seja
     * informado.<br>
     * Caso ambos sejam informados, o Número terá prioridade.<br><br>
     * 1 - Banco do Brasil<br>
     * 2 - Santander<br>
     * 3 - Caixa Econômica Federal (Convênio SIGCB)<br>
     * 4 - Caixa Econômica Federal (Convênio SICOB) <br>
     * 5 - Bradesco<br>
     * 6 - Itaú<br>
     * 7 - Banco Mercantil<br>
     * 8 - Sicred<br>
     * 9 - Bancoob<br>
     * 10 - Banrisul<br>
     * 11- HSBC<br>
     * 12- Banestes<br>
     * 13- Banco do Nordeste<br>
     * 14- Banco BRB<br><br>
     *
     * Valores válidos para o campo LayoutBol<br><br>
     * 0 - Padrão<br>
     * 1 - Carnê<br>
     * 2 - Fatura (Não implementado = Padrão)<br>
     * 3 - Padrão Entrega<br><br>
     *
     * Valores válidos para o campo CaracTitulo<br><br>
     * 0 - Cobrança Simples<br>
     * 1 - Cobrança Vinculada<br>
     * 2 - Cobrança Caucionada<br>
     * 3 - Cobrança Descontada<br>
     * 4 - Cobrança Vendor<br>
     *
     * @param f path do arquivo ini com o nome do arquivo, contendo os dados do
     * cedente(Informações do cedente, conta, banco)
     * @throws ACBrBoletoException
     */
    public void configurarDados(File f) throws ACBrBoletoException {
        try (Scanner sc = new Scanner(f)) {
            String s = "";
            while (sc.hasNext()) {
                s += sc.nextLine();
            }
            configurarDados(s);
        } catch (FileNotFoundException ex) {
            throw new ACBrBoletoException(ex.getMessage());
        }
    }

    /**
     * Imprime os boletos adicionados na lista, de acordo com as configurações
     * feitas no ACBrMonitor(PDF,HTML,Impressora)
     *
     * @throws ACBrBoletoException
     */
    public void imprimir() throws ACBrBoletoException {
        comandoBoleto("Imprimir");
    }

    /**
     * Lista no formato PDF os boletos existentes na lista de titulos.
     *
     * @throws ACBrBoletoException
     */
    public void gerarPDF() throws ACBrBoletoException {
        comandoBoleto("GerarPDF");
    }

    /**
     * Lista no formato HTML os boletos existentes na lista de titulos.
     *
     * @throws ACBrBoletoException
     */
    public void GerarHTML() throws ACBrBoletoException {
        comandoBoleto("GerarHTML");
    }

    /**
     * Gera um arquivo PDF com os boletos existentes na lista de titulos e envia
     * como anexo para o e-mail do Sacado.
     *
     * @throws ACBrBoletoException
     */
    public void enviarEmail() throws ACBrBoletoException {
        comandoBoleto("EnviarEmail");
    }


    /**
     * Limpa a lista de titulos
     *
     * @throws ACBrBoletoException
     */
    public void limparLista() throws ACBrBoletoException {
        comandoBoleto("LimparLista");
    }
}
