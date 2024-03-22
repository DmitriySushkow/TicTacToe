import java.util.Scanner;

public class PlayerMove { // Ход игрока
    public static int move (String [] pos, String player) { // ХОД ИГРОКА.

        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        int positionSolutionInt;

        System.out.println("\nВыбери поле, в которое поставишь " + player + " и введи его номер в консоль:\n");

        while(true) {
            Scanner scanner = new Scanner(System.in);
            String positionSolution = scanner.next();
            positionSolutionInt = Integer.parseInt(positionSolution);

            boolean isInputCorrect1 = (positionSolution.equals("1")) || (positionSolution.equals("2")) ||(positionSolution.equals("3"));
            boolean isInputCorrect2 = (positionSolution.equals("4")) || (positionSolution.equals("5")) ||(positionSolution.equals("6"));
            boolean isInputCorrect3 = (positionSolution.equals("7")) || (positionSolution.equals("8")) ||(positionSolution.equals("9"));
            boolean isInputCorrect = (isInputCorrect1) || (isInputCorrect2) || (isInputCorrect3);

            if (!(isInputCorrect)) {
                System.out.println("\nТакой команды нет. Введи число от 1 до 9, соответствующее выбранной тобой позиции.\n");
            } else if ((pos[positionSolutionInt - 1].equals(ANSI_RED + "X" + ANSI_RESET)) || (pos[positionSolutionInt - 1].equals(ANSI_BLUE + "O" + ANSI_RESET))) {
                System.out.println("\nЭто поле уже занято! Выбери другое свободное поле!\n");
            } else {
                break;
            }
        }
        return (positionSolutionInt) - 1;
    }
}
