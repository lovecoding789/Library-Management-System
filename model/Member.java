package model;

public class Member extends User {

    public Member(int id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Member";
    }
}