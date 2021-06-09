import java.util.HashMap;
import java.util.Map;

public class DupWordsInString {
	public static void main(String[] args) {
		String str="Hello java, java is java program java is OOPS based";
		String str1[]= str.split(" ");
		Map<String, Integer> words=new HashMap<String, Integer>();
		for(String word:str1) {
			if(words.containsKey(word)) {
				words.put(word, words.get(word)+1);
			}
			else {
				words.put(word, 1);
			}
			
		}
		
		System.out.println(words);
	}

}
