package com.example.databaseRelation;

import com.example.databaseRelation.Security.JwtTokenService;
import com.example.databaseRelation.Security.TokenService;
import com.example.databaseRelation.Tokens.UserTokenRepository;
import com.example.databaseRelation.Tokens.UserTokenService;
import com.example.databaseRelation.Users.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


@SpringBootApplication
public class DatabaseRelationApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseRelationApplication.class, args);
	}


	private static final String AUTHENTICATION_METHOD = "JWT";
	@Bean
	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public TokenService tokenService(
			@Autowired UserTokenRepository userTokenRepository,
			@Autowired UsersRepository usersRepository
			){

		switch(AUTHENTICATION_METHOD){
			case "JWT":
				return new JwtTokenService();
			case "SST":
				return new UserTokenService(userTokenRepository, usersRepository);
			default:
				System.out.println("not exist");
		}
		return new JwtTokenService();
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
