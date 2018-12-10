package com.company;

import java.util.Arrays;

public class MyTriangle {

    private Point [] point = new Point[3];
    TriangleStatus triangleStatus;

    public enum TriangleStatus{
        Rectangular,
        Equilateral,
        Isosceles,
        Verstile
    }


    MyTriangle(Point point1, Point point2, Point point3){
        this.point[0] = point1;
        this.point[1] = point2;
        this.point[2] = point3;
        this.triangleStatus = findStatus(this);
    }

    public TriangleStatus findStatus (MyTriangle myTriangle){

        double AB = helpCalcLenth(myTriangle.getPointOne(),myTriangle.getPointTwo());
        double BC = helpCalcLenth(myTriangle.getPointTwo(),myTriangle.getPointThree());
        double CA = helpCalcLenth(myTriangle.getPointThree(),myTriangle.getPointOne());

        if (AB==BC&&BC==CA){
            myTriangle.triangleStatus = TriangleStatus.Equilateral;
        }
        else if (AB==BC||BC==CA||CA==AB){
            myTriangle.triangleStatus = TriangleStatus.Isosceles;
        }
        else {
            double[] mass  = new double[3];
            mass[0] = AB;
            mass[1] = BC;
            mass[2] = CA;
            Arrays.sort( mass);
            if (Math.sqrt((mass[0]*mass[0])+(mass[1]*mass[1]))==mass[2]){
                myTriangle.triangleStatus = TriangleStatus.Rectangular;
            }else{
                myTriangle.triangleStatus = TriangleStatus.Verstile;
            }
        }
        return myTriangle.triangleStatus;
    }

    public double helpCalcLenth(Point p1,Point p2){
        return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    }


    //-------------
    public Point getPointOne(){
        return point[0];
    }
    public Point getPointTwo(){
        return point[1];
    }
    public Point getPointThree(){
        return point[2];
    }

    public TriangleStatus getTriangleStatus() {
        return triangleStatus;
    }

    public void setPointOne(Point point){
        this.point[0] = point;
    }
    public void setPointTwo(Point point){
        this.point[1] = point;
    }
    public void setPointThree(Point point){
        this.point[2] = point;
    }
}