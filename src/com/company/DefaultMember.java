package com.company;

public class DefaultMember
{
     public String membershipNumber;
     public String name;
     public Date startMembershipDate;
     public String type;
     public String schoolName;
     public String age;

    public DefaultMember(String membershipNumber,String name,Date startMembershipDate,String type, String schoolName, String age) {
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.startMembershipDate = startMembershipDate;
        this.type = type;
        this.schoolName = schoolName;
        this.age = age;
    }
    public String getMembershipNumber() {//getmethod of MembershipNumber
        return membershipNumber;//return the value of membershipNumber
    }

    public void setMembershipNumber(String membershipNumber) {//setmethod of MembershipNumber
        this.membershipNumber = membershipNumber;
    }

    public String getName() {//getmethod of getName
        return name;//return the value of name
    }

    public void setName(String name) {//setmethod of getName
        this.name = name;
    }

    public Date getStartMembershipDate() {//getmethod of StartMembershipDate
        return startMembershipDate;//return the value of startMembershipDate
    }

    public void setStartMembershipDate(Date startMembershipDate) {//setmethod of StartMembershipDate
        this.startMembershipDate = startMembershipDate;
    }

    public String getType() {//getmethod of Type
        return type;//return the value of type
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchoolName() {//getmethod of SchoolName
        return schoolName;//return the value of age
    }

    public void setSchoolName(String schoolName) {//setmethod of SchoolName
        this.schoolName = schoolName;
    }

    public String getAge() {//getmethod of Age
        return age;//return the value of age
    }

    public void setAge(String age) {//setmethod of Age
        this.age = age;
    }

}

