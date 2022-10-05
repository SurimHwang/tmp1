package com.tmp.dao;

import com.tmp.dto.TestDTO;


public interface TestDAO {
	
    TestDTO login(TestDTO dto);  
        
    void signUp(TestDTO dto);
    
    void updateUserName(TestDTO dto);
    
    void deleteUser(TestDTO dto);
    
}
