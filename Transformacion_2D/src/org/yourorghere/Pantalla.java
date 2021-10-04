package org.yourorghere;

import javax.swing.JFrame;

public class Pantalla extends JFrame{
    public Panel panel=new Panel();
    public Pantalla (){
        setTitle("T2-03-Traslacion-Escalamiento-Rotacion-Sesgado");
        setSize(1270, 420);
        componentes();
    }
    
    public void componentes(){
        setLayout(null);
        panel.setBounds(0, 0, getWidth(), getHeight());
        add(panel);
    }
    
    public static void main (String args[]){
        Pantalla frame = new Pantalla();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
