/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problem1;

import java.util.Scanner;

/**
 *
 * @author lethang
 */
public class ExecuteProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String start;
        String finish;
        
        start=scanner.nextLine();
        Bishop bishopBegin=new Bishop(start);

        finish=scanner.nextLine();
        System.out.println("Type 00 to exit!");
        while(!finish.equals("00")){
            
            Bishop bishopEnd=new Bishop(finish);
            BishopDAOIplm bishopDAO= new BishopDAOIplm();

            boolean result= bishopDAO.checkMovement(bishopBegin, bishopEnd);

            System.out.println(result);
            finish=scanner.nextLine();
        }
    }
}
