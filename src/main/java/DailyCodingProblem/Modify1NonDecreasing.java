package DailyCodingProblem;

public class Modify1NonDecreasing {
    public static boolean isValid(int[] arr){
        if(arr.length == 1 || arr.length == 2) return true;
        int peakIndex = 0;
        int valleyIndex = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                peakIndex = i-1;
                valleyIndex = i;
                break;
            }
        }
        return isNonDecreasing(arr,peakIndex ) || isNonDecreasing(arr, valleyIndex);
    }

    public static boolean isNonDecreasing(int[] arr, int remove){
        int pre = remove == 0? arr[1]:arr[0];
        for(int i = remove==0? 2:1; i < arr.length; i++){
            if(i == remove){
                continue;
            }
            if(arr[i] < pre){
                return false;
            }else{
                pre = arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] arr = new int[]{10,5,1};
        System.out.println(Modify1NonDecreasing.isValid(arr));
    }


}
