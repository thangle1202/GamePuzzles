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
public class ConvertableImpl implements Convertable{

    @Override
    public String convertPointToString(Point point) {
        char y=(char) (point.getY()+96);
        String result=String.valueOf(y);
        result=result.concat(String.valueOf(point.getX()));
        return result;
    }
    
}
