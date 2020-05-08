package com.cts.service;

import java.util.List;
import java.util.Optional;

import com.cts.model.Transact;

public interface ITransactService {

	public List<Transact> getAllTransact();
	public Transact saveTransact(Transact transact);
	public Optional<Transact> getById(Long id);
	public void deleteTransact(Long id);
}
