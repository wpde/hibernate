package demo2;


/**  
* @Description: TODO(持久化类的编写原则)  
* @author cofe  
* @date 2018年12月9日
* 
*   1.提供无参构造器
*   2.提供唯一标识，属性建议使用基本数据类型的包装类(默认值为null而不是“0”)
*   3.类不要使用final进行修饰。(延迟加载：hibernate底层使用继承来实现动态代理)
*   4.提供公共的get、set方法
* -------------------------主键生成策略------------------------------------
*    increment
*    			：hibernate提供的自动增长策略，单线程使用
*    identity
*    			：MySQL底层实现自动增长		
*    sequence
*    			：Orcal底层实现自动增长
*    uuid
*    			：hibrenate随机生成字符串
*    native
*    			：identity和sequence自动切换
*    assigned
*    			：用户自己手动生成
*    
*/
public /*final*/ class Customer {
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_source=" + cust_source
				+ ", cust_industry=" + cust_industry + ", cust_level=" + cust_level + ", cust_phone=" + cust_phone
				+ ", cust_mobile=" + cust_mobile + "]";
	}
	private Long cust_id;
	private String cust_name;
	private String cust_source;
	private String cust_industry;
	private String cust_level;
	private String cust_phone;
	private String cust_mobile;
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_source() {
		return cust_source;
	}
	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}
	public String getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(String cust_industry) {
		this.cust_industry = cust_industry;
	}
	public String getCust_level() {
		return cust_level;
	}
	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	/*public Customer(Long cust_id, String cust_name, String cust_source, String cust_industry, String cust_level,
			String cust_phone, String cust_mobile) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_source = cust_source;
		this.cust_industry = cust_industry;
		this.cust_level = cust_level;
		this.cust_phone = cust_phone;
		this.cust_mobile = cust_mobile;
	}*/
	
	
}
