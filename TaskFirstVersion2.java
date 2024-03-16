import java.util.Arrays;
import java.util.Scanner;

public class TaskFirstVersion2 {
    public static final char P = 'P';
    public static final char L = 'L';
    public static final char O = 'O';
    public static final char F = 'F';
    public static final char B = 'B';

    public static final char W = 'W';
    public static final char S = 'S';
    public static final char A = 'A';
    public static final char D = 'D';
    public static char[][][] flat = {
            {
                    {O, O, O, O, O, O},
                    {O, B, O, O, O, O},
                    {O, O, O, O, O, O},
                    {O, B, B, O, O, O},
                    {L, O, B, O, O, P}
            },

            {
                    {B, O, O, B, O, L},
                    {O, O, O, O, O, B},
                    {O, O, B, O, B, O},
                    {B, O, O, O, O, O},
                    {O, O, O, O, O, O}
            },

            {
                    {O, O, O, O, O, O},
                    {O, O, O, B, O, O},
                    {O, O, O, O, O, O},
                    {O, O, O, O, B, O},
                    {O, B, O, F, O, O}
            }

    };

    public static int floor;
    public static int row;
    public static int col;
    public static boolean flag = true;

    static public void printMatrixFloor(int floor) {
        for(int i = 0; i < flat[0].length; i++) {
            System.out.println(Arrays.toString(flat[floor][i]));
        }
        System.out.println();
    }

    static void searchPositions(char point) {
        for (int i = 0; i < flat.length; i++) {
            for (int j = 0; j < flat[i].length; j++) {
                for (int k = 0; k < flat[i][j].length; k++) {
                    if (flat[i][j][k] == point) {
                        floor = i;
                        row = j;
                        col = k;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        searchPositions(P);

        System.out.println("Карта лабиринта: ");
        for (int i = 0; i < flat.length; i++) {
            printMatrixFloor(i);
        }

        while (flag) {
            System.out.print("Введите куда будете ходить: ");
            String enter = scanner.nextLine().toUpperCase();

            switch (enter.charAt(0)) {
                case W: //вперед
                    if (row - 1 < 0 || flat[floor][row - 1][col] == B) {
                        System.out.println("Сюда нельзя!");
                        continue;
                    }

                    if (flat[floor][row - 1][col] == L) { // переход на следующий этаж, если точка L
                        flat[floor][row][col] = O;
                        floor++;
                        flat[floor][--row][col] = P;

                        System.out.println("Текущий этаж: " + (floor + 1));
                        printMatrixFloor(floor);
                        continue;
                    }

                    if (flat[floor][row - 1][col] == F) {
                        System.out.println("Вы добрались до финиша!!!");
                        flag = false;
                        continue;
                    }

                    flat[floor][row][col] = O;
                    flat[floor][--row][col] = P;

                    System.out.println("Текущий этаж: " + (floor + 1));
                    printMatrixFloor(floor);
                    continue;

                case S: //назад
                    if (flat[floor][row + 1][col] == B || row + 1 == flat[0].length) {
                        System.out.println("Сюда нельзя!");
                        continue;
                    }

                    if (flat[floor][row + 1][col] == L) { // переход на следующий этаж, если точка L
                        flat[floor][row][col] = O;
                        floor++;
                        flat[floor][++row][col] = P;

                        System.out.println("Текущий этаж: " + (floor + 1));
                        printMatrixFloor(floor);
                        continue;
                    }

                    if (flat[floor][row + 1][col] == F) {
                        System.out.println("Вы добрались до финиша!!!");
                        flag = false;
                        continue;
                    }

                    flat[floor][row][col] = O;
                    flat[floor][++row][col] = P;

                    System.out.println("Текущий этаж: " + (floor + 1));
                    printMatrixFloor(floor);
                    continue;

                case A: //налево
                    if (col - 1 < 0 || flat[floor][row][col - 1] == B) {
                        System.out.println("Сюда нельзя!");
                        continue;
                    }

                    if (flat[floor][row][col - 1] == L) { // переход на следующий этаж, если точка L
                        flat[floor][row][col] = O;
                        floor++;
                        flat[floor][row][--col] = P;

                        System.out.println("Текущий этаж: " + (floor + 1));
                        printMatrixFloor(floor);
                        continue;
                    }

                    if (flat[floor][row][col - 1] == F) {
                        System.out.println("Вы добрались до финиша!!!");
                        flag = false;
                        continue;
                    }

                    flat[floor][row][col] = O;
                    flat[floor][row][--col] = P;

                    System.out.println("Текущий этаж: " + (floor + 1));
                    printMatrixFloor(floor);
                    continue;

                case D: //направо
                    if (col + 1 == flat[0][0].length || flat[floor][row][col + 1] == B) {
                        System.out.println("Сюда нельзя!");
                        continue;
                    }

                    if (flat[floor][row][col + 1] == L) { // переход на следующий этаж, если точка L
                        flat[floor][row][col] = O;
                        floor++;
                        flat[floor][row][++col] = P;

                        System.out.println("Текущий этаж: " + (floor + 1));
                        printMatrixFloor(floor);
                        continue;
                    }

                    if (flat[floor][row][col + 1] == F) {
                        System.out.println("Вы добрались до финиша!!!");
                        flag = false;
                        continue;
                    }

                    flat[floor][row][col] = O;
                    flat[floor][row][++col] = P;

                    System.out.println("Текущий этаж: " + (floor + 1));
                    printMatrixFloor(floor);

                default:
                    System.out.println("Введенное значение некорректно! Попробуйте снова");
            }
        }
    }
}
