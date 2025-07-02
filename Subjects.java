/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management;

public class Subjects {
    private int sub_int;
    private String sub_name;
    private int first_month;
    private int second_month;
    private int third_month;
    private int midterm;
    private int finalExam;
    private int semester;
	
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public int getSub_int() {
        return sub_int;
    }

    public void setSub_int(int sub_int) {
        this.sub_int = sub_int;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public int getFirst_month() {
        return first_month;
    }

    public void setFirst_month(int first_month) {
        this.first_month = first_month;
    }

    public int getSecond_month() {
        return second_month;
    }

    public void setSecond_month(int second_month) {
        this.second_month = second_month;
    }

    public int getThird_month() {
        return third_month;
    }

    public void setThird_month(int third_month) {
        this.third_month = third_month;
    }

    public int getMidterm() {
        return midterm;
    }

    public void setMidterm(int midterm) {
        this.midterm = midterm;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(int finalExam) {
        this.finalExam = finalExam;
    }

  
    
}
