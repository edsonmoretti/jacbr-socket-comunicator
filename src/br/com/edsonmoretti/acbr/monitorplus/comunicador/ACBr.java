package br.com.edsonmoretti.acbr.monitorplus.comunicador;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Edson Moretti - www.edsonmoretti.com.br
 */
public class ACBr {

    private static BufferedReader recebeComando;
    private static PrintWriter enviaComando;
    private static Socket acbrSocket;
    private static final String NAMEHOST = getConfig().getNameHost();
    private static final int PORTA = getConfig().getPorta();

    private ACBr() {
    }

    /**
     * Executa comandos na máquina em que o ACBrMonitor está rodando, útil para
     * executar comandos no terminal Remoto, quando usando modo TCP/IP
     * <br><br>Exemplos:
     * <br>ACBr.Run(“NOTEPAD.EXE”,”Novo.TXT”) – Roda o Bloco de Notas do
     * Windows, criando o arquivo Novo.TXT
     * <br>ACBr.Run(“CALC.EXE”, ,”True”) – Executa a calculadora do Windows e
     * aguarda o termino<br><br>
     *
     * @param comando Linha de comando a ser executada pelo ACBrMonitorPlus
     * @param paramentros (opcional) Parâmetros complementares informados a
     * Linha de Comando
     * <br>
     * @param aguarda Opcional, se for omitido assume “False”. Quando informado
     * “True”, aguarda o termino da execução do programa informado em cComando,
     * antes de continuar com o ACBrMonitor (cuidado, esse parâmetro em “True”
     * pode fazer o ACBrMonitor para de responder enquanto o Programa executado
     * não seja finalizado)
     * <br>
     * @param windowState (Opcional) Numérico informando o Estado daJanela:
     * Utilize: 0 = Escondido; 1 = Normal (default); 2 = Minimizado; 3 =
     * Maximizado (Disponível apenas no Windows)
     * <br>
     * @param altTab Opcional, se for omitido assume “False”. Quando informado
     * “True”, envia ALT+TAB para o teclado do Windows assim que a execução do
     * programa terminar. Útil para restaurar o foco da aplicação controladora
     * do ACBrMonitor (Disponível apenas no Windows)
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException
     */
    public void run(String comando, String paramentros, boolean aguarda, int windowState, boolean altTab) throws ACBrException {
        comandoAcbr("ACBr.Run(" + comando + "," + paramentros + "," + aguarda + "," + windowState + ")");
    }

    /**
     * Exibe a tela do ACBrMonitor
     *
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException
     */
    public void restaurar() throws ACBrException {
        comandoAcbr("ACBr.Restaurar");
    }

    /**
     * Esconde o ACBrMonitor no Systray
     *
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException
     */
    public void ocultar() throws ACBrException {
        comandoAcbr("ACBr.Ocultar");
    }

    /**
     * Encerra, finaliza o ACBrMonitor
     *
     * @throws ACBrException
     */
    public void encerrarMonitor() throws ACBrException {
        comandoAcbr("ACBr.EncerrarMonitor");
    }

    /**
     * Salva um arquivo na máquina em que o ACBrMonitor está rodando. <br>Util
     * por exemplo, para implementar TEF discado em máquinas operadas
     * remotamente por TCP/IP
     * <br><br>Exemplos:<br>
     * ACBr.SaveToFile("C:\TEF_Dial\Req\INTPOS.001","000-000 =
     * ADM\x0D\x0A001-000 = 0001\x0D\x0A999-999 = 0\x0D\x0A") – Cria um arquivo
     * de Requisição Administrativa para o programa TEF discado
     * <br><br>
     * Nota: Necessita qua a Opção "Permitir Comandos Remotos" esteja
     * selecionada
     * <br>
     *
     * @param nomeDoArquivo Nome completo do Arquivo a ser criado, informe o
     * Path<br>
     * @param conteudoDoArquivo Conteudo do Arquivo que será salvo. Para uso de
     * caracteres de controle, como CR ou LF, use a notação especial "\x"
     * seguido de 2 caracteres com o código em Hexadecimal do Caracter desejado.
     * <br>
     * @throws
     * br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrException
     */
    public void saveToFile(String nomeDoArquivo, String conteudoDoArquivo) throws ACBrException {
        comandoAcbr("ACBr.SaveTofile(" + nomeDoArquivo + "," + conteudoDoArquivo + ")");
    }

    /**
     * Lê um arquivo na máquina em que o ACBrMonitor está rodando.
     * <br>
     * Util por exemplo, para implementar TEF discado em máquinas operadas
     * remotamente por TCP/IP
     * <br>
     * Exemplos:<br>
     * ACBr.LoadFromFile("C:\TEF_Dial\Resp\INTPOS.001", 7 ) – Tenta ler a
     * resposta do TEF discado por até 7 segundos
     * <br>
     * Nota: Necessita qua a Opção "Permitir Comandos Remotos" esteja
     * selecionada
     * <br>
     *
     * @param nomeDoArquivo Nome completo do Arquivo a ser Lido, informe o
     * Path<br>
     * @param timeOut Tempo de Espera, em Milissegundos, até o arquivo ser
     * encontrado ou liberado para Leitura. O ACBrMonitor tentará ler o arquivo
     * até ter sucesso ou o Tempo de Espera seja atingido<br>
     * @return <br>
     * A resposta com o conteudo do arquivo será gravada no arquivo de saída (ou
     * enviada por TCP/IP), com a sinalização de sucesso ou não ("OK: " ou
     * "ERRO: "). <br>Exemplo: <br>OK: 000-000 = ADM<br>
     * 001-000 = 0001<br>
     * 002-000 = * 009-000 = FF<br>
     * 030-000 = Cancelada pelo Operador<br>
     * 999-999 = 0<br>
     * @throws ACBrException
     */
    public String loadFromFile(String nomeDoArquivo, int timeOut) throws ACBrException {
        return comandoAcbr("ACBr.LoadFromFile(" + nomeDoArquivo + "," + timeOut + ")");
    }

    /**
     * Apaga arquivos na máquina em que o ACBrMonitor está rodando. <br>Util por
     * exemplo, para implementar TEF discado em máquinas operadas remotamente
     * por TCP/IP
     * <br><br>Exemplo: ACBr.DeleteFiles("C:\TEF_Dial\Resp\INTPOS.001" )
     * <br>
     * Nota: Necessita qua a Opção "Permitir Comandos Remotos" esteja
     * selecionada <br>
     * As mascaras '*', '*.*' ou '' não são permitidas por motivos de segurança
     * <br>
     *
     * @param nomeDoArquivo Nome completo do Arquivo a ser Apagado, ou Mascara
     * com Arquivos a serem apagados
     * @throws ACBrException
     */
    public void deleteFiles(String nomeDoArquivo) throws ACBrException {
        comandoAcbr("ACBr.DeleteFiles(" + nomeDoArquivo + ")");
    }

    /**
     * Ativa o foco do Sistema Operacional para uma aplicação, baseado no nome
     * da Janela. Exemplo: <br> ACBr.AppActivate("Calculator") - Traz a
     * Calculadora do Windows para o Foco principal (se ela estiver em execução)
     * <br><br>
     * Nota: Apenas disponível no Windows
     *
     * @param nomeJanela Nome da Janela que deseja ajustar o foco.<br>
     * comando.
     * @throws ACBrException
     */
    public void appActivate(String nomeJanela) throws ACBrException {
        comandoAcbr("ACBr.AppActivate(" + nomeJanela + ")");
    }

    /**
     * Ativa o foco do Sistema Operacional para uma aplicação, baseado no nome
     * da Janela. Exemplo: <br> ACBr.AppActivate("Calculator") - Traz a
     * Calculadora do Windows para o Foco principal (se ela estiver em execução)
     * <br><br>
     * Nota: Apenas disponível no Windows
     *
     * @param nomeJanela Nome da Janela que deseja ajustar o foco.<br>
     * @param timeOut Tempo em Milissegundos a esperar antes de efetuar o
     * comando.
     * @throws ACBrException
     */
    public void appActivate(String nomeJanela, int timeOut) throws ACBrException {
        comandoAcbr("ACBr.AppActivate(" + nomeJanela + "," + timeOut + ")");
    }

    /**
     * Retorna True ou False se existir uma aplicação em execução, baseado no
     * nome da Janela informado
     * <br>Exemplos:<br>
     * ACBr.AppExists("Calculator") - Verifica se um programa chamado
     * "Calculator" está em execução<br>
     * OK: True
     * <br>
     *
     * @param nomeJanela Nome da Janela que deseja consultar a execução.
     * @return
     *
     * @throws ACBrException
     */
    public boolean appExists(String nomeJanela) throws ACBrException {
        return comandoAcbr("ACBr.AppExists(" + nomeJanela + ")").toLowerCase().equals("true");
    }

    /**
     * Bloqueia/Desbloqueia o teclado. <br>Nota: Apenas disponível no Windows
     *
     * @param b True para bloquear e False para desbloquear o teclado.
     * @throws ACBrException
     */
    public void blockInput(boolean b) throws ACBrException {
        comandoAcbr("ACBr.BlockInput(" + b + ")");
    }

    /**
     * Envia teclas para o Buffer de Teclado
     * <br>
     * Exemplos:<br>
     * ACBr.SendKeys("^{ESC}") - Envia Ctrl+ESC para o buffer de Teclado
     * <br><br><b>SINTAXE</b><br>
     * SendKeys suporta a sintaxe do Visual Basic, conforme documentado
     * abaixo.<br>
     *
     * @param aguarda Se True, aguarda o termino do envio das teclas<br>
     * @param teclas Teclas a serem enviadas, usando a sintaxe especificada
     * acima:<br>
     *
     * @throws ACBrException
     */
    public void sendKeys(String teclas, boolean aguarda) throws ACBrException {
        comandoAcbr("ACBr.SendKeys(" + teclas + "," + aguarda + ")");
    }

    public String comandoAcbr(String comando) throws ACBrException {
        String[] retorno;
        try {
            retorno = writeToReadFromSocket(comando).split(":");
        } catch (Exception ex) {
            throw new ACBrException(ex.getMessage());
        }
        String r = "";
        switch (retorno[0].toLowerCase()) {
            case "ok":
                if (retorno.length > 2) {
                    for (int i = 1; i < retorno.length; i++) {
                        r += retorno[i] + ":";
                    }
                    r = r.substring(0, r.length() - 1);
                } else {
                    r = retorno[1];
                }
                break;
            case "erro":
                String e = "";
                if (retorno.length > 2) {
                    for (int i = 1; i < retorno.length; i++) {
                        e += retorno[i] + ":";
                    }
                    e = e.substring(0, e.length() - 1);
                } else {
                    e = retorno[1];
                }
                throw new ACBrException(e);
            default:
                throw new AssertionError();
        }
        return r.trim();
    }

    private static String writeToReadFromSocket(String comando) throws ACBrException {
        try {
            InetAddress hostName = InetAddress.getByName(NAMEHOST);
            boolean primeiraInstancia = false;
            if (acbrSocket == null) {
                primeiraInstancia = true;
                acbrSocket = new Socket(hostName, PORTA);
            }
            if (enviaComando == null) {
                enviaComando = new PrintWriter(acbrSocket.getOutputStream());
            }
            if (recebeComando == null) {
                recebeComando = new BufferedReader(new InputStreamReader(acbrSocket.getInputStream(), "UTF-8"));
            }
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ACBrBAL.class.getName()).log(Level.SEVERE, null, ex);
//            }
            if (primeiraInstancia) {
                //loop para limpar o cabeÃ§alho da conexao com o acbr  
                short byteLido = -1;
                String leitura = "";
                while (byteLido != 3) {
                    byteLido = (short) recebeComando.read();
                    if (byteLido != 3) {
                        leitura += (char) byteLido;
                    }
                }
                System.out.println("Leitura: " + leitura);
            }
            comando = comando.toUpperCase();
//        enviaComando.println(comando);
            enviaComando.print(comando + '\r' + '\n' + "." + '\r' + '\n');
            enviaComando.flush();

            if ("BYE".equals(comando)) {
                enviaComando.close();
                recebeComando.close();
                acbrSocket.close();
                return "FIM";
            }
            //faz a leitura do retorno do acbr  
            short b = -1;
            String retorno = "";
            while (b != 3) {
                b = (short) recebeComando.read();
                if (b != 3) {
                    retorno += (char) b;
                }
            }
            return retorno;
        } catch (UnknownHostException ex) {
            throw new ACBrException(ex.getMessage());
        } catch (IOException ex) {
            throw new ACBrException(ex.getMessage());
        }
    }

    private static Config getConfig() {
        String c = "config.acbr";
        try {
            FileInputStream fis = new FileInputStream(c);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Config) ois.readObject();
        } catch (Exception e) {
            Config config = new Config();
            JLabel l1 = new JLabel("Nome/IP do AcbrMonitorPlus");
            JTextField jtfNameHost = new JTextField();
            JLabel l2 = new JLabel("Porta do AcbrMonitorPlus");
            JTextField jtfPorta = new JTextField();
            Object[] msg = {l1, jtfNameHost, l2, jtfPorta};
            JOptionPane.showMessageDialog(null, msg, "Configuração ACBr Não Encontrada!", JOptionPane.OK_OPTION);
            config.setNameHost(jtfNameHost.getText());
            config.setPorta(Integer.parseInt(jtfPorta.getText()));
            try (FileOutputStream fout = new FileOutputStream(c); ObjectOutputStream oos = new ObjectOutputStream(fout)) {
                oos.writeObject(config);
            } catch (IOException ex) {
                Logger.getLogger(ACBr.class.getName()).log(Level.SEVERE, null, ex);
            }
            return config;
        }
    }

    public static ACBr getInstance() {
        return ACBrHolder.INSTANCE;
    }

    private static class ACBrHolder {

        private static final ACBr INSTANCE = new ACBr();
    }

    private static class Config implements Serializable {

        private String nameHost;
        private int porta;

        public String getNameHost() {
            return nameHost;
        }

        public void setNameHost(String nameHost) {
            this.nameHost = nameHost;
        }

        public int getPorta() {
            return porta;
        }

        public void setPorta(int porta) {
            this.porta = porta;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a chave");
        String chave = sc.nextLine();
        System.out.println("CNPJ");
        String cnpj = sc.nextLine();
        try {
            System.out.println(ACBrNFe.getInstance().downloadNFe(cnpj, chave));
        } catch (ACBrException ex) {
            Logger.getLogger(ACBr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
