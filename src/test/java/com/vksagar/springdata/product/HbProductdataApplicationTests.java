package com.vksagar.springdata.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.vksagar.springdata.product.entities.Address;
import com.vksagar.springdata.product.entities.Card;
import com.vksagar.springdata.product.entities.Cheque;
import com.vksagar.springdata.product.entities.Customer;
import com.vksagar.springdata.product.entities.Employee;
import com.vksagar.springdata.product.entities.Image;
import com.vksagar.springdata.product.entities.License;
import com.vksagar.springdata.product.entities.Person;
import com.vksagar.springdata.product.entities.PhoneNumber;
import com.vksagar.springdata.product.entities.Product;
import com.vksagar.springdata.product.entities.Programmer;
import com.vksagar.springdata.product.entities.Project;
import com.vksagar.springdata.product.repos.CardRepository;
import com.vksagar.springdata.product.repos.CustomerRepository;
import com.vksagar.springdata.product.repos.EmployeeRepository;
import com.vksagar.springdata.product.repos.ImageRepository;
import com.vksagar.springdata.product.repos.LicenseRepository;
import com.vksagar.springdata.product.repos.PaymentRepository;
import com.vksagar.springdata.product.repos.ProductRepository;
import com.vksagar.springdata.product.repos.ProgrammerRepository;
import com.vksagar.springdata.product.service.BankAccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HbProductdataApplicationTests {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Autowired
	LicenseRepository licenseRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	BankAccountService bankAccountService;
	
	@Autowired
	ImageRepository imageRepository;
	
	@Test
	public void contextLoads() {
	}

	/*
	@Test
	public void testCreate() {
		Product product = new Product();
		//product.setId(2);
		product.setName("One Plus three");
		product.setDesc1("Nice phone");
		product.setPrice(28000d);
		
		productRepository.save(product);
	}
	
	
	@Test
	public void testRead() {
		Product product = productRepository.findById(1).get();
		
		System.out.println("*******************************"+product.toString());
	}
	
	@Test
	public void testUpdate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Samsung Galaxy");
		product.setDesc("Awesome");
		product.setPrice(50000d);
		
		productRepository.save(product);
	}
	
	@Test
	public void testDelete() {
		if(productRepository.existsById(0))
			productRepository.deleteById(0);;
	}
	
	
	@Test
	public void testCount() {
		long count = productRepository.count();
		System.out.println("Total products: "+count);
	}
	
	@Test
	public void testFindByName() {
		
		
		List<Product> products = productRepository.findByName("Iphone X");
		products.forEach(p->System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByNameAndDesc() {
		
		
		List<Product> products = productRepository.findByNameAndDesc("Moto G5 Plus", "Great");
		products.forEach(p->System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreaterThan() {
		
		
		List<Product> products = productRepository.findByPriceGreaterThan(1000d);
		products.forEach(p->System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByDescContains() {
		
		
		List<Product> products = productRepository.findByDescContains("phone");
		products.forEach(p->System.out.println("testFindByDescContains - "+p.getName()));
	}
	
	
	@Test
	public void testFindByPriceBetween() {
		
		
		List<Product> products = productRepository.findByPriceBetween(18000d, 70000d);
		products.forEach(p->System.out.println("testFindByPriceBetween - "+p.getName()));
	}
	
	
	@Test
	public void testFindByDescLike() {
		
		
		List<Product> products = productRepository.findByDescLike("A%");
		products.forEach(p->System.out.println("testFindByDescLike - "+p.getName()));
	}
	
	@Test
	public void testFindAllPaging() {
		Pageable pageable = new PageRequest(3, 2);
		
		Page<Product> products = productRepository.findAll(pageable);
		products.forEach(p->System.out.println("testFindAllPaging - "+p.getName()));
	}
	
	
	@Test
	public void testFindAllSorting() {
		productRepository.findAll(new Sort(Direction.DESC,"price")).forEach(p->System.out.println("testFindAllSorting: "+p.getName()));
	}
	
	
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = new PageRequest(0, 1, Direction.DESC, "name");
		
		Page<Product> products = productRepository.findAll(pageable);
		products.forEach(p->System.out.println("testFindAllPagingAndSorting - "+p.getName()));
	}
	
	
	@Test
	public void testFindAllProducts() {
		List<Product> products = productRepository.findAllProducts();
		//Page<Product> products = productRepository.findAll(pageable);
		products.forEach(p->System.out.println("testFindAllProducts - "+p.getName()));
	}
	
	
	@Test
	public void testFindAllProductsPartialData() {
		List<Object[]> findAllProductsPartialData = productRepository.findAllProductsPartialData();
		System.out.println("findAllProductsPartialData: "+findAllProductsPartialData);
		
		findAllProductsPartialData.forEach(obj->System.out.println(obj[0] +"  -  "+obj[1]));
	}
	
	
	@Test
	public void testFindAllProductsByName() {
		System.out.println("In testFindAllProductsByName()");
		List<Product> products = productRepository.findAllProductsByName("Samsung j7");
		products.forEach(p->System.out.println("testFindAllProductsByName - "+p.getName()));
	}
	
	@Test
	@Transactional	//for DML operation
	@Rollback(false)	//false - delete operation will not rollback
	public void testDeleteProductByName() {
		productRepository.deleteProductByName("Samsung j7");
	}
	
	
	@Test
	public void testFindAllProductsNQ() {
		List<Product> products = productRepository.findAllProductsNQ();
		products.forEach(p->System.out.println("testFindAllProductsNQ - "+p.getName()));
	}
	
	
	@Test
	public void testFindProductByNameNQ() {
		List<Product> products = productRepository.findProductsByNameNQ("Iphone X");
		products.forEach(p->System.out.println("testFindProductByNameNQ - "+p.getName()));
	}
	
	
	
	@Test
	public void testInsertCardPayment() {
		Card card = new Card();
		card.setId(1);
		card.setAmount(1000d);
		card.setCardNumber("876530036654");
		paymentRepository.save(card);
		
		Cheque cheque = new Cheque();
		cheque.setId(2);
		cheque.setAmount(1500d);
		cheque.setChequeNumber("334665888999");
		paymentRepository.save(cheque);
	}
	
	
	
	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Vikram");
		
		Address address = new Address();
		address.setStreetaddress("rammandir road");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("INDIA");
		address.setZipcode("400086");
		
		employee.setAddress(address);
		employeeRepository.save(employee);
	}
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Sansa Strak");
		Set<PhoneNumber> phoneNumbers = new HashSet<>();
		
		PhoneNumber ph1= new PhoneNumber();
		ph1.setPhonenumber("9860909206");
		ph1.setType("Mobile");
		ph1.setCustomer(customer);
		phoneNumbers.add(ph1);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhonenumber("022-22299911");
		ph2.setType("Work");
		ph2.setCustomer(customer);
		phoneNumbers.add(ph2);
		
		PhoneNumber ph3 = new PhoneNumber();
		ph3.setPhonenumber("022-22299911");
		ph3.setType("Office");
		ph3.setCustomer(customer);
		phoneNumbers.add(ph3);
		
		customer.setNumbers(phoneNumbers);
		
		customerRepository.save(customer);
	}
	
	
	@Test
	public void testReadCustomer() {
		Customer customer = customerRepository.findById(1L).get();
		System.out.println("Cust Name: "+customer.getName());
		System.out.println("Cust Data: "+customer.toString());
	}
	
	
	@Test
	public void testManyToManyCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("Jon");
		programmer.setSalary(100000);
		
		Set<Project> projects = new HashSet<>();
		
		Project project1 = new Project();
		project1.setName("Whitewalker");
		projects.add(project1);
		
		Project project2 = new Project();
		project2.setName("Win Iron Throne");
		projects.add(project2);
		
		programmer.setProjects(projects);
		
		programmerRepository.save(programmer);
	}
	
	
	@Test
	public void testManyToManyReadProgrammer() {
		Programmer programmer = programmerRepository.findById(3).get();
		System.out.println("Programmer data : "+programmer.getName());
		programmer.getProjects().forEach(p->System.out.println(p.getName()));
	}
	
	
	@Test
	public void testOneToOneCreateLicense() {
		License license = new License();
		license.setType("CAR");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person = new Person();
		person.setFirstname("Vikram");
		person.setLastname("Kshirsagar");
		person.setAge(26);
		license.setPerson(person);
		
		licenseRepository.save(license);
	}
	
	
	@Test
	public void testOneToOneReadLicense() {
		License license = licenseRepository.findById(1L).get();
		
		System.out.println("License data : "+license.getType());
		System.out.println("Person data : "+license.getPerson().getFirstname());
	}
	
	
	@Test
	@org.springframework.transaction.annotation.Transactional
	public void testFindProductCaching() {
		Session unwrap = entityManager.unwrap(Session.class);
		Product product = productRepository.findById(1).get();

		productRepository.findById(1);
		unwrap.evict(product); 	//remove from level-1 cache
		//@Cache annotated to Product means level-2 cache is enabled
		productRepository.findById(1);
	}
	
	
	@Test
	public void testTransactionMoneyTransfer() {
		bankAccountService.transfer(500);
	}
	
	*/
	
	@Test
	public void testInsertImage() {
		Image image = new Image();
		image.setId(2L);
		image.setName("Test.jpg");
		
		File file = new File("C:\\Users\\Vikram\\Downloads\\hibernate.jpg");
		byte[] content = new byte[(int) file.length()];
		FileInputStream fileInputStream=null;
		try {
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(content);
			image.setData(content);
			imageRepository.save(image);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fileInputStream != null)
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		image.setData(content);
		
	}
	
	@Test
	public void testReadImage() {
		Image image = imageRepository.findById(1L).get();
	
		String imagepath = "C:\\Users\\Vikram\\Downloads\\";
		
		File file = new File(imagepath+image.getName());
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(file);
			outputStream.write(image.getData());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
