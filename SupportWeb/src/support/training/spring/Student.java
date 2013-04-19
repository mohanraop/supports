package support.training.spring;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("student")

public class Student {
	
	public String sname;
    public String cname;
	public int sno;
	
	public Student(String cname)
	{
		this.cname=cname;
	}
    public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getCname() {
		return cname;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getSno() {
		return sno;
	}
	 public void setSno(int sno) {
			this.sno = sno;
		}
    public void result()
    {
    	System.out.println("Student name is : " +getSname()+ "\n Student roll no  : " +getSno()+"\n student class name is : " +getCname()
    			);
    }

}
