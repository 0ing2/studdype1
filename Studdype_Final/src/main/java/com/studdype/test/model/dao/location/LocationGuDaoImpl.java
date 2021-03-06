package com.studdype.test.model.dao.location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studdype.test.model.dto.location.LocationGuDto;
import com.studdype.test.model.dto.study.StudyDto;

@Repository
public class LocationGuDaoImpl implements LocationGuDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<LocationGuDto> locationGuList() {
		List<LocationGuDto> list = new ArrayList<LocationGuDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE+"locationGuList");
		} catch (Exception e) {
			System.out.println("[ERROR] : locationGuList");
			e.printStackTrace();
		}
		return list;
	}
	
	//메인페이지 리스트 넘기기
	@Override
	public Map<Integer, String> selectGuForMainPage(List<StudyDto> studyList) {
		Map<Integer, String> selectGuForMainMap = new HashMap<Integer, String>();
		String  guName = null;
		int guNo = 0;
		for(int i=0; i<studyList.size(); i++) {
			guNo = studyList.get(i).getGu_no();
			try {
				guName = sqlSession.selectOne(NAMESPACE+"selectGuForMainPage", guNo);
			}catch(Exception e) {
					System.out.println("에러: 구 맵에 넣기");
					e.printStackTrace();
				}
			selectGuForMainMap.put(studyList.get(i).getGu_no(), guName);
			}
		return selectGuForMainMap;
		
	}

}
