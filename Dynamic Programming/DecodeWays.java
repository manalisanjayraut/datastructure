public class DecodeWays {

    public static void main(String args[]){

        String s = "226";

        System.out.println( "result is "+function(s, 0));
    }

    public static int function(String s , int index){

        if(index == s.length()) return 1;//reached end

        if(s.charAt(index) == '0') return 0; //invalid

        int result = function(s, index + 1);

        if(index + 1 < s.length()){

            int a = Integer.parseInt(s.substring(index, index+2));

            if(a <= 26){
                result = result + function(s, index + 2);
            }

        }

        return result;


    }
    
}
