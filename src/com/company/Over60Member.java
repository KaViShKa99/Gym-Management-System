package com.company;

public class Over60Member extends DefaultMember {

    String age;

    public Over60Member(String membershipNumber, String name, Date startMembershipDate,String type, String schoolName, String age) {

        super(membershipNumber, name, startMembershipDate,type,schoolName,String.valueOf(age));
        this.age = age;
    }

}
