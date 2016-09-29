/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto.Banco;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto.Cedente;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto.Conta;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto.TipoDeSaida;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.boleto.Titulo;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBoletoException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import java.util.List;

/**
 *
 * @author Edson
 */
public class ACBrBOLETO {

    private final Cedente cedente = new Cedente();
    private final Conta conta = new Conta();
    private final Banco banco = new Banco();

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
     * no componente. Exemplo de Ini com os dados do Cedente\Conta\Banco<br><br>
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
    public void configurarDados() throws ACBrBoletoException {
        if (banco == null) {
            throw new ACBrBoletoException("NullPointerException: Objeto banco não pode ser null, informe um banco.");
        }
        if (conta == null) {
            throw new ACBrBoletoException("NullPointerException: Objeto conta não pode ser null, informe um banco.");
        }
        if (cedente == null) {
            throw new ACBrBoletoException("NullPointerException: Objeto cendente não pode ser null, informe um banco.");
        }
        comandoBoleto("ConfigurarDados(\"" + gerarStringFormatoIniConfig() + "\")");
    }

    /**
     *
     * @param titulos
     */
    public void incluirTitulos(List<Titulo> titulos) throws ACBrBoletoException {
        for (Titulo t : titulos) {
            incluirTitulos(t);
        }
    }

    public void incluirTitulos(Titulo titulo) throws ACBrBoletoException {
        comandoBoleto("IncluirTitulos(\"" + gerarStringFormatoIniTitulo(titulo) + "\")");
    }

    public void incluirTitulos(List<Titulo> titulos, TipoDeSaida tipoDeSaida) throws ACBrBoletoException {
        for (Titulo t : titulos) {
            incluirTitulos(t, tipoDeSaida);
        }
    }

    public void incluirTitulos(Titulo titulo, TipoDeSaida tipoDeSaida) throws ACBrBoletoException {
        comandoBoleto("IncluirTitulos(\"" + gerarStringFormatoIniTitulo(titulo) + "\", " + tipoDeSaida + ")");
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
    public void gerarHTML() throws ACBrBoletoException {
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

    /**
     *
     * @param dirArqRemessa Diretório onde deverá ser gravado o arquivo de
     * Remessa.
     * @param numeroArquivo Numero do arquivo que deve ser gerado, utilizado
     * pelo Bradesco, funciona como um contador de arquivos remessa já enviados.
     * Exemplos:
     *
     * BOLETO.GerarRemessa("c:\remessa\",1,000001.rem ) – Irá gerar o arquivo de
     * remessa no diretório "C:\Remessa", com o nome formatado de acordo com o
     * banco para o qual esta sendo feita a remessa .000001.rem
     *
     * BOLETO.GerarRemessa("c:\remessa\" ) – Irá gerar o arquivo de remessa no
     * diretório "C:\Remessa", com o nome formatado de acordo com o banco para o
     * qual esta sendo feita a remessa . No caso do Bradesco cb00002.rem,
     * considerando que já exista o arquivo cb00001.rem em C:\Remessa.
     */
    public void gerarRemessa(String dirArqRemessa, int numeroArquivo) throws ACBrBoletoException {
        comandoBoleto("GerarRemessa('" + dirArqRemessa + "'," + numeroArquivo + ")");
    }

    /**
     *
     * @param dirArqRemessa Diretório onde deverá ser gravado o arquivo de
     * Remessa.
     * @param numeroArquivo Numero do arquivo que deve ser gerado, utilizado
     * pelo Bradesco, funciona como um contador de arquivos remessa já enviados.
     * Exemplos:
     *
     * BOLETO.GerarRemessa("c:\remessa\",1,000001.rem ) – Irá gerar o arquivo de
     * remessa no diretório "C:\Remessa", com o nome formatado de acordo com o
     * banco para o qual esta sendo feita a remessa .000001.rem
     *
     * BOLETO.GerarRemessa("c:\remessa\" ) – Irá gerar o arquivo de remessa no
     * diretório "C:\Remessa", com o nome formatado de acordo com o banco para o
     * qual esta sendo feita a remessa . No caso do Bradesco cb00002.rem,
     * considerando que já exista o arquivo cb00001.rem em C:\Remessa.
     *
     *
     * @param nomeArquivo Nome do Arquivo
     */
    public void gerarRemessa(String dirArqRemessa, int numeroArquivo, String nomeArquivo) throws ACBrBoletoException {
        comandoBoleto("GerarRemessa(\"" + dirArqRemessa + "\"," + numeroArquivo + ", " + nomeArquivo + ")");
    }

    ////////GETS SETTS
    public Cedente getCedente() {
        return cedente;
    }

    public Conta getConta() {
        return conta;
    }

    public Banco getBanco() {
        return banco;
    }

    private String gerarStringFormatoIniConfig() {
        return cedente.toString() + conta.toString() + banco.toString();
    }

    private String gerarStringFormatoIniTitulo(Titulo titulo) {
        String titulosStr = "";
        int i = 1;
        titulosStr += titulo.toString().replace("[Titulo]", "[Titulo" + i + "]").replace("}", "").concat("\n");
        return titulosStr;
    }

}
