package week3;

import java.util.Scanner;

public class PrimeEncryption {
	private static String code[];
	
	private static int[] listOfPrimes() {
		int arr[] = new int[110];
		int p = 2;
		while(p<=110) {
			for(int i=p*p; i<=110; i+=p) {
				arr[i-1] = 1;
			}
			int j;
			for(j=p+1; ((j<=110)&&(arr[j-1]!=0)); j++);
			p = j;
		}
		return arr;
	}
	
	private static void codeAllLetters() {
		int[] arr = listOfPrimes();
		code  = new String[26];
		int count  = 1;
		for(int i=0; i<26; i++) {
			while(arr[count-1]!= 0)
				count++;
			code[i] = Integer.toHexString(count);
			count+=1;
		}
	}
	
	public static void main(String args[]) {
		codeAllLetters();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter word to encrypted : ");
		String str = sc.next().toUpperCase();
		StringBuffer output = new StringBuffer();
		int num;
		for(int i=0; i<str.length()-1; i++) {
			num = str.charAt(i)-65;
			output.append(code[num].toUpperCase() + ", ");
		}
		num = str.charAt(str.length()-1) - 65;
		output.append(code[num]);
		System.out.println(output.toString());
		sc.close();
	}
}
