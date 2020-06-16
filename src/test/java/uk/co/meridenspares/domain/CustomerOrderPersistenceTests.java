package uk.co.meridenspares.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import uk.co.meridenspares.domain.CustomerOrder;
import uk.co.meridenspares.domain.OrderItem;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerOrderPersistenceTests {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	public void testSaveCustomerOrderWithItems() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		CustomerOrder order = new CustomerOrder();
		order.getItems().add(new OrderItem());
		session.save(order);
		session.flush();
		assertNotNull(order.getId());
	}

	@Test
	@Transactional
	public void testSaveAndGet() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		CustomerOrder order = new CustomerOrder();
		order.getItems().add(new OrderItem());
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing customer order (and we didn't set the
		// parent in the item)...
		session.clear();
		CustomerOrder other = (CustomerOrder) session.get(CustomerOrder.class, order.getId());
		assertEquals(1, other.getItems().size());
		assertEquals(other, other.getItems().iterator().next().getCustomerOrder());
	}

	@Test
	@Transactional
	public void testSaveAndFind() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		CustomerOrder order = new CustomerOrder();
		order.getItems().add(new OrderItem());
		session.save(order);
		session.flush();
		// Otherwise the query returns the existing customer order (and we didn't set the
		// parent in the item)...
		session.clear();
//		CustomerOrder other = (CustomerOrder) session
//				.createQuery( "select o from CustomerOrder o join o.items i where i.item=:item")
//				.setString("product", "foo").uniqueResult();
//		assertEquals(1, other.getItems().size());
//		assertEquals(other, other.getItems().iterator().next().getCustomerOrder());
	}

}
