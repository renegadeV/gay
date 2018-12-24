package cn.edu.zjut.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zjut.discount.IDiscount;
import cn.edu.zjut.po.Address;
import cn.edu.zjut.po.Book;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.OrderItem;
import cn.edu.zjut.po.UserOrder;
import cn.edu.zjut.service.IBookService;
import cn.edu.zjut.service.ICustomerService;
import cn.edu.zjut.service.IOrderService;

public class ShoppingAction extends ActionSupport{
	private Book book;
	private Customer customer;
	private Address address;
	private UserOrder order;
	private List<UserOrder> orders=new ArrayList<UserOrder>(0);
	private OrderItem item;
	private Integer num;
	private IOrderService orderService;
	private List<Book> bookList;
	private ICustomerService customerService=null;
	private IBookService bookService=null;
	private IDiscount discount=null;
	public void setBookList(List<Book> bookList){
		this.bookList=bookList;
	}
	public List<Book> getBookList(){
		return this.bookList;
	}
	public IDiscount getDiscount(){
		return this.discount;
	}
	public void setDiscount(IDiscount discount){
		this.discount=discount;
	}
	public void setOrderService(IOrderService orderService){
		this.orderService=orderService;
	}
	public IOrderService getOrderService(){
		return this.orderService;
	}
	public void setOrders(List<UserOrder> orders){
		this.orders=orders;
	}
	public List<UserOrder> getOrders(){
		return this.orders;
	}
	public ICustomerService getCustomerService(){
		return this.customerService;
	}
	public void setCustomerService(ICustomerService customerService){
		this.customerService=customerService;
	}
	public void setBookService(IBookService bookService){
		this.bookService=bookService;
	}
	public IBookService getBookService(){
		return this.bookService;
	}
	public Address getAddress(){
		return this.address;
	}
	public void setItem(OrderItem item){
		this.item=item;
	}
	public OrderItem getItem(){
		return this.item;
	}
	public Integer getNum(){
		return num;
	}
	public void setNum(Integer num){
		this.num=num;
	}
	public void setAddress(Address address){
		this.address=address;
	}
	public void setBook(Book book){
		this.book=book;
	}
	public Book getBook(){
		return this.book;
	}
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer(){
		return this.customer;
	}
	public void setOrder(UserOrder order){
		this.order=order;
	}
	public UserOrder getOrder(){
		return this.order;
	}
	private Double format(Double value){
		value=(value+0.005)*100;
		Integer b=value.intValue();
		Double a=b/100.0;
		return a;
	}
	//��ȡ�����鱾
	public String getAllBooks(){
		
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.put("discountName", discount.getDiscountName());
		bookList=bookService.getAllBooks();
		return "success";
	}
	//���鼮��ӵ����ﳵ
	public String addtoCart(){
		book=bookService.getBookByID(book.getBookID());
		item=new OrderItem();
		Map<String,Object> session=ActionContext.getContext().getSession();
		UserOrder cart=null;
		if(session.get("cart")==null){
			cart=new UserOrder();
			session.put("cart", cart);
		}
		else{
			cart=(UserOrder)session.get("cart");
		}
		//System.out.println(session.get("cart"));
		for(OrderItem oi:cart.getOrderItem()){
			if(oi.getBook().getBookID().equals(book.getBookID())){
				oi.setNum(oi.getNum()+num);
				oi.setPrice(format(oi.getPrice()+num*book.getPrice()));
				cart.setPrice(format(cart.getPrice()+num*book.getPrice()));
				this.addActionMessage("��ӳɹ��������...");
				return "success";
			}
		}
		item.setBook(book);
		//System.out.println("num:"+num);
		item.setNum(num);
		item.setPrice(format(book.getPrice()*num));
		if(cart.getPrice()==null){
		cart.setPrice(format(num*book.getPrice()));
		}
		else{
			cart.setPrice(format(cart.getPrice()+num*book.getPrice()));
		}
		cart.getOrderItem().add(item);
		cart.setFinalPrice(format(discount.getPrice(cart.getPrice())));
		if(cart.getFinalPrice().equals(cart.getPrice())){
			cart.setDiscountName("���ۿ�");
		}
		else{
			cart.setDiscountName(discount.getDiscountName());
		}
		this.addActionMessage("��ӳɹ��������...");
		return "success";
	}
	//ɾ�����ﳵ
	public String deleteCart(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		order=(UserOrder)session.get("cart");
		for(OrderItem i:order.getOrderItem()){
			if(i.getBook().getBookID().equals(book.getBookID())){
				order.getOrderItem().remove(i);
				order.setPrice(format(order.getPrice()-i.getPrice()));
				order.setFinalPrice(format(discount.getPrice(order.getPrice())));
				if(order.getFinalPrice().equals(order.getPrice())){
					order.setDiscountName("���ۿ�");
				}
				else{
					order.setDiscountName(discount.getDiscountName());
				}
				this.addActionMessage("ɾ���ɹ��������...");
				if(order.getOrderItem().size()==0){
					session.remove("cart");
				}
				
				return "success";
			}
		}
		return "fail";
	}
	//��չ��ﳵ
	public String deleteAllCart(){			
		Map<String,Object> session=ActionContext.getContext().getSession();
		order=(UserOrder)session.get("cart");		//��ȡcart��ֵ
		order.clearCart();		//��������
		return "success";
	}
	//֧�����ﳵ����
	public String pay(){
		Map<String,Object> session=ActionContext.getContext().getSession();//��ȡ�Ự
		order=(UserOrder) session.get("cart");//��ȡ���ﳵ
		customer=(Customer) session.get("loginUser");
		if(order.getAddress()==null){
		for(Address adrs:customer.getAddress()){     //���Ҷ����ջ���ַ
			if(adrs.getAddressID().equals(address.getAddressID()))
			{
				order.setAddress(adrs.getAddress());
				order.setName(adrs.getName());
				order.setZipcode(adrs.getZipcode());
				order.setPhone(adrs.getPhone());
				break;
			}
		}
		}
	//	UserOrder oldCart=new UserOrder();//�ѵ�ǰ���ﳵ����
	//	oldCart=(UserOrder) session.get("cart");
		Book bk=null;
		boolean isEnough=true;//�ж����ﳵ���Ƿ�ÿ����Ʒ���㹻�Ŀ��
		boolean isPriceChanged=false;
		Double allPrice=0.0;
		for(OrderItem oi:order.getOrderItem()){
			bk=bookService.getBookByID(oi.getBook().getBookID());
			if(oi.getNum()>bk.getStockNum()){
				oi.setNum(bk.getStockNum());
				isEnough=false;//���û�����趨Ϊfalse
			}
			if(!format(oi.getBook().getPrice()).equals(format(bk.getPrice())))
				isPriceChanged=true;
			allPrice+=bk.getPrice()*oi.getNum();
			oi.setBook(bk);
			oi.setPrice(format(bk.getPrice()*oi.getNum()));
			oi.setBookPrice(bk.getPrice());
			oi.setBookTitle(bk.getTitle());
		}
		order.setPrice(format(allPrice));
		order.setFinalPrice(format(discount.getPrice(order.getPrice())));
		order.setDiscountName(discount.getDiscountName());
		if(!isEnough){     //�����治���򷵻ؽ��NoEnoughBook
			boolean isNumZero=true;
			while(isNumZero){
				isNumZero=false;
				for(OrderItem oi:order.getOrderItem()){
					if(oi.getNum()==0){
						order.getOrderItem().remove(oi);
						break;
					}
				}
				for(OrderItem oi:order.getOrderItem()){
					if(oi.getNum()==0){
						isNumZero=true;
						break;
					}
				}
			}
			session.put("cart",order);
			this.addActionMessage("��Ʒ��治�㣡���ﳵ�Ѹ��£�");
			return "NoEnoughBook";
		}
		if(format(order.getPrice()).equals(format(order.getFinalPrice()))){
			order.setDiscountName("���ۿ�");
		}
		if(isPriceChanged){
			session.put("cart",order);
			return "CartPriceChanged";
		}
		
		if(format(order.getFinalPrice())>format(customer.getMoney())){
			order.setCustomer(customer);
			order.setOrderState(1);
			customer.getOrders().add(order);
			customerService.update(customer);
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			session.remove("cart");
			//this.addActionMessage("֧��ʧ�ܣ����㡣���������ɡ��ɵ�δ֧�������鿴��֧����");
			return "NoEnoughMoney";
		}
		else{
			customer.setMoney(format(customer.getMoney()-order.getFinalPrice()));
			customer.setUsedMoney(customer.getUsedMoney()+order.getFinalPrice());
			order.setCustomer(customer);
			order.setOrderState(2);
			customer.getOrders().add(order);
			customerService.update(customer);
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			session.remove("cart");
			for(OrderItem item:order.getOrderItem()){
				book=item.getBook();
				book.setStockNum(book.getStockNum()-item.getNum());
				book.setSoldNum(book.getSoldNum()+item.getNum());
				bookService.updateBooks(book);
			}
			this.addActionMessage("֧���ɹ���");
			return "success";
		}
	}
	//֧������
	public String payOrder(){
		System.out.println("payOrder");
		Map<String,Object> session=ActionContext.getContext().getSession();//��ȡ�Ự
		customer=(Customer) session.get("loginUser");//��ȡ��¼�û�
		for(UserOrder uo:customer.getOrders()){
			if(uo.getOrderID().equals(order.getOrderID())){
				order=uo;
				customer.getOrders().remove(uo);
				break;
			}
		}
		Book bk=null;
		boolean isEnough=true;//�ж��������Ƿ�ÿ����Ʒ���㹻�Ŀ��
		boolean isPriceChanged=false;//�ж��������Ƿ�����Ʒ�۸�䶯
		Double allPrice=0.0;
		for(OrderItem oi:order.getOrderItem()){
			bk=bookService.getBookByID(oi.getBook().getBookID());
			if(oi.getNum()>bk.getStockNum()){
				isEnough=false;//���û�����趨Ϊfalse
			}
			if(!format(oi.getBookPrice()).equals(format(bk.getPrice()))){
				oi.setPrice(format(bk.getPrice()*oi.getNum()));
				oi.setBookPrice(format(bk.getPrice()));
				isPriceChanged=true;
			}
			allPrice+=oi.getPrice();
		}
	//	System.out.println("isPriceChanged"+isPriceChanged);
		if(isPriceChanged){
			order.setPrice(format(allPrice));
			order.setFinalPrice(format(discount.getPrice(order.getPrice())));
			order.setDiscountName(discount.getDiscountName());
			customer.getOrders().add(order);
			customerService.update(customer);
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			return "PriceChanged";
		}
		if(!isEnough){     //�����治���򷵻ؽ��NoEnoughBook
			//this.addActionMessage("֧��ʧ�ܣ������еĻ����������㣬������ʧЧ��");
			customerService.update(customer);
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			return "NoEnoughBook";
		}
		if(order.getFinalPrice()>customer.getMoney()){
			this.addActionMessage("֧��ʧ�ܣ����㡣");
			customer.getOrders().add(order);
			return "NoEnoughMoney";
		}
		else{
			customer.setMoney(format(customer.getMoney()-order.getFinalPrice()));
			customer.setUsedMoney(customer.getUsedMoney()+order.getFinalPrice());
			order.setOrderState(2);
			customer.getOrders().add(order);
			customerService.update(customer);
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			for(OrderItem item:order.getOrderItem()){
				book=item.getBook();
				book.setStockNum(book.getStockNum()-item.getNum());
				book.setSoldNum(book.getSoldNum()+item.getNum());
				bookService.updateBooks(book);
			}
			this.addActionMessage("֧���ɹ���");
			return "success";
		}
	}
	//��ʾ����
	public String showOrder(){
		if(order==null){
			order=new UserOrder();
			order.setOrderState(1);
		}
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		customer=customerService.getUpdatedCustomer(customer);
		for(UserOrder odr:customer.getOrders()){
			if(order.getOrderState()==odr.getOrderState()&&order.getOrderState()!=0){
				orders.add(odr);
			}
		}
		session.put("loginUser", customer);
		return "success";
	}
	//ɾ������
	public String delOrder(){
		Map<String,Object> session=ActionContext.getContext().getSession();//��ȡ�Ự
		customer=(Customer) session.get("loginUser");//��ȡ��¼�û�
		for(UserOrder uo:customer.getOrders()){
			if(uo.getOrderID().equals(order.getOrderID())){
				order=uo;
				if(uo.getOrderState()==4)
				{
					//System.out.println(uo.getOrderState());
					uo.setOrderState(0);
					orderService.updateOrder(uo);
					
				}
				else{
				customer.getOrders().remove(uo);
				}
				break;
			}
		}
		customerService.update(customer);
		customer=customerService.getUpdatedCustomer(customer);
		session.put("loginUser", customer);
		return "success";
	}
	//��ʾ���ﳵ
	public String ShowCart(){
		Map<String,Object> session=ActionContext.getContext().getSession();//��ȡ�Ự
		order=(UserOrder) session.get("cart");
		if(order==null){
			return "success";
		}
		Double allPrice=0.0;
		Book bk=null;
		for(OrderItem oi:order.getOrderItem()){
			bk=bookService.getBookByID(oi.getBook().getBookID());
			allPrice+=bk.getPrice()*oi.getNum();
			oi.setPrice(format(bk.getPrice()*oi.getNum()));
			oi.setBook(bk);
		}
		order.setPrice(format(allPrice));
		order.setFinalPrice(format(discount.getPrice(order.getPrice())));
		order.setDiscountName(discount.getDiscountName());
		session.put("cart", order);
		return "success";
	}
	//ȷ���ջ�
	public String finishOrder(){
		if(order==null){
			this.addActionMessage("ȷ���ջ�ʧ�ܣ�δѡ�񶩵���");
			return "fail";
		}
		order=orderService.getOrderByID(order.getOrderID());
		if(order.getOrderState()!=3){
			this.addActionMessage("�ö���״̬�쳣������ȷ���ջ���״̬��:"+order.getOrderState());
		}
		order.setOrderState(4);
		orderService.updateOrder(order);
		return "success";
	}
}
