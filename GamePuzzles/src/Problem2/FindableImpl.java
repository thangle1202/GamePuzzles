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
public class FindableImpl implements Findable{

    @Override
    public Point findFatherPoint(int currentPosition, Point currentFatherPoint, ArrayList<Point> listChildPoints, ArrayList<Point> listFatherPoints) {
        Checkable checker=new CheckableImpl();
          for (int i = currentPosition; i >=0; i--) {
                if (checker.isSamePoint(listChildPoints.get(i), currentFatherPoint)) {
                    FindTheRoad.pos=i;
                    return listFatherPoints.get(i);
                }
        }
        return null;
    }
    
}
