public class GameField {
    public static String field(String[] pos, String playerOne, String playerTwo) {

        String[] line = new String[18]; // ЗАПОЛНЯЕМЫЕ ЛИНИИ
        for (int i = 0; i < 18; i++) {
            line[i] = "   ";
        }
        String[] col = new String[18]; // ЗАПОЛНЯЕМЫЕ СТОЛБИКИ
        for (int i = 0; i < 18; i++) {
            col[i] = " ";
        }
        for (int i = 1; i <= 13; i += 6) { // (Исключения)
            col[i] = "_";
            col[i + 2] = "_";
        }
        String[] cross = new String[12]; // ЗАПОЛНЯЕМЫЕ ДИАГОНАЛИ
        for (int i = 0; i < 12; i++) {
            cross[i] = " ";
        }
        for (int i = 2; i <= 6; i += 4) { // (Исключения)
            cross[i] = "_";
            cross[i + 1] = "_";
        }
        cross[8] = " ";
        cross[9] = " ";

        String [] paint = paint(pos, playerOne, playerTwo);

        conditions(GameStatus.status(pos, playerOne),line,col,cross,paint);
        conditions(GameStatus.status(pos, playerTwo),line,col,cross,paint);

        return  "\n" +cross[0] + "  " + col[0] + "   |   " + col[6] + "   |   " + col[12] + "  " + cross[1] + "  \n" +
                line[0] + pos[0] + line[1] + "|" + line[2] + pos[1] + line[3] + "|" + line[4] + pos[2] + line[5] + "\n" +
                "___" + col[1] + "__" + cross[2] + "|___" + col[7] + "___|" + cross[3] + "__" + col[13] + "___" + "\n" +
                "   " + col[2] + "   |" + cross[4] + "  " + col[8] + "  " + cross[5] + "|   " + col[14] + "\n" +
                line[6] + pos[3] + line[7] + "|" + line[8] + pos[4] + line[9] + "|" + line[10] + pos[5] + line[11] + "\n" +
                "___" + col[3] + "___|" + cross[6] + "__" + col[9] + "__" + cross[7] + "|___" + col[15] + "___" + "\n" +
                "   " + col[4] + "  " + cross[8] + "|   " + col[10] + "   |" + cross[9] + "  " + col[16] + "\n" +
                line[12] + pos[6] + line[13] + "|" + line[14] + pos[7] + line[15] + "|" + line[16] + pos[8] + line[17] + "\n" +
                cross[10] + "  " + col[5] + "   |   " + col[11] + "   |   " + col[17] + "  " + cross[11];
    } // Игровое поле
    private static void conditions (String condition, String [] line, String [] col, String [] cross, String [] paint) {

        String lineColored = paint[0];
        String colColored = paint[1];
        String crossColored = paint [2];

        switch (condition) {
            case "WinLine1":
                for (int i = 0; i < 6; i++) {
                    line[i] = lineColored;
                }
                break;
            case "WinLine2":
                for (int i = 6; i < 12; i++) {
                    line[i] = lineColored;
                }
                break;
            case "WinLine3":
                for (int i = 12; i < 18; i++) {
                    line[i] = lineColored;
                }
                break;
            case "WinColumn1":
                for (int i = 0; i < 6; i++) {
                    col[i] = colColored;
                }
                break;
            case "WinColumn2":
                for (int i = 6; i < 12; i++) {
                    col[i] = colColored;
                }
                break;
            case "WinColumn3":
                for (int i = 12; i < 18; i++) {
                    col[i] = colColored;
                }
                break;
            case "WinCross1" :
                for (int i = 0; i < 12; i += 7) { // 0 7
                    for (int j = 0; j < 5; j += 2) {
                        cross[(i + j)] = crossColored;
                    }
                }
                break;
            case "WinCross2" :
                for (int i = 1; i < 7; i += 5) {
                    for (int j = 0; j < 5; j += 2) {
                        cross[(i + j)] = crossColored;
                    }
                }
                break;
        }
    } // Условия для поля
    private static String [] paint (String [] pos, String playerOne, String playerTwo) {

        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        String [] paint = new String[3];

        if ((!(GameStatus.winStatus(pos, playerOne).isEmpty())) && playerOne.equals(ANSI_RED + "X" + ANSI_RESET)) {
            paint[0] = ANSI_RED + "---" + ANSI_RESET;
            paint[1] = ANSI_RED + "|" + ANSI_RESET;
            paint[2] = ANSI_RED + "x" + ANSI_RESET;
        } else if ((!(GameStatus.winStatus(pos, playerOne).isEmpty())) && playerOne.equals(ANSI_BLUE + "O" + ANSI_RESET)) {
            paint[0] = ANSI_BLUE + "---" + ANSI_RESET;
            paint[1] = ANSI_BLUE + "|" + ANSI_RESET;
            paint[2] = ANSI_BLUE + "x" + ANSI_RESET;
        } else if ((!(GameStatus.winStatus(pos, playerTwo).isEmpty())) && playerTwo.equals(ANSI_RED + "X" + ANSI_RESET)) {
            paint[0] = ANSI_RED + "---" + ANSI_RESET;
            paint[1] = ANSI_RED + "|" + ANSI_RESET;
            paint[2] = ANSI_RED + "x" + ANSI_RESET;
        } else if ((!(GameStatus.winStatus(pos, playerTwo).isEmpty())) && playerTwo.equals(ANSI_BLUE + "O" + ANSI_RESET)) {
            paint[0] = ANSI_BLUE + "---" + ANSI_RESET;
            paint[1] = ANSI_BLUE + "|" + ANSI_RESET;
            paint[2] = ANSI_BLUE + "x" + ANSI_RESET;
        }
        return paint;
    } // Какого цвета зачёркивания
}