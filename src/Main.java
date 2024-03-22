import java.util.Scanner;

public class Main {

    public static void main(String[] args) { // ГЛАВНОЕ МЕНЮ:
        mainMenu:
        while (true) {
            System.out.println(Message.mainMenu);
            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "1": // 1. ИГРА С КОМПЬЮТЕРОМ.
                    do {
                        PlayWithComp.play();
                    } while (!(playAgain()));
                    break;
                case "2": // 2. ИГРА С ДРУГОМ.
                    do {
                        PlayWithFriend.play();
                    } while (!(playAgain()));
                    break;
                case "3": // 3. ПРАВИЛА.
                    System.out.println(Message.rules);
                    break;
                case "4": // 4. ВЫХОД.
                    System.out.println(Message.byeBye);
                    break mainMenu;
                default: // ОШИБКА ВВОДА
                    System.out.println(Message.mainMenuError);
                    break;
            }
        }
    }
    private static boolean playAgain() {

        boolean playAgain = false;

        System.out.println(Message.playAgain);
        Scanner scanner = new Scanner(System.in);
        String menuSolution = scanner.next();

        while (true) {
            if (menuSolution.equals("1")) {
                break;
            } else if (menuSolution.equals("2")) {
                playAgain = true;
                break;
            } else {
                System.out.println(Message.playAgainError);
                menuSolution = scanner.next();
            }
        }
        return playAgain;
    } // СЫГРАТЬ СНОВА?
    public static void whoWins (String [] pos, String playerOne, String playerTwo, String gameType, String playerOneName, String playerTwoName) {

        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(GameField.field(pos, playerTwo, playerOne));
        if (GameStatus.status(pos, playerOne).equals("Draw")) {
            System.out.println("\nНичья!");
        } else if (!(GameStatus.status(pos, playerOne).isEmpty())) { // Итог игры
            if (gameType.equals("WithComp")) {
                System.out.println("\nУра! Победа! Восславим небеса!");
            } else {
                System.out.println("\nПобедил игрок " + ANSI_RED + playerOneName + ANSI_RESET + "! Честь ему и слава!");
            }
        } else if (!(GameStatus.status(pos, playerTwo).isEmpty())) {
            if (gameType.equals("WithComp")) {
                System.out.println("\nО нет! Поражение =(");
            } else {
                System.out.println("\nПобедил игрок " + ANSI_BLUE + playerTwoName + ANSI_RESET + "! Честь ему и слава!");
            }
            System.out.println();
        }
    } // Кто победил?
}
