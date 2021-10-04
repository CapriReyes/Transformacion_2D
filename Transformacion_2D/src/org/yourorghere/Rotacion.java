package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Rotacion implements GLEventListener{
    GL gl;
    GLU glu;
    
    public double[][] puntosR;
    
    public Rotacion(double[][] puntosR){
        this.puntosR=puntosR;
    }
    
    public void rotar(double grado){
        double DeltaX;
        double DeltaY;
        for(int i=0;i<puntosR.length;i++){
            DeltaX=puntosR[i][0];
            DeltaY=puntosR[i][1];
            puntosR[i][0]=DeltaX*Math.cos(Math.toRadians(grado))-DeltaY*Math.sin(Math.toRadians(grado));
            puntosR[i][1]=DeltaY*Math.cos(Math.toRadians(grado))+DeltaX*Math.sin(Math.toRadians(grado));
        }
    }
        
    @Override
    public void init(GLAutoDrawable drawable) {
        glu = new GLU();
        gl = drawable.getGL();
        gl.glClearColor(0, 0, 0, 0);
        //Establecer los parametros para la proyeccion
        gl.glMatrixMode(gl.GL_PROJECTION);
        glu.gluOrtho2D(-400, 400, -400, 400);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glLineWidth(1);
        gl.glClear(gl.GL_COLOR_BUFFER_BIT);
        gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(1,0,0);
            for(int i=0;i<puntosR.length;i++){
                gl.glVertex2d(puntosR[i][0],puntosR[i][1]);
            }
        gl.glEnd();
        rotar(25);
        gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0,1,0);
            for(int i=0;i<puntosR.length;i++){
                gl.glVertex2d(puntosR[i][0],puntosR[i][1]);
            }
        gl.glEnd();
        rotar(-25);
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
    
}
