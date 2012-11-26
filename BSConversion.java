
public class BSConversion {
	
	public char[] hashtagToChar(String hashtag){
		return hashtag.toCharArray();
	}
	
	public void compareTags(String foo, String bar){
		
		int i = 0;
		char1 = foo.charAt(i); char2 = bar.charAt(i);
		while(char1 == char2){
			i++;
			char1 = foo.charAt(i); char2 = bar.charAt(i);
		}
		if (char1 < char2){
			//add left
		}
		else {
			//add right
		}
	}
	
	char char1;
	char char2;
	
	String hashtag;
	
}
