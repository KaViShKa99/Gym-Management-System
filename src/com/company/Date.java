package com.company;

import java.util.Scanner;

public class Date {

        public static Scanner integer_input = new Scanner(System.in);//craeted the integer_input object from Scanner class
        public static String date;


    public Date(String date){//date class constructor

        while (!dateCheck(date)) {//starting while loop
            System.out.println("\t\tDate is not valid..!");
            System.out.println("!!.......try again........!!!");
            System.out.print("\t\t*Enter date:-");
            date = integer_input.nextLine();

        }
        this.date=date;
    }


    public  boolean dateCheck(String date){
        if (!date.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)")) {//it is date check method,leap year  and wrong date check special code
            return false;
        }
        return true;

    }

    @Override
    public String toString() {//created the toString method
        return date;
    }
}
