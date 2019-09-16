package com.sample.app.calendar.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.app.calendar.model.CalendarDto;
import com.sample.app.calendar.model.FullCalendarDTO;
import com.sample.app.common.util.CustomCalendarUtil;

@Controller
public class CalendarController {
private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	/**calmain뷰로 보내주는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "calmain")
	public String calMain(Model model) {
		
		logger.info("CalendarController calMain()");
		
		model.addAttribute("doc_title", "일정관리");//제목 설정
		model.addAttribute("cal", new CustomCalendarUtil());
		
		return "calmain.tiles";
	}
	
	/**Ajax 통신을 통해 DB에 저장된 스케줄을 리턴하는 메소드
	 * @param model
	 * @param jsMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "calendar/getall")
	public Map<String, FullCalendarDTO> calGetSchedules(Model model, @RequestBody Map<String, Object> jsMap){
		logger.info("ajax input : " + jsMap.get("year") + "  ..  " + jsMap.get("month"));
		Map<String, FullCalendarDTO> javaMap = new HashMap<String, FullCalendarDTO>();
		//Map<String, CalendarDto> javaMap = new HashMap<String, CalendarDto>();
		//javaMap.put("f", CalendarDto.builder().id("1").content("내용").build());
		//javaMap.put("s", CalendarDto.builder().id("2").content("내용").title("제목").build());
		
		//javaMap.put("evt1", FullCalendarDTO.builder().title("db이벤트1").start("2019-09-04").end("2019-09-05").allDay("false").build());
		//javaMap.put("evt2", FullCalendarDTO.builder().title("db이벤트2").start("2019-09-23").end("2019-09-24").allDay("false").build());
		
		javaMap.put("evt1", new FullCalendarDTO("db이벤트1", "2019-09-04", "2019-09-06", "false") );
		javaMap.put("evt2", new FullCalendarDTO("db이벤트2", "2019-09-23", "2019-09-26", "false") );		
		
		//System.out.println(javaMap);
		
		return javaMap;
	}
}
