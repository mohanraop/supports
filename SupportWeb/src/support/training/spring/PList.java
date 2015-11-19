package support.training.spring;

public class PList {
	
    public Project PA;
    public Project PB;
	
	public Project getPA() {
		return PA;
	}
	
	public void setPA(Project pA) {
		PA = pA;
	}
	
	public Project getPB() {
		return PB;
	}
	
	public void setPB(Project pB) {
		PB = pB;
	}

	public void values()
	{
		System.out.println("Name of First Project is : "+getPA().getPname()+
				"\n Duration is\t" +getPA().getPduration()+
				"\n Name of Second Project is : " +getPB().getPname()+
				"\n Duration is\t" +getPB().getPduration());
	
}
}