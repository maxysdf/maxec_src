package idv.maxy.maxec.biz.content.controller;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import idv.maxy.maxec.biz.content.service.ContentService;
import idv.maxy.maxec.biz.content.vo.UploadResultVO;

@RestController
public class ContentUploadController {
	private static final Logger logger = LoggerFactory.getLogger(ContentUploadController.class);
	
	@Autowired
	private ContentService contentService;
	
	@PostMapping(path="/upload", consumes="multipart/form-data")
	public UploadResultVO upload(MultipartHttpServletRequest req) {
		boolean result = true;
		String errorMessage = null;
		try { 
			String path = req.getParameter("path");
			MultiValueMap<String, MultipartFile> fileMap = req.getMultiFileMap();
			
			List<MultipartFile> mfiles = fileMap.get("file");
			if(mfiles.isEmpty()) { throw new Exception("no file found in form"); }

			MultipartFile mfile = mfiles.get(0);
			
			InputStream is = mfile.getInputStream();
			contentService.uploadFile(is, path);
		} catch(Exception ex) {
			result = false;
			errorMessage = ex.getMessage() != null ? ex.getMessage() : "unknown error";
		}

		UploadResultVO v = new UploadResultVO();
		v.setResult(result);
		v.setErrorMessage(errorMessage);
		v.setCode("00000");
		return v;
	}
	
}
