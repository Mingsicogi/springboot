package com.sample.app.pds.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sample.app.common.util.FUpUtil;
import com.sample.app.pds.model.PdsDTO;
import com.sample.app.pds.model.PdsOrderOption;
import com.sample.app.pds.service.PdsService;

@Controller
public class PdsController {
	
	@Autowired
	private PdsService pdsService;
	
	@RequestMapping(value = "pds/main", method = {RequestMethod.POST, RequestMethod.GET})
	public String getPdsList(Model model, PdsOrderOption option) {
		
		model.addAttribute("doc_title", "자료실");//제목 설정
				
		//검색어가 없으면 cond를 4로 설정
		if( option.getKeyword().length() < 1 ) {
			option.setCond(4);
		}
		
		//전체사이즈 세팅
		option.setTotalSize( pdsService.getTotalSize(option) );
		
		System.out.println("[PdsController]" + option.toString());
		
		List<PdsDTO> pdsList = pdsService.getPdsList(option);
				
		model.addAttribute("PdsOrderOption", option);
		model.addAttribute("pdsList", pdsList);
		
		return "pdsmain.tiles";
	}
	
	/**자료실 게시물을 업로드하기 위한 뷰로 이동시키는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pds/write")
	public String showPdsWrite(Model model) {
		
		model.addAttribute("doc_title", "자료실 > 자료 업로드");//제목 설정
		
		return "pdswrite.tiles";
	}
	
	/**자료실 게시물 저장하는 메소드
	 * @param model
	 * @param sourceFile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "pds/savefile", method = RequestMethod.POST)
	public String showPdsSaveFile(Model model,  
			@RequestParam(value="fileload", required = false) MultipartFile fileload,
			PdsDTO pdsDTO,
			HttpServletRequest req) throws IOException {
				
		//서버에 파일을 저장할 때에는 파일명을 시간값으로 변경
		//DB에 저장할 때에는 원본 파일명과 시간값을 모두 저장
		//filename 취득
		String filename = fileload.getOriginalFilename();
		pdsDTO.setFilename(filename);
		pdsDTO.setOrigin_filename(filename);
		//upload 경로 설정(tomcat realpath)
		String fuploadPath = req.getServletContext().getRealPath("/upload");

		//폴더 경로 설정
		String f = pdsDTO.getFilename();
		String newfilename = FUpUtil.name(f);
		
		//업로드 수행
		pdsDTO.setFilename(newfilename);
		
		File file = new File(fuploadPath + "/" + newfilename);
		
		try {
			//실제 파일이 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes() );
			
			//db에 값 저장
			pdsService.uploadPds(pdsDTO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return "redirect:/" + req.getContextPath() + "/pds/main";
		return "redirect:/pds/main";
	}
	

	/**파일이름, seq 번호를 받아서 해당 파일을 다운로드 시켜주는 기능을 가진 메소드
	 * @param param
	 * @param req
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "pds/downloadfile", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Resource> downloadFile(String filename, int seq,
				HttpServletRequest req) throws IOException {
		//경로 설정
		String fuploadPath = req.getServletContext().getRealPath("/upload");
		
		//파일정보 설정
		PdsDTO pdsdto = pdsService.getOnePds(seq);
		String fileName = pdsdto.getFilename();
		String origin_fileName = pdsdto.getOrigin_filename();
		File file = new File(fuploadPath + "/" + fileName);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attatchment; filename=\"" + 
                new String(origin_fileName.getBytes("UTF-8"), "ISO-8859-1") + 
                "\"");

	    InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	    return ResponseEntity.ok()
	    		.headers(headers)
	            .contentLength(file.length())
	            .contentType(MediaType.parseMediaType("application/octet-stream"))
	            .body(resource);
	}
	
	/**자료실 게시물 1개의 상세정보를 볼 수 있는 뷰로 이동시키는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pds/detail")
	public String showPdsDetail(Model model, int seq) {
		
		model.addAttribute("doc_title", "자료실 > 자료 상세");//제목 설정
		
		PdsDTO dto = pdsService.getOnePds(seq);
		
		model.addAttribute("pds", dto);
		
		return "pdsdetail.tiles";
	}
	
	/**자료실 게시물 1개의 내용을 수정할 수 있는 뷰로 이동시키는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pds/modify")
	public String showPdsModify(Model model, int seq) {
		
		model.addAttribute("doc_title", "자료실 > 자료 상세 > 자료 수정");//제목 설정
		
		PdsDTO dto = pdsService.getOnePds(seq);
		
		model.addAttribute("pds", dto);
		
		return "pdsmod.tiles";
	}
}
