package com.hubstc.lottery;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;


public class MainFrameApp extends JFrame implements Runnable {

    private ButtonGroup group=new ButtonGroup();
    private JRadioButton rbStu=new JRadioButton("����");
    private JRadioButton rbTeacher=new JRadioButton("Ů��");
    //��ѡ��ť

    private JButton btnStart=new JButton("��ʼ����");
    private JButton btnReset=new JButton("���õ������");
    //��ͨ��ť


    private JLabel titleLabel=new JLabel("����ְ",JLabel.CENTER);
    //ͼƬ������
    
    private int type=Person.TYPE_BOY;//��ȡѡ������
    private List<Person> persons;
    private List<Person> listWhite;
    private List<Person> listBlack;
    private boolean flag;

    public MainFrameApp(){
        this.setTitle("�������ϵͳ");
        this.setBounds(650, 250, 450, 500);
        this.setResizable(false);
        BackgroundPanel bp=new BackgroundPanel(Toolkit.getDefaultToolkit().
                getImage(MainFrameApp.class.getResource("/imgs/main.png"))); //��ȡͼƬ �������
        this.setContentPane(bp);
        
        
        btnStart.setBounds(40, 70, 120, 40);
        btnReset.setBounds(180, 70, 120, 40);
        bp.add(btnStart);bp.add(btnReset);
        btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ʼ����");
				startRun();//��ʼ�齱����
			}
        	
        });
    
        
        btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���õ������");
				rbStu.setSelected(true);
			}
        	
        });
        
        group.add(rbStu);group.add(rbTeacher);
        rbStu.setBounds(320, 70, 100, 20);
        rbTeacher.setBounds(320, 90, 100, 20);
        bp.add(rbStu);bp.add(rbTeacher);
        rbStu.addActionListener(new ActionListener(){
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�������齱");
				type=Person.TYPE_BOY;
				initialData();
			}
        	
        });
        
        rbTeacher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Ů�����齱");
				type=Person.TYPE_Girl;
				initialData();
			}
        	
        });
        

        titleLabel.setBounds(60, 200, 300, 50);
        Font font=new Font("΢���ź�",Font.BOLD,24);
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.RED);
        bp.add(titleLabel);
        
          initialUI(); //��ʼ������getTitle picLablel
          initialData(); //��ʼ������
    }
    //���췽��
    
    private void initialUI(){
    	rbStu.setSelected(true);
    	flag=true;
    	Person person = PersonFactory.getPerson(Person.TYPE_DEFAULT, "", "");
    	displayUI(person);
    }
    private void displayUI(Person person){
    	titleLabel.setText(person.getTiTle());
    }
    
    private void initialData(){
    	try{
    		persons=FileinfoUtils.getFileInfo(type, type); //��ͨ����
//    		listWhite=FileinfoUtils.getFileInfo(type, FileinfoUtils.WHITE_TYPE);  //������
//    		listBlack=FileinfoUtils.getFileInfo(type, FileinfoUtils.BLACK_TYPE);  //������
    		
            }
    			catch (IOException e) {
                e.printStackTrace();
    	}
    }
    
    private void setBtnEnable(boolean flag){
    	btnStart.setEnabled(flag);
		btnReset.setEnabled(flag);
		rbStu.setEnabled(flag);
		rbTeacher.setEnabled(flag);
    }
    private void startRun(){
    	setBtnEnable(false);
    	Thread thread=new Thread(this);
    	thread.start();//run()
    }
    @Override
    public void run(){
    	//displayUI(person.get(i))
    	int size=persons.size();//4
    	int count=0;
    	int currentId=0;
    	Random rd=new Random();
		int rdm=rd.nextInt(size);
    	while(flag){//ȡһ�鼯���е�Ԫ��
    		currentId=count%size;
    		displayUI(persons.get(currentId));
    		
    		
    		if(count==10+rdm)
    		{
    			flag=false;
    		}
//    		int time;
//    		if(count<40){
//    			time=30;
//    		}else if(count<80){
//    			time=100;
//    		}else{
//    			time=200;
//    		}
    		try {
				Thread.sleep(30);//�ó�CPUʹ��Ȩ
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		count++;
    	}

    	flag=true;
    	setBtnEnable(true);
    }
   
    
    private List<Person> getPersonsOutBlack(){
    	List<Person> outBlackPersons=new ArrayList<>();
    	
    	for(int i=0;i<persons.size();i++){//��ͨ������ȡ��һ������
    		Person person=persons.get(i);
    		for(int j=0;j<listBlack.size();j++){
    			Person blackPerson=listBlack.get(j);//��������ȡ��һ������
    			if(!person.equals(blackPerson)){
    				outBlackPersons.add(person);
    			}
    		}
    	}
    	
    	return outBlackPersons;
    }
    private void randomDisplay(List<Person> list){
    	int size=list.size();
    	Random rd=new Random();
    	int rdm=rd.nextInt(size);
    	displayUI(list.get(rdm));
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	try{
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}//ˮ�����
    	
    	
        MainFrameApp frame=new MainFrameApp();
        frame.setVisible(true);
    }

}
//������