/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;

/**
 *
 * @author lethang
 */
public class BishopDAOIplm implements BishopDAO{

    @Override
    public boolean checkMovement(Bishop bishopBegin, Bishop bishopEnd) {
        int x=Math.abs(bishopBegin.getX()-bishopEnd.getX());
        int y=Math.abs(bishopBegin.getY()-bishopEnd.getY());

        if (x==y) {
            return true;
        }
        return false;
    }

    public void convertCoordinate(Bishop bishop) {
        String coordinate=bishop.getCoordinate();
        char x=coordinate.charAt(0); //implicit convert x to (int) Vd: 'a'->97
        int y=Integer.parseInt(coordinate.substring(1));
        
        bishop.setX(x);
        bishop.setY(y);
    }
    
}
