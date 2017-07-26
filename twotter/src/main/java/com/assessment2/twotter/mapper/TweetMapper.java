package com.assessment2.twotter.mapper;

import com.assessment2.twotter.dto.TweetDto;
import com.assessment2.twotter.entity.Tweet;

public interface TweetMapper {

	Tweet fromDto(TweetDto dto);
	
	TweetDto toDto(Tweet tweet);	
}
