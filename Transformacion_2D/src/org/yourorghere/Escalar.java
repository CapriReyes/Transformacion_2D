package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Escalar implements GLEventListener{
    GL gl;
    GLU glu;
    
    public double[][] puntosE;
    
    public Escalar(double[][] puntosE){
        this.puntosE=puntosE;
    }
    
    public void escalamiento(double DeltaX, double DeltaY){
        for(int i=0;i<puntosE.length;i++){
            puntosE[i][0]*=DeltaX;
            puntosE[i][1]*=DeltaY;
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
        escalamiento(2,2);
        gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0,1,0);
            for(int i=0;i<puntosE.length;i++){
                gl.glVertex2d(puntosE[i][0],puntosE[i][1]);
            }
        gl.glEnd();
        escalamiento(0.5,0.5);
        gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(1,0,0);
            for(int i=0;i<puntosE.length;i++){
                gl.glVertex2d(puntosE[i][0],puntosE[i][1]);
            }
        gl.glEnd();
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}