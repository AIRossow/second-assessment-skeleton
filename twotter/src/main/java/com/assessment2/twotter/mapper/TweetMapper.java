package com.assessment2.twotter.mapper;

import org.mapstruct.Mapper;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.entity.Tweet;

@Mapper(componentModel = "Spring")
public interface TweetMapper {

	Tweet fromDto(TweetDto dto);
	
	TweetDto toDto(Tweet tweet);	
}
