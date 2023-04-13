package tn.com.abt.smw.security;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

	@Override
	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		OAuth2Authentication auth = super.extractAuthentication(map);
		AccessTokenMapper accessTokenMapper = new AccessTokenMapper();
		if (map.get("id_acc_cli") != null)
			accessTokenMapper.setIdAccessClient(new Long(map.get("id_acc_cli").toString()));

		if (map.get("id") != null)
			accessTokenMapper.setId(map.get("id").toString());

		if (map.get("user_name") != null)
			accessTokenMapper.setUserName(map.get("user_name").toString());

		auth.setDetails(accessTokenMapper);
		return auth;
	}

}