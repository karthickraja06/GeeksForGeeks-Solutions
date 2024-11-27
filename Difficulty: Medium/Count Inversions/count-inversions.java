//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int merge(int[] a,int l,int m,int h){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = l, right = m+1,cnt =0;
        
        while(left <= m && right <= h){
            if(a[left] > a[right]){
                temp.add(a[right++]);
                cnt += m - left +1;
            }else{
                temp.add(a[left++]);
            }
        }
        while(left <= m){
            temp.add(a[left++]);
        }
        while(right <= h){
            temp.add(a[right++]);
        }
        
        for(int i = l;i <= h;i++){
            a[i] = temp.get(i-l);
        }
        return cnt;
        
    }
    static int mergeSort(int[] a,int l,int h){
        int cnt = 0;
        if(l >= h){
            return cnt;
        }
        int mid = (l+h)/2;
        cnt += mergeSort(a,l,mid);
        cnt += mergeSort(a,mid+1,h);
        cnt += merge(a,l,mid,h);
        return cnt;
    }
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        return mergeSort(arr,0,arr.length-1);
        
    }
}