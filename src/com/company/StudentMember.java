package com.company;

public class StudentMember extends DefaultMember {
     String schoolName;

    public StudentMember(String membershipNumber, String name, Date startMembershipDate,String type, String schoolName, String age) {
        super(membershipNumber, name, startMembershipDate,type,schoolName,age);
        this.schoolName = schoolName;

    }

}
