/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

import java.util.ArrayList;

/**
 *
 * @author lethang
 */
public class SetupableImpl implements Setupable{

    @Override
    public boolean[][] chooseChessBoard(Point point,ArrayList<Point> listPoint) {
        boolean a[][]=new boolean[10][10];
        if (((point.getX()-point.getY())%2)==0) {
            a=ChessBoard.createBlackChessBoard();
        }else{
            a=ChessBoard.createWhiteChessBoard();
        }
        for (int i = 0; i < listPoint.size(); i++) {
            int x=listPoint.get(i).getX();
            int y=listPoint.get(i).getY();
            a[x][y]=false;
        }
        return a;
    }

    @Override
    public boolean isBlackBishop(Point point) {
        if ((point.getX()-point.getY())==0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinish(Point currentPoint, Point endPoint) {
        if (currentPoint.getX()==endPoint.getX() && currentPoint.getY()==endPoint.getY()) {
            return true;
        }
        return false;
    }
    
    
    
}
