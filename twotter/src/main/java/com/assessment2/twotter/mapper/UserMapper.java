package com.assessment2.twotter.mapper;

import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Users;

public interface UserMapper {

	UserDto toDto(Users user);
	
	Users fromDto(UserDto dto);
}
