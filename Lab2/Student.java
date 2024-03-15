/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hellosd19314;

/**
 *
 * @author TienTHM_1
 */
public class Student {
    String name;
    double mark;
    String course;

    public double getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setCourse(String course) {
        this.course = course;
    }
   

    public Student() {
    }
    
    public String getRank(){
        if(this.mark < 5){
            return "TB";
        }
        if(this.mark < 7.5){
            return "Kha";
        }
        if(this.mark < 9){
            return "Gioi";
        }
        return "XS";
    }
    
    public boolean isBouns(){
        return this.mark > 7.5;
    }
}
