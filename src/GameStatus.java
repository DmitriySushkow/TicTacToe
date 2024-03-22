public class GameStatus {
    public static String status(String[] pos, String player) {

        String gameStatus;

        if (drawConditions(pos)) { // Проверка на ничью
            gameStatus = "Draw";
        } else if (!(winStatus(pos, player).isEmpty())) { // Проверка победил ли игрок
            gameStatus = winStatus(pos, player); // Как именно победил (для поля)
        }  else {
            gameStatus = ""; // Игра продолжается
        }
        return gameStatus;
    }
    public static String winStatus(String[] pos, String verifable) {

        String gameStatus;

        boolean WinLine1 = (pos[0].equals(verifable)) && (pos[1].equals(verifable)) && (pos[2].equals(verifable));
        boolean WinLine2 = (pos[3].equals(verifable)) && (pos[4].equals(verifable)) && (pos[5].equals(verifable));
        boolean WinLine3 = (pos[6].equals(verifable)) && (pos[7].equals(verifable)) && (pos[8].equals(verifable));

        boolean WinColumn1 = (pos[0].equals(verifable)) && (pos[3].equals(verifable)) && (pos[6].equals(verifable));
        boolean WinColumn2 = (pos[1].equals(verifable)) && (pos[4].equals(verifable)) && (pos[7].equals(verifable));
        boolean WinColumn3 = (pos[2].equals(verifable)) && (pos[5].equals(verifable)) && (pos[8].equals(verifable));

        boolean WinCross1 = (pos[0].equals(verifable)) && (pos[4].equals(verifable)) && (pos[8].equals(verifable));
        boolean WinCross2 = (pos[2].equals(verifable)) && (pos[4].equals(verifable)) && (pos[6].equals(verifable));

        if (WinLine1) {
            gameStatus = "WinLine1";
        } else if (WinLine2) {
            gameStatus = "WinLine2";
        } else if (WinLine3) {
            gameStatus = "WinLine3";
        } else if (WinColumn1) {
            gameStatus = "WinColumn1";
        } else if (WinColumn2) {
            gameStatus = "WinColumn2";
        } else if (WinColumn3) {
            gameStatus = "WinColumn3";
        } else if (WinCross1) {
            gameStatus = "WinCross1";
        } else if (WinCross2) {
            gameStatus = "WinCross2";
        } else {
            gameStatus = "";
        }
        return gameStatus;
    } // Как именно победил (для поля)
    private static boolean drawConditions(String[] pos) {

        boolean draw1 = (!(pos[0].equals("1")) && !(pos[1].equals("2")) && !(pos[2].equals("3")));
        boolean draw2 = (!(pos[3].equals("4")) && !(pos[4].equals("5")) && !(pos[5].equals("6")));
        boolean draw3 = (!(pos[6].equals("7")) && !(pos[7].equals("8")) && !(pos[8].equals("9")));

        return (draw1) && (draw2) && (draw3);
    } // Условия ничьи
}
