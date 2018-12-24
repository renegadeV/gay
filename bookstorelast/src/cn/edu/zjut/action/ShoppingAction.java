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
	//获取所有书本
	public String getAllBooks(){
		
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.put("discountName", discount.getDiscountName());
		bookList=bookService.getAllBooks();
		return "success";
	}
	//将书籍添加到购物车
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
				this.addActionMessage("添加成功！请继续...");
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
			cart.setDiscountName("无折扣");
		}
		else{
			cart.setDiscountName(discount.getDiscountName());
		}
		this.addActionMessage("添加成功！请继续...");
		return "success";
	}
	//删除购物车
	public String deleteCart(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		order=(UserOrder)session.get("cart");
		for(OrderItem i:order.getOrderItem()){
			if(i.getBook().getBookID().equals(book.getBookID())){
				order.getOrderItem().remove(i);
				order.setPrice(format(order.getPrice()-i.getPrice()));
				order.setFinalPrice(format(discount.getPrice(order.getPrice())));
				if(order.getFinalPrice().equals(order.getPrice())){
					order.setDiscountName("无折扣");
				}
				else{
					order.setDiscountName(discount.getDiscountName());
				}
				this.addActionMessage("删除成功！请继续...");
				if(order.getOrderItem().size()==0){
					session.remove("cart");
				}
				
				return "success";
			}
		}
		return "fail";
	}
	//清空购物车
	public String deleteAllCart(){			
		Map<String,Object> session=ActionContext.getContext().getSession();
		order=(UserOrder)session.get("cart");		//获取cart的值
		order.clearCart();		//函数调用
		return "success";
	}
	//支付购物车订单
	public String pay(){
		Map<String,Object> session=ActionContext.getContext().getSession();//获取会话
		order=(UserOrder) session.get("cart");//获取购物车
		customer=(Customer) session.get("loginUser");
		if(order.getAddress()==null){
		for(Address adrs:customer.getAddress()){     //查找订单收货地址
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
	//	UserOrder oldCart=new UserOrder();//把当前购物车保存
	//	oldCart=(UserOrder) session.get("cart");
		Book bk=null;
		boolean isEnough=true;//判定购物车中是否每件商品有足够的库存
		boolean isPriceChanged=false;
		Double allPrice=0.0;
		for(OrderItem oi:order.getOrderItem()){
			bk=bookService.getBookByID(oi.getBook().getBookID());
			if(oi.getNum()>bk.getStockNum()){
				oi.setNum(bk.getStockNum());
				isEnough=false;//如果没有则设定为false
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
		if(!isEnough){     //如果库存不足则返回结果NoEnoughBook
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
			this.addActionMessage("商品库存不足！购物车已更新！");
			return "NoEnoughBook";
		}
		if(format(order.getPrice()).equals(format(order.getFinalPrice()))){
			order.setDiscountName("无折扣");
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
			//this.addActionMessage("支付失败！余额不足。订单已生成。可到未支付订单查看或支付。");
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
			this.addActionMessage("支付成功！");
			return "success";
		}
	}
	//支付订单
	public String payOrder(){
		System.out.println("payOrder");
		Map<String,Object> session=ActionContext.getContext().getSession();//获取会话
		customer=(Customer) session.get("loginUser");//获取登录用户
		for(UserOrder uo:customer.getOrders()){
			if(uo.getOrderID().equals(order.getOrderID())){
				order=uo;
				customer.getOrders().remove(uo);
				break;
			}
		}
		Book bk=null;
		boolean isEnough=true;//判定订单中是否每件商品有足够的库存
		boolean isPriceChanged=false;//判定订单中是否有商品价格变动
		Double allPrice=0.0;
		for(OrderItem oi:order.getOrderItem()){
			bk=bookService.getBookByID(oi.getBook().getBookID());
			if(oi.getNum()>bk.getStockNum()){
				isEnough=false;//如果没有则设定为false
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
		if(!isEnough){     //如果库存不足则返回结果NoEnoughBook
			//this.addActionMessage("支付失败，订单中的货物数量不足，订单已失效！");
			customerService.update(customer);
			customer=customerService.getUpdatedCustomer(customer);
			session.put("loginUser", customer);
			return "NoEnoughBook";
		}
		if(order.getFinalPrice()>customer.getMoney()){
			this.addActionMessage("支付失败！余额不足。");
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
			this.addActionMessage("支付成功！");
			return "success";
		}
	}
	//显示订单
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
	//删除订单
	public String delOrder(){
		Map<String,Object> session=ActionContext.getContext().getSession();//获取会话
		customer=(Customer) session.get("loginUser");//获取登录用户
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
	//显示购物车
	public String ShowCart(){
		Map<String,Object> session=ActionContext.getContext().getSession();//获取会话
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
	//确认收货
	public String finishOrder(){
		if(order==null){
			this.addActionMessage("确认收货失败！未选择订单！");
			return "fail";
		}
		order=orderService.getOrderByID(order.getOrderID());
		if(order.getOrderState()!=3){
			this.addActionMessage("该订单状态异常！不能确认收货！状态码:"+order.getOrderState());
		}
		order.setOrderState(4);
		orderService.updateOrder(order);
		return "success";
	}
}
