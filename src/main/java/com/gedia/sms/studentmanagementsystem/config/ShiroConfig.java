package com.gedia.sms.studentmanagementsystem.config;

import com.gedia.sms.studentmanagementsystem.shiro.*;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * shiro核心配置信息,shiroFilter过滤器中新增拦截
 */
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false,prefix = "shiro.login")
@PropertySource("classpath:config/shiro.properties")
public class ShiroConfig {
	/**
	 * 日志输入出对象
	 */
	private Logger log = Logger.getLogger(ShiroConfig.class.getName());
	/**
	 * 登录跳转链接
	 */
	private String loginUrl ;
	/**
	 * 无权限跳转链接
	 */
	private String unauthorizedUrl ;
	/**
	 * cache配置文件路径
	 */
	private String cacheFilePath ;
	/**
	 * 密码错误次数
	 */
	private int errorTimes ;

	public String getLoginUrl() {
		return loginUrl;
	}
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}
	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}
	public String getCacheFilePath() {
		return cacheFilePath;
	}
	public void setCacheFilePath(String cacheFilePath) {
		this.cacheFilePath = cacheFilePath;
	}
	public int getErrorTimes() {
		return errorTimes;
	}
	public void setErrorTimes(int errorTimes) {
		this.errorTimes = errorTimes;
	}

	@Bean(name="sessionFilter")
	public OncePerRequestFilter sessionFilter() {
		return new SessionFilter();
	}

	/**
	 * 资源过滤器注册
	 *
	 * @return ResourceCheckFilter
     */
	@Bean(name="resourceCheckFilter")
	public ResourceCheckFilter resourceCheckFilter(){
		ResourceCheckFilter resourceCheckFilter = new ResourceCheckFilter(unauthorizedUrl);
		return resourceCheckFilter;
	}
	/**
	 * url过滤器注册
	 *
	 * @return UrlFilter
	 */
	@Bean(name = "urlFilter")
	public UrlFilter urlFilter(){
		UrlFilter urlFilter = new UrlFilter();
		return urlFilter;
	}
	/**
	 * 自定义过滤器注册
	 *
	 * @return EdopPermissionsAuthorizationFilter
	 */
	@Bean(name="edopPermissionAuthorizationFileter")
	public EdopPermissionsAuthorizationFilter edopPermissionsAuthorizationFilter(){
		return new EdopPermissionsAuthorizationFilter();
	}

	/**
	 * 配置shiro核心安全事务管理器
	 *
	 * @return DefaultWebSecurityManager
	 * @author ZhangGuibin
	 * @Time 2017-07-12
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm, @Qualifier("cacheManager") EhCacheManager cacheManager){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		//注入缓存管理器;
		securityManager.setCacheManager(cacheManager);//这个如果执行多次，也是同样的一个对象;
		return securityManager;
	}

	/**
	 * shiro核心拦截器配置
	 *
	 * @return ShiroFilterFactoryBean
	 */
	@Bean(name="shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager, @Qualifier("urlFilter") UrlFilter urlFilter
			, @Qualifier("edopPermissionAuthorizationFileter") EdopPermissionsAuthorizationFilter edopPermFilter) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setLoginUrl(loginUrl);
		bean.setUnauthorizedUrl(unauthorizedUrl);
		Map<String,Filter> filters = bean.getFilters();;
		filters.put("edopPerms",edopPermFilter);
		bean.setSecurityManager(securityManager);
		//配置访问权限
		LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/", "anon");
		try {
			Map<String,String> permissions = urlFilter.getAllPermission();
			for (Map.Entry<String, String> entry : permissions.entrySet()) {
				filterChainDefinitionMap.put(entry.getKey(),"edopPerms[" + entry.getValue() + "]");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		bean.setFilters(filters);
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean ;
	}

	/**
	 * 配置自定义的权限登录器
	 *
	 * @return UserRealm
	 */
	@Bean(name="userRealm")
	public UserRealm userRealm(){
		UserRealm userRealm = new UserRealm();
		return userRealm;
	}

	/**
	 * 配置缓存管理
	 *
	 * @return EhCacheManager
	 */
	@Bean(name="cacheManager")
	public EhCacheManager cacheManager(){
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile(cacheFilePath);
		return cacheManager;
	}

	/**
	 * 配置代理过滤器
	 *
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean delegatingFilterProxy(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		DelegatingFilterProxy proxy = new DelegatingFilterProxy();
		proxy.setTargetFilterLifecycle(true);
		proxy.setTargetBeanName("shiroFilter");
		filterRegistrationBean.setFilter(proxy);
		return filterRegistrationBean;
	}
}
