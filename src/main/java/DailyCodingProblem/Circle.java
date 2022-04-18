package DailyCodingProblem;

public class Circle {
    public static double calculate(){
        int r = 100;
        double circle = 0;
        for(int i = 0; i <= r; i++){
            circle += (2 * i * Math.sqrt(r*r - i*i) )/ r*r ;
        }
        return circle;
    }

    public static void main(String[] args){
       System.out.println( Circle.calculate());
    }

}




/*

x^2 + y^2 = r^2
x = sqrt(r^2- y ^2)

sum (4(x*y/2)) , x,y= sqrt(r^2-x^2), x = 0 ~ r

sum(4(x * sqrt(r^2-x^2) /2))  = πr^2 , x = 0~ r

sum(2x * sqrt(r^2-x^2)) / r^2  = π, x = 0~ r

r = 1000, x = 1~1000

*
* */