package com.klu.lms;

public class Card {

    private String cardNo;
    private String issueDate;
    private String validTill;

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    @Override
    public String toString() {
        return "Card[cardNo=" + cardNo +
               ", issueDate=" + issueDate +
               ", validTill=" + validTill + "]";
    }
}