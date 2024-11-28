//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int l = 0,h = arr.size() - 1, ans = 0;
        while(l <= h){
            int mid = (l + h) / 2;
            if(arr.get(mid) < arr.get(ans)){
                ans = mid;
            }
            if(arr.get(mid) <= arr.get(h)){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}