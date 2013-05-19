package resources;

public class SourceFile{
	
	/*
	 * #DocTitle This is document
	 */
	public void commentedMethod(){
		//#DocStart
		System.out.println("Hello Doc Start!");
		//#DocEnd
				
		//#DocStart
		System.out.println("Hello Doc Start2!");
		//#DocEnd
		
		//#DocStart
		System.out.println("Hello Doc Start3!");
		//#DocEnd
	}
}