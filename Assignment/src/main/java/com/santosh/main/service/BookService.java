package com.santosh.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.santosh.main.model.BookVO;

public interface BookService {
	public List<BookVO> addData(String requestBody,MultipartFile multipartFile);
	public List<BookVO> getBook(String id);
	public List<BookVO> updateBook(String request);
	public List<BookVO> deleteBook(String Request);
}
