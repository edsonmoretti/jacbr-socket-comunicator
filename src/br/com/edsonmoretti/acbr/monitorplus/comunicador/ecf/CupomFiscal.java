/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf;

import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrAAC;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF;
import static br.com.edsonmoretti.acbr.monitorplus.comunicador.ACBrECF.comandoECF;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.exceptions.ACBrECFException;
import br.com.edsonmoretti.acbr.monitorplus.comunicador.utils.Numeros;
import java.math.BigDecimal;

/**
 *
 * @author Edson
 */
public class CupomFiscal {

    private char sufixoAliquota = 'T';
    private br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.cupomfiscal.Variaveis variaveis;

    public CupomFiscal() {
    }

    /**
     * Realiza o teste com o estado da ECF se está livre para emissão de Cupom
     * Fiscal. Retornando OK se estado é livre ou ERRO juntamente com o motivo.
     *
     * @throws ACBrECFException Em caso de não poder abrir CUPOM, juntamente com
     * sua mensagem de erro. EX: ERRO: Estado da impressora SwedaSTX *
     * estRelatorio (não é Livre) *
     */
    public void testaPodeAbrirCupom() throws ACBrECFException {
        comandoECF("TestaPodeAbrirCupom");
    }

    /**
     * O Método Identifica Consumidor, se for usado antes da abertura do cupom,
     * os dados do consumidor serão usados no comando de AbreCupom, caso seja
     * usado após o abre cupom, se o ECF não for MFD, os dados serão impressos
     * nas linhas de mensagens do cupom.
     *
     * @param documento CPF/CNPJ do Consumidor
     * @throws ACBrECFException
     */
    public void identificaConsumidor(String documento) throws ACBrECFException {
        identificaConsumidor(documento, "", "");
    }

    /**
     * O Método Identifica Consumidor, se for usado antes da abertura do cupom,
     * os dados do consumidor serão usados no comando de AbreCupom, caso seja
     * usado após o abre cupom, se o ECF não for MFD, os dados serão impressos
     * nas linhas de mensagens do cupom.
     *
     * @param documento CPF/CNPJ do Consumidor
     * @param nome Nome do Consumidor
     * @param endereco Endereço do Consumidor
     * @throws ACBrECFException
     */
    public void identificaConsumidor(String documento, String nome, String endereco) throws ACBrECFException {
        comandoECF("IdentificaConsumidor (" + documento + ", " + nome + ", \"" + endereco + "\")");
    }

    /**
     * Realiza a abertura do Cupom Fiscal.
     *
     * @throws ACBrECFException
     */
    public void abreCupom() throws ACBrECFException {
        abreCupom("", "", "");
    }

    /**
     * Realiza a abertura do Cupom Fiscal.<br>
     * <b>Nota:</b> Nem todos os modelos de ECF fazem uso do parâmetro
     * cCPF_CNPJ, nesse caso o Cupom será aberto, porém o número de
     * identificação do cliente não será impresso. Dica: Para identificar o
     * cliente prefira usar o Rodapé do Cupom, que permite até 8 linhas de texto
     * livre. Caso tenha problemas utilize o abreCupom();
     *
     * @param documento Se necessário, informe o CPF/CNPJ do Consumidor
     * @param nome Se necessário, informe o NOME do Consumidor
     * @param endereco Se necessário, informe o ENDEREÇO do Consumidor
     * @throws ACBrECFException
     */
    public void abreCupom(String documento, String nome, String endereco) throws ACBrECFException {
        comandoECF("AbreCupom (" + documento + ", " + nome + ", \"" + endereco + "\")");
    }

    /**
     * Cancela o Cupom Fiscal atual (se estiver aberto) em qualquer estágio do
     * Cupom. <br>
     * Se não houver cupom aberto, cancela o Último Cupom emitido, caso o último
     * documento seja realmente um Cupom Fiscal.
     *
     * @throws ACBrECFException
     */
    public void cancelaCupom() throws ACBrECFException {
        comandoECF("CancelaCupom");
    }

    /**
     * Habilita a Legenda InMetro para o próximo item. Este comando deve ser
     * utilizado antes da venda de um item, com a Legenda habilitada é impresso
     * no cupom fiscal a unidade de medida do InMetro. Exemplo : R$/UN.<br>
     * A legenda INMETRO é desabilitada automaticamente após a impressão do
     * item.<br>
     * <b>Nota:</b> Comando disponível apenas para Daruma.
     *
     * @throws ACBrECFException
     */
    public void legendaInMetroProximoItem() throws ACBrECFException {
        comandoECF("LegendaInMetroProximoItem");
    }

    public void vendeItem(String gtin, String descricaoPdv, String ecficms, BigDecimal quantidade, BigDecimal valorUni, String unidadeProduto) throws ACBrECFException {
        vendeItem(gtin, descricaoPdv, ecficms, quantidade.toString(), valorUni.toString(), "0.00", unidadeProduto, "", "", "0");
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @throws ACBrECFException
     * @deprecated melhor não usar valor como aliquota, pois podem vir II, NN,
     * FF
     */
    public void vendeItem(String codigo, String descricao, Double aliquotaICMS, Double qtd, Double valorUnitario) throws ACBrECFException {
        vendeItem(codigo, descricao, String.valueOf(aliquotaICMS), String.valueOf(qtd), String.valueOf(valorUnitario));
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param unidadeProduto unidade do produto, ex: UN, KG, CX, etc...
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @throws ACBrECFException
     */
    public void vendeItem(String codigo, String descricao, String aliquotaICMS, String unidadeProduto, String qtd, String valorUnitario) throws ACBrECFException {
        comandoECF("VendeItem(\"" + codigo + "\", \"" + descricao + "\", " + aliquotaICMS + sufixoAliquota + ", " + qtd + ", " + Numeros.parseToBig(valorUnitario).toString() + ", 0.00," + unidadeProduto + ", \"$\", \"A\", 0.00)");
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @throws ACBrECFException
     */
    public void vendeItem(String codigo, String descricao, String aliquotaICMS, String qtd, String valorUnitario) throws ACBrECFException {
        comandoECF("VendeItem(\"" + codigo + "\", \"" + descricao + "\", " + aliquotaICMS + sufixoAliquota + ", " + qtd + ", " + Numeros.parseToBig(valorUnitario).toString() + ")");
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @throws ACBrECFException
     */
    public void vendeItem(String codigo, String descricao, BigDecimal aliquotaICMS, BigDecimal qtd, BigDecimal valorUnitario) throws ACBrECFException {
        vendeItem(codigo, descricao, aliquotaICMS.toString(), qtd.toString(), valorUnitario.toString());
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @throws ACBrECFException
     */
    public void vendeItem(String codigo, String descricao, String aliquotaICMS, BigDecimal qtd, BigDecimal valorUnitario) throws ACBrECFException {
        vendeItem(codigo, descricao, aliquotaICMS, qtd.toString(), valorUnitario.toString());
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param unidadeProduto unidade do produto, und, kg, cx, etc...
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @throws ACBrECFException
     */
    public void vendeItem(String codigo, String descricao, String aliquotaICMS, String unidadeProduto, BigDecimal qtd, BigDecimal valorUnitario) throws ACBrECFException {
        vendeItem(codigo, descricao, aliquotaICMS, unidadeProduto, qtd.toString(), valorUnitario.toString());
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @param valorDescontoAcrescimo Se necessário, informe a Porcentagem de
     * Desconto a aplicar no item Vendido. Dependendo do ECF o valor e
     * porcentagem do Desconto será impresso no Cupom. cUnidade - Parâmetro
     * opcional, Se necessário, informe o Texto com a unidade de medida do Item.
     * Exemplo: "UN", "LT", "MT", "KG", etc cTipoDescontoAcrescimo - Parâmetro
     * opcional. Informar "%" para porcentagem ou "$" para valor.Se parâmetro
     * omitido será considerado em porcentagem "%".
     * @param unidade Se necessário, informe o Texto com a unidade de medida do
     * Item. Exemplo: "UN", "LT", "MT", "KG", etc
     * @param tipoDescontoAcrescimo Informar "%" para porcentagem ou "$" para
     * valor.Se parâmetro omitido será considerado em porcentagem "%".
     * @param ehDescontoOuAcrescimo Informar "A" para acréscimo ou "D" para
     * desconto.Se parâmetro omitido será considerado Desconto "D"
     * @param codDepartamento Código de departamento.
     * @throws ACBrECFException
     */
    public void vendeItem(String codigo, String descricao, String aliquotaICMS, String qtd, String valorUnitario,
            String valorDescontoAcrescimo, String unidade, String tipoDescontoAcrescimo, String ehDescontoOuAcrescimo, String codDepartamento) throws ACBrECFException {
        vendeItem(codigo, descricao, Numeros.parseToBig(aliquotaICMS), Numeros.parseToBig(qtd), Numeros.parseToBig(valorUnitario),
                Numeros.parseToBig(valorDescontoAcrescimo), unidade, tipoDescontoAcrescimo.charAt(0), ehDescontoOuAcrescimo.charAt(0), Integer.parseInt(codDepartamento));
    }

    /**
     * Realiza a venda dos itens.
     *
     * @param codigo código do produto, geralmente á aceito até 13
     * @param descricao descrição do Produto vendido. Procure não usar acentos,
     * pois alguns ECFs não aceitam caracteres acentuados. Para imprimir
     * Descrições "grandes" habilite a opção "Descrição Grande" no ACBrMonitor.
     * @param aliquotaICMS representação da Alíquota do ICMS.<br>
     * - As alíquotas podem ser informadas em Valor (mesmo sendo texto).
     * Exemplos: "18", "2.46".<br>
     * - Se no ECF existem alíquotas iguais para ICMS e ISS, use o sufixo "T"
     * para informar que a alíquota é do ICMS ou "S" para alíquotas do ISS.
     * Exemplo: "18T" = alíquota de 18% do ICMS; "2.5S" alíquota de 2,5% do ISS
     * <br>
     * - As alíquotas podem ser informadas em índice, de acordo com a Tabela de
     * alíquotas do ECF, nesse caso use a letra "T", seguida da posição da
     * Alíquota: Exemplo: "T01", "T10"<br>
     * - Existem alíquotas internas do ECF para tratar produtos Isentos, nesse
     * caso use: "FF" para Substituição Tributária, "NN" = Não incidência ou
     * "II" = Isento <br>
     * @param qtd Quantidade de Produtos a Vender. Permite valores com até 3
     * casas decimais. O ACBr verifica quantas casas decimais existem no valor
     * informado e utiliza o comando apropriado para o ECF, otimizando a
     * impressão para Inteiros o 2 casas decimais, sempre que possível
     * @param valorUnitario Preço Unitário do produto vendido. Permite valores
     * com até 3 casas decimais. O ACBr verifica quantas casas decimais existem
     * no valor informado e utiliza o comando apropriado para o ECF, otimizando
     * a impressão para 2 casas decimais, sempre que possível.
     * @param valorDescontoAcrescimo Se necessário, informe a Porcentagem de
     * Desconto a aplicar no item Vendido. Dependendo do ECF o valor e
     * porcentagem do Desconto será impresso no Cupom. cUnidade - Parâmetro
     * opcional, Se necessário, informe o Texto com a unidade de medida do Item.
     * Exemplo: "UN", "LT", "MT", "KG", etc cTipoDescontoAcrescimo - Parâmetro
     * opcional. Informar "%" para porcentagem ou "$" para valor.Se parâmetro
     * omitido será considerado em porcentagem "%".
     * @param unidade Se necessário, informe o Texto com a unidade de medida do
     * Item. Exemplo: "UN", "LT", "MT", "KG", etc
     * @param tipoDescontoAcrescimo Informar "%" para porcentagem ou "$" para
     * valor.Se parâmetro omitido será considerado em porcentagem "%".
     * @param ehDescontoOuAcrescimo Informar "A" para acréscimo ou "D" para
     * desconto.Se parâmetro omitido será considerado Desconto "D"
     * @param codDepartamento Código de departamento.
     * @deprecated Não é bom usar aliquotaICMS como numero, pode levantar
     * parseexception devido NN, FF e II
     * @throws ACBrECFException
     */
    public void vendeItem(String codigo, String descricao, BigDecimal aliquotaICMS, BigDecimal qtd, BigDecimal valorUnitario,
            BigDecimal valorDescontoAcrescimo, String unidade, char tipoDescontoAcrescimo, char ehDescontoOuAcrescimo, int codDepartamento) throws ACBrECFException {
        ehDescontoOuAcrescimo = String.valueOf(ehDescontoOuAcrescimo).toUpperCase().charAt(0);
        if (tipoDescontoAcrescimo == '%' || tipoDescontoAcrescimo == '$') {
            if (ehDescontoOuAcrescimo == 'D' || ehDescontoOuAcrescimo == 'A') {
                comandoECF("VendeItem(\"" + codigo + "\", \"" + descricao + "\", " + aliquotaICMS + (sufixoAliquota) + ", " + qtd + ", " + valorUnitario + ","
                        + "" + valorDescontoAcrescimo + "," + unidade + ",\"" + tipoDescontoAcrescimo + "\",\"" + ehDescontoOuAcrescimo + "\"," + codDepartamento + ")");
            } else {
                throw new ACBrECFException("Informação sobre ser desconto ou acrescimo invalido. Possíveis: D - Desconto ou A - Acrescimo");
            }
        } else {
            throw new ACBrECFException("Tipo de desconto ou acrescimo inválido. Possíveis: % ou $");
        }
    }

    /**
     * Cancela o item informado no parâmetro.
     *
     * @param numItem Numero do Item, de acordo com a ordem de impressão no
     * Cupom fiscal a cancelar.
     */
    public void cancelaItemVendido(int numItem) throws ACBrECFException {
        comandoECF("CancelaItemVendido(" + numItem + ")");
    }

    /**
     * Cancela o item parcialmente, ou seja cancela a quantidade informada no
     * parâmetro.
     * <b>Nota:</b> Comando disponível apenas para Daruma.
     *
     * @param numItem Numero do Item, de acordo com a ordem de impressão no
     * Cupom fiscal a cancelar.
     * @param qtd a ser cancelada.
     * @throws ACBrECFException
     */
    public void cancelaItemVendidoParcial(int numItem, Double qtd) throws ACBrECFException {
        cancelaItemVendidoParcial(numItem, String.valueOf(qtd));
    }

    /**
     * Cancela o item parcialmente, ou seja cancela a quantidade informada no
     * parâmetro.
     * <b>Nota:</b> Comando disponível apenas para Daruma.
     *
     * @param numItem Numero do Item, de acordo com a ordem de impressão no
     * Cupom fiscal a cancelar.
     * @param qtd a ser cancelada.
     * @throws ACBrECFException
     */
    public void cancelaItemVendidoParcial(int numItem, String qtd) throws ACBrECFException {
        cancelaItemVendidoParcial(numItem, Numeros.parseToBig(qtd));
    }

    /**
     * Cancela o item parcialmente, ou seja cancela a quantidade informada no
     * parâmetro.
     * <b>Nota:</b> Comando disponível apenas para Daruma.
     *
     * @param numItem Numero do Item, de acordo com a ordem de impressão no
     * Cupom fiscal a cancelar.
     * @param qtd a ser cancelada.
     * @throws ACBrECFException
     */
    public void cancelaItemVendidoParcial(int numItem, BigDecimal qtd) throws ACBrECFException {
        comandoECF("CancelaItemVendidoParcial(" + numItem + "," + qtd + ")");
    }

    /**
     * Cancela o Desconto ou Acréscimo atribuido a um item.
     * <b>Nota:</b> Comando disponível apenas para Daruma.
     *
     * @param numItem Numero do Item, de acordo com a ordem de impressão no
     * Cupom fiscal.
     * @throws ACBrECFException
     */
    public void cancelaDescontoAcrescimoItem(int numItem) throws ACBrECFException {
        comandoECF("CancelaDescontoAcrescimoItem(" + numItem + ")");
    }

    /**
     * Realiza desconto item anterior.
     *
     * @param valorDesconto Valor do Desconto.
     * @param tipo Informar "%" para tipo em porcentagem ou "$" para valor, se
     * parâmetro for omitido será considerado por porcentagem.
     * @throws ACBrECFException
     */
    public void descontoItemAnterior(BigDecimal valorDesconto, char tipo) throws ACBrECFException {
        comandoECF("DescontoAcrescimoItemAnterior(" + valorDesconto + ", \"D\"," + tipo + ")");
    }

    /**
     * Realiza acrescimo item anterior.
     *
     * @param valorAcrescimo Valor do Acréscimo.
     * @param tipo Informar "%" para tipo em porcentagem ou "$" para valor, se
     * parâmetro for omitido será considerado por porcentagem.
     * @throws ACBrECFException
     */
    public void acrescimoItemAnterior(BigDecimal valorAcrescimo, char tipo) throws ACBrECFException {
        comandoECF("DescontoAcrescimoItemAnterior(" + valorAcrescimo + ", \"A\",\"" + tipo + "\")");
    }

    /**
     * Realiza desconto ou acréscimo sobre o item informado.
     *
     * @param valorDescontoAcrescimo Valor do Desconto/Acréscimo.
     * @param ehDescontoOuAcrescimo Informa "D" para desconto e "A" para
     * Acréscimo, se parâmetro for omitido será considerado desconto.
     * @param tipoDescontoAcrescimo Informar "%" para tipo em porcentagem ou "$"
     * para valor, se parâmetro for omitido será considerado por porcentagem.
     * @param numItem Número do item a ser atribuido o desconto ou acréscimo, se
     * parâmetro for omitido será considerado o item anterior
     * @throws ACBrECFException
     */
    public void descontoAcrescimoItem(BigDecimal valorDescontoAcrescimo, char ehDescontoOuAcrescimo, char tipoDescontoAcrescimo, int numItem) throws ACBrECFException {
        comandoECF("DescontoAcrescimoItemAnterior(" + valorDescontoAcrescimo + ",\"" + ehDescontoOuAcrescimo + "\",\"" + tipoDescontoAcrescimo + "\"," + numItem + ")");

    }

    /**
     * Subtotaliza o cupom.
     *
     * @throws ACBrECFException
     */
    public void subtotalizaCupom() throws ACBrECFException {
        subtotalizaCupom("");
    }

    /**
     * Subtotaliza o cupom. 'Menor que 0' para desconto 'Maior que 0' para
     * acrescimo
     *
     * @param descontoAcrescimo Para Descontos, informe valores negativos, para
     * acréscimos valores positivos
     * @param mensagemRodape Informe até 8 linhas de mensagem a serem impressas
     * no rodapé do cupom. Usado apenas para o ECF DataRegis que não possui o
     * método FechaCupom, nos demais ECFs, se a mensagem for informada nesse
     * momento, ela será armazenada pelo ACBr e utilizada em FechaCupom
     * @throws ACBrECFException
     */
    public void subtotalizaCupom(BigDecimal descontoAcrescimo, String mensagemRodape) throws ACBrECFException {
        comandoECF("SubtotalizaCupom(" + descontoAcrescimo + "," + mensagemRodape + ")");
    }

    /**
     * Subtotaliza o cupom.
     *
     * @param mensagemRodape Informe até 8 linhas de mensagem a serem impressas
     * no rodapé do cupom. Usado apenas para o ECF DataRegis que não possui o
     * método FechaCupom, nos demais ECFs, se a mensagem for informada nesse
     * momento, ela será armazenada pelo ACBr e utilizada em FechaCupom
     * @throws ACBrECFException
     */
    public void subtotalizaCupom(String mensagemRodape) throws ACBrECFException {
        subtotalizaCupom(BigDecimal.ZERO, mensagemRodape);
    }

    /**
     * Cancela o Desconto ou Acréscimo atribuido no subtotal do cupom.
     *
     * @param tipo Tipo 'A' para Acrescimo 'D' para Desconto
     *
     * @throws ACBrECFException
     */
    public void cancelaDescontoAcrescimoSubTotal(char tipo) throws ACBrECFException {
        comandoECF("CancelaDescontoAcrescimoSubTotal(\"" + tipo + "\")");
    }

    /**
     * Efetua o Pagamento do Cupom fiscal.
     *
     * @param codFormaPagto Índice da Forma de pagamento cadastrada no ECF. Para
     * conhecer todas as Formas de pagamento cadastradas e seus respectivos
     * índices, utilize o comando ECF.FormasPagamento.
     * @param valor Valor pago para essa forma de pagamento.
     * @throws ACBrECFException
     */
    public void efetuaPagamento(String codFormaPagto, BigDecimal valor) throws ACBrECFException {
        efetuaPagamento(codFormaPagto, valor.toString());
    }

    /**
     * Efetua o Pagamento do Cupom fiscal.
     *
     * @param codFormaPagto Índice da Forma de pagamento cadastrada no ECF. Para
     * conhecer todas as Formas de pagamento cadastradas e seus respectivos
     * índices, utilize o comando ECF.FormasPagamento.
     * @param valor Valor pago para essa forma de pagamento
     * @throws ACBrECFException
     */
    public void efetuaPagamento(String codFormaPagto, String valor) throws ACBrECFException {
        comandoECF("EfetuaPagamento(" + codFormaPagto + "," + valor + ")");
    }

    /**
     * Efetua o Pagamento do Cupom fiscal.
     *
     * @param codFormaPagto Índice da Forma de pagamento cadastrada no ECF. Para
     * conhecer todas as Formas de pagamento cadastradas e seus respectivos
     * índices, utilize o comando ECF.FormasPagamento.
     * @param valor Valor pago para essa forma de pagamento.
     * @param obs Pode ser omitido. Alguns ECFs permitem a impressão de até 2
     * linhas de observação para cada forma de pagamento.
     * @param imprimeVinculado Pode ser omitido, nesse caso assume "False". Se
     * for informado "True" para este parâmetro, o ACBr apenas verifica se é
     * permitido imprimir Cupom Não Fiscal Vinculado para essa forma de
     * Pagamento.
     * @throws ACBrECFException
     */
    public void efetuaPagamento(String codFormaPagto, BigDecimal valor, String obs, boolean imprimeVinculado) throws ACBrECFException {
        efetuaPagamento(codFormaPagto, valor.toString(), obs, imprimeVinculado);
    }

    /**
     * Efetua o Pagamento do Cupom fiscal.
     *
     * @param codFormaPagto Índice da Forma de pagamento cadastrada no ECF. Para
     * conhecer todas as Formas de pagamento cadastradas e seus respectivos
     * índices, utilize o comando ECF.FormasPagamento.
     * @param valor Valor pago para essa forma de pagamento.
     * @param obs Pode ser omitido. Alguns ECFs permitem a impressão de até 2
     * linhas de observação para cada forma de pagamento.
     * @param imprimeVinculado Pode ser omitido, nesse caso assume "False". Se
     * for informado "True" para este parâmetro, o ACBr apenas verifica se é
     * permitido imprimir Cupom Não Fiscal Vinculado para essa forma de
     * Pagamento.
     * @throws ACBrECFException
     */
    public void efetuaPagamento(String codFormaPagto, String valor, String obs, boolean imprimeVinculado) throws ACBrECFException {
        comandoECF("EfetuaPagamento(" + codFormaPagto + ",\"" + valor + "\",\"" + obs + "\", " + imprimeVinculado + ")");
    }

    /**
     * Estorna um pagamento substituindo por outro, conforme os dados informados
     * nos parâmetros.
     *
     * @param codFormaPagtoEstornar Código da Forma de pagamento que será
     * estornado.
     * @param codFormaPagtoEfetivar Código da Forma de pagamento que será
     * efetivado.
     * @param valor Valor do pagamento que será estornado.
     * @throws ACBrECFException
     */
    public void estornaPagamento(String codFormaPagtoEstornar, String codFormaPagtoEfetivar, String valor) throws ACBrECFException {
        estornaPagamento(codFormaPagtoEstornar, codFormaPagtoEfetivar, valor, "");
    }

    /**
     * Estorna um pagamento substituindo por outro, conforme os dados informados
     * nos parâmetros.
     *
     * @param codFormaPagtoEstornar Código da Forma de pagamento que será
     * estornado.
     * @param codFormaPagtoEfetivar Código da Forma de pagamento que será
     * efetivado.
     * @param valor Valor do pagamento que será estornado.
     * @throws ACBrECFException
     */
    public void estornaPagamento(String codFormaPagtoEstornar, String codFormaPagtoEfetivar, BigDecimal valor) throws ACBrECFException {
        estornaPagamento(codFormaPagtoEstornar, codFormaPagtoEfetivar, valor.toString(), "");
    }

    /**
     * Estorna um pagamento substituindo por outro, conforme os dados informados
     * nos parâmetros.
     *
     * @param codFormaPagtoEstornar Código da Forma de pagamento que será
     * estornado.
     * @param codFormaPagtoEfetivar Código da Forma de pagamento que será
     * efetivado.
     * @param valor Valor do pagamento que será estornado.
     * @param observacao Observação ( Mensagem promocional)
     * @throws ACBrECFException
     */
    public void estornaPagamento(String codFormaPagtoEstornar, String codFormaPagtoEfetivar, BigDecimal valor, String observacao) throws ACBrECFException {
        estornaPagamento(codFormaPagtoEstornar, codFormaPagtoEfetivar, valor.toString(), observacao);
    }

    /**
     * Estorna um pagamento substituindo por outro, conforme os dados informados
     * nos parâmetros.
     *
     * @param codFormaPagtoEstornar Código da Forma de pagamento que será
     * estornado.
     * @param codFormaPagtoEfetivar Código da Forma de pagamento que será
     * efetivado.
     * @param valor Valor do pagamento que será estornado.
     * @param observacao Observação ( Mensagem promocional)
     * @throws ACBrECFException
     */
    public void estornaPagamento(String codFormaPagtoEstornar, String codFormaPagtoEfetivar, String valor, String observacao) throws ACBrECFException {
        comandoECF("EstornaPagamento(" + codFormaPagtoEstornar + "," + codFormaPagtoEfetivar + "," + valor + ", \"" + observacao + "\")");
    }

    /**
     * Realiza o Fechamento do cupom Fiscal.
     *
     * @throws ACBrECFException
     */
    public void fechaCupom() throws ACBrECFException {
        fechaCupom("");
    }

    /**
     * Realiza o Fechamento do cupom Fiscal.
     * <b>Notas:</b> Utilize a mensagem no rodapé para identificar o Cliente,
     * (Nome, Documento, Endereço, etc)
     * <br>
     * Este comando só pode ser executado após o Total de Pagamentos
     * (ECF.TotalPago) efetuados com ECF.EfetuaPagamento atingir ou ultrapassar
     * o valor de ECF.SubTotal
     * <br>
     *
     * @param mensagemRodape Informe até 8 linhas de mensagem a serem impressas
     * no rodapé do cupom. Se esse parâmetro for omitido aqui, porém foi
     * informado em ECF.SubtotalizaCupom , o texto informado anteriormente será
     * utilizado.<br><b>EX: "Mensagem Linha 1|Mensagem Linha 2"</b>
     * @throws ACBrECFException
     */
    public void fechaCupom(String mensagemRodape) throws ACBrECFException {
        comandoECF("FechaCupom(\"" + mensagemRodape + "\")");
    }

    /**
     * Variáveis do Cupom Fiscal
     *
     * @return
     */
    public br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.cupomfiscal.Variaveis getVariaveis() {
        return variaveis == null ? variaveis = new br.com.edsonmoretti.acbr.monitorplus.comunicador.ecf.cupomfiscal.Variaveis() : variaveis;
    }

    public char getSufixoAliquota() {
        return sufixoAliquota;
    }

    public void setSufixoAliquota(char sufixoAliquota) {
        this.sufixoAliquota = sufixoAliquota;
    }

}
