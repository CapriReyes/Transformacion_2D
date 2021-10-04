package org.yourorghere;

import java.awt.Font;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel extends JPanel{
    public double[][] puntos={{0,0},{100,0},{100,100},{0,100}};
    public double[][] puntos1={{0,0},{100,0},{100,100},{0,100}};
    public double[][] puntos2={{0,0},{100,0},{100,100},{0,100}};
    public double[][] puntos3={{0,0},{100,0},{100,100},{0,100}};
    public JLabel lblTitulo=new JLabel("Traslación");
    public Panel(){
        setLayout(null);
        
        Traslacion tras = new Traslacion(puntos);
        Rotacion rota = new Rotacion(puntos1);
        Escalar esca = new Escalar(puntos2);
        Sesgado sesga = new Sesgado(puntos3);
        
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        GLCanvas canvas2 = new GLCanvas(new GLCapabilities());
        GLCanvas canvas3 = new GLCanvas(new GLCapabilities());
        GLCanvas canvas4 = new GLCanvas(new GLCapabilities());
        
        canvas.addGLEventListener(tras);
        canvas2.addGLEventListener(rota);
        canvas3.addGLEventListener(esca);
        canvas4.addGLEventListener(sesga);
        
        lblTitulo.setBounds(10, 10, 400, 40);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", 3, 20));
        
        canvas.setBounds(10, 60, 300, 300);
        canvas2.setBounds(320, 60, 300, 300);
        canvas3.setBounds(630,60,300,300);
        canvas4.setBounds(940,60,300,300);
        
        add(canvas);
        add(canvas2);
        add(canvas3);
        add(canvas4);
        add(lblTitulo);
    }
}
