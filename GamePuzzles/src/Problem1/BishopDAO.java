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
public interface BishopDAO {
    boolean checkMovement(Bishop bishopBegin, Bishop bishopEnd);
    void convertCoordinate(Bishop bishop);
}
