//package com.assessment2.twotter.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.assessment2.twotter.entity.Hashtag;
//import com.assessment2.twotter.service.TagService;
//
//@RestController
//public class TagController {
//	private TagService tagService;
//	
//	public TagController(TagService tagService) {
//		this.tagService = tagService;
//	}
//	
//	@GetMapping
//	public List<Hashtag> getTags() {
//		return tagService.getAllTags();
//	}
//
//}
