public class Sum {
	public static void main(String[] args) {
		Report report = new Report();
		report.setSubject("amar");
		report.setMarks(12);

		System.out.println(report.getsubject());
		System.out.println(report.getmarks());
		
		int i=10;
		int j=20;
		int a=i=j;
		System.out.println(a);
		System.out.println(i);
		System.out.println(j);
			{
			float f=i;
			//i=f;
			
			System.out.println( i==20 && j==30);
			
			}
			
		if(i==20)
			System.out.println("true");
		else
			System.out.println("false");
		
		for(int index=i;index<100;index++){
			System.out.println(index);
		}
		
		for(int p=1;p<5;p++){
			System.out.println(p);
		}
		
		
		int ind=0;
		while(i<100000){
			System.out.println(i);
			if(i==500)
				break;
			i++;
		}
		System.out.println("**********************");
		
		i=10;
		while(i<100){
			if(i%2==0){
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
		
		
		
		/*
		*
		**
		***
		****
		*****
		******
		*******
		*/
	}
}
