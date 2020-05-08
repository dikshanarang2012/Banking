package com.cts.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.TransactException;
import com.cts.model.Transact;
import com.cts.service.TransactService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
public class TransactController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	TransactService service;
	
	@GetMapping("/transaction")
	
	@ApiOperation(value = "Find All Transactions",
	notes="Return all transaction with there details",
	response = Transact.class)
	public List<Transact> getAllTransaction() {
		logger.info("{}",service.getAllTransact());
	    return service.getAllTransact();
	}
	
	@ApiOperation(value = "Update All Transactions",
			notes="Put new transaction into the List",
			response = Transact.class)
	@PostMapping("/transaction")
	
	public Transact createTransaction(@Valid @RequestBody Transact transact) {
		
	    return service.saveTransact(transact);
	}
	
	@ApiOperation(value = "Find Transactions from the List",
			notes="Use transaction Id for Searching",
			response = Transact.class)
	@GetMapping("/transaction/{id}")
	public Transact getById(@PathVariable(value = "id") Long id) {
		logger.info("{ }", service.getAllTransact(id));
	    return service.getById(id)
	            .orElseThrow(() -> new TransactException("Transact", "id", id));
	}
	
	@ApiOperation(value = "Delete Transactions from List",
			notes="Delete Existing transaction from the List",
			response = Transact.class)
	@DeleteMapping("/transaction/{id}")
	public ResponseEntity<?> deleteId(@PathVariable(value = "id") Long id) {
		Transact transact = service.getById(id)
	            .orElseThrow(() -> new TransactException("Transact", "id", id));

		service.deleteTransact(id);

	    return ResponseEntity.ok().build();
	}

}
