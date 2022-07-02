package com.santosh.main.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.result.DeleteResult;
import com.santosh.main.dao.BookDao;
import com.santosh.main.model.BookVO;
import com.santosh.main.util.BookUtil;

@Repository
public class BookDaoImpl implements BookDao{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	GridFsTemplate gridFsTemplate;
	
	public List<BookVO> addData(BookVO bookVO,MultipartFile multipartFile) {
		BookVO b=new BookVO();
		List<BookVO> bookVOs=new ArrayList<BookVO>();
		try {
			bookVO.setImage(new Binary(BsonBinarySubType.BINARY, multipartFile.getBytes()));
			b=mongoTemplate.insert(bookVO);
			if(b!=null) {
				bookVOs.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookVOs;
	}
	
	public List<BookVO> getBook(String id) {
		List<BookVO> bookVO=new ArrayList<BookVO>();
		BookVO b=new BookVO();
		try {
			if(id!=null) {
				b=mongoTemplate.findById(id, BookVO.class);
				bookVO.add(b);
				return BookUtil.getDiscountedPrice(bookVO);
			}else {
				bookVO=BookUtil.getDiscountedPrice(mongoTemplate.findAll(BookVO.class));
				return bookVO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<BookVO> updateBook(BookVO bookVO) {
		List<BookVO> responsebookVO=new ArrayList<BookVO>();
		BookVO bookVO2=new BookVO();
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(bookVO.getId()));
			bookVO2=mongoTemplate.findOne(query, BookVO.class);
			if(bookVO2!=null) {
				bookVO2.setAuthor(bookVO.getAuthor());
				bookVO2.setTitle(bookVO.getTitle());
				bookVO2.setChapters(bookVO.getChapters());
				bookVO2.setDateOfPublication(bookVO.getDateOfPublication());
				bookVO2.setPrice(bookVO.getPrice());
				mongoTemplate.save(bookVO2);
				
				BookVO updateBookVO = mongoTemplate.findOne(query, BookVO.class);
				responsebookVO.add(updateBookVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responsebookVO;
	}
	
	public List<BookVO> deleteBook(BookVO bookVO) {
		List<BookVO> bookVOs=new ArrayList<BookVO>();
		BookVO b=new BookVO();
		try {
			b=mongoTemplate.findById(bookVO.getId(), BookVO.class);
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(bookVO.getId()));
			DeleteResult deleteResult=mongoTemplate.remove(query, BookVO.class);
			if(deleteResult.getDeletedCount()>0) {
				bookVOs.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookVOs;
	}

}
