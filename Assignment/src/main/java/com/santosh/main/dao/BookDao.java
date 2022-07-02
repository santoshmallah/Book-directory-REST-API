package com.santosh.main.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.santosh.main.model.BookVO;

public interface BookDao {
	public List<BookVO> addData(BookVO bookVO,MultipartFile multipartFile);
	public List<BookVO> getBook(String id);
	public List<BookVO> updateBook(BookVO bookVO);
	public List<BookVO> deleteBook(BookVO bookVO);
}
