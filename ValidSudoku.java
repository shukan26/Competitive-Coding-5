//Time - O(81) -> O(1)
//Space -> O(1)
//LeetCode: https://leetcode.com/problems/valid-sudoku/

/**
 * Validates a partially filled 9x9 Sudoku board.
 * Uses a HashSet to track digits in rows, columns, and 3x3 sub-boxes for duplicates.
 * Returns true if the board is valid according to Sudoku rules.
 */

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hset = new HashSet<>();

        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                char currentChar = board[i][j];

                if(currentChar != '.') {
                    if ((hset.contains(currentChar + "R" + i)) ||
                        (hset.contains(currentChar + "C" + j)) ||
                        (hset.contains(currentChar + "B" + (i/3) + (j/3)))) {
                            return false;
                        }
                    hset.add(currentChar + "R" + i);
                    hset.add(currentChar + "C" + j);
                    hset.add(currentChar + "B" + (i/3) + (j/3));
                }
            }
        }
        return true;
    }
}


