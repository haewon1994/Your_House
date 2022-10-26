package mvc.dao.user;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.user.UserDTO;



public interface UserDAO {
	
	/**
	 * 로그인 기능
	 * select user_id , pwd, name from users where user_id=? and pwd=?
	 **/
	UserDTO loginCheck(UserDTO userDTO)throws SQLException;
 
	/**
	 * 회원가입
	 **/	
	int insert(UserDTO user)throws SQLException;
	
	/**
	 * 이메일 중복 체크
	 **/
     boolean duplicateCheckByEmail(String email)throws SQLException;
     
 	/**
 	 * 닉네임 중복 체크
 	 **/
      boolean duplicateCheckByNickname(String email)throws SQLException;
      
    /**
     * 회원 정보 검색
     **/
      List<UserDTO> searchUser() throws SQLException;
	
      
      UserDTO searchByUserCode(int userCode) throws SQLException; 
    

}









