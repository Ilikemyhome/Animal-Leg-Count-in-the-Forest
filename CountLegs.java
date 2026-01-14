import java.util.Arrays;
import java.util.HashSet;
public class CountLegs{

    public static void main(String[] args){
        String[] animals = new String[]{"lion", "monkey", "deer", "snake", "elephant"};
        int count = countFourLegs(animals);
        System.out.print(count);

    }

    public static int countFourLegs(String[] animals){
        int totalCount = 0;
        HashSet<String> fourLegs = new HashSet<>(Arrays.asList( "lion", "deer", "elephant", "horse", "dog", "cat"));
        for(String a : animals){
            if(fourLegs.contains(a.toLowerCase())){
                totalCount++;
            }
        }

        return totalCount;
    }



}