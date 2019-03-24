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
public interface Checkable {
    boolean isSamePoint(Point firstPoint, Point secondPoint);
    boolean isFinishPoint(Point firstPoint, Point secondPoint);
    boolean isVisitedPoint(Point point, ArrayList<Point> listPoint);
    int isStopPoint(ArrayList<Point> listChildPoints, Point finishPoint);
    boolean isRedundantPoint(int index, ArrayList<Integer> arrayIndex);
}
