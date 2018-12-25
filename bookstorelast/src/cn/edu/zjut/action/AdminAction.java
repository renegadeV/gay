package cn.edu.zjut.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zjut.po.Admin;
import cn.edu.zjut.po.Category;
import cn.edu.zjut.po.CategorySecond;
import cn.edu.zjut.po.Customer;
import cn.edu.zjut.po.MoneyCard;
import cn.edu.zjut.po.UserOrder;
import cn.edu.zjut.service.IAdminService;
import cn.edu.zjut.service.IOrderService;

public class AdminAction extends BookAction{
	private IAdminService adminService=null;
	public IOrderService orderService=null;
	private Admin admin;
	private Double money;
	private Customer customer;
	private UserOrder order;
	private Integer num;
	private MoneyCard moneyCard;
	private List<UserOrder> orders;
	private List<MoneyCard> newcards;
	private Category category;
	private CategorySecond categorySecond;
	protected List<Category> categoryList;
	protected List<CategorySecond> secondcategoryList;
	public List<CategorySecond> getSecondcategoryList() {
		return secondcategoryList;
	}
	public void setSecondcategoryList(List<CategorySecond> secondcategoryList) {
		this.secondcategoryList = secondcategoryList;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public Category getCategory() {
		return category;
	}
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond=categorySecond;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setMoneyCard(MoneyCard moneyCard){
		this.moneyCard=moneyCard;
	}
	public MoneyCard getMoneyCard(){
		return this.moneyCard;
	}
	public void setOrder(UserOrder order){
		this.order=order;
	}
	public UserOrder getOrder(){
		return this.order;
	}
	public Customer getCustomer(){
		return this.customer;
	}
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	public List<UserOrder> getOrders(){
		return this.orders;
	}
	public void setOrders(List<UserOrder> orders){
		this.orders=orders;
	}
	public void setOrderService(IOrderService orderService){
		this.orderService=orderService;
	}
	public IOrderService getOrderService(){
		return this.orderService;
	}
	public List<MoneyCard> getNewcards(){
		return newcards;
	}
	public void setNewCards(List<MoneyCard> cards){
		this.newcards=cards;
	}
	public void setMoney(Double money){
		this.money=money;
	}
	public Double getMoney(){
		return this.money;
	}
	public void setNum(Integer num){
		this.num=num;
	}
	public Integer getNum(){
		return this.num;
	}
	public void setAdmin(Admin admin){
		this.admin=admin;
	}
	public Admin getAdmin(){
		return this.admin;
	}
	public IAdminService getAdminService(){
		return this.adminService;
	}
	public void setAdminService(IAdminService adminService){
		this.adminService=adminService;
	}
	public String login(){
		if(adminService.login(admin.getAccount(), admin.getPassword()))
		{
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("admin", admin);
			return "success";
		}
		this.addActionMessage("登陆失败！用户名或密码错误！");
		return "fail";
	}
	public String logout(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("admin");
		return "success";
	}
	//更新书籍
	public String updateBook(){
		if(islogin()||getRight(0)){
		bookService.updateBooks(book);
		bookList=bookService.getAllBooks();
		this.addActionMessage("修改成功！请继续...");
		return "success";
		}
		return "fail";
	}
	//删除书籍
	public String deleteBook(){
		if(islogin()||getRight(0)){
			book=bookService.getBookByID(book.getBookID());
			book.setStockNum(-999);
			bookService.deleteBooks(book);
			bookList=bookService.getAllBooks();
			this.addActionMessage("删除成功！该书本已对用户不可见，请继续...");
			return "success";
		}
		return "fail";
	}
	//增加书籍
	public String addBook(){
		if(islogin()||getRight(0)){
			book.setSoldNum(0);
			bookService.addBooks(book);
			return "success";
		}
		this.addActionMessage("添加失败！");
		return "fail";
	}
	//增加大类别
	public String addCategory() {
		if(islogin()||getRight(1)){
			categoryService.save(category);
			ActionContext.getContext().getValueStack().set("cList", categoryList);
			return "success";
		}
		this.addActionMessage("添加失败！");
		return "fail";
	}
	//删除大类别
	public String deleteCategory(){
		if(islogin()||getRight(1)){
			category=categoryService.findByCid(category.getCid());
			categoryService.delete(category);
			categoryList=categoryService.findAll();
			this.addActionMessage("删除成功！请继续...");
			return "success";
		}
		this.addActionMessage("添加失败！");
		return "fail";
	}
	//删除用户
	public String deleteCustomer() {
		customer=adminService.FindCustomerByCustomerID(customer.getCustomerID());
		adminService.deleteCustomer(customer);
		categoryList=categoryService.findAll();
		this.addActionMessage("删除成功！请继续...");
		return "success";
	}
	//删除小分类
	public String deleteSecondCategory() {
		categorySecond=categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		secondcategoryList=categorySecondService.findAll();
		this.addActionMessage("删除成功！请继续...");
		return "success";
	}
	//更新大类别
	public String updateCategory(){
		if(islogin()||getRight(1)){
			categoryService.update(category);
			categoryList=categoryService.findAll();
		this.addActionMessage("修改成功！请继续...");
		return "success";
		}
		return "fail";
	}
	//更新小分类
	public String updateSecondCategory() {
		if(islogin()||getRight(2)){
			categorySecond.setCategory(category);
			categorySecondService.update(categorySecond);
			secondcategoryList=categorySecondService.findAll();
		this.addActionMessage("修改成功！请继续...");
		return "success";
		}
		return "fail";
	}
	//生产充值卡
	public String produceMoneyCard(){
		if(islogin()||getRight(4)){
			newcards=adminService.produceMoneyCard(money, num);
			this.addActionMessage("购物卡批量生产成功！");
			for(MoneyCard card:newcards){
			//System.out.println(card.getMoneyCardID()+":"+card.getPassword());
			}
			return "success";
		}
		return "fail";
	}
	//判断登陆
	private boolean islogin(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		if(session.get("admin")==null){
			return false;
		}
		return true;
	}
	//获取权限码
	private boolean getRight(Integer i){
		Integer rightCode=0;;
		Map<String,Object> session=ActionContext.getContext().getSession();
		customer=(Customer) session.get("loginUser");
		if(customer.getRole()!=null)
			rightCode=customer.getRole().getRightCode();
		//右移几位判断是否有权限
		if(session.get("loginUser")==null || (rightCode>>i)%2==0){	
			return false;
		}
		return true;
	}
	//获取等待支付的订单
	public String getWaitDealOrders(){
		orders=orderService.getOrdersByOrderState(2);
		return "success";
	}
	//查找用户
	public String FindCustomer(){
		if(islogin()||getRight(5)){
		customer=adminService.FindCustomerByCustomerID(customer.getCustomerID());
		if(customer==null)
		{
			return "fail";
		}
		orders=new ArrayList<UserOrder>();
		if(order==null){
			order=new UserOrder();
			order.setOrderState(1);
			}
	//	System.out.println(order.getOrderState());
		for(UserOrder od:customer.getOrders()){
			if(od.getOrderState()==order.getOrderState()){
				orders.add(od);
			}
		}
		if(customer==null){
			this.addActionError("查询失败！返回结果为空！");
			return "fail";
		}
		return "success";
		}
		this.addActionError("查询失败，没有相关权限！");
		return "fail";
	}
	//处理订单
	public String dealOrder(){
		if(islogin()||getRight(3)){
		UserOrder od=orderService.getOrderByID(order.getOrderID());
		if(od==null){
			this.addActionError("处理失败！找不到该订单！");
			return "fail";
		}
		od.setKdNum(order.getKdNum());
		od.setOrderState(3);
		orderService.updateOrder(od);
		return "success";
		}
		this.addActionError("处理失败，你没有权限");
		return "fail";
	}
	//发送订单
	public String getSendedOrder(){
		orders=orderService.getOrdersByOrderState(3);
		return "success";
	}
	//获取已完成订单
	public String getFinishedOrders(){
		orders=orderService.getOrdersByOrderState(0);
		if(orders==null){
			orders=orderService.getOrdersByOrderState(4);
			return "success";
		}
		orders.addAll(orderService.getOrdersByOrderState(4));
		return "success";
	}
	//查找订单ID
	public String findOrderByID(){
		order=orderService.getOrderByID(order.getOrderID());
		return "success";
	}
	//查找充值卡
	public String findMoneyCard(){
		moneyCard=adminService.getMoneyCardByID(moneyCard.getMoneyCardID());
		if(moneyCard!=null){
		customer=adminService.FindCustomerByCustomerID(moneyCard.getCustomerID());
		}
		return "success";
	}
	//显示书本
	public String adminShowBook(){
		book=bookService.getBookByID(book.getBookID());
		return "success";
	}
	//获取所有大分类
	public String getAllCategory(){
		categoryList=categoryService.findAll();
		return "success";
	}
	//获取所有小分类
	public String getAllSecondCategory() {
		secondcategoryList=categorySecondService.findAll();
		//System.out.print(secondcategoryList.get(2).getCategory().getCid());
		return "success";
	}
	//获取大分类id
	public String getCategoryByCid(){
		category=categoryService.findByCid(category.getCid());
		return "success";
	}
	//获取小分类id
	public String getSecondCategoryByCsid(){
		categorySecond=categorySecondService.findByCsid(categorySecond.getCsid());
		// 查询所有一级分类.
		List<Category> cList = categoryService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "success";
	}
	//查找大分类
	public String findCategory() {
		// 查询所有一级分类.
		List<Category> cList = categoryService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "success";
	}
	//查找小分类
	public String findSecondCategory() {
		// 查询所有二级分类.
		List<CategorySecond> csList = categorySecondService.findAll();
		// 将集合存入到值栈中.
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "success";
	}
	//保存小分类
	public String saveSecondCategory() {
		if(islogin()||getRight(2)){
			categorySecond.setCategory(category);
			categorySecondService.save(categorySecond);
			return "success";
		}
		this.addActionError("处理失败，你没有权限");
		return "fail";
	}
	//更新用户
	public String updateCustomer(){
		System.out.println(customer.getCustomerID());
		if(islogin()||getRight(5)){
			
			adminService.updateCustomer(customer);
			//categoryList=categoryService.findAll();
		this.addActionMessage("修改成功！请继续...");
		return "success";
		}
		return "fail";
	}
	//通过用户id获取用户
	public String getCustomerByCustomerId() 
	{
		customer=adminService.FindCustomerByCustomerID(customer.getCustomerID());
		return "success";
	}
}
