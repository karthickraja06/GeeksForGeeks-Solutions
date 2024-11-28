//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        int l = 1,h = m/2;
        if(n == 1)return m;
        while(l <= h){
            int mid = (l+h) / 2;
            long val = (long)Math.pow(mid,n);
            if(val == (long)m){
                return (int)mid;
            }else if(val < (long)m){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return -1;
    }
}