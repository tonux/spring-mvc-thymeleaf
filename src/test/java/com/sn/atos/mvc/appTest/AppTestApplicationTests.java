package com.sn.atos.mvc.appTest;

import com.sn.atos.mvc.appTest.entities.Product;
import com.sn.atos.mvc.appTest.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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


	public void getProduct(){

		productRepository.save(new Product("Iphone 13", "Telephone", 10000));
		List<Product> productList = productRepository.findByName("Iphone 13");

		Assertions.assertThat(productList).isNotNull();
		Assertions.assertThat(productList.size()).isEqualTo(1);

	}




}
