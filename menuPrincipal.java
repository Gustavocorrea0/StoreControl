import java.util.Scanner;

public class menuPrincipal {
    public static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        String op;
        do {
            System.out.println("+---------------------------+");
            System.out.println("|           Vendas          |");
            System.out.println("+---------------------------+");
            System.out.println("|       1 - Venda           |");
            System.out.println("|       2 - Cliente         |");
            System.out.println("|       3 - Bloquear        |");
            System.out.println("|       9 - Sair            |");
            System.out.println("+---------------------------+");
            System.out.println("| Qual a opção Desejada: ");
            op = scanner.next();

            switch (op) {
                case "1":
                    Controle.limpaTela();
                    SubPUmVendas.menuVendas(); //PRONTO
                    break;
                case "2":
                    Controle.limpaTela();
                    SubPDoisCadastroDeCliente.menuCadastroDeCliente();
                    break;
                case "3":
                    Controle.limpaTela();
                    System.out.println("+---------------------------+");
                    System.out.println("|        Bloqueado          |");
                    Acesso.testeDeSeguranca();
                    break;
                case "9":
                    System.exit(9);
                    break;
                default:
                    Controle.limpaTela();
                    System.out.println("+---------------------------+");
                    System.out.println("|      Opção inválida       |");
                    menu();
                    break;
            }
        } while (op == "9");
    }
}