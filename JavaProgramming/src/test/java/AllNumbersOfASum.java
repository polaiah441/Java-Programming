import java.util.Scanner;

public class AllNumbersOfASum {
	
	public static void main(String[] args) {
		
		
		System.out.println("enter number of digits and sum values ");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sum=sc.nextInt();
		AllNumbers(num,sum);
		//int count=0;
		//System.out.println("total number of possible combinations for sum:"+sum+"is with "+num+"combinations are: "+count);
	}
	
	public static void AllNumbers(int num, int sum) {
		
		int count=0;
		int i=0, j=0;
		
		switch (num) {
		  case 1:
		     i=0; j=9;
		    break;
		  case 2:
		    i=10; j=99;
		    break;
		  case 3:
		    i=100; j=999;
		    break;
		  case 4:
		    i=1000; j=9999;
		    break;
		  case 5:
		    i=10000;j=99999;
		    break;
		  case 6:
		   i=100000;j=999999;
		   break;
		  case 7:
		    i=1000000;j=9999999;
		    break;
		  case 8:
			    i=10000000;j=99999999;
			    break;
		  case 9:
			    i=10000000;j=99999999;
			    break;
		  default:
			System.out.println("Enter a valid number btw 1 to 9");
			break;	
		}
		
		for(i=i;i<j;i++) {
			int sumOfDigits=sumOfAllDigits(i);
			if(sum==sumOfDigits) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println("total number of possible combinations for sum:"+sum+" is with "+num+" digit combinations are: "+count);
		
		
	}
	
	public static int sumOfAllDigits(int num) {
		int sum=0;
		while(num>0) {
			sum=sum+num%10;
			num=num/10;
		}
		
		return sum;
	}

}
