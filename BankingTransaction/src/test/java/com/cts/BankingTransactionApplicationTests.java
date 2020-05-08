package com.cts;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.model.Transact;
import com.cts.repository.TransactRepository;
import com.cts.service.TransactService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BankingTransactionApplicationTests {

	@MockBean
	 TransactRepository repository;
	
	@Autowired
	 TransactService service;
	
	
	//test case for getAllTransact
	
	@Test
	public void getAllTransactTest()
	 {
		when(repository.findAll()).thenReturn(Stream.of(new Transact(10l,1000d)).collect(Collectors.toList()));
		assertEquals(1,service.getAllTransact().size());
	}
	
	
	//test case for save transaction
	@Test
	public void saveTransactTest()
	{
		Transact transact=new Transact(12,1000);
		when(repository.save(transact)).thenReturn(transact);
		assertEquals(transact,service.saveTransact(transact));
	}
	

	//test case for delete
/**	@Test
	
		public void deleteTransactTest()
	{
		Transact transact = new Transact(13,1500);
		service.deleteTransact(transact.deleteById());
		verify(repository,times(1)).delete(transact);
	}
	**/
}

