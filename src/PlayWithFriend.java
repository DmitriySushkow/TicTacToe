import java.util.Scanner;

public class PlayWithFriend {
    public static void play() {

        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        String [] pos = {"1","2","3","4","5","6","7","8","9",};

        String playerOne = ANSI_RED + "X" + ANSI_RESET;
        String playerTwo = ANSI_BLUE + "O" + ANSI_RESET;

        Scanner scanner = new Scanner(System.in);

        System.out.println(Message.playerOneName);
        String playerOneName = ANSI_RED + scanner.next() + ANSI_RESET;
        System.out.println(Message.playerTwoName);
        String playerTwoName = ANSI_BLUE + scanner.next() + ANSI_RESET;

        while (GameStatus.status(pos, playerOne).isEmpty()) { // Ход игры
            if (GameStatus.status(pos, playerTwo).isEmpty()) { // Ход первого игрока
                System.out.println(GameField.field(pos,playerOne,playerTwo));
                System.out.print("\nХодит " + playerOneName + ".");
                pos[PlayerMove.move(pos, playerOne)] = playerOne;
            } else {
                break; // Чтобы завершить цикл при победе
            }
            if (GameStatus.status(pos, playerOne).isEmpty()) { // Ход второго игрока
                System.out.println(GameField.field(pos,playerOne,playerTwo));
                System.out.print("\nХодит " + playerTwoName + ".");
                pos[PlayerMove.move(pos, playerTwo)] = playerTwo;
            } else {
                break; // Чтобы завершить цикл при победе
            }
        }
        Main.whoWins (pos, playerOne, playerTwo, "WithFriend",playerOneName,playerTwoName);
    }
}