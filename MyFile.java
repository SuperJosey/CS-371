
public class MyFile {
	
	public static String MyFileText;
	public static boolean isScrolling = false;
	public static boolean isLoaded = false;
	
	public static void setMyFileText(String s){
		
		//Setting the text from the file into a String
		MyFileText = s;
		
		//If the text put in the String is not null
		if(MyFileText != null){
			
			isLoaded = true; //Then the file have been loaded into the program's memory
			isScrolling = true; //Then we consider that the text is scrolling
		}
		else{
			
			isLoaded = false;
			
		}
		
	}
	
	public static void SetIsScrolling(boolean b){
		isScrolling = b;
	}
	
	
}
