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
public class State {
    private boolean stateOfX;
    private boolean stateOfY;
    private static State currentState=null;

    private State() {
        stateOfX=false;
        stateOfY=false;
    }
    
    public static State getInstance(){
        if (currentState==null) {
            currentState=new State();
            return currentState;
        }
        else return currentState;
    }
    
    public boolean isStateOfX() {
        return stateOfX;
    }

    public void setStateOfX(boolean stateOfX) {
        this.stateOfX = stateOfX;
    }

    public boolean isStateOfY() {
        return stateOfY;
    }

    public void setStateOfY(boolean stateOfY) {
        this.stateOfY = stateOfY;
    }
    
    
}
