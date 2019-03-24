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
public interface Setupable {
    boolean isBlackBishop(Point point);
    boolean[][] chooseChessBoard(Point point,ArrayList<Point> listPoint);
    boolean isFinish(Point currentPoint,Point endPoint);
}
