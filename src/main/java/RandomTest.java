import java.util.Random;

public class RandomTest {

    public static double getRandomNumberExclusive1(int min, int max) {
        return  ((Math.random() * (max - min)) + min);
    }

    public static double getRandomNumberExclusive2(int min, int max) {
        Random random = new Random();
        return  random.nextDouble()*(max - min) + min;
    }


    public static void main(String[] args){
        System.out.println(RandomTest.getRandomNumberExclusive1(-1,1));
    }
}
