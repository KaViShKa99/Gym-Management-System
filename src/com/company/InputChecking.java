package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class InputChecking {

    private String integerValue;
    private String stringValue;
    private String membershipNumber;
    public ArrayList<DefaultMember> members;
    public Scanner integer_input = new Scanner(System.in);
    public Scanner string_input = new Scanner(System.in);

    public String integerInputCheck(String DisplayShow){

        integerValue = integer_input.nextLine();//get the input value
        while (!testIntegerInput(integerValue)) {// input value sending from testintegerInput method
            System.out.println("\t\tIntegers only, please.");
            System.out.print(DisplayShow);
            integerValue = integer_input.nextLine();//if input value is not integer

        }
        return integerValue;
    }


    public static boolean testIntegerInput(String number){

        if (!number.matches("[a-zA-Z ]+")){//it is integer check method,a to z , A to Z and space check special code
            return true;
        }else {
            return false;
        }
    }


    public String stringInputCheck(String DisplayShow) {
        stringValue = string_input.nextLine();//get the input value
        while (!nameCheck(stringValue)) {// input value sending from nameCheck method
            System.out.println("\t\tString only, please.");
            System.out.print(DisplayShow);
            stringValue = string_input.nextLine();//if input value is not string
        }
        return stringValue;
    }


    public static boolean nameCheck(String name){
        if (!name.matches("[a-zA-Z ]+")) {//it is string check method,a to z , A to Z and space check special code
            return false;
        }
        return true;

    }


    public String idCheck(String membershipNumber, ArrayList<DefaultMember> members){
                if (members.size()>0) {
                    this.members =members;
                    checkDuplicateMembershipNumber(membershipNumber,members);

                }else {
                    return this.membershipNumber = membershipNumber;
                }

                return this.membershipNumber;
            }



    public  void checkDuplicateMembershipNumber(String membershipNumber, ArrayList<DefaultMember> members){
        for (int j = 0; j <members.size() ; j++){//creaed the for loop that loops to the size of arraylist

            String gettingPreviousMembershipmembers=members.get(j).membershipNumber;

                if (testDuplicateMembershipNumber(membershipNumber,gettingPreviousMembershipmembers)) {

                    System.out.println("\t\t***The Id number exists***\n\t\t!!****** try again ******!!");
                    System.out.print("\t*Enter MembershipNumber :");
                    integerValue =integerInputCheck("\t*Enter MembershipNumber :");

                    inputDuplicateMembershipNumberCheck(members);

                    this.membershipNumber = integerValue;
                } else {
                    this.membershipNumber = membershipNumber;
                }
        }

    }


    public void inputDuplicateMembershipNumberCheck( ArrayList<DefaultMember> members){
        for (int i = 0; i <members.size() ; i++) {

            while (integerValue.matches(members.get(i).membershipNumber )) {
                System.out.println("\t!!****** try again ******!!");
                System.out.print("\t*Enter MembershipNumber :");
                integerValue = integerInputCheck("\t*Enter MembershipNumber :");
            }
        }
    }


    public static boolean testDuplicateMembershipNumber(String membershipNumber,String gettingPreviousMembershipmembers){
            if (membershipNumber.matches(gettingPreviousMembershipmembers)){
                return true;
            }
        return false;
    }

}
