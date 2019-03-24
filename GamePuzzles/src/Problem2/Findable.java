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
public interface Findable {
    Point findFatherPoint(int currentPosition, Point currentFatherPoint,ArrayList<Point> listChildPoints, ArrayList<Point> listFatherPoints);
}
