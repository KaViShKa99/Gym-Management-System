package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Gui extends Application {

    public static ArrayList<DefaultMember> members;
    public static Boolean flag=true;

            public static void main(String[] args) {
                launch(args);
            }// created the main method

            @SuppressWarnings("unchecked")
            @Override
            public void start(Stage stage)//created the start method
            {

                TableView<DefaultMember> membersDetailsTable = new TableView<>();// Created a TableView with a list of DefaultMember
                membersDetailsTable.getItems().addAll( MemberDetailsDataInsert.getMembersDetailsList());// Add rows to the TableView
                membersDetailsTable.getColumns().addAll(MemberDetailsDataInsert.getMembersTypeColumn(),// Add columns to the TableView
                        MemberDetailsDataInsert.getMembershipNumberColumn(),
                        MemberDetailsDataInsert.getStartMembershipDateColumn(),
                        MemberDetailsDataInsert.getNameColumn(),
                        MemberDetailsDataInsert.getSchoolNameColumn(),
                        MemberDetailsDataInsert.getAgeColumn());

                membersDetailsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);// Set the column resize policy to constrained resize policy
                membersDetailsTable.setPlaceholder(new Label("No visible columns and/or data exist."));// Set the Placeholder for an empty membersDetailsTable
                membersDetailsTable.setLayoutX(50);
                membersDetailsTable.setLayoutY(150);
                membersDetailsTable.setMinWidth(1100);
                membersDetailsTable.setMinHeight(500);

                Label topic =new Label(" Online gym management system ");// created the lable " Online gym management system "
                topic.setLayoutX(50);
                topic.setLayoutY(100);
                topic.setTextFill(Color.WHITE);// applied the white color for text color
                Font font = Font.font("", FontWeight.BOLD, 25);
                topic.setFont(font);

                Button search = new Button("Search");//created the button ,it is "Search"
                search.setLayoutX(50);
                search.setLayoutY(750);

                Button clear = new Button("clear");//created the button ,it is "clear"
                clear.setLayoutX(300);
                clear.setLayoutY(750);

                Label searchMememberData = new Label();//created the lable, it show the Memembers Data
                searchMememberData.setLayoutX(250);
                searchMememberData.setLayoutY(800);
                searchMememberData.setStyle("-fx-background-color: #ece889;-fx-background-radius: 20px");
                Font font1 = Font.font("", FontWeight.BOLD, 20);
                searchMememberData.setFont(font1);

                TextField membershipNumber = new TextField();
                membershipNumber.setLayoutX(120);
                membershipNumber.setLayoutY(750);
                membershipNumber.setPromptText("give a membership num");

                search.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)//created void handle method
                    {

                            if ((membershipNumber.getText()).isEmpty())
                                {

                                    Alert alert = new Alert(Alert.AlertType.NONE);// created the alert object from alert class
                                    alert.setAlertType(Alert.AlertType.ERROR);// set alert type,it is Alert.AlertType.ERROR
                                    alert.setContentText("please.....,give a membership number");//set ContentText,it is "please.....,give a membership number"
                                    alert.show();// show the dialog

                                }
                            else
                                {
                                    if ((membershipNumber.getText()).matches("[a-zA-Z ]+"))
                                        {
                                            Alert integerWrongAlert = new Alert(Alert.AlertType.NONE);// create the integerWrongAlert object from alert class
                                            integerWrongAlert.setAlertType(Alert.AlertType.ERROR);// set alert type,it is Alert.AlertType.ERROR
                                            integerWrongAlert.setContentText("Integer only...please");//set ContentText,it is "Integer only...please"
                                            integerWrongAlert.show(); // show the dialog
                                            membershipNumber.setText("");

                                        }
                                    else {
                                            for (int i = 0; i < members.size(); i++) {////created the for loop that loop to the size of arraylist

                                                if ((membershipNumber.getText()).matches(members.get(i).membershipNumber))  {// get the  membershipNumber from arraylist and membershipNumber.getText()) number

                                                    searchMememberData.setText(
                                                            "# Members Type -----> " +members.get(i).type+"\n"
                                                            +"* Membership Number -----> " +members.get(i).membershipNumber+"\n"
                                                            +"* Name -----> " +members.get(i).name+"\n"
                                                            +"* Start Membership Date -----> " +members.get(i).startMembershipDate+"\n"
                                                            +"* School Name -----> " +members.get(i).schoolName+"\n"
                                                            +"* Age -----> " +members.get(i).age+"\n");

                                                }
                                            }
                                        }
                                }

                        membershipNumber.setText("");
                        }
                });

                clear.setOnAction(new EventHandler<ActionEvent>() //Applied the setOnAction for button
                {
                    @Override
                    public void handle(ActionEvent event) {//created void handle method
                       membershipNumber.setText("");//after button click,Applied the " " for textfield
                       searchMememberData.setText("");//after button click,Applied the " " for memberDetails lable
                    }

            });

                Pane root = new Pane();// Created the Pane
                root.getChildren().addAll(membersDetailsTable,search,membershipNumber,clear,topic,searchMememberData);//add all search textfield,button and table
                root.setStyle("-fx-background-color: #4c67ac");//set the background colour
                Scene scene = new Scene(root,1200,1000); // Created the Scene
                stage.setScene(scene); // add the Scene to the Stage
                stage.setTitle("My Gym Manager database ");// set the Title of the Stage,it is "My Gym Manager database "
                stage.show();// display the Stage
            }

                public void ArraylistpassGui(ArrayList<DefaultMember> members)//this method parameters sending from MyGymManager class
                {
                    this.members=members;//assign the arraylist object
                }
        }





