package cs410;

import com.sun.source.tree.BreakTree;

public class Rectangle {
    private  int x1, y1;
    private  int x2 ,y2;
    public int  getX1(){
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getX2(){
        return x2;
    }
    public int getY2(){
        return y2;
    }
    // now we have to create rectangele from caordinates
    public static Rectangle of(int x1,int y1 , int x2, int y2) {
        //this is to validate the coordinate
        if (x1 > x2 || y1 > y2 ) {
            throw new IllegalArgumentException("Emppty or invalid cordinate");
        }
        //this will be our new rectangle
        Rectangle rectan = new Rectangle();
        rectan.x1 = x1;
        rectan.x2 = x2;
        rectan.y1 = y1;
        rectan.y2 = y2;
        return rectan;
    }
    //then we have calculate the area of rectangle
    public int area() {
        int Width  = x2-x1;
        int Height =y2-y1;
        return Width * Height;
    }
    //our point on rectangle
    public boolean contains(int y, int x){

        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }

    public boolean overlaps(Rectangle Abdi){
//now check x cordinate
        if(this.x1 >= Abdi.x2 || Abdi.x1 >= this.x2){
            return false;
        }

        if(this.y1 >= Abdi.y2 || Abdi.y1 >= this.y2) {
            return false;
        }

        return true;
    }

}