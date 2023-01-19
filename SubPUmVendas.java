import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class SubPUmVendas {
    public static Scanner scanner = new Scanner(System.in);
    static LinkedList<String> vendas = new LinkedList<String>();
    static LinkedList<Double> boValorVendas = new LinkedList<Double>();
    static double valor;

    public static void menuVendas() {
        String op;
        do {
            System.out.println("+------------------------------+");
            System.out.println("|             Vendas           |");
            System.out.println("+------------------------------+");
            System.out.println("|     1 - Realizar Venda       |");
            System.out.println("|     2 - Verificar Vendas     |");
            System.out.println("|     9 - Voltar ao Menu       |");
            System.out.println("+------------------------------+");
            System.out.println("| Qual a opção Desejada: ");
            op = scanner.next();

            switch (op) {
                case "1":
                    Controle.limpaTela();
                    realizarVendas();
                    break;
                case "2":
                    Controle.limpaTela();
                    verificarVendas();
                    break;
                case "3":
                    Controle.limpaTela();
                    removerUltimaVenda();
                    break;
                case "9":
                    Controle.limpaTela();
                    menuPrincipal.menu();
                    break;
                default:
                    Controle.limpaTela();
                    System.out.println("+---------------------------+");
                    System.out.println("|      Opção inválida       |");
                    menuVendas();
                    break;
            }
        } while (op == "9");
    }

    public static void realizarVendas() {
        String idProduto, nomeCliente, sobrenomeCliente, vendedor, produto;
        int horaVenda, minutoVenda, diaVenda, mesVenda, anoVenda;
        long idVenda;
        double valor;

        System.out.println("+---------------------------+");
        System.out.println("|       Realizar Venda      |");
        System.out.println("+---------------------------+");

        System.out.println("> Nome do Cliente: ");
        nomeCliente = scanner.next();
        System.out.println("> Sobrenome do Cliente: ");
        sobrenomeCliente = scanner.next();

        System.out.println("> Qual é o ID do Produto vendido: ");
        idProduto = scanner.next();
        System.out.println("> Produto: ");
        produto = scanner.next();
        System.out.println("> Valor: ");
        valor = scanner.nextDouble();

        do {
            System.out.println("> Hora da Venda: ");
            horaVenda = scanner.nextInt();
        } while (horaVenda >= 24);

        do {
            System.out.println("> Minuto da Venda: ");
            minutoVenda = scanner.nextInt();
        } while (minutoVenda >= 60);

        do {
            System.out.println("> Dia da Venda: ");
            diaVenda = scanner.nextInt();
        } while (diaVenda >= 32);

        do {
            System.out.println("> Mês da Venda: ");
            mesVenda = scanner.nextInt();
        } while (mesVenda >= 13);

        do {
            System.out.println("> Ano da Venda: ");
            anoVenda = scanner.nextInt();
        } while (anoVenda < 2023);

        System.out.println("> Vendedor: ");
        vendedor = scanner.nextLine();

        idVenda = horaVenda + mesVenda + diaVenda + minutoVenda;

        boolean testarFormaLetra;
        String encerrarVenda;

        System.out.println("+---------------------------------------+");
        System.out.println("|             NOTA FISCAL               |");
        System.out.println("+---------------------------------------+");
        System.out.println("| Nome do CLiente: " + nomeCliente + " " + sobrenomeCliente);
        System.out.println("| Data da Venda: " + diaVenda + "/" + mesVenda + "/" + anoVenda);
        System.out.println("| Horario da Venda: " + horaVenda + " Hrs e " + minutoVenda + " minutos");
        System.out.println("| Produto: " + produto);
        System.out.println("| IdProduto: " + idProduto);
        System.out.println("| IdVenda: " + idVenda);
        System.out.println("| Vendedor: " + vendedor);
        System.out.println("+---------------------------------------+");
        System.out.println("| Valor: R$" + valor);
        System.out.println("+---------------------------------------+");

        System.out.println("| Deseja Finalizar a Venda? |");
        System.out.println("| (S) para Sim (N) para Não |");
        encerrarVenda = scanner.next();
        testarFormaLetra = !encerrarVenda.equalsIgnoreCase("S") && !encerrarVenda.equalsIgnoreCase("N");

        do {
            if (testarFormaLetra) {
                System.out.println("+---------------------------+");
                System.out.println("|      OPÇÃO INVÁLIDA!!!    |");
                System.out.println("+---------------------------+");
            } else if (encerrarVenda.equalsIgnoreCase("S")) {
                System.out.println("+-------------------------------+");
                System.out.println("| ENVIANDO NF PARA A IMPRESSORA |");
                System.out.println("+-------------------------------+");
                boValorVendas.add(valor);
                vendas.add(produto);
                valor = valor + valor;
                menuVendas();
            } else if (encerrarVenda.equalsIgnoreCase("N")) {
                System.out.println("+------------------------------+");
                System.out.println("|        Voltando ao Menu      |");
                menuVendas();
            }
        } while (testarFormaLetra);
    }

    public static void verificarVendas() {
        if (vendas.size() == 0) {
            System.out.println("+------------------------------+");
            System.out.println("|      Controle de Vendas      |");
            System.out.println("+------------------------------+");
            System.out.println("|      Não Há vendas Hoje      |");
            testeDeRetornoAoMenu();
        } else {
            System.out.println("+------------------------------+");
            System.out.println("|      Controle de Vendas      |");
            System.out.println("+------------------------------+");
            if (vendas.size() == 0) {
                System.out.println("|      Não Tivemos Vendas      |");
                testeDeRetornoAoMenu();
            } else {
                System.out.println("| Foram realizadas: " + vendas.size() + " Vendas ");
                System.out.println("+------------------------------+");
                System.out.println("| A Última Venda Foi: " + vendas.peek());
                System.out.println("+------------------------------+");
                System.out.println("| Estas foram as vendas: ");
                for (String vend : vendas) {
                    System.out.println("  " + vend);
                }
                System.out.println("+------------------------------+");
                System.out.println("| Este é o valor das Vendas: ");
                for (Double vendValor : boValorVendas) {
                    System.out.println("  R$" + vendValor);
                }
                testeDeRetornoAoMenu();
            }
        }
    }

    public static void removerUltimaVenda() {
        System.out.println("+------------------------------+");
        System.out.println("|        Remover Venda         |");
        System.out.println("+------------------------------+");
        String remover;
        if (vendas.peek() == null) {
            System.out.println("+----------------------------+");
            System.out.println("| Não há Peças para a venda  |");
            System.out.println("+----------------------------+");
        } else {
            System.out.println("A venda que pode ser removida é : " + vendas.peek());
            System.out.println("+--------------------------------------------------------+");
            System.out.println("| Tem certeza que vai remove-lá? S para Sim ou N para Não ");
            remover = scanner.next();

            if (Objects.equals(remover, "s")) {
                vendas.remove(vendas.peek());
                System.out.println("+------------------------------+");
                System.out.println("|         Venda Removida       |");
                System.out.println("+------------------------------+");
            } else if (Objects.equals(vendas, "n")) {
                System.out.println("+------------------------------+");
                System.out.println("|        Venda Não Removida    |");
                System.out.println("+------------------------------+");
                System.out.println("|        Voltando ao menu!     |");
                menuVendas();
            } else {
                System.out.println("Opção Invalida");
                removerUltimaVenda();
            }
        }
    }

    public static void testeDeRetornoAoMenu() {
        String encerrarVenda;
        boolean valiadacao;

        System.out.println("+------------------------------+");
        System.out.println("|       Deseja Continuar?      |");
        System.out.println("|   (S) para Sim (N) para Não  |");
        encerrarVenda = scanner.next();

        valiadacao = !encerrarVenda.equalsIgnoreCase("S") && !encerrarVenda.equalsIgnoreCase("N");
        do {
            if (valiadacao) {
                System.out.println("+---------------------------+");
                System.out.println("|      OPÇÃO INVÁLIDA!!!    |");
                System.out.println("+---------------------------+");
            } else if (encerrarVenda.equalsIgnoreCase("S")) {
                verificarVendas();
            } else if (encerrarVenda.equalsIgnoreCase("N")) {
                System.out.println("+---------------------------+");
                System.out.println("|      Voltando ao Menu     |");
                menuVendas();
            }
        } while (valiadacao);
    }
}