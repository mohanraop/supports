
public class Shopping {

	String mallName;
	String mallCity;
	int mallDIstance;

	public void setmallName (String mn){
		this.mallName=mn;
	}
	public String getmallName(){
		return this.mallName;
		
	}
	public void setmallCity (String MC){
		this.mallCity=MC;
		
	}
	public String getmallCity(){
		return this.mallCity;
		
	}
	public void setmallDistance (int MD){
		this.mallDIstance=MD;
		
	}
	public int getmallDistance(){
		return this.mallDIstance;
		
	}
	public static void main(String[] args) {
		Shopping sh = new Shopping();
		sh.mallCity="herndon";
		sh.mallName="tyson";
		sh.mallDIstance=123;
		
		System.out.println(sh.mallCity);
		System.out.println(sh.mallName);
		System.out.println(sh.mallDIstance);
		
		
			
		
	}
}
