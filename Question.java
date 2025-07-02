/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management;

import java.io.Serializable;



public class Question implements Serializable{
    private String question;
    private String a,b,c,d;

    public Question(String question){
        this.question = question;
    }
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
    
    @Override
    public String toString(){
        return "Question - " + getQuestion() + " : " 
                + "A - " + getA()
                + " / B - " + getB()
                + " / C - " + getC()
                + " / D - " + getD();
    }
}
