//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*
        int l = 0,r = 0,res = 0;
        while(l < arr1.length && r < arr2.length && k > 0){
            if(arr1[l] == arr2[r]){
                res = arr1[l++];
                r++;
                k--;
            }
            else if(arr1[l] > arr2[r]){
                res = arr2[r++];
            }else{
                res = arr1[l++];
            }
            k--;
        }
        while(k > 0 && l < arr1.length){
            return arr1[l + k - 1];
        }
        while(k > 0 && r < arr2.length){
            return arr2[l + k - 1];
        }
        return res;
*/

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        int n1 = arr1.length, n2 = arr2.length;
        if(n1 > n2) return kthElement(k,arr2,arr1);
        
        int l = Math.max(0,k - n2),h = Math.min(n1,k);
        while(l <= h){
            int mid1 = (l + h) >> 1;
            int mid2 = k - mid1;
            
            int l1 = (mid1 > 0)?arr1[mid1 - 1]:Integer.MIN_VALUE;
            int l2 = (mid2 > 0)?arr2[mid2 - 1]:Integer.MIN_VALUE;
            int r1 = (mid1 < n1)?arr1[mid1]:Integer.MAX_VALUE;
            int r2 = (mid2 < n2)?arr2[mid2]:Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }else if(l1 > r2){
                h = mid1 - 1;
            }else{
                l = mid1 + 1;
            }
        }
        return 0;
        
    }
}


















