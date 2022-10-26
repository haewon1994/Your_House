 package mvc.service;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.user.UserDTO;
import mvc.exception.AuthenticationException;



public interface UserService {
	/**
	 * 로그인 체크
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
   
   UserDTO select(String email) throws SQLException;
   
   void insert(UserDTO userDTO)throws SQLException;
   
   List<UserDTO> searchUser()throws SQLException;
   
   
}


