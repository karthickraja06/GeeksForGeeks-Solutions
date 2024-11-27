//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int upperBound(int[] a,int k){
        int l = 0, h = a.length-1;
        int ans = -1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(a[mid] <= k){
                ans = mid;
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return (ans != -1 && a[ans] == k)?ans + 1: -1;
    }
    public int lowerBound(int[] a,int k){
        int l = 0, h = a.length-1;
        int ans = -1;
        while(l <= h){
            int mid = (l + h) / 2;
            if(a[mid] >= k){
                ans = mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return (ans != -1 && a[ans] == k)?ans: -1;
    }
    int countFreq(int[] arr, int target) {
        if(arr.length <1) return 0;
        return upperBound(arr,target) - lowerBound(arr,target);
    }
}
