import java.util.Scanner;

public class Acesso {
    public static Scanner scanner = new Scanner(System.in);

    public static void testeDeSeguranca() {
        String senha;
        int tentativas = 3, contador = 1;

        System.out.println("+---------------------------+");
        System.out.println("| Acesso ao Sistema Da Loja |");

        while (contador < 3) {
            Controle.limpaTela();
            System.out.println("+---------------------------+");
            System.out.println("| > Digite a Senha: ");
            senha = scanner.next();

            if (senha.equals("Store2023")) {
                System.out.println("+---------------------------+");
                System.out.println("|     Acesso Permitido      |");
                menuPrincipal.menu();
            } else {
                if (tentativas == 0) {
                    System.out.println("+---------------------------------+");
                    System.out.println("|   Você Não tem mais tentativas  |");
                    System.out.println("|        Sistema Bloqueado        |");
                    System.out.println("+---------------------------------+");
                    System.exit(0);
                    break;
                } else {
                    System.out.println("+---------------------------+");
                    System.out.println("|      Senha Incorreta      | ");
                    System.out.println("+---------------------------+");
                    System.out.println("|  Restam " + (tentativas--) + " tentativa(s)!   |");
                }
            }
        }
    }
}
