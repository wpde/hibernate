package demo2;


/**  
* @Description: TODO(�־û���ı�дԭ��)  
* @author cofe  
* @date 2018��12��9��
* 
*   1.�ṩ�޲ι�����
*   2.�ṩΨһ��ʶ�����Խ���ʹ�û����������͵İ�װ��(Ĭ��ֵΪnull�����ǡ�0��)
*   3.�಻Ҫʹ��final�������Ρ�(�ӳټ��أ�hibernate�ײ�ʹ�ü̳���ʵ�ֶ�̬����)
*   4.�ṩ������get��set����
* -------------------------�������ɲ���------------------------------------
*    increment
*    			��hibernate�ṩ���Զ��������ԣ����߳�ʹ��
*    identity
*    			��MySQL�ײ�ʵ���Զ�����		
*    sequence
*    			��Orcal�ײ�ʵ���Զ�����
*    uuid
*    			��hibrenate��������ַ���
*    native
*    			��identity��sequence�Զ��л�
*    assigned
*    			���û��Լ��ֶ�����
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
