package junk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public void save(Student stu) {
		studentRepository.save(stu);
	}

	public void remove(Student stu) {
		studentRepository.delete(stu);
	}

}

