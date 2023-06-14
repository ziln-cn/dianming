package com.hubstc.lottery;

public abstract class Person {
    protected String no2;
    protected String name2;
    protected int type;

    public static final int TYPE_DEFAULT=0;
    public static final int TYPE_BOY=1;
    public static final int TYPE_Girl=2;
    //创建成员变量

    public Person(String no2, String name2, int type) {
        // TODO Auto-generated constructor stub
    	super();
    	this.no2 = no2;
    	this.name2 = name2;
    	this.type = type;
    }
    public String getNo2() {
        return no2;
    }
    public void setNo(String no2) {
        this.no2 = no2;
    }
    public String getName2() {
        return name2;
    }
    public void setName(String name2) {
        this.name2 = name2;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    //封装
    public abstract String getTiTle();
   
}
//Person父类
