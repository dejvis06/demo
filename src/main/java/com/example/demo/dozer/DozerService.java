package com.example.demo.dozer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dozer.entity.Person;
import com.example.demo.dozer.entity.Personne;
import com.github.dozermapper.core.Mapper;

@Service
public class DozerService {

	@Autowired
	private Mapper mapper;

	// Properties that are of the same name do not need to be specified in the
	// mapping XML file,
	// dozer.mapping-files=classpath:templates/dozer/dozer_mapping.xml -> file for
	// mapping in app properties

	public void convertPersonneToPerson() throws Exception {

		Person person = new Person();
		mapper.map(new Personne("name", "surname", 10), person);

		System.err.println(person.toString());
	}

}
