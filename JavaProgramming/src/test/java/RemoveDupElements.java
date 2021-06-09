
public class RemoveDupElements {
	
	public static void main(String[] args) {
		String s1="Hello 123 456";
		String s2="Hello 456";
		//String replaceStr = null;
		String s3[]=s2.split(" ");
		for(int i=0;i<s3.length;i++) {
		s1=s1.replace(s3[i], "");
		
		}
		System.out.println(s1);
	}

}
