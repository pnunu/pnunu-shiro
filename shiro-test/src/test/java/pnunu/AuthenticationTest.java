package pnunu;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {
	
	SimpleAccountRealm realm = new SimpleAccountRealm();
	
	
	@Before
	public void addUsers() {
		realm.addAccount("pnunu", "pnunu");
	}
	
	@Test
	public void  testAuthentication() throws Exception {
		//1、构建securityManager
		DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
		defaultSecurityManager.setRealm(realm);
		
		//2、主题提交认证请求
		SecurityUtils.setSecurityManager(defaultSecurityManager);
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("pnunu", "pnunu");
//		UsernamePasswordToken token = new UsernamePasswordToken("pnunu", "pnunu1"); // error
		subject.login(token);
		
		System.out.println("isAuthenticated: " + subject.isAuthenticated());
		
		// 退出
		subject.logout();
		
		System.out.println("isAuthenticated: " + subject.isAuthenticated());
		
		//3、
		
		//4、
	}

}
