package com.txzhang.springcloud.oauthserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName：MySecurityConfig
 * @Author：txzhang
 * @Date：2020/1/15—14:17
 * @Description： 认证服务器配置
 * 链接： https://www.jianshu.com/p/ea0a7d89f5f0
 **/
@Configuration
@EnableAuthorizationServer
public class MyAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 用于定义客户详细信息服务的配置器。客户端详情信息进行初始化，能够把客户端详情信息写在内存中或者是通过数据库来存储调取详情信息。
     * 多个客户端来连接Spring OAuth2 Auth Server，需要在配置类里为inMemory生成器定义多个withClients
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("user")
                .secret(passwordEncoder().encode("123456"))
                .authorizedGrantTypes("authorization_code", "refresh_token") //允许的授权类型
                .scopes("all") //允许的授权方位
                .autoApprove(false) //自动授权
                .redirectUris("http://localhost:8087/login") //设置回调地址
                .refreshTokenValiditySeconds(60 * 30)
                .and()
                .withClient("txzhang").secret(passwordEncoder().encode("123456"))
                .authorizedGrantTypes("authorization_code", "refresh_token") //允许的授权类型
                .scopes("all") //允许的授权方位
                .autoApprove(false)
                .redirectUris("http://localhost:8086/oauth2-client/authorized"
                        , "http://localhost:8086/oauth2-client/login");
    }

    /**
     * 用来配置授权authorization以及令牌token的访问端点和令牌服务token services
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //DefaultTokenService作为OAuth2中操作token(crud)的默认实现，在OAuth2框架中有着很重要的地位。使用随机值创建令牌，并处理除永久令牌以外的所有令牌
        //在认证服务的 Endpoints 中, 使用的正是 DefaultTokenServices, 它为 DefaultTokenServices 提供了默认配置
        //
        //作者：意识流丶
        //链接：https://www.jianshu.com/p/ea0a7d89f5f0
        //来源：简书
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
        tokenServices.setTokenStore(jwtTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(jwtAccessTokenConverter());
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1));
        endpoints.tokenServices(tokenServices);
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
//        endpoints.getRedirectResolver();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
    }

    /**
     * JwtTokenStore：将OAuth2AccessToken保存到JSON Web Token
     * <p>
     * jwt具有自解释的特性，客户端不需要再去授权服务器认证这个token的合法性,这里使用对称密钥testKey来签署我们的令牌，意味着需要为资源服务器使用同样的确切密钥。
     * 注：也支持使用非对称加密的方式，不过有点复杂
     *
     * @return
     */
    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * token生成器
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("testKey");
        return tokenConverter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
