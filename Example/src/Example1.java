public class Example1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int i=2;
		if (i>0) {

		} else if(i>4){
			
		}else {

		}
		String str="xyz";
		switch(i){
		case 5:
			System.out.println("i");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		case 4:
			System.out.println("4");
			break;
		default:
			System.out.println("default ");
		}
		
		
		for(int j=0;j<10;j++){
			for(int k=0;k<=j;k++){
				System.out.print("*");
			}
			System.out.println();
		}
		int l=0;
		l=l+5;
		l=l-3;
		l=l+2;
		
		
		while(l<10){
			System.out.println(l);
			
			l++;
		}
		
		/*
		 0
		 01
		 012
		 0123
		 */
		/*
		 01234
		 0123
		 012
		 01
		 0
		 */
		
	}
}
