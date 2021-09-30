package cn.com.gs.library.realm;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

	@Autowired
	private SysUserRealm sysUserRealm;

	/**
	 * 配置ehcache缓存
	 */
	@Bean
	public EhCacheManager ehcacheManager(){
		EhCacheManager ehCacheManager = new EhCacheManager();
		return ehCacheManager;
	}

	/**
	 * 配置securityManager管理器
	 * 指定认证器
	 * 指定缓存器
	 * @return
	 */
	@Bean
	public SecurityManager securityManager(){
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(sysUserRealm);
		defaultWebSecurityManager.setCacheManager(ehcacheManager());
		return defaultWebSecurityManager;
	}

	/**
	 * 开启shiro 注解支持
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

	/**
	 * 配置shiro过滤器
	 * 给ShiroFilterFactoryBean指定管理器
	 * 配置过滤器链
	 * @param securityManager
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
		System.out.println("shiroFilter过滤器链");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 指定管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 配置过滤器
		shiroFilterFactoryBean.setLoginUrl("/sysUser/toLogin.do");
		shiroFilterFactoryBean.setSuccessUrl("/sysUser/toMain.do");
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		filterChainDefinitionMap.put("/sysUser/toLogin.do", "anon");
		filterChainDefinitionMap.put("/sysUser/toShiroLogin.do", "anon");
		filterChainDefinitionMap.put("/sysUser/login.do", "anon");
		filterChainDefinitionMap.put("/sysUser/timeout.do", "anon");
		filterChainDefinitionMap.put("/sysUser/toRefuse.do", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/2/**", "anon");
		filterChainDefinitionMap.put("/bootstrap/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/img/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 前台的shiro标签才能生效,注意thymeleaf-extras-shiro版本问题：2.0.0可用
	 * @return
	 */
	@Bean
	public ShiroDialect shiroDialect(){
		return new ShiroDialect();
	}
}
