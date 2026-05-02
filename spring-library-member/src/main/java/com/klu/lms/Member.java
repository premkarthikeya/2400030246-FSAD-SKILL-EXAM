package com.klu.lms;


public class Member {

    private String memberId;
    private String name;
    private String phone;
    private Card card;

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void print() {
        System.out.println(memberId + " | " + name + " | " + phone + " | " + card);
    }
}