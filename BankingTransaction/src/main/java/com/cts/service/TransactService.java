package com.cts.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Transact;
import com.cts.repository.TransactRepository;

@Service
@Transactional
public class TransactService implements ITransactService {
	
	@Autowired
	TransactRepository repository;
	
	public List<Transact> getAllTransact(){
		return (List<Transact>) repository.findAll();
	}
	
	public Transact saveTransact(Transact transact) {
		return repository.save(transact);
	}
	
	public Optional<Transact> getById(Long id) {
		return repository.findById(id);
	}
	
	public void deleteTransact(Long id) {
		repository.deleteById(id);
	}

	public Object getAllTransact(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
