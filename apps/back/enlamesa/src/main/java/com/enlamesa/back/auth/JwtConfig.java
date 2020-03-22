package com.enlamesa.back.auth;

public class JwtConfig {
	
	
	public static final String API_SECRET_KEY = "Castellana_171";
	
	public static final String RSA_PRIVATE= "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEowIBAAKCAQEAlsjayuSXngxOQqIl8me4jwMaLI46kIrOIZkPyqCByweDccOA\r\n" + 
			"c8pLZ41yESCTOfZ51YeXMqPBQfBHKeMIc1XwXQ3qxDNu4AIM1XQs2Uq1svXFbhQc\r\n" + 
			"emy63fr3CMyHuayy0ktpH2zfcWqd3EsdUXD7/7lFQ2c1HBKySkGomrSeXZmyRdmE\r\n" + 
			"Nri1avKFtaqzmWdU9K+JEdJ42Xbuur7veMmf5NnibyGPYlx8gkQEg1K7d6oiNzwg\r\n" + 
			"11+ZumXPUqNT9K0W+9EuLcOd2hVxAHY7cJmQEntSv8mhTIgM8yj2qMvnF8Ok7SWQ\r\n" + 
			"BXsHhB9ZjhcPqXN24MZcqeGWyFAhw5WX6XNHewIDAQABAoIBADR67/vSGBtAOTTj\r\n" + 
			"7sUx6ICOGdwMHMIWLaxv85kYyFP753n/C4RBkoEWL+9aISP5b2osaSmM6USj9oDT\r\n" + 
			"ritGbARXRbDIHf0FeaYJa1qtsBP7ip3HjinmEhwUr0p2tX6gZxTeflYbtKFq9Eqq\r\n" + 
			"MigYZP0aZMsS7t84eqlxtNczqjL1NNuPh0C4TbwJhhdQaY2cMHZT7LQPGhOCMTQm\r\n" + 
			"rvi4zW7YFN7sOc4M+2oU5zeSpWrYNIyGZWbJs/I3URzrPohj5LtCU59VDkkbD5KI\r\n" + 
			"WhJaCmqgKHQq1+yC6CBTC9v0/URdzID7jzY9E1eL4/dfiJDn+J7wkGWwCvuSbbix\r\n" + 
			"IjIpiyECgYEAxoPtErtndq3yiJQwCX6B6vRKMvIbvGoFqBOkKBx/jsSHygpA3C9V\r\n" + 
			"0qsb+OLNh7TloT/sPufvBmUPTsrXqXkSFxGiRxVYGyUgYvkBzBu5n7KGOFSH2Wsu\r\n" + 
			"AuBOAZtfs2sr5TwOY0q6UUIp5zn1JqI1q8LshqYBWDeQFU997CgagOkCgYEAwnKd\r\n" + 
			"08VwpHBJbn9jiPldQQgANEwo37yK4RRUXQRB6sq9CFsrKyvyVUX4YJp2G29LRzQb\r\n" + 
			"w1mkqkY9ZGcQmswGmDjvdafYHCudnm5CfC90nVaogRtsYgD4HxeOTRNWxju4iHcQ\r\n" + 
			"7rZwmxc1CtwHJ6vERkTqp9zb/pkKG14hYVTMpsMCgYEAuw83hw42iVuSDebteRTP\r\n" + 
			"YVG+1VDUl++j0uRnLDDmdeZ1Ogn9Yj3sdi4slpNJLtZkB1VPzVsKHhF+ojV7kMN4\r\n" + 
			"K2q/apIPSszqPrj7W5TIjlZQKaZluJdJbQZmGxeIz21umHzF5gRVmxpol+1CN5xk\r\n" + 
			"TKzJ6ntlCvaYe6xDMRP9HXkCgYBfwDEX51Hgp6qBTxmkiabyLw5qslYuVpnM3EXu\r\n" + 
			"x/nttIgBZWOMjsd2Vk5Iw8cFG3jmRzKkr6/2aUAyAM6ca3uT2fWQ6mXw+UlUitcS\r\n" + 
			"cAvsro+rg+WLHQ8RwHfCXJOOajokeP1Nj2lD9dmYz2B2mI6+S5GBt7BdXt8rOt8V\r\n" + 
			"HrzoIQKBgC2NLcxcajFshIUxIYNwm4x5Ra2qvjCNcb+WcOoJB+F9CmruaLGptQoh\r\n" + 
			"j7jS4ubUZv3ypOpbTM9iSdrGmH1pxzgGYtYYkVilZDGyqzXlWuwANx2clHtlyrcW\r\n" + 
			"d8CkvkCQ+qyDXE35YoL5W1Mvb0aMALzqJFHK7IPXsB1yT68ORkiJ\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlsjayuSXngxOQqIl8me4\r\n" + 
			"jwMaLI46kIrOIZkPyqCByweDccOAc8pLZ41yESCTOfZ51YeXMqPBQfBHKeMIc1Xw\r\n" + 
			"XQ3qxDNu4AIM1XQs2Uq1svXFbhQcemy63fr3CMyHuayy0ktpH2zfcWqd3EsdUXD7\r\n" + 
			"/7lFQ2c1HBKySkGomrSeXZmyRdmENri1avKFtaqzmWdU9K+JEdJ42Xbuur7veMmf\r\n" + 
			"5NnibyGPYlx8gkQEg1K7d6oiNzwg11+ZumXPUqNT9K0W+9EuLcOd2hVxAHY7cJmQ\r\n" + 
			"EntSv8mhTIgM8yj2qMvnF8Ok7SWQBXsHhB9ZjhcPqXN24MZcqeGWyFAhw5WX6XNH\r\n" + 
			"ewIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
