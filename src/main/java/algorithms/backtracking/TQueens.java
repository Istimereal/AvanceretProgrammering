package algorithms.backtracking;

import java.util.Arrays;

public class TQueens {

        static final int N = 35;

        static char[][] board = new char[N][N];

        static{
            for (int i = 0; i < N; i++) {
                Arrays.fill(board[i], '.');
            }

        }

        // Vi går ud fra, at vi starter med at placere dronning i række 0 og slutter i række N
        // Hvis vi forsøger at placere i række N skal der derfor printes og returneres.
        static boolean placeQueen(int row) {

            if (row == N) {
                printBoard();
                return true;
            }

            //if(found) return;


            int start = 0;

            if(row == 0)
            {
                start = 0 ;
            }

            for (int col = start; col < N; col++) {
                if (isSafe(row, col)) {

                    board[row][col] = 'Q';


                  if (placeQueen(row + 1)) {
                        return true;
                    }

                    placeQueen(row + 1);
                    board[row][col] = '.'; // backtrack, fjern dronningen
                }
            }
return false;
        }

        static boolean isSafe(int row, int col) {
            // Tjek kolonne og diagonaler (ikke rækker, da vi tager det række for række)
            // Vi behøver kun tjekke kolonner og diagonaler over denne række (i < row) da vi arbejder os nedad


            for (int i = 0; i < row; i++) {
                // Kolonnen
                if (board[i][col] == 'Q') return false;
                // Venstre diagonal opad
                if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') return false;
                // Højre diagonal opad
                if (col + (row - i) < N && board[i][col + (row - i)] == 'Q') return false;
            }
            return true;
        }

        static void printBoard() {
            for (char[] row : board) {
                System.out.println(new String(row));
            }
            System.out.println();
        }
}
