package support.training.spring;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service("student")
public class Student {
	public String sname;
   
	public int sno;
	
    public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSno() {
		return sno;
	}
	 public void setSno(int sno) {
			this.sno = sno;
		}
    public void result()
    {
    	System.out.println("Student name is" +getSname()+ "\n Student roll no : " +getSno());
    }

}
