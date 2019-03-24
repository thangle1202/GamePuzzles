/*
 * To listFatherPointsnge this license header, choose License Headers in Project Properties.
 * To listFatherPointsnge this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lethang
 */
public class FindTheRoad {
    private  boolean a[][];
    private  Point finishP;
    private  Point startP;
    private  int arrOrdinate[]={1,1,-1,-1};
    private  int arrAbscissa[]={1,-1,-1,1};
    private  ArrayList<Point> listFatherPoints=new ArrayList();
    private  ArrayList<Point> listChildPoints=new ArrayList();
    private  ArrayList<Point> listPassedPoints=new ArrayList();
    private  ArrayList<Integer> listRedundantPoints =new ArrayList();
    private  ArrayList<Point> theRoad=new ArrayList();
    private  ArrayList<String> listPreventPointsString;
    private  Scanner scanner=new Scanner(System.in);
    private  Checkable checker= new CheckableImpl();
    private  Setupable setupChessBoard;
    private  Convertable converter;
    private  Findable finder;
    private  Queue<Point> listTravelledPoints;
    static int pos=0;
    private State state;

    public FindTheRoad() {
        init();
    }
    
    
    public void init(){
        String x=scanner.nextLine();
        String y=scanner.nextLine();
        startP=StringToCoordinate.convertToPoint(x);
        finishP=StringToCoordinate.convertToPoint(y);
        System.out.println("Số lượng quân cản: ");
        int count=scanner.nextInt();
        scanner.nextLine();
        listPreventPointsString=new ArrayList();
        while(count>0){
            String s=scanner.nextLine();
            listPreventPointsString.add(s);
            count--;
        }
        ArrayList<Point> listPreventPoints=StringToCoordinate.convertToListPoint(listPreventPointsString);
        finder=new FindableImpl();
        setupChessBoard=new SetupableImpl();
        a=setupChessBoard.chooseChessBoard(startP, listPreventPoints);
        listTravelledPoints=new LinkedList<>();
        converter=new ConvertableImpl();
    }
    
    public void travelChessBoard(){
        listTravelledPoints.add(startP);
        
        while(!listTravelledPoints.isEmpty()){
            
            Point headQueuePoint=listTravelledPoints.remove();
                listPassedPoints.add(headQueuePoint);
            if (checker.isFinishPoint(headQueuePoint,finishP)) {
                listPassedPoints.remove(headQueuePoint);
            }
            for (int i = 0; i < 4; i++) {
                Point temp=new Point(headQueuePoint.getX()+arrOrdinate[i],headQueuePoint.getY()+arrAbscissa[i]);

                if (a[temp.getX()][temp.getY()] && listTravelledPoints.contains(temp)==false && checker.isVisitedPoint(temp,listPassedPoints)==false) {
                    listTravelledPoints.add(temp);
                    listFatherPoints.add(headQueuePoint);
                    listChildPoints.add(temp);
                }
            }
        }
    }
    
    public boolean findTheRoad(){
        if (checker.isStopPoint(listChildPoints, finishP)==-1) {
            System.out.println("Can not find the way!");
            return false;
        }else{
            int positionStop=checker.isStopPoint(listChildPoints, finishP);
            if (isExistTheRoad(startP, positionStop, finishP)) {
                return true;
            }else{
                System.out.println("Can not find the way!");
                return false;
            }
        }
    }
    
    public void printTheRoad(){
        if (findTheRoad()) {
            removeRedundantPoints();
            for (int i = theRoad.size()-1; i >=0 ; i--) {
                if (!checker.isRedundantPoint(i, listRedundantPoints)) {
                    System.out.print(converter.convertPointToString(theRoad.get(i)));
                    if (i!=0) {
                        System.out.print("=>");
                    }else{
                        System.out.println();
                    }
                }
                
            }
        }
    }
    
    public boolean isExistTheRoad(Point startPoint,int currentPosition, Point finishPoint ){
        theRoad.add(finishP);
        Point p=finder.findFatherPoint(currentPosition, finishPoint, listChildPoints, listFatherPoints);
        if (p==null) {
            return false;
        }else{
            theRoad.add(p);
            if (checker.isSamePoint(p, startPoint)) {
                theRoad.add(p);
            }else{
                do {                    
                    p=finder.findFatherPoint(pos, p, listChildPoints, listFatherPoints);
                    if (p==null) {
                        return false;
                    }
                    theRoad.add(p);
                } while (!checker.isSamePoint(p, startPoint));
            }
        }
        return true;
    }
    

    
    public void getCurrentState(){
        boolean stateX;
        boolean stateY;
        
        Point p0=theRoad.get(0);
        Point p1=theRoad.get(1);
        
        if ((p1.getX()-p0.getX()) <0 ) {
            stateX=false;
        }else{
            stateX=true;
        }
        
        if ((p1.getY()-p0.getY()) <0) {
            stateY=false;
        }else{
            stateY=true;
        }
        
        state.getInstance().setStateOfX(stateX);
        state.getInstance().setStateOfY(stateY);
    }
    
    public void removeRedundantPoints(){
        Point currentPoint= theRoad.get(0);
        if (currentPoint==null) {
            return;
        }
        for (int i = 1; i < theRoad.size(); i++) {
            if(checker.isSamePoint(currentPoint, theRoad.get(i))){
                theRoad.remove(i);
                break;
            }
            currentPoint=theRoad.get(i);
        }
        Point nowPoint;
        getCurrentState();
        for (int i = 1; i < theRoad.size()-1; i++) {
            nowPoint= theRoad.get(i);
            boolean stateX;
            boolean stateY;
            int x=theRoad.get(i+1).getX()-nowPoint.getX();
            int y=theRoad.get(i+1).getY()-nowPoint.getY();
            
            if (x<0) {
                stateX=false;
            }else{
                stateX=true;
            }
            if (y<0) {
                stateY=false;
            }else{
                stateY=true;
            }
            
            if ((state.getInstance().isStateOfX()==stateX) && (state.getInstance().isStateOfY()==stateY ) ) {
                listRedundantPoints.add(i);
            }
            
            state.getInstance().setStateOfX(stateX);
            state.getInstance().setStateOfY(stateY);
        }
        

    }
    
}
