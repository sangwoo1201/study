package com.dw.emp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.emp.mapper.DeptMapper;
import com.dw.emp.vo.DeptVO;
import com.dw.emp.vo.EmpVO;
import com.github.pagehelper.PageHelper;

@Service
public class DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	// 부서 전체 조회
	public List<Map<String, Object>> getDeptPageList(int page){
		// 필요에 따라 고객 요구사항이 들어오면 여기서 로직을 구현하면 됩니다.
		int pageSize = 10;
		PageHelper.startPage(page, pageSize);
		return deptMapper.selectDept();
	}
	// 부서 추가
	public int setDept(DeptVO vo) {
		int deptno = vo.getDeptno();
		int count = deptMapper.selectCountByDeptNo(deptno);
		if(count > 0) {
			return 0;
		}
		return deptMapper.insertDept(vo);
	}
	// 특정 부서 조회
	public DeptVO getDeptByDeptno(int deptno) {
		return deptMapper.selectDeptByDeptno(deptno);
	}
	// 특정 부서 정보 수정
	public int getDeptUpdate(DeptVO vo){
		return deptMapper.updateDept(vo);
	}
	// 특정 부서 삭제(is_use)
	public int getFireDept(int deptno) {
	  return deptMapper.fireDept(deptno);
	}

}