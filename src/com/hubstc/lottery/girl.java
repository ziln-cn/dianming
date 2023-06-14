package com.hubstc.lottery;

public class girl extends Person {
    public girl(String no2,String name2) {
        super(no2,name2,Person.TYPE_Girl);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="工号"+no2+"姓名:"+name2;
        return title;
    }
    //构造方法


}
//老师信息
