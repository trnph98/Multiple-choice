package com.example.tracnghiemv1;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private String question;
    private String ans_a;
    private String ans_b;
    private String ans_c;
    private String ans_d;
    private String result;
    private String image;
    private int num_exam;
    private String subject;
    private String Ansert="";
    public int choiceID = -1;
    public String getAnsert() {
        return Ansert;
    }

    public int getChoiceID() {
        return choiceID;
    }

    public void setAnsert(String ansert) {
        Ansert = ansert;
    }

    public Question() {
    }

    public Question(int id, String question, String ans_a, String ans_b, String ans_c, String ans_d, String result, String image, int num_exam, String subject,String Ansert) {
        this.id = id;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.image = image;
        this.num_exam = num_exam;
        this.subject = subject;
        this.Ansert = Ansert;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNum_exam() {
        return num_exam;
    }

    public void setNum_exam(int num_exam) {
        this.num_exam = num_exam;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
