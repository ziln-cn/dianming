package com.hubstc.lottery;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel{
    Image image;
    public BackgroundPanel(Image image){
        super();
        this.setOpaque(false);  //�Ƿ�͸��
        this.setLayout(null);  //�ղ���setBounds()
        this.image=image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        if(image!=null){
            int width=this.getWidth();
            int height=this.getHeight();
            g.drawImage(image, 0, 0, width, height, this);
        }
        super.paintComponent(g);
    }

}