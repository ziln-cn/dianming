package com.hubstc.lottery;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileinfoUtils {
	
	
	public static List<Person> getFileInfo(int personType,int fileType) throws IOException{
		//�����û������жϣ����ļ���·��
		String prefix="";
		String filePath="/res/";
		
		if(personType==Person.TYPE_BOY){
			filePath=filePath+"boy.txt";
		}else if(personType==Person.TYPE_Girl){
			filePath=filePath+"girl.txt";
		}
		
		URL url = MainFrameApp.class.getResource(filePath);
        File file = new File(url.getPath()); // ����ָ���ļ�·��
        
        	List<Person> personList=new ArrayList<Person>();
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line="";
            while ((line = in.readLine()) != null) {
                System.out.println(line);  //���ÿһ�е�����
                String[] flag=line.split(";"); //�ַ������
                if(flag==null || flag.length!=2){
                	continue;
                }
                String no2=flag[0]; //System.out.println(flag[0]);
                String name2=flag[1]; //System.out.println(flag[1]);
                if(no2==null||no2.isEmpty()||name2==null||name2.isEmpty()){
                	continue;
                }
                Person person=PersonFactory.getPerson(personType, no2, name2);
                personList.add(person);
            }
            in.close();
	    //.PersonFactory.getPerson(int,String,String); //getTitle
            return personList;
	}
}
