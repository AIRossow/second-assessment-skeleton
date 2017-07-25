package com.assessment2.twotter.mapper;

import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.User;

public interface UserMapper {

	UserDto toDto(User user);
	
	User fromDto(UserDto dto);
}
