
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrBOLETO;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrBoletoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edson
 */
public class TesteBoleto {

    public static void main(String[] args) {
        ACBrBOLETO boleto = new ACBrBOLETO();
        try {
            boleto.configurarDados(""
                    + "[Cedente]\n"
                    + "Nome=São João LTDA. \n"
                    + "CNPJCPF= 10.493.367/0001-48 \n"
                    + "Logradouro=Rua Evaristo Mendes \n"
                    + "Numero=200 \n"
                    + "Bairro=Centro \n"
                    + "Cidade=Tatui \n"
                    + "CEP=18.270-000 \n"
                    + "Complemento=Sala 10 UF=SP \n"
                    + "RespEmis=0 \n"
                    + "TipoPessoa=1 \n"
                    + "CodigoCedente=123456 \n"
                    + "LayoutBol=1 \n"
                    + "CaracTitulo=0  \n"
                    + "\n"
                    + "[Conta] \n"
                    + "Conta=99999 \n"
                    + "DigitoConta=9 \n"
                    + "Agencia=9999 \n"
                    + "DigitoAgencia=9  \n"
                    + "\n"
                    + "[Banco] \n"
                    + "Numero=001 \n"
                    + "CNAB=1 \n"
                    + "IndiceACBr=5");
//            boleto.limparLista();
//            boleto.incluirTitulos("[Titulo1]\n"
//                    + "NumeroDocumento=000010\n"
//                    + "NossoNumero=0000001\n"
//                    + "Carteira=20\n"
//                    + "ValorDocumento=100,50\n"
//                    + "Vencimento=10/09/2010\n"
//                    + "ValorMoraJuros=0,50\n"
//                    + "DataDocumento=10/08/2010\n"
//                    + "DataProcessamento=10/08/2010\n"
//                    + "DataAbatimento=05/09/2010\n"
//                    + "DataDesconto=07/09/2010\n"
//                    + "DataMoraJuros=12/09/2010\n"
//                    + "DataProtesto=10/10/2010\n"
//                    + "ValorAbatimento=5,00\n"
//                    + "ValorDesconto=0,50\n"
//                    + "ValorMoraJuros=0,55\n"
//                    + "ValorIOF=3,50\n"
//                    + "ValorOutrasDespesas=2,50\n"
//                    + "PercentualMulta=05,00\n"
//                    + "LocalPagamento=Pagável em qualquer agência bancária mesmo após o vencimento\n"
//                    + "Especie=DM\n"
//                    + "EspecieMod=R$\n"
//                    + "Sacado.NomeSacado=Sacado Teste\n"
//                    + "Sacado.CNPJCPF=01234567890\n"
//                    + "Sacado.Pessoa=0\n"
//                    + "Sacado.Logradouro=Rua Jose Rodrigues\n"
//                    + "Sacado.Numero=100\n"
//                    + "Sacado.Bairro=Jardim Moderno\n"
//                    + "Sacado.Complemento=Casa\n"
//                    + "Sacado.Cidade=Tatui\n"
//                    + "Sacado.UF=SP\n"
//                    + "Sacado.CEP=18277.500\n"
//                    + "Sacado.Email=edson@g3automacao.com.br\n"
//                    + "Mensagem=teste1|teste2\n"
//                    + "Instrucao1=10\n"
//                    + "Instrucao2=11\n"
//                    + "Aceite=1\n"
//                    + "OcorrenciaOriginal=0\n"
//                    + "Parcela=1\n"
//                    + "TotalParcelas=1\n"
//                    + "SeuNumero=000020\n"
//                    + "TipoDiasProtesto=1\n"
//                    + "TipoImpressao=1");
            boleto.gerarPDF();
//            boleto.enviarEmail();
        } catch (ACBrBoletoException ex) {
            Logger.getLogger(TesteBoleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
