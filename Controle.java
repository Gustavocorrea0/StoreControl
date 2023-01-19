public class Controle {
    public static void limpaTela() {
        // não funciona pelo runner do intellij
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
