import java.util.Scanner;

public class PlayWithComp {
    public static void play() {

        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        String[] pos = {"1", "2", "3", "4", "5", "6", "7", "8", "9",};

        String playerOne;
        String playerTwo;

        System.out.println(Message.crossesOrNulls);
        Scanner scanner = new Scanner(System.in);
        String menuSolution = scanner.next();

        // Выбор крестиков или ноликов и первый ход, если игрок выбрал крестики
        while (true) {
            if (menuSolution.equals("крестики")) {
                playerOne = ANSI_RED + "X" + ANSI_RESET;
                playerTwo = ANSI_BLUE + "O" + ANSI_RESET;
                System.out.println(GameField.field(pos, playerOne, playerTwo));
                pos[PlayerMove.move(pos, playerOne)] = playerOne;
                break;
            } else if (menuSolution.equals("нолики")) {
                playerOne = ANSI_BLUE + "O" + ANSI_RESET;
                playerTwo = ANSI_RED + "X" + ANSI_RESET;
                break;
            } else {
                System.out.println(Message.crossesOrNullsError);
                menuSolution = scanner.next();
            }
        }
        // Ход игры:
        while (GameStatus.status(pos, playerOne).isEmpty()) {
            if (GameStatus.status(pos, playerOne).isEmpty()) { // Ход компьютера
                pos[CompMove.move(pos, playerOne, playerTwo)] = playerTwo;
            } else {
                break; // Чтобы завершить цикл при победе
            }
            if (GameStatus.status(pos, playerTwo).isEmpty()) { // Ход игрока
                System.out.println(GameField.field(pos, playerOne, playerTwo));
                pos[PlayerMove.move(pos, playerOne)] = playerOne;
            } else {
                break; // Чтобы завершить цикл при победе
            }
        }
        Main.whoWins (pos, playerOne, playerTwo, "WithComp","","");
    }
}
