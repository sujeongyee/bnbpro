package com.ddu.pro.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ddu.pro.command.LodgmentVO;
import com.ddu.pro.command.RoomImgVO;
import com.ddu.pro.command.RoomVO;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Value("${project.upload.path}")
	private String uploadPath;

	// 폴더 생성 함수
	public String makeFolder() {
		String path = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		File file = new File(uploadPath + "/" + path);
		if (file.exists() == false) { // 존재하면 true, 존재하지 않으면 false
			file.mkdirs();
		}
		return path;
	}

	@Autowired
	RoomMapper roomMapper;

	@Override
	public ArrayList<RoomVO> getRoomList(int lodg_num) {
		return roomMapper.getRoomList(lodg_num);
	}

	@Override
	public int modifyRoom(RoomVO vo) {
		return roomMapper.modifyRoom(vo);
	}

	@Override
	public int deleteRoom(int room_num) {
		return roomMapper.deleteRoom(room_num);
	}

	@Override
	public int addRoom(RoomVO vo) {
		return roomMapper.addRoom(vo);

	}

	@Override
	public LodgmentVO getLodgment(int lodg_num) {
		return roomMapper.getLodgment(lodg_num);
	}

	@Override
	public int addRoomImg(int roomnum, List<MultipartFile> list) {
		list = list.stream().filter(p->p.isEmpty()==false).collect(Collectors.toList());
		for (MultipartFile file : list) {

			String originName = file.getOriginalFilename(); // 파일이름

			String filename = originName.substring(originName.lastIndexOf("\\") + 1); // \\ 기준으로 파일명만 잘라서 저장

			String uuid = UUID.randomUUID().toString(); // 난수 이름

			String filepath = makeFolder(); // 폴더생성

			String savepath = uploadPath + "/" + filepath + "/" + uuid + "_" + filename; // 저장 경로

			try {
				File saveFile = new File(savepath);
				file.transferTo(saveFile); // 파일 업로드를 진행
			} catch (Exception e) {
				System.out.println("파일업로드 중 error 발생");
				e.printStackTrace();
				return 0; // 실패의 의미
			}

			roomMapper.registRoomImg(RoomImgVO.builder().ro_img_filename(filename).ro_img_filepath(filepath)
					.ro_img_uuid(uuid).room_num(roomnum).build());
		}
		return 1;
	}

	@Override
	public ArrayList<RoomVO> getRoomnum() {
		return roomMapper.getRoomnum();
	}

	@Override
	public ArrayList<RoomImgVO> getimgList(int room_num) {
		return roomMapper.getimgList(room_num);
	}

	@Override
	public RoomVO getRoom(String room_num) {
		return roomMapper.getRoom(room_num);
	}

	@Override
	public int modifyRoomImg(int roomnum, List<MultipartFile> list) {
		
		ArrayList<RoomImgVO> imglist = roomMapper.getimgList(roomnum);
		
		int idx = 0;
		list = list.stream().filter(p->p.isEmpty()==false).collect(Collectors.toList());
		for (MultipartFile file : list) {

			String originName = file.getOriginalFilename(); // 파일이름

			String filename = originName.substring(originName.lastIndexOf("\\") + 1); // \\ 기준으로 파일명만 잘라서 저장

			String uuid = UUID.randomUUID().toString(); // 난수 이름

			String filepath = makeFolder(); // 폴더생성

			String savepath = uploadPath + "/" + filepath + "/" + uuid + "_" + filename; // 저장 경로

			try {
				File saveFile = new File(savepath);
				file.transferTo(saveFile); // 파일 업로드를 진행
			} catch (Exception e) {
				System.out.println("파일업로드 중 error 발생");
				e.printStackTrace();
				return 0; // 실패의 의미
			}
			roomMapper.modifyRoomImg(RoomImgVO.builder().ro_img_filename(filename).ro_img_filepath(filepath)
					.ro_img_uuid(uuid).build(),imglist.get(idx).getRo_img_num());
			idx++;
		}
		return 1;
	}

}
