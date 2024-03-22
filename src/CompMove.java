import java.util.Random;

public class CompMove { // ХОД КОМПЬЮТЕРА:
    public static int move(String[] pos, String player, String comp) {

        int positionSolutionInt = 4;

        positionSolutionInt = crossTactics(pos,comp,positionSolutionInt); // Тактика диагоналей
        positionSolutionInt = cleverMove(pos,comp,player,positionSolutionInt); // Тактика избегания невыгодных ходов
        positionSolutionInt = closeToWin(pos,player,positionSolutionInt); // Если игрок близок к победе
        positionSolutionInt = closeToWin(pos,comp,positionSolutionInt); // Если компьютер близок к победе

        while (true) {
            if ((pos[positionSolutionInt].equals(player)) || (pos[positionSolutionInt].equals(comp))) {
                Random random = new Random();
                positionSolutionInt = random.nextInt(9);
            } else {
                break;
            }
        } // Подстраховка последнего случая, чтобы ход однозначно состоялся:
        return positionSolutionInt;
    }
    private static int closeToWin (String [] pos,String verifable, int positionSolutionInt) {

        // ЛИНИИ:
        if ((pos[0].equals(verifable)) && (pos[1].equals(verifable) && (pos[2].equals("3")))) {
            positionSolutionInt = 2;
        } else if ((pos[2].equals(verifable)) && (pos[1].equals(verifable) && (pos[0].equals("1")))) {
            positionSolutionInt = 0;
        } else if ((pos[3].equals(verifable)) && (pos[4].equals(verifable) && (pos[5].equals("6")))) {
            positionSolutionInt = 5;
        } else if ((pos[5].equals(verifable)) && (pos[4].equals(verifable) && (pos[3].equals("4")))) {
            positionSolutionInt = 3;
        } else if ((pos[6].equals(verifable)) && (pos[7].equals(verifable) && (pos[8].equals("9")))) {
            positionSolutionInt = 8;
        } else if ((pos[8].equals(verifable)) && (pos[7].equals(verifable) && (pos[6].equals("7")))) {
            positionSolutionInt = 7;
        }
        // СТОЛБЦЫ:
        else if ((pos[0].equals(verifable)) && (pos[3].equals(verifable) && (pos[6].equals("7")))) {
            positionSolutionInt = 6;
        } else if ((pos[6].equals(verifable)) && (pos[3].equals(verifable) && (pos[0].equals("1")))) {
            positionSolutionInt = 0;
        } else if ((pos[1].equals(verifable)) && (pos[4].equals(verifable) && (pos[7].equals("8")))) {
            positionSolutionInt = 7;
        } else if ((pos[7].equals(verifable)) && (pos[4].equals(verifable) && (pos[1].equals("2")))) {
            positionSolutionInt = 1;
        } else if ((pos[2].equals(verifable)) && (pos[5].equals(verifable) && (pos[8].equals("9")))) {
            positionSolutionInt = 8;
        } else if ((pos[8].equals(verifable)) && (pos[5].equals(verifable) && (pos[2].equals("3")))) {
            positionSolutionInt = 5;
        }
        // ДИАГОНАЛИ:
        else if ((pos[0].equals(verifable)) && (pos[4].equals(verifable) && (pos[8].equals("9")))) {
            positionSolutionInt = 8;
        } else if ((pos[8].equals(verifable)) && (pos[4].equals(verifable) && (pos[0].equals("1")))) {
            positionSolutionInt = 0;
        } else if ((pos[2].equals(verifable)) && (pos[4].equals(verifable) && (pos[6].equals("7")))) {
            positionSolutionInt = 6;
        } else if ((pos[6].equals(verifable)) && (pos[4].equals(verifable) && (pos[2].equals("3")))) {
            positionSolutionInt = 2;
        }
        // ВНЕШНИЕ ЛИНИИ:
        else if ((pos[0].equals(verifable)) && (pos[2].equals(verifable) && (pos[1].equals("2")))) {
            positionSolutionInt = 1;
        } else if ((pos[2].equals(verifable)) && (pos[8].equals(verifable) && (pos[5].equals("6")))) {
            positionSolutionInt = 5;
        } else if ((pos[6].equals(verifable)) && (pos[8].equals(verifable) && (pos[7].equals("8")))) {
            positionSolutionInt = 7;
        } else if ((pos[0].equals(verifable)) && (pos[6].equals(verifable) && (pos[3].equals("4")))) {
            positionSolutionInt = 3;
        }
        return positionSolutionInt;

    } // БЛИЗОК ЛИ КТО-ТО К ПОБЕДЕ (I)
    private static int cleverMove (String [] pos, String comp, String player, int positionSolutionInt) { // ТАКТИКА ИЗБЕГАНИЯ НЕВЫГОДНЫХ ХОДОВ (II)

        boolean innerCheck1 = false;
        boolean innerCheck2 = false;
        boolean innerCheck3 = false;

        Random random = new Random();

        for (int i = 0; i < 7; i += 3) { // ЛИНИИ
            boolean check1 = (((pos[i].equals(comp)) && (pos[i + 1].equals(player))) || ((pos[i].equals(comp)) && (pos[i + 2].equals(player))) || ((pos[i + 1].equals(comp)) && (pos[i + 2].equals(player))));
            boolean check2 = (((pos[i + 1].equals(comp)) && (pos[i].equals(player))) || ((pos[i + 2].equals(comp)) && (pos[i].equals(player))) || ((pos[i + 2].equals(comp)) && (pos[i + 1].equals(player))));

            if (check1 || check2) {
                if (i == 0) {
                    int [] availablePos = {3,4,5,6,7,8};
                    positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
                    innerCheck1 = true;
                } if (i == 3) {
                    int [] availablePos = {0,1,2,6,7,8};
                    positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
                    innerCheck2 = true;
                } if (i == 6) {
                    int [] availablePos = {3,4,5,6,7,8};
                    positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
                    innerCheck3 = true;
                }
            }
            if (innerCheck1 && innerCheck2) {
                int [] availablePos = {6,7,8};
                positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
            } if (innerCheck1 && innerCheck3) {
                int [] availablePos = {3,4,5,};
                positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
            } if (innerCheck2 && innerCheck3) {
                int [] availablePos = {0,1,2};
                positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
            }
        } // ЛИНИИ
        for (int i = 0; i < 3; i += 1) { // СТОЛБЦЫ
            boolean check1 = (((pos[i].equals(comp)) && (pos[i + 3].equals(player))) || ((pos[i].equals(comp)) && (pos[i + 6].equals(player))) || ((pos[i + 3].equals(comp)) && (pos[i].equals(player))));
            boolean check2 = (((pos[i + 3].equals(comp)) && (pos[i].equals(player))) || ((pos[i + 6].equals(comp)) && (pos[i].equals(player))) || ((pos[i].equals(comp)) && (pos[i + 3].equals(player))));

            if (check1 || check2) {
                if (i == 0) {
                    int [] availablePos = {1,4,7,2,5,8};
                    positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
                    innerCheck1 = true;
                } if (i == 1) {
                    int [] availablePos = {0,3,6,2,5,8};
                    positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
                    innerCheck2 = true;
                } if (i == 2) {
                    int [] availablePos = {0,3,6,2,5,8};
                    positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
                    innerCheck3 = true;
                }
            }
            if (innerCheck1 && innerCheck2) {
                int [] availablePos = {2,5,8};
                positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
            } if (innerCheck1 && innerCheck3) {
                int [] availablePos = {1,4,7,};
                positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
            } if (innerCheck2 && innerCheck3) {
                int [] availablePos = {0,3,6};
                positionSolutionInt = availablePos[random.nextInt(availablePos.length)];
            }
        } // СТОЛБЦЫ

        return positionSolutionInt;
    }
    private static int crossTactics (String [] pos, String comp, int positionSolutionInt) {

        // От ноля:
        if ((pos[0].equals("1")) && (pos[8].equals("9")) && ((pos[2].equals("3")) || (pos[6].equals("7")))) {
            positionSolutionInt = 0;
        } if ((pos[0].equals(comp)) && (pos[8].equals("9")) && ((pos[2].equals("3")) || (pos[6].equals("7")))) {
            positionSolutionInt = 8;
        } if ((pos[0].equals(comp)) && (pos[8].equals(comp))) {
            if ((pos[2].equals("3"))) {
                positionSolutionInt = 2;
            } else if ((pos[6].equals("7"))) {
                positionSolutionInt = 6;
            }
        }
        // От двойки:
        if ((pos[2].equals("3")) && (pos[6].equals("7")) && ((pos[0].equals("1")) || (pos[8].equals("9")))) {
            positionSolutionInt = 2;
        } if ((pos[2].equals(comp)) && (pos[6].equals("7")) && ((pos[0].equals("1")) || (pos[8].equals("9")))) {
            positionSolutionInt = 6;
        } if ((pos[2].equals(comp)) && (pos[6].equals(comp))) {
            if ((pos[0].equals("1"))) {
                positionSolutionInt = 0;
            } else if ((pos[8].equals("9"))) {
                positionSolutionInt = 8;
            }
        }
        return positionSolutionInt;
    } // ТАКТИКА ДИАГОНАЛЕЙ (III)
}
