package com.alta7ade.bala8a;

public class questionform {
    String false1, false2, false3, lamp, leson, question, right;
    int agerequired, number;

    public questionform() {
    }

    public questionform(String false1, String false2, String false3, String leson, String question, String right, int agerequired, int number) {
        this.false1 = false1;
        this.false2 = false2;
        this.false3 = false3;
        this.leson = leson;
        this.question = question;
        this.right = right;
        this.agerequired = agerequired;
        this.number = number;
    }

    public String getFalse1() {
        return false1;
    }

    public void setFalse1(String false1) {
        this.false1 = false1;
    }

    public String getFalse2() {
        return false2;
    }

    public void setFalse2(String false2) {
        this.false2 = false2;
    }

    public String getFalse3() {
        return false3;
    }

    public void setFalse3(String false3) {
        this.false3 = false3;
    }


    public String getLeson() {
        return leson;
    }

    public void setLeson(String leson) {
        this.leson = leson;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public int getAgerequired() {
        return agerequired;
    }

    public void setAgerequired(int agerequired) {
        this.agerequired = agerequired;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
