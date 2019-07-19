package com.minhjFreeBoard.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.minhjFreeBoard.model.dto.PostsDTO;

public interface FreeBoardDAO {
	
	@Select("select * from fb_post_data order by seq desc")
	public List<PostsDTO> list();
	
	@Insert("insert into fb_post_data values (fb_post_data_seq.nextval, "
			+ " #{id}, #{title}, #{content}, sysdate, 1, 0")
	public void insert(PostsDTO dto);
	
	
}
