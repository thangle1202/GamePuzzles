/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

/**
 *
 * @author lethang
 */
public class ChessBoard {
    public static final boolean a[][]=new boolean[10][10];
    public static final boolean b[][]=new boolean[10][10];
    public static boolean[][] createBlackChessBoard(){
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if ((j-i)%2==0) {
                    a[i][j]=true;
                }
            }
        }
        return a;
    }
    public static boolean[][] createWhiteChessBoard(){
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if ((j-i)%2!=0) {
                    b[i][j]=true;
                }
            }
        }
        return b;
    }
}
