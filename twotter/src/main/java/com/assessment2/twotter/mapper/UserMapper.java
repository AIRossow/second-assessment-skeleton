package com.assessment2.twotter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.assessment2.twotter.dto.UserDto;
import com.assessment2.twotter.entity.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mappings({ @Mapping(source = "profile.creds.username", target = "username")})
	UserDto toDto(Users user);
	
	@Mappings({ @Mapping(source = "username", target = "profile.creds.username")})
	Users fromDto(UserDto dto);
}	
