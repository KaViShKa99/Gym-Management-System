package com.company;
import javafx.application.Application;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class MyGymManager implements GymManager{//created the MyGymManager class

    public static  ArrayList<DefaultMember> members =new ArrayList<>();
    public static  Scanner integer_input = new Scanner(System.in);//created integer_input object from Scanner class
    public static  Scanner string_input = new Scanner(System.in);//created string_input object from Scanner class
    public static boolean start =true;
    public static boolean flag =true;
    public static boolean helpViewStart=true;
    public static int count =0;
    public static InputChecking inputChecking = new InputChecking();//created inputChecking object from InputChecking class
    public static MemberDetailsDataInsert memberDetailsDataInsert= new MemberDetailsDataInsert();//created memberDetailsDataInsert object from MemberDetailsDataInsert class
    public static Gui gui = new Gui();//created gui object from Gui class


    public  void helpView(String[] args){//created the helpView method

        while (helpViewStart){
            System.out.println("___________Instruction__________________________\n");
            System.out.println("*----------addNewMember--------------press-->(1)");
            System.out.println("*----------deleteMember--------------press-->(2)");
            System.out.println("*----------printListOfMembers--------press-->(3)");
            System.out.println("*----------sortItem------------------press-->(4)");
            System.out.println("*----------saveMembersDetails--------press-->(5)");
            System.out.println("*----------openGUI-------------------press-->(6)");
            System.out.println("*----------exit----------------------press-->(7)");

            System.out.print("Enter your choice:- ");
            String selected =inputChecking.integerInputCheck("Enter your choice:- ");

                    switch (selected){
                            case "1":
                                addNewMember();//call addNewMember()
                                break;
                            case "2":
                                deleteMember();//call deleteMember()
                                break;
                            case "3":
                                printListOfMembers();//call printListOfMembers()
                                break;
                            case "4":
                                sortItem();//call sortItem()
                                break;
                            case "5":
                                saveMembersDetails();//call saveMembersDetails()
                                break;
                            case "6":
                                openGUI(args);//call openGUI()
                                helpViewStart = false;
                                break;
                            case "7":
                                helpViewStart = false;
                                break;
            }
        }
    }
   public static void addNewMember() {//add new member method
       if (count<=100) {
           while (start) {
               flag = true;
               System.out.println("************************************************");
               System.out.println("\nPress" + "\n\t" + "1- to add DefaultMember" + "\n\t" + "2- to add StudentMember" + "\n\t" + "3- to add Over60Member");
               System.out.println("************************************************");
               System.out.print("Press number :-");
               String choice = inputChecking.integerInputCheck("Press number :-");

               System.out.println("----------------------" + "[" + count + "]" + "  members registered in the system " + "---------------------------");
               switch (choice) {
                   case "1":
                       addDefaultMemberDetails();//call the addDefaultMemberDetails()
                       break;

                   case "2":
                       addStudentMemberDetails();//call the addStudentMemberDetails()
                       break;

                   case "3":
                       addOver60MemberDetails();//call the addOver60MemberDetails()
                       break;
               }

               if (start) {
                       while (flag) {
                           String displayShow = "# Do you want to exit add member option (y/n) ?";
                           System.out.print(displayShow);
                           String check = inputChecking.stringInputCheck(displayShow);

                                       if (check.matches("y")) {
                                           flag = false;
                                           start = false;
                                           System.out.println("............................................................................................");

                                       } else if (check.matches("n")) {
                                           start = true;
                                           flag = false;

                                       } else {
                                           System.out.println("input is not valid");
                                           flag = true;
                                       }
                       }
               } else {
                   start = false;
               }

           }

       }else {
           System.out.println("no spaces available...!!");
       }

    }


   public  static void saveMembersDetails(){//save member details method
       if (members.size()>0) {//firstly check default class arraylist size.if size>0 then  the code is run inside the iffunction

                   JSONArray allMemberDetailsArray = new JSONArray();// created the jsonArray object
                   try
                   {
                       FileWriter fileWriter = new FileWriter("file.json");//created the FileWriter object,
                       for (int i = 0; i <members.size() ; i++) {//created the for loop that loop to the size of arraylist

                                   JSONObject memberDetail = new JSONObject();//created the JSONObject
                                   memberDetail.put("name", members.get(i).name);//added both variable name and name date form the array list put it in memberDetail object
                                   memberDetail.put("membershipNumber", members.get(i).membershipNumber);//added both variable name and membershipNumber date form the array list put it in memberDetail object
                                   memberDetail.put("startMembershipDate", members.get(i).startMembershipDate.date);//added both variable name and startMembershipDate date form the array list put it in memberDetail object
                                   memberDetail.put("schoolName", members.get(i).schoolName);//added both variable name and schoolName date form the array list put it in memberDetail object
                                   memberDetail.put("age", members.get(i).age);//added both variable name and age date form the array list put it in memberDetail object


                       allMemberDetailsArray.put((new JSONObject()).put(members.get(i).type, memberDetail));//added the memberDetails object to inside the allMemberDetailsArray
                               }
                       fileWriter.write(String.valueOf(allMemberDetailsArray));
                       fileWriter.flush();
                   } catch (IOException exception) {
                       exception.printStackTrace();
                   }
       }else {
           System.out.println("\t\tplease...add new member...!\n");
       }

   }

   public static void deleteMember(){

       if (members.size()>0) {

                       System.out.print("Please give a membership number :");
                       String inputMembershipNumber = integer_input.nextLine();

                           for (int j = 0; j < members.size(); j++) {//created the for loop that loop to the size of arraylist
                               if (inputMembershipNumber == members.get(j).membershipNumber) {
                                   System.out.println("*******************************************************************************");
                                   System.out.println("Membership number"+"["+members.get(j).membershipNumber+"] ,"+members.get(j).name + "   data has been deleted from the " + members.get(j).type + " database !");
                                   System.out.println("*******************************************************************************");
                                   members.remove(j);
                                   count-=1;

                               }else {
                                   System.out.println("Membership number is not found...!");
                               }
           }
       }else {
           System.out.println("\t\tplease...add new member...!\n");
       }
   }

   public static void sortItem(){

               if (members.size()>0) {
                           Comparator<DefaultMember> compareByMembersName = Comparator.comparing(e -> e.name);
                           Collections.sort(members,compareByMembersName);//sort names

                           System.out.println("*******************************************************************************");

                                   for (DefaultMember member : members) {//created the for loop that loop to the size of arraylist
                                       System.out.println(member.type+"  "+member.name+"  "+member.startMembershipDate+"  "+member.membershipNumber+"  "+member.schoolName+"  "+member.age);
                                   }
                           System.out.println("*******************************************************************************");
               }else {
                           System.out.println("\t\tplease...add new member...!\n");
               }
       }

    public static void printListOfMembers(){//print the list of members method

        if (members.size()>0) {
                    System.out.println("*******************************************************************************");
                    System.out.println("Members Type||"+"\tMembership Number\t|"+"\tStart Membership Date\t|"+"\tName\t|"+"\tSchool Name\t|"+"\tAge\t|");
                    System.out.println("-------------------------------------------------------------------------------");

                            for (int k = 0; k <members.size() ; k++) {
                                System.out.println("\t"+members.get(k).type+"\t||"+"\t"+members.get(k).membershipNumber+"\t||"+"\t"+members.get(k).startMembershipDate+"\t||"+"\t"+members.get(k).name+"\t||"+"\t"+members.get(k).schoolName+"\t||"+"\t"+members.get(k).age+"\t||");
                                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            }
                    System.out.println("*******************************************************************************");
        }else {
            System.out.println("\t\tplease...add new member...!\n");
        }
    }

    public static  void openGUI(String[] args) {//open gui application method
        if (members.size()>0) {
                memberDetailsDataInsert.Arraylistpass(members);
                gui.ArraylistpassGui(members);
                Application.launch(Gui.class, args);
        }else {
            System.out.println("\t\tplease...add new member...!\n");
        }
    }

    public static void addDefaultMemberDetails(){//add Default Member Details method
        if (count <= 100) {
                        System.out.print("* Enter DefaultMember Membership Number :");
                            String checkmembershipNumber = inputMembershipNumber("* Enter DefaultMember Membership Number :");
                        System.out.print("* Enter DefaultMember Name :");
                            String name = inputChecking.stringInputCheck("* Enter DefaultMember Name :");
                        System.out.print("* Enter DefaultMember StartMembership Date (dd/mm/yyyy)  :");
                            Date startMembershipDate = inputStartMembershipDate();

                        members.add(new DefaultMember(checkmembershipNumber, name, startMembershipDate, "defaultmember", "None", "None"));

                        System.out.println("###########################################################################################################################");
                        count += 1;
        } else {
                        System.out.println("No spaces available...!!");
                        start = false;
        }
    }

    public static void addStudentMemberDetails(){//add Student Member Details method
        if (count <= 100) {
                        System.out.print("* Enter StudentMember Membership Number :");
                            String studentCheckmembershipNumber = inputMembershipNumber("* Enter StudentMember Membership Number :");
                        System.out.print("* Enter StudentMember Name :");
                            String studentMemberName = inputChecking.stringInputCheck("* Enter StudentMember Name :");
                        System.out.print("* Enter StudentMember StartMembership Date (dd/mm/yyyy)  :");
                            Date studentStartMembershipDate = inputStartMembershipDate();
                        System.out.print("* Enter StudentMember SchoolName :");
                            String studentMemberSchoolName = inputChecking.stringInputCheck("* Enter StudentMember SchoolName :");

                        members.add(new StudentMember(studentCheckmembershipNumber, studentMemberName, studentStartMembershipDate, "studentmember", studentMemberSchoolName, "None"));

                        System.out.println("###########################################################################################################################");
                        count += 1;
        } else {
                        System.out.println("No spaces available...!!");
                        start = false;
        }
    }

    public static void addOver60MemberDetails(){//add Over60Member Details method
        if (count <= 100) {
                        System.out.print("* Enter Over60Member Membership Number :");
                            String over60MemberCheckmembershipNumber = inputMembershipNumber("* Enter Over60Member Membership Number :");
                        System.out.print("* Enter Over60Member Name :");
                            String over60MemberstudentMemberName = inputChecking.stringInputCheck("* Enter Over60Member Name :");
                        System.out.print("* Enter Over60Member StartMembership Date (dd/mm/yyyy)  :");
                            Date over60MemberStartMembershipDate = inputStartMembershipDate();
                        System.out.print("* Enter Over60Member Age :");
                            String Over60MemberAge = inputChecking.integerInputCheck("* Enter Over60Member Age :");

                        members.add(new Over60Member(over60MemberCheckmembershipNumber, over60MemberstudentMemberName, over60MemberStartMembershipDate, "Over60Member", "None", Over60MemberAge));

                        System.out.println("###########################################################################################################################");
                        count += 1;
        } else {
                        System.out.println("No spaces available...!!");
                        start = false;
        }
    }

    public static String inputMembershipNumber(String message){//input Membership Number method
        String studentMembershipNumber = inputChecking.integerInputCheck(message);
        String studentCheckmembershipNumber = inputChecking.idCheck(studentMembershipNumber, members);
        return studentCheckmembershipNumber;
    }
    public static Date inputStartMembershipDate(){//input StartMembership Date method
        String date = string_input.nextLine();
        Date studentStartMembershipDate = new Date(date);
        return studentStartMembershipDate;
    }
}
