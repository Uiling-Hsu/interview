package DailyCodingProblem;

public class RunLengthEnCode {
    public static String encode(String input){
        if(input.length() == 0){
            return null;
        }
        int count = 1;
        char current = input.charAt(0);
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i)!= input.charAt(i-1)){
                sb.append(count);
                sb.append(current);
                current = input.charAt(i);
                count = 1;
            }else {
                count++;
            }
        }
        sb.append(count);
        sb.append(current);
        return sb.toString();
    }

    public static String deCode(String input){
        if(input.length() == 0){
            return null;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < input.length()){
            int count = Integer.valueOf(input.charAt(i)+"");
            i++;
            char c = input.charAt(i);
            for(int j = 0; j < count; j++){
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String i = RunLengthEnCode.encode("AAABCCAAAAA");
        System.out.println(i);
        String d = RunLengthEnCode.deCode(i);
        System.out.println(d);

    }

}
