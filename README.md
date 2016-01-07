# ACBrMonitorPlus-Comunicador

##Como emitir um Cupom Fiscal Completo
Primeiramente cofigure os dados da impressora no ACBrMonitor.
Em breve colocaremos isso para configurar direto pela LIB.
Depois...
<code>
ACBrECF e = new ACBrECF();
e.ativar();
try{
  e.getCupomFiscal().testaPodeAbrirCupom();//Verifica se é possivel abrir Cupom.
  e.getCupomFiscal().abreCupom();
  e.getCupomFiscal().vendeItem("001", "descricao item 1", Numeros.parseToBig("18"), new BigDecimal("5"), Numeros.parseToBig("5,00"));
  e.getCupomFiscal().vendeItem("002", "descricao item 2", "17", "2", "1,02");
  e.getCupomFiscal().vendeItem("003", "descricao item 3", Double.parseDouble("18"), Double.parseDouble("2"), Double.parseDouble("1.02"));
  if (e.getVariaveis().getEquipamento().marcaStr().toLowerCase().contains("daruma")) {
                        e.getCupomFiscal().vendeItem("004", "descricao item 4", Numeros.parseToBig("17"), new BigDecimal("20"), BigDecimal.ONE, BigDecimal.TEN, "UND", '$', 'A', 1);
  }
  e.getCupomFiscal().cancelaItemVendido(2); //cancelando o item 2
  e.getCupomFiscal().vendeItem("005", "descricao item 5", "17", "4", "1,02");
  e.getCupomFiscal().cancelaItemVendido(4);
  //O if abaixo é devido ser um comando onde está disponível apenas para daruma
  if (e.getVariaveis().getEquipamento().marcaStr().toLowerCase().contains("daruma")) {
    e.getCupomFiscal().cancelaItemVendidoParcial(1, "1,5"); //cancela parcialmente a qtd 1,5 do item 1
  }
  e.getCupomFiscal().vendeItem("006", "descricao item 6 - aplicar desc", "FF", "6", "1,00");
  e.getCupomFiscal().descontoItemAnterior(BigDecimal.ONE, '%'); //aplica desconto no item anterior
  e.getCupomFiscal().vendeItem("007", "descricao item 7 - aplicar acres", "12", BigDecimal.TEN, BigDecimal.ONE);
  e.getCupomFiscal().acrescimoItemAnterior(BigDecimal.ONE, '%'); //aplica acrescimo no item anterior
  e.getCupomFiscal().vendeItem("008", "descricao item 8 - aplicar desc item", "II", BigDecimal.TEN, BigDecimal.ONE);
  e.getCupomFiscal().descontoAcrescimoItem(BigDecimal.ONE, 'D', '$', 8);
  System.out.println("Numero Cupom: " + e.getCupomFiscal().getVariaveis().numCupom());
  System.out.println("Numero ultimo item: " + e.getCupomFiscal().getVariaveis().numUltItem());
  e.getCupomFiscal().subtotalizaCupom(); //subtotaliza
  e.getCupomFiscal().efetuaPagamento("01", new BigDecimal(100)); //efetua pagamento
  System.out.println("Subtotal: " + e.getCupomFiscal().getVariaveis().subTotal());
  System.out.println("Total pago: " + e.getCupomFiscal().getVariaveis().totalPago());
  e.getCupomFiscal().fechaCupom("mensagem linha1|mensagem linha2"); //fanaliza cupom
}catch(ACBrECFException ex){
  JOptionPane.showMessageDialog(null, ex.getMessage());
}
</code>
OBS: Todos os métodos do ACBrECF estão com javadoc baseado no Help do ACBrMonitorPlus.
Mais informções:
http://edsonmoretti.github.io/ACBrMonitorPlus-Comunicador/ 
