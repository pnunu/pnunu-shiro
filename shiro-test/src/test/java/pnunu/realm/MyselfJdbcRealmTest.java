package pnunu.realm;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author: pnunu
 * @create: 2018-09-03 22:15
 */
public class MyselfJdbcRealmTest {

    private DruidDataSource druidDataSource = new DruidDataSource();
    {
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/pnunu");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
    }

    @Test
    public void testAuthentication() {
        JdbcRealm jdbcRealm = new JdbcRealm();

        jdbcRealm.setDataSource(druidDataSource);
        //权限开关
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from pnunu_users where username = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql = "select role_name from pnunu_user_roles where username = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        String permissionSql = "select permission from pnunu_roles_permissions where role_name = ?";
        jdbcRealm.setPermissionsQuery(permissionSql);

        //1、构建securityManager环境
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(jdbcRealm);

        //2、主题提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        // 登录
        try {
            UsernamePasswordToken token = new UsernamePasswordToken("pnunu0", "pnunu22");
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
            subject.checkRoles("admin1", "user1");
            subject.checkPermission("user:select");
            System.out.println("权限正常");
        } catch (Exception e) {
            System.out.println("角色校验失败。" + e.getMessage());
            e.printStackTrace();
        }

    }
}
