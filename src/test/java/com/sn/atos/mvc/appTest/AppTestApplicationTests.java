package com.sn.atos.mvc.appTest;

import com.sn.atos.mvc.appTest.entities.Product;
import com.sn.atos.mvc.appTest.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppTestApplicationTests {

	@MockBean
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void init(){
		//productRepository.save(new Product("Iphone 10", "Telephone", 10000));
		//productRepository.save(new Product("Iphone 13", "Telephone", 10000));
	}



	public void saveProduct(){
		Product product = productRepository.save(new Product("Iphone 12", "Telephone", 10000));

		Assertions.assertThat(product).hasFieldOrPropertyWithValue("name", "Iphone 12");
	}

	@Test
	public void getProduct(){

		Product p = new Product("Iphone 13", "Telephone", 10000);
		p.setId(1L);
		when(productRepository.save(p)).thenReturn(p);
		List<Product> productList = productRepository.findByNameQuery("Iphone 13");

		Assertions.assertThat(productList).isNotNull();
		Assertions.assertThat(productList.size()).isEqualTo(2);

	}




}
