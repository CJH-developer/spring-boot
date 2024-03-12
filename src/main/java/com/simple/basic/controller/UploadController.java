package com.simple.basic.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.codec.multipart.MultipartHttpMessageReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.simple.basic.command.UploadVO;

@Controller
@RequestMapping("/fileupload")
public class UploadController {
	
	// 업로드 경우
	@Value("${project.upload.path}")
	private String uploadPath;
	
	// 날짜 폴더 만드는 함수 - 윈두우 시스템상 하나의 폴더에 파일이 65532 개
	public String makeFolder() {
		String filePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
		File file = new File(uploadPath + "/" + filePath);
		if(file.exists() == false ) { // 해당 파일이 있으면 true
			file.mkdirs();
		}
		return filePath;
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "fileupload/upload";
	}
	
	@PostMapping("/upload_ok")
	public String upload_ok(@RequestParam("file") MultipartFile file) {
		
		// 1. 파일 명 
		String originName = file.getOriginalFilename();
		originName = originName.substring(originName.lastIndexOf("\\") + 1);
		// 2. 파일 사이즈
		long size = file.getSize();
	
		// 동일한 파일로 업로드가 되면, 기존 파일이 덮어지기 때문에, 랜덤한 이름을 이용해서 파일 명칭 바꿈
		String uuid = UUID.randomUUID().toString();
	
		String filepath = makeFolder();
		// 3. 업로드 할 경로
		String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + originName; 
		
		System.out.println("파일명 : " + originName); // DB에 원본 파일명 저장
		System.out.println("폴더명 : " + filepath); // DB에 폴더명 저장
		System.out.println("랜덤이름 : " + uuid); // DB 저장
		System.out.println("파일 사이즈 : " + size);
		System.out.println("업로드 할 경로 : " + savePath);
		
		
		try {
			File saveFile = new File(savePath);
			file.transferTo(saveFile);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok2")
	public String upload_ok2(MultipartHttpServletRequest part) {
		
		List<MultipartFile> list = part.getFiles("file");
		
		for(MultipartFile file : list) {
			String originName = file.getOriginalFilename();
			originName = originName.substring(originName.lastIndexOf("\\") + 1);
			// 2. 파일 사이즈
			long size = file.getSize();
		
			// 동일한 파일로 업로드가 되면, 기존 파일이 덮어지기 때문에, 랜덤한 이름을 이용해서 파일 명칭 바꿈
			String uuid = UUID.randomUUID().toString();
		
			String filepath = makeFolder();
			// 3. 업로드 할 경로
			String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + originName; 
			
			System.out.println("파일명 : " + originName); // DB에 원본 파일명 저장
			System.out.println("폴더명 : " + filepath); // DB에 폴더명 저장
			System.out.println("랜덤이름 : " + uuid); // DB 저장
			System.out.println("파일 사이즈 : " + size);
			System.out.println("업로드 할 경로 : " + savePath);
			
			
			try {
				File saveFile = new File(savePath);
				file.transferTo(saveFile);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		return " fileupload/upload_ok2";
	}
	
	@PostMapping("/upload_ok3")
	public String upload_ok3(@RequestParam("file") List<MultipartFile> list) {
		
		// MultipartFile 비어있으면, 필터링
		list = list.stream().filter(m -> m.isEmpty() == false).collect(Collectors.toList());
		
		for(MultipartFile file : list) {
			String originName = file.getOriginalFilename();
			originName = originName.substring(originName.lastIndexOf("\\") + 1);
			// 2. 파일 사이즈
			long size = file.getSize();
		
			// 동일한 파일로 업로드가 되면, 기존 파일이 덮어지기 때문에, 랜덤한 이름을 이용해서 파일 명칭 바꿈
			String uuid = UUID.randomUUID().toString();
		
			String filepath = makeFolder();
			// 3. 업로드 할 경로
			String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + originName; 
			
			System.out.println("파일명 : " + originName); // DB에 원본 파일명 저장
			System.out.println("폴더명 : " + filepath); // DB에 폴더명 저장
			System.out.println("랜덤이름 : " + uuid); // DB 저장
			System.out.println("파일 사이즈 : " + size);
			System.out.println("업로드 할 경로 : " + savePath);
			
			
			try {
				File saveFile = new File(savePath);
				file.transferTo(saveFile);
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		return "fileupload/upload_ok3";
	}
	
	@PostMapping("/upload_ok4")
	@ResponseBody //일반컨트롤러에서 rest방식으로 변경
	public String upload_ok4(UploadVO vo) {
		
		MultipartFile file = vo.getFile();
		
				// 1. 파일 명 
				String originName = file.getOriginalFilename();
				originName = originName.substring(originName.lastIndexOf("\\") + 1);
				// 2. 파일 사이즈
				long size = file.getSize();
			
				// 동일한 파일로 업로드가 되면, 기존 파일이 덮어지기 때문에, 랜덤한 이름을 이용해서 파일 명칭 바꿈
				String uuid = UUID.randomUUID().toString();
			
				String filepath = makeFolder();
				// 3. 업로드 할 경로
				String savePath = uploadPath + "/" + filepath + "/" + uuid + "_" + originName; 
				
				System.out.println("파일명 : " + originName); // DB에 원본 파일명 저장
				System.out.println("폴더명 : " + filepath); // DB에 폴더명 저장
				System.out.println("랜덤이름 : " + uuid); // DB 저장
				System.out.println("파일 사이즈 : " + size);
				System.out.println("업로드 할 경로 : " + savePath);
				
				
				try {
					File saveFile = new File(savePath);
					file.transferTo(saveFile);
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		return "success";
	}
}
