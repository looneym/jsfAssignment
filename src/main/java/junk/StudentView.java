package junk;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import java.util.List;

import javax.annotation.PostConstruct;

@ManagedBean
@ApplicationScoped
public class StudentView {
	
   
	@ManagedProperty("#{studentService}")
    private StudentService store;
	private List<Student> students;
  
   

	
	public StudentService getStore() {
		return store;
	}


	public void setStore(StudentService store) {
		this.store = store;
	}


	public List<Student> getStudents() {
		students = store.findAll();
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public String add(){
		store.save(student);
		System.out.println(" saved student: "+student.toString());
		student = new Student();
    	System.out.println("add to store");
    	return "./output.xhtml";
    }
	
	private Student student;
    
    @PostConstruct
    public void makeStudent(){
    	System.out.println("YOU HAVE RUN StudentView !!!!!!!!!!!!!!!!!!!!!!!! ");
    	student = new Student();
    	System.out.println("postconstruct student");
    	students = store.findAll();
    }
    
    public void remove(Student s) {
		store.remove(s);
		students = store.findAll();
		FacesContext.getCurrentInstance().addMessage
			(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Student removed!", null));
	}
    
    public Student getStudent() {
		return student;
	}

    

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
}