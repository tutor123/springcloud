package onlineshop.order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import static org.mockito.Mockito.*;
import onlineshop.order.models.Item;
import onlineshop.order.client.ItemClient;

import org.junit.Before;

import org.junit.Test;

public class ItemClientTest {

@InjectMocks
ItemClient ic;
@Mock
RestTemplate restTemplate;



	@Before
	public void initMocks() {
	MockitoAnnotations.initMocks(this);
	//this.ic = new ItemClient(this.restTemplate);
	}

	@Test
	public void testItemClientGetAll() {
		Item[] it = new Item[1];
		
		Mockito.when(restTemplate.getForObject("http://localhost:8082/item/list", Item[].class)).thenReturn(it);
		Assert.assertEquals(ic.getAll().size(), it.length);

	}
	@Test
	public void testItemClientGetByName() {
		Item it= new Item("test",30f);
		Mockito.when(restTemplate.getForObject("http://localhost:8082/item/list", Item.class)).thenReturn(it);
		Assert.assertEquals(ic.getByName("test").getName(),"test");
	}

}
