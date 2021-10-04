
package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Sesgado implements GLEventListener{
    GL gl;
    GLU glu;
    
    public double[][] puntosS;
    
    public Sesgado(double [][] puntosS){
        this.puntosS=puntosS;
    }
    
    public void Sesgar(double DeltaX, double DeltaY){
        double x;
        double y;
        for(int i=0;i<puntosS.length;i++){
            x=puntosS[i][0];
            y=puntosS[i][1];
            puntosS[i][0]+=(DeltaX*y);
            puntosS[i][1]+=(DeltaY*x);
        }
    }
    @Override
    public void init(GLAutoDrawable drawable) {
        glu = new GLU();
        gl = drawable.getGL();
        gl.glClearColor(0, 0, 0, 0);
        //Establecer los parametros para la proyeccion
        gl.glMatrixMode(gl.GL_PROJECTION);
        glu.gluOrtho2D(-400, 400, -400,400);
    }
    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glLineWidth(1);
        gl.glClear(gl.GL_COLOR_BUFFER_BIT);
        gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(1,0,1);
            for(int i=0;i<puntosS.length;i++){
                gl.glVertex2d(puntosS[i][0],puntosS[i][1]);
            }
        gl.glEnd();
        Sesgar(1,0);
        gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0,1,1);
            for(int i=0;i<puntosS.length;i++){
                gl.glVertex2d(puntosS[i][0],puntosS[i][1]);
            }
        gl.glEnd();
        Sesgar(-1,0);
        gl.glFlush();
    }
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
}
