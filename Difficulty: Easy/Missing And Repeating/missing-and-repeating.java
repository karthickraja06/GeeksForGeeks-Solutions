//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        int xr = 0;
        for(int i = 0;i < arr.length;i++){
            xr ^= i+1;
            xr ^= arr[i];
        }
        int number = xr & ~(xr - 1);
        int one = 0, zero = 0;
        for(int i = 0;i < arr.length;i++){
            if((arr[i] & number) != 0){
                one ^= arr[i];
            }else{
                zero ^= arr[i];
            }
            if((i+1 & number) != 0){
                one ^= i + 1;
            }else{
                zero ^= i + 1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == one){
                res.add(one);
                res.add(zero);
                return res;
            }
        }
        res.add(zero);
        res.add(one);
        return res;
    }
}
