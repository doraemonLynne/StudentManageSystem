/** 
 * Project Name:MVCDemo 
 * File Name:UpdateUserAction.java 
 * Package Name:com.chf.action 
 * Date:2014年12月17日 上午10:35:40 
 * Copyright (c) 2014, zhangzhaoyu0524@163.com All Rights Reserved. 
 * 
*/  
  
package com.chf.action;

import java.util.ArrayList;
import java.util.List;

public class ShowingGrade implements Grade {
    private List<Grade> grades = new ArrayList<Grade>();
    private String grade;

    @Override
    public String showGrade() {
        return grades.get(0).showGrade();
    }

    //adding shape to drawing
    public void add(Grade g){
        this.grades.add(g);
    }

    //removing shape from drawing
    public void remove(Grade g){
        grades.remove(g);
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Clearing all the subjects from ShowingGrade");
        this.grades.clear();
    }
}

 