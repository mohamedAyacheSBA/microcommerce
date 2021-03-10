package com.commerce.microcommerce;

import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

public class PourTest {

	//57
	static boolean isFoo(String param) {
		if(param.equals("foo")) return true;
		else return false;
	}


	//58

	static int findLargest(int [] numbers) {
		int lagest = numbers[0];
		for(int i=1; i< numbers.length ; i++) {
			lagest = lagest < numbers[i] ? numbers[i] : lagest;
		}
		return lagest;
	}

	//59
	static String concat(String[] strings) {
		StringBuilder str = new StringBuilder();
		for(String e : strings)
			str.append(e);
		return str.toString();
	}


	//59

	static int [] filterDuplicates(int [] data) {
		int n = data.length;
		if (n==0 || n==1){  
			return data;  
		}  
		int[] temp = new int[n];  
		int j = 0;  
		for (int i=0; i<n-1; i++){  
			if (data[i] != data[i+1]){  
				temp[j++] = data[i];  
			}  
		}  
		temp[j++] = data[n-1];     
		// Changing original array  
		int [] result = new int[j];
		for (int i=0; i<j; i++){  
			result[i] = temp[i];  
		}  
		return result;  
	}



	//61

	public enum TypeColis {
		STNDARD, SPECIAL, REJECTED;
	}
	public static String solve(int width, int height,int  length,int mass){


		int volume = width * height * length;

		if(volume >= 1000000 || width>= 150 || height>= 150 || length>= 150 || mass >=20){
			return TypeColis.SPECIAL.toString();
		}

		if((volume >= 1000000 || width>= 150 || height>= 150 || length>= 150) && mass >=20){
			return TypeColis.REJECTED.toString();
		}

		return TypeColis.STNDARD.toString();
	}


	//62

	static int sumRange(int[] ints) {
		int sum = 0;

		for (int nbr : ints)
			if(nbr >=10 && nbr<=100) {
				sum = + nbr;
			}
		return sum;
	}


	//63

	static boolean a(int i, int j) {
		if(i ==1 || j ==1 || i+j == 1) {return true;}
		return false;
	}



	//65 
	interface Service {
		void execute() throws Exception;
		void setConnection(Connection c);
	}

	interface Connection {
		void commit();
		void rollback();
		void close();
	}

	void a(Service s, Connection c) {
		try {
			s.execute();
			c.commit();
		} catch (Exception e) {
			c.rollback();
		} finally {
			c.close();
		}
	}


	//67 à le faire par la suite 


	public static int calc(int[] array, int n1, int n2) {
		int sum =0;
		for(int i = 0; i< array.length-1; i ++){
			if(i != array.length){
				if(0 <=array[i] && array[i]<= array[i+1] && array[i+1]<= array.length)
					sum = array[i] + array[i+1];
			}
		} 
		return sum;
	}

	//
	static int computeMultiplesSum(int n) {
		int sum = 0;
		for(int i = 1; i < n; i++) {
			if((i % 3 == 0) || (i % 5 == 0) || (i % 7 == 0)) {
				sum += i;
			}
		}
		return sum;
	}


	//70 à le revoir 

	//71



	static boolean isTwin(String a, String b) {
		char[] first = a.toLowerCase().toCharArray();
		char[] second = b.toLowerCase().toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}

	//72

	static int count(int n) {
		return  n *(n-1)/2;
	}


	//73

	public static int calculateTotalPrice(int[] prices, int discount) {

		int lagest = prices[0];
		int lagestDiscount;
		int sumPrices;
		for(int i=1; i< prices.length ; i++) {
			lagest = lagest < prices[i] ? prices[i] : lagest;
		}
		lagestDiscount =(lagest * discount)/100;
		sumPrices = lagestDiscount;
		for(int i=1; i< prices.length ; i++) {
			if(prices[i] != lagest)
				sumPrices =+ prices[i];
		}

		return sumPrices;
	}


	//83

	static int closestToZero(int [] ints ) {
		if(ints == null || ints.length == 0) {
			return 0;
		}
		int curr = 0;
		int result = ints[0]; 
		Arrays.sort(ints);      
		for ( int i=0; i < ints.length; i++ ){
			curr = ints[i] * ints[i]; 
			if ( curr <= (result * result) )  { 
				result = ints[i];
			} 
		}
		System.out.println( result );
		return result;
	}


	//page 93

	public static char scanChar(int asciiValue)
	{

		return (char)asciiValue;
	}


	//page 97
	//	static double approx(double[][] pts) {
	//	 pts c'est les points tirés au hasard
	static double approx(double pts) {
		double pi, x, y,compteur = 0 ;

		for (int départ=0;départ<=pts;départ++){
			// coordonnees du point tiré au hasard
			//		    x = (double)(Math.random() * (1) + 0);
			//		    y = (double)(Math.random() * (1) + 0);
			x = Math.random();
			y = Math.random();
			if (x*x+y*y <= 1) 
				compteur++;// le nombre de points tombés dans le cercle
		}
		//Calcul de Pi
		pi = 4 * (compteur/pts);
		return pi;
	}


	//page 98

	public static String reshape(int n, String str) {
		String strResult = new String();
		int i = 0;
		// remove spaces from a string 
		 str = str.replaceAll("\\s", "");

		char[] ch =  str.toCharArray(); 
		
		for (char c :  ch){
			
			if(i < n )
			{
				strResult = strResult.concat(String.valueOf(c));
				
				i = i+1;
				
			}else{
				strResult = strResult.concat(System.getProperty("line.separator")).concat(String.valueOf(c));
				i = 1;
			}
		
		}
		return strResult;
	}

	public static void main(String[] args) {

		String[] strings = {"f","o","o","bar"};
		int[] numbers1 = {15,99,99,7,99,88,56,43};
		System.out.println("concat : "+concat(strings));

		int iArr[] = {-2,-1,2, 1, 9, 6, 4};


		System.out.println("result = "+closestToZero(iArr));


		for(int e : filterDuplicates(numbers1))
			System.out.println(e);

		System.out.println("ASCII : 97 en char est : "+ scanChar(97));

		
		System.out.println("pi = "+approx(40));

		
		//98
		
		System.out.println(reshape(3, "abc de fghij"));
		
		System.out.println(reshape(2, "1 23 456"));

	}// end main






}

