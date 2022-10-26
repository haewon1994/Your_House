 package mvc.service;

import java.sql.SQLException;

import mvc.dto.user.UserDTO;
import mvc.exception.AuthenticationException;



public interface UserService {
	/**
	 * �α��� üũ
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
   
   UserDTO select(String email) throws SQLException;
   
   void insert(UserDTO userDTO)throws SQLException;
}


