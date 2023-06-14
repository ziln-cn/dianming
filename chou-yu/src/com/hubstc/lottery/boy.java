package com.hubstc.lottery;

public class boy extends Person{

    public boy(String no2,String name2) {
        super(no2,name2,Person.TYPE_BOY);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="学号"+no2+"姓名:"+name2;
        return title;
    }
    //构造方法


}
//学生信息
