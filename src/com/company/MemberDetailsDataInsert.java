package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MemberDetailsDataInsert {

    public static ArrayList<DefaultMember> members;//created the instance variable whose name is member

    // ***Returns an observable list of DefaultMember***//
    public static ObservableList<DefaultMember> getMembersDetailsList() {
        ArrayList list = new ArrayList();//created the Arraylist object

        for (int i = 0; i <members.size() ; i++) {//creaed the for loop that loops to the size of arraylist
            list.add(new DefaultMember(members.get(i).membershipNumber, members.get(i).name, members.get(i).startMembershipDate, members.get(i).type, members.get(i).schoolName, members.get(i).age));//The date taken from the arraylist was added to the inside arraylist list object

        }
        ObservableList membersData = (ObservableList) FXCollections.observableList(list);
        return membersData;//return the membersData of table row

    }
    // ***Returns Members Type TableColumn***//
    public static TableColumn<DefaultMember, Integer> getMembersTypeColumn() {//created the getMembersTypeColumn() method
        TableColumn<DefaultMember, Integer> MembersTypeColumnId = new TableColumn<>("Members Type");//created a  MembersTypeColumnId object from TableColumn class
        PropertyValueFactory<DefaultMember, Integer> MembersTypeIdCellValueFactory = new PropertyValueFactory<>("type");//create the MembersTypeIdCellValueFactory object from PropertyValueFactory class
        MembersTypeColumnId.setCellValueFactory(MembersTypeIdCellValueFactory);
        return MembersTypeColumnId;
    }

    // ***Returns Membership Number TableColumn***//
    public static TableColumn<DefaultMember, String> getMembershipNumberColumn() {//created the getMembershipNumberColumn() method
        TableColumn<DefaultMember, String> MembershipNumberColumn = new TableColumn<>("Membership Number");//created a  MembershipNumberColumn object from TableColumn class
        PropertyValueFactory<DefaultMember, String> MembershipNumberCellValueFactory = new PropertyValueFactory<>("membershipNumber");//create the MembershipNumberCellValueFactory object from PropertyValueFactory class
        MembershipNumberColumn.setCellValueFactory(MembershipNumberCellValueFactory);
        return MembershipNumberColumn;
    }

    // *****Returns Start Membership Date TableColumn****//
    public static TableColumn<DefaultMember, String> getStartMembershipDateColumn() {//created the getStartMembershipDateColumn() method
        TableColumn<DefaultMember, String> StartMembershipDateColumn = new TableColumn<>("Start Membership Date");//created a  StartMembershipDateColumn object from TableColumn class
        PropertyValueFactory<DefaultMember, String> StartMembershipDateColumnCellValueFactory = new PropertyValueFactory<>("startMembershipDate");//create the StartMembershipDateColumnCellValueFactory object from PropertyValueFactory class
        StartMembershipDateColumn.setCellValueFactory(StartMembershipDateColumnCellValueFactory);
        return StartMembershipDateColumn;
    }

    // ****Returns Name TableColumn****//
    public static TableColumn<DefaultMember, String> getNameColumn() {//created the getNameColumn() method
        TableColumn<DefaultMember, String> NameColumn = new TableColumn<>("Name");//created a  NameColumn object from TableColumn class
        PropertyValueFactory<DefaultMember, String> NameCellValueFactory = new PropertyValueFactory<>("name");//create the NameCellValueFactory object from PropertyValueFactory class
        NameColumn.setCellValueFactory(NameCellValueFactory);
        return NameColumn;
    }

    // ****Returns School Name TableColumn***//
    public static TableColumn<DefaultMember, String> getSchoolNameColumn() {//created the getSchoolNameColumn() method
        TableColumn<DefaultMember, String> SchoolNameColumn = new TableColumn<>("School Name");//created a  SchoolNameColumn object from TableColumn class
        PropertyValueFactory<DefaultMember, String> SchoolNameCellValueFactory = new PropertyValueFactory<>("schoolName");//create the SchoolNameCellValueFactory object from PropertyValueFactory class
        SchoolNameColumn.setCellValueFactory(SchoolNameCellValueFactory);
        return SchoolNameColumn;
    }

    //*** Returns Age TableColumn ***//
    public static TableColumn<DefaultMember, String> getAgeColumn() {//created the getAgeColumn() method
        TableColumn<DefaultMember, String> AgeColumn = new TableColumn<>("Age");//created a  AgeColumn object from TableColumn class
        PropertyValueFactory<DefaultMember, String> AgeCellValueFactory = new PropertyValueFactory<>("age");//create the AgeCellValueFactory object from PropertyValueFactory class
        AgeColumn.setCellValueFactory(AgeCellValueFactory);
        return AgeColumn;
    }
    public void Arraylistpass(ArrayList<DefaultMember> members){
        this.members=members;
    }//added the value to instance variable

}
