package Interface;

import java.awt.*;
import java.awt.geom.Line2D;

public class Line {
    private double x1,y1;
    private double x2,y2;
    private int r;


    public Line(int x1,int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        int midx = (x1+x2)/2;
        int midy = (y1+y2)/2;
        double xdiff = x2-midx;
        double ydiff = y2-midy;
        r = (int)Math.sqrt(xdiff*xdiff+ydiff*ydiff);


    }

    public void rotate(String dir){


        double a = getangle();
        //  a = Math.toRadians(a);
        double midx = (x1+x2)/2;
        double midy = (y1+y2)/2;
        double xdiff = x2-midx; //length of x component
        double ydiff = y2-midy; //length of y component





        if(dir.equals("cc")) {

            System.out.println("yuh");

            a -= (Math.PI / 180) / 2.5;

            double x2change = (Math.cos(a) * r) - xdiff; //will be negative
            x2 += x2change;

            double y2change = (Math.sin(a) * r) - ydiff; //will be positive
            y2 += y2change;                              //needs to be negative

            //  int x1change = (int) (Math.cos(a + Math.PI) * r)+(int)xdiff;
            double x1change = -x2change;

            x1 += x1change;

            double y1change = -y2change;

            y1 += y1change;



        }else if(dir.equals("c")){
            a += (Math.PI / 180) / 2.5;

            double x2change = (Math.cos(a) * r) - xdiff;
            x2 += x2change;

            double y2change = (Math.sin(a) * r) - ydiff;
            y2 += y2change;

            double x1change = -x2change;

            x1 += x1change;

            double y1change = -y2change;

            y1 += y1change;


        }
    }

    public void draw(Graphics2D g){
        g.draw(new Line2D.Double(x1,y1,x2,y2));




    }

    public double getangle(){
        double a;
        double midx = (x1+x2)/2;
        double midy = (y1+y2)/2;
        double xdiff = x2-midx;
        double ydiff = (y2-midy);
        a = Math.atan(ydiff/xdiff);
        return a;

    }

    public void rotateto(double a){

        a = Math.toRadians(a);

        double midx = (x1+x2)/2;
        double midy = (y1+y2)/2;
        double xdiff = x2-midx;
        double ydiff = y2-midy;

        if(a>=0&&a<Math.PI/2) {
            double x2change = (Math.cos(a) * r) - xdiff;
            x2 += x2change;

            double y2change = (Math.sin(a) * r) - ydiff; //will be positive
            y2 -= y2change;

            double x1change = -x2change;

            x1 += x1change;

            double y1change = -y2change;

            y1 += y1change;
        }


    }

}
