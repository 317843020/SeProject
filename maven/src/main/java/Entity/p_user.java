package Entity;


/*
 * 本系统所有用户类继承父类
 * 
 *  
 */
 
public  class p_user {
	private String id;          //账号
	private String password;    //密码
	private String name;        //姓名
	private String type;       //用户身份类型
	private String sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
		
}
