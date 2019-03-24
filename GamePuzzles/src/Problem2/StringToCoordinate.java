/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lethang
 */
public class StringToCoordinate{
    public static Point convertToPoint(String coordinate){
        int x,y;
        
        char t=coordinate.charAt(0);//implicit convert x to (int) Vd: 'a'->97
        x=t-96;
        y=Integer.parseInt(coordinate.substring(1));
        
        return new Point(y,x);
    }
    public static ArrayList<Point> convertToListPoint(List<String> listStr){
        ArrayList<Point> listPoint=new ArrayList();
        for (int i = 0; i < listStr.size(); i++) {
            listPoint.add(convertToPoint(listStr.get(i)));
        }
        return listPoint;
    }

}
