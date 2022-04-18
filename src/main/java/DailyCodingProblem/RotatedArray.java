package DailyCodingProblem;

public class RotatedArray {
    public static Integer find(int[] a, int start, int end, int element){
        if (a[start] < a[end]){
            return binarySearch(a, start, end, element);
        }

        int mid = start + (end-start)/2;
        if (a[mid] == element) return mid;
        if(a[mid] < a[start]){
            if( a[mid] < element && element <= a[end]){
                return binarySearch(a, mid+1, end, element);
            }else {
                return find(a, start, mid - 1, element);
            }
        }
        // a[mid] > a[start]
        if(a[start] < element && element <a[mid]){
            return binarySearch(a, start, mid-1, element);
        }else{
            return find(a, mid+1, end, element);
        }
    }

    public static Integer binarySearch(int[] a, int start, int end, int element){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(a[mid] == element){
                return mid;
            }
            if(a[mid] < element){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println(RotatedArray.find(new int[]{5,8,1,2,3,4}, 0, 5, 4));
    }
}
