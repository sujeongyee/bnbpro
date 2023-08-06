package com.ddu.pro.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.ddu.pro.command.LodgmentVO;

@Service("lodgmentService")
public class LodgmentServiceImpl implements LodgmentService {

	@Autowired
	private LodgmentMapper lodgmentMapper;

	@Value("${project.upload.path}")
	private String uploadPath;

	public String makeFolder() {

		String path = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		File file = new File(uploadPath+"/"+path);
		if(file.exists() == false) { // 존재하면 true, 존재하지 않으면 false
			file.mkdir();
		}

		return path; // 날짜 폴더명 반환
	}

	@Override
	public int lodgmentRegist(LodgmentVO vo, List<MultipartFile> list) {
		
		for(MultipartFile file : list) {
			
			String originName = file.getOriginalFilename();  //파일이름
		
			String filename = originName.substring(originName.lastIndexOf("\\")+1);	 // \\ 기준으로 파일명만 잘라서 저장
			
			String uuid = UUID.randomUUID().toString();	 //난수 이름
			
			String filepath = makeFolder();	 //폴더생성	
			
			String savepath = uploadPath+"/"+filepath+"/"+uuid+"_"+filename; //저장 경로

			try {
				File saveFile = new File(savepath);
				file.transferTo(saveFile); // 파일 업로드를 진행
			} catch (Exception e) {
				System.out.println("파일업로드 중 error 발생");
				e.printStackTrace();
				return 0; // 실패의 의미
			}

			lodgmentMapper.lodgmentRegist(LodgmentVO.builder()
					.lodg_type(vo.getLodg_type())
					.lodg_name(vo.getLodg_name())
					.lodg_rg(vo.getLodg_rg())
					.lodg_addr(vo.getLodg_addr())
					.lodg_img_filename(filename)
					.lodg_img_filepath(filepath)
					.lodg_img_uuid(uuid)
					.lodg_ph(vo.getLodg_ph())
					.lodg_content(vo.getLodg_content())
					.bn_id(vo.getBn_id()).build()

					);
		}
		return 1;
	}

	@Override
	public List<LodgmentVO> getLodgList(String bn_id) {
		
		return lodgmentMapper.getLodgList(bn_id);
	}

}
