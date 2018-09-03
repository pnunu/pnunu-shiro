package pnunu.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author: pnunu
 * @create: 2018-09-03 22:09
 */
public class IniRealmTest {

    @Test
    public void testAuthentication() {
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        //1、构建securityManager环境
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(iniRealm);

        //2、主题提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        // 登录
        try {
            UsernamePasswordToken token = new UsernamePasswordToken("pnunu", "pnunu");
            //3、登录
            subject.login(token);
            boolean isAuthenticated = subject.isAuthenticated();
            System.out.println("isAuthenticated: " + isAuthenticated);

            //4、退出
//            subject.logout();
//            isAuthenticated = subject.isAuthenticated();
//            System.out.println("isAuthenticated: " + isAuthenticated);
        } catch (Exception e) {
            System.out.println("登录失败。" + e.getMessage());
        }

        //角色验证
        try {
            subject.checkRoles("admin");
        } catch (Exception e) {
            System.out.println("角色校验失败。" + e.getMessage());
        }

        //权限验证
        subject.checkPermission("user:delete");

    }
}
