package com.santosh.main.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.santosh.main.model.BookResponseVO;
import com.santosh.main.model.BookVO;
import com.santosh.main.model.ErrorVO;
import com.santosh.main.model.FailedVO;
import com.santosh.main.service.BookService;
/**
 * @author Santosh Mallah
 * santoshmallah121@gmail.com
 * https://github.com/santoshmallah/Book-directory-REST-API.git
 * 
 * */

@RestController
public class Controller {

	Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

	@Autowired
	BookService bookService;

	@PostMapping("/addbook")
	public ResponseEntity<String> addRecord(@RequestParam("book") String requestBody,
			@RequestParam("image") MultipartFile multipartFile) {
		BookResponseVO<BookVO, String> bookResponseVO = new BookResponseVO<BookVO, String>();
		List<BookVO> bookVOs = new ArrayList<BookVO>();
		String responsSring = null;
		try {
			bookVOs = bookService.addData(requestBody, multipartFile);
			if (bookVOs.size() > 0) {
				bookResponseVO.setSuccess(bookVOs);
				bookResponseVO.setTotalRecords(bookVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			} else {
				ErrorVO errorVO = new ErrorVO();
				List<ErrorVO> errorVOs = new ArrayList<ErrorVO>();
				errorVO.setErrorMessage("User Id does not Exist in database");
				errorVOs.add(errorVO);
				FailedVO<String> failedVO = new FailedVO<String>();
				List<FailedVO<String>> failedVOs = new ArrayList<FailedVO<String>>();
				failedVO.setIdentityDetails(requestBody);
				failedVO.setErrors(errorVOs);
				failedVOs.add(failedVO);
				bookResponseVO.setFailed(failedVOs);
				bookResponseVO.setTotalfailedRecords(failedVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(responsSring);
	}

	@GetMapping(value = { "/getbook", "/getbook/{id}" })
	public ResponseEntity<String> getBook(@PathVariable(required = false) String id) {
		BookResponseVO<BookVO, String> bookResponseVO = new BookResponseVO<BookVO, String>();
		List<BookVO> bookVOs = new ArrayList<BookVO>();
		String responsSring = null;
		try {
			bookVOs = bookService.getBook(id);
			if (bookVOs.size() > 0) {
				bookResponseVO.setSuccess(bookVOs);
				bookResponseVO.setTotalRecords(bookVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			} else {
				ErrorVO errorVO = new ErrorVO();
				List<ErrorVO> errorVOs = new ArrayList<ErrorVO>();
				errorVO.setErrorMessage("No record found !");
				errorVOs.add(errorVO);
				FailedVO<String> failedVO = new FailedVO<String>();
				List<FailedVO<String>> failedVOs = new ArrayList<FailedVO<String>>();
				failedVO.setIdentityDetails(id);
				failedVO.setErrors(errorVOs);
				failedVOs.add(failedVO);
				bookResponseVO.setFailed(failedVOs);
				bookResponseVO.setTotalfailedRecords(failedVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(responsSring);
	}

	@PutMapping("/updatebook")
	public ResponseEntity<String> updateBook(@RequestBody String request) {
		BookResponseVO<BookVO, String> bookResponseVO = new BookResponseVO<BookVO, String>();
		List<BookVO> bookVOs = new ArrayList<BookVO>();
		String responsSring = null;
		try {
			bookVOs = bookService.updateBook(request);
			if (bookVOs.size() > 0) {
				bookResponseVO.setSuccess(bookVOs);
				bookResponseVO.setTotalRecords(bookVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			} else {
				ErrorVO errorVO = new ErrorVO();
				List<ErrorVO> errorVOs = new ArrayList<ErrorVO>();
				errorVO.setErrorMessage("User Id does not Exist in database");
				errorVOs.add(errorVO);
				FailedVO<String> failedVO = new FailedVO<String>();
				List<FailedVO<String>> failedVOs = new ArrayList<FailedVO<String>>();
				failedVO.setIdentityDetails(request);
				failedVO.setErrors(errorVOs);
				failedVOs.add(failedVO);
				bookResponseVO.setFailed(failedVOs);
				bookResponseVO.setTotalfailedRecords(failedVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(responsSring);
	}

	@DeleteMapping("/deletebook")
	public ResponseEntity<String> deleteBook(@RequestBody String request) {
		BookResponseVO<BookVO, String> bookResponseVO = new BookResponseVO<BookVO, String>();
		List<BookVO> bookVOs = new ArrayList<BookVO>();
		String responsSring = null;
		try {
			bookVOs = bookService.deleteBook(request);
			if (bookVOs.size() > 0) {
				bookResponseVO.setSuccess(bookVOs);
				bookResponseVO.setTotalRecords(bookVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			} else {
				ErrorVO errorVO = new ErrorVO();
				List<ErrorVO> errorVOs = new ArrayList<ErrorVO>();
				errorVO.setErrorMessage("User Id does not Exist in database");
				errorVOs.add(errorVO);
				FailedVO<String> failedVO = new FailedVO<String>();
				List<FailedVO<String>> failedVOs = new ArrayList<FailedVO<String>>();
				failedVO.setIdentityDetails(request);
				failedVO.setErrors(errorVOs);
				failedVOs.add(failedVO);
				bookResponseVO.setFailed(failedVOs);
				bookResponseVO.setTotalfailedRecords(failedVOs.size());
				responsSring = gson.toJson(bookResponseVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(responsSring);
	}
	
	@GetMapping
	public String googleLogin(Principal principal) {
		StringBuilder sampleText = new StringBuilder();
		try {
			System.out.println("============>"+principal);
			sampleText.append("Welcome to Google !!");
			sampleText.append(" Login Successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sampleText.toString();
	}

	@GetMapping("/googleloginuserdetail")
	public Principal googleUserDetail(Principal principal) {
		try {
			System.out.println("username : " + principal.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return principal;
	}

}
