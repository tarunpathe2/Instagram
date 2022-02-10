package com.instagram.service;

import java.util.List;

import com.instagram.dto.LikesDto;

public interface LikeService {

	public String like(LikesDto likeDto);
	public String unLike(LikesDto likeDto);
	public List<LikesDto> getAllLikes();
}
