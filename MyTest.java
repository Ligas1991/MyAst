package ua.i.pustovalov.taskTwo;

import java.util.Arrays;

public class MyTest {

    public static void main(String[] args) {
	Vert vr = new Vert(10);
	Point[] nst = new Point[] { new Point(0, 1, 2), new Point(0, 3, 5),
		new Point(1, 2, 3), new Point(1, 3, 4), new Point(2, 0, 3),
		new Point(2, 4, 1), new Point(3, 1, 4), new Point(3, 0, 1),
		new Point(4, 0, 3), new Point(4, 1, 4) };
	vr.addMas(nst);
	System.out.println(Arrays.toString(vr.myPointMas));
	
	
	int[][] mas = new int[nst.length][nst.length];

	for (int i = 0; i < vr.myPointMas.length; i++) {
	    vr.mas[i] = true;

	    System.out.println(vr.myPointMas[i].friend + " "
		    + vr.myPointMas[i].size);
	    mas[vr.myPointMas[i].start][vr.myPointMas[i].friend] = vr.myPointMas[i].size;
	}
	
	
	System.out.println(Arrays.deepToString(mas));

	for (int i = 0; i < nst.length; i++) {
	    for (int j = 1; j < nst.length; j++) {
		if(mas[i][j]!=0 ||  i != j){ // Ёлемент i j всегда должен быть 0 , это путь к самому себе
		    
			    if (j<nst.length-1){ // если  j не последний элементэлемент 
				if(mas[i][j] == 0 && i<nst.length-1){ //  ищем пустые элементы 
				    for(int k = i ; k <nst.length-1 ; k++ ){
					
					if(mas[k+1][j] != 0 || mas[k+1][j] < nst.length-1){ // провер€ем следующую €чейку если 0 но увеличиваем j
					    mas[k][j] = mas[k+1][j] + mas[k][j-1];// наш пустой элемент равен  элемент из следующей €чейки + элемент данной €чейки равный следующей €чейки 
				      }
					
				    }
				}
			    
			    
		    }
		}
	    }
	}
	System.out.println(Arrays.deepToString(mas));
    }
}

class Point {

    int start;
    int friend;
    int size;

    public Point(int start, int friend, int size) {
	this.start = start;
	this.friend = friend;
	this.size = size;
    }

    @Override
    public String toString() {
	return "Point [start=" + start + ", friend=" + friend + ", size="
		+ size + "]";
    }

}

class Vert {
    boolean[] mas;
    Point[] myPointMas;

    public Vert(int Size) {
	mas = new boolean[Size];
	myPointMas = new Point[Size];
    }

    public void addMas(Point[] ps) {
	myPointMas = ps;
    }

}