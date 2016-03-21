package junk;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InitDbService {

	@Autowired
	private StudentRepository studentRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
		{
			Student a = new Student();
			a.setName("joe");
			a.setAddress("cork");
			studentRepository.save(a);
		}
		{
			Student a = new Student();
			a.setName("mary");
			a.setAddress("dublin");
			studentRepository.save(a);
		}
		System.out.println("*** INIT DATABASE FINISH ***");
	}
}
