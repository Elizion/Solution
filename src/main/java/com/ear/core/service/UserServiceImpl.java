package com.ear.core.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ear.core.model.AuthenticatedModel;
import com.ear.core.model.AuthorizedModel;
import com.ear.core.model.UserModel;
import com.ear.core.payload.UserRequest;
import com.ear.core.repository.UserRepository;
import com.ear.core.util.PasswordUtil;

@Service
public class UserServiceImpl implements UserService {
    
	public final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
    private Environment env;

    public String propertyStaticFolder() {
        return env.getProperty("spring.web.resources.static-locations");
    }
    
    public String propertyFolderImages() {
        return env.getProperty("folder.images");
    }
    
    public String propertyPictureUserDefautl() {
        return env.getProperty("picture.user.default");
    }   

	@Autowired
	private SystemService systemService;
	
	@Autowired
	private AuthenticatedService authenticatedService;
	
	@Autowired
	private AuthorizedService authorizedService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private PasswordUtil passwordUtil = new PasswordUtil();
		
	@Override
	public UserModel getUserByEmail(String email) {		
		
		UserModel userModel = new UserModel();		
		userModel = this.userRepository.getUserByEmail(email); 		
		/*
		String staticFolder = this.propertyStaticFolder();
		String pictureUserDefault = this.propertyPictureUserDefautl();		
		String foderImages = this.propertyFolderImages();	
		String encodedString = userModel.getPicture();
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		userModel.setPicture(decodedBytes.toString());
		FileUtils.writeByteArrayToFile(new File(staticFolder+foderImages+"user_picture_default_"+uuid+".jpg"), decodedBytes);
		*/
		return userModel;

	}

	@Override
	public UserRequest createUser(UserRequest userRequest) throws IOException {
								
		//Para gener una contraseña aleatoria, se logea con passwordRandom
		String passwordRandom = this.passwordUtil.generatePasswordRandom();
		String passwordEncode = this.passwordEncoder.encode(passwordRandom);
		
		//Para almacenar los roler admin, user
		List<AuthenticatedModel> listAuthenticated = new ArrayList<AuthenticatedModel>();
		AuthenticatedModel authenticatedModel = this.authenticatedService.getDefaultUserRole();
		listAuthenticated.add(authenticatedModel);
		
		//Para almacenar los permisos de lectura, escritura, editar, borrar
		List<AuthorizedModel> listAuthorized = new ArrayList<AuthorizedModel>();
		AuthorizedModel authorizedModel = this.authorizedService.getDefaultUserPermission();
		listAuthorized.add(authorizedModel);
				
		//Para almacenar una imagen por default
		String staticFolder = this.propertyStaticFolder();
		String pictureUserDefault = this.propertyPictureUserDefautl();		
		String foderImages = this.propertyFolderImages();						
		byte[] fileContent = FileUtils.readFileToByteArray(new File(staticFolder + foderImages + pictureUserDefault));		
		String encoded = Base64.getEncoder().encodeToString(fileContent);	
			    			
		userRequest.setPassword(passwordEncode);
		userRequest.setListAuthenticated(listAuthenticated);
		userRequest.setListAuthorized(listAuthorized);
		userRequest.setPicture(encoded);
		
		this.userRepository.createUser(userRequest);		
		Integer idUser = this.systemService.getIdUser();
		userRequest.setId(idUser);
		this.authenticatedService.createListAuthenticated(userRequest);
		this.authorizedService.createListAuthorized(userRequest);		
		
		logger.info("Correo generado " + userRequest.getEmail());
		logger.warn("Contrase\u00f1a por default generada " + passwordRandom);
		logger.info("Rol por default generado " + authenticatedModel.getName());
		logger.info("Permiso por default generado " + authorizedModel.getName());
		logger.info("Imagen por default generada " + staticFolder + foderImages + pictureUserDefault);
				
		return userRequest;
		
	}

	@Override
	public List<UserModel> getUserActives() {
		return this.userRepository.getUserActives();
	}

	@Override
	public void desactivatedUserByEmail(Integer id) {
		this.userRepository.desactivatedUserByEmail(id);
	}

	@Override
	public void activatedUserByEmail(Integer id) {
		this.userRepository.activatedUserByEmail(id);		
	}

}
												
