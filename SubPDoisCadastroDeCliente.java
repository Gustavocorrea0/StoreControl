import java.util.LinkedList;
import java.util.Scanner;

public class SubPDoisCadastroDeCliente {
    public static Scanner scanner = new Scanner(System.in);
    static LinkedList<String> clientes = new LinkedList<String>();

    public static void menuCadastroDeCliente() {
        String op;
        do {
            System.out.println("+---------------------------+");
            System.out.println("|   Controle De Clientes    |");
            System.out.println("+---------------------------+");
            System.out.println("|  1 - Cadastrar Cliente    |");
            System.out.println("|  2 - Verificar Clientes   |");
            System.out.println("|  9 - Voltar ao Menu       |");
            System.out.println("+---------------------------+");
            System.out.println("| Qual a opção Desejada: ");
            op = scanner.next();

            switch (op) {
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    verificarClientes();
                    break;
                case "9":
                    menuPrincipal.menu();
                    break;
                default:
                    System.out.println("+---------------------------+");
                    System.out.println("|      Opção inválida       |");
                    menuCadastroDeCliente();
                    break;
            }
        } while (op == "9");
    }

    public static void cadastrarCliente() {
        String nomeCliente, sobrenomeCliente, ruaDoCliente, cidadeCliente, bairroCliente;

        //DATA DE NASCIMENTO
        int diaNascimentoCliente, mesNascimentoCliente, anoNascimentoCliente, numCasaDoCliente;
        long cpfCliente, telefoneCliente; // long mais de 7 digitos

        System.out.println("+--------------------------+");
        System.out.println("|    Cadastrar Cliente     |");
        System.out.println("+--------------------------+");
        System.out.println("> Qual é o Nome do Cliente: ");
        nomeCliente = scanner.next();
        System.out.println("> Qual é o Sobrenome do Cliente: ");
        sobrenomeCliente = scanner.next();
        System.out.println("> Qual é o CPF do Cliente (Sem Pontuação): ");
        cpfCliente = scanner.nextLong();

        do {
            System.out.println("> Qual é o Dia de nascimento do Cliente: ");
            diaNascimentoCliente = scanner.nextInt();
        } while (diaNascimentoCliente >= 32);

        do {
            System.out.println("> Qual é o Mês de nascimento do Cliente: ");
            mesNascimentoCliente = scanner.nextInt();
        } while (mesNascimentoCliente >= 13);

        do {
            System.out.println("> Qual é o Ano de nascimento do Cliente: ");
            anoNascimentoCliente = scanner.nextInt();
        } while (anoNascimentoCliente > 2023);

        System.out.println("> Telefone do Cliente: ");
        telefoneCliente = scanner.nextLong();

        //DADO DE ENDERECO
        System.out.println("> Cidade do Cliente (Sem Espaço): ");
        cidadeCliente = scanner.next();

        System.out.println("> Bairro Cliente (Sem Espaço): ");
        bairroCliente = scanner.next();

        System.out.println("> Rua do Cliente (Sem Espaço): ");
        ruaDoCliente = scanner.next();

        System.out.println("> Número da casa do Cliente: ");
        numCasaDoCliente = scanner.nextInt();

        System.out.println("+-----------------------------------+");
        System.out.println("|      Conferindo Informações       |");

        int idadeCliente = (2023 - anoNascimentoCliente);

        if (idadeCliente < 18) {
            System.out.println("+-----------------------------------+");
            System.out.println("|    O Cliente não Possui 18 anos   |");
            testeDeAceitacao();
        } else {

            System.out.println("+-----------------------------------+");
            System.out.println("|   Ficha de Cadastro De Cliente    |");
            System.out.println("+-----------------------------------+");
            System.out.println("| > Nome: " + nomeCliente + " " + sobrenomeCliente);
            System.out.println("| > CPF: " + cpfCliente);
            System.out.println("| > Data de Nascimento: " + diaNascimentoCliente + "/" + mesNascimentoCliente + "/" + anoNascimentoCliente);
            System.out.println("| > Idade: " + idadeCliente);
            System.out.println("+-----------------------------------+");
            System.out.println("| > Cidade: " + cidadeCliente);
            System.out.println("| > Bairro: " + bairroCliente);
            System.out.println("| > Endereço: " + ruaDoCliente + ", Número: " + numCasaDoCliente);
            System.out.println("+-----------------------------------+");
            System.out.println("| > Telefone | Celular: " + telefoneCliente);
            System.out.println("+-----------------------------------+");

            String refazerCadastro;
            boolean controleDeCadastro;

            System.out.println("+-----------------------------------+");
            System.out.println("|    Deseja Refazer o cadastro ?    |");
            System.out.println("|      (S) para Sim e (N) não       |");
            refazerCadastro = scanner.next();
            controleDeCadastro = !refazerCadastro.equalsIgnoreCase("S") && !refazerCadastro.equalsIgnoreCase("N");
            do {
                if (controleDeCadastro) {
                    System.out.println("+-----------------------------------+");
                    System.out.println("|         Opção Inválida            |");
                    System.out.println("+-----------------------------------+");
                } else if (refazerCadastro.equalsIgnoreCase("S")) {
                    cadastrarCliente();
                } else if (refazerCadastro.equalsIgnoreCase("N")) {
                    clientes.add(nomeCliente + sobrenomeCliente);
                    System.out.println("+-----------------------------------+");
                    System.out.println("|         Cliente Cadastrado        |");
                    System.out.println("+-----------------------------------+");
                    menuCadastroDeCliente();
                }
            } while (controleDeCadastro);
        }
    }

    public static void testeDeAceitacao() {
        String refazerCadastro;
        boolean controleDeCadastro;

        System.out.println("+-----------------------------------+");
        System.out.println("|    Deseja Refazer o cadastro ?    |");
        System.out.println("|      (S) para Sim e (N) não       |");
        refazerCadastro = scanner.next();
        controleDeCadastro = !refazerCadastro.equalsIgnoreCase("S") && !refazerCadastro.equalsIgnoreCase("N");
        do {
            if (controleDeCadastro) {
                System.out.println("+-----------------------------------+");
                System.out.println("|           Opção Inválida          |");
                System.out.println("+-----------------------------------+");
            } else if (refazerCadastro.equalsIgnoreCase("S")) {
                cadastrarCliente();
            } else if (refazerCadastro.equalsIgnoreCase("N")) {
                menuCadastroDeCliente();
            }
        } while (controleDeCadastro);
    }

    public static void testeDeAceitacao2() {
        String refazerCadastro;
        boolean controleDeCadastro;

        System.out.println("+-----------------------------------+");
        System.out.println("|       Deseja Voltar ao menu ?     |");
        System.out.println("|      (S) para Sim e (N) não       |");
        refazerCadastro = scanner.next();
        controleDeCadastro = !refazerCadastro.equalsIgnoreCase("S") && !refazerCadastro.equalsIgnoreCase("N");

        do {
            if (controleDeCadastro) {
                System.out.println("+-----------------------------------+");
                System.out.println("|         Opção Inválida            |");
                System.out.println("+-----------------------------------+");
            } else if (refazerCadastro.equalsIgnoreCase("S")) {
                menuCadastroDeCliente();
            } else if (refazerCadastro.equalsIgnoreCase("N")) {
                verificarClientes();
            }
        } while (controleDeCadastro);

    }

    public static void verificarClientes() {
        System.out.println("+----------------------------------+");
        System.out.println("|         Verificar Clientes       |");
        System.out.println("+----------------------------------+");
        if (clientes.size() == 1) {
            System.out.println("| A empresa Possui 1 Cliente |");
        } else {
            System.out.println("| A empresa possui: " + clientes.size() + " Clientes ");
        }
        System.out.println("+----------------------------------+");
        System.out.println("| O Cliente mais novo é " + clientes.peek());
        System.out.println("+----------------------------------+");
        System.out.println("| Estes são todos os clientes: ");

        for (String client : clientes) {
            System.out.println(" " + client);
        }

        testeDeAceitacao2();
    }
}