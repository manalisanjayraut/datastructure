public class HouseRobber {

    public static void main(String[] args) {
        int[] house = { 1, 2, 3, 1 };
        int result = totalAmount(house);
        System.out.println("result : "+result);
    }

    private static int totalAmount(int[] house) {
        
        int prev = house[0];
        int prev2 = 0;
        for(int i = 1 ; i < house.length; i++){

            int taken = house[i];
            if(taken > 1)
                taken += prev2;
            int notTaken = prev ;

            int current = Math.max(taken, notTaken);

            prev2 = prev;
            prev = current;

        }

        return prev;


    }

}
