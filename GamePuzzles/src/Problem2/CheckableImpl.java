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
public class CheckableImpl implements Checkable{

    @Override
    public boolean isSamePoint(Point p1, Point p2) {
        if (p1.getX()==p2.getX() && p1.getY()==p2.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinishPoint(Point firstPoint, Point secondPoint) {
        if (firstPoint.getX()==secondPoint.getX() && firstPoint.getY()==secondPoint.getY()) {
                    return true;
                }
                return false;
    }

    @Override
    public boolean isVisitedPoint(Point point, ArrayList<Point> listPoint) {
       for (int i = 0; i < listPoint.size(); i++) {
            Point p= listPoint.get(i);
            if (p.getX()==point.getX() && p.getY()==point.getY()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int isStopPoint(ArrayList<Point> listChildPoints, Point finishPoint) {
        Checkable checker=new CheckableImpl();
        for (int i = 0; i < listChildPoints.size(); i++) {
            if (checker.isSamePoint(finishPoint, listChildPoints.get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isRedundantPoint(int index, ArrayList<Integer> arrayIndex) {
        for (int i = 0; i < arrayIndex.size(); i++) {
            if (index==arrayIndex.get(i)) {
                return true;
            }
        }
        return false;
    }


    
    
}
