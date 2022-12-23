package Framework;

import java.util.HashMap;

import Framework.ConfigProperties;

public class Setting {
	public String browerType, implicitWait,scriptTimeout,password,username,base_url,bookstore_password;
	private HashMap<String,String> properties;
	
	public Setting(HashMap<String,String> properties) {
		this.properties=properties;
		load();
	}

	
	public void load()
	{
		this.browerType=this.properties.get(ConfigProperties.BROWSER_TYPE);
		this.implicitWait=this.properties.get(ConfigProperties.IMPLICIT_WAIT);
		this.scriptTimeout=this.properties.get(ConfigProperties.SCRIPT_TIMEOUT);
		this.base_url=this.properties.get(ConfigProperties.BASE_URL);
		this.username=this.properties.get(ConfigProperties.USERNAME);
		this.password=this.properties.get(ConfigProperties.PASSWORD);
		this.bookstore_password=this.properties.get(ConfigProperties.BOOKSTORE_PASSWORD);
	}
}
