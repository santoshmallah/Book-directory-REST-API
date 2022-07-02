package com.santosh.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.santosh.main.dao.BookDao;
import com.santosh.main.model.BookVO;
import com.santosh.main.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	Gson gson=new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
	
	@Autowired
	BookDao bookDao;
	
	public List<BookVO> addData(String requestBody,MultipartFile multipartFile) {
		List<BookVO> resBookVO=new ArrayList<BookVO>();
		try {
			BookVO bookVO=gson.fromJson(requestBody, BookVO.class);
			resBookVO=bookDao.addData(bookVO,multipartFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resBookVO;
	}
	
	public List<BookVO> getBook(String id) {
		List<BookVO> resBookVO=new ArrayList<BookVO>();
		try {
			resBookVO=bookDao.getBook(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resBookVO;
	}
	
	public List<BookVO> updateBook(String request) {
		List<BookVO> bookVOs=new ArrayList<BookVO>();
		try {
			BookVO bookVO=gson.fromJson(request, BookVO.class);
			bookVOs=bookDao.updateBook(bookVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookVOs;
	}
	
	public List<BookVO> deleteBook(String request) {
		List<BookVO> bookVOs=new ArrayList<BookVO>();
		try {
			BookVO bookVO=gson.fromJson(request, BookVO.class);
			bookVOs=bookDao.deleteBook(bookVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookVOs;
	}

}
