package cafe.jjdev.ajaxcrud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.ajaxcrud.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public Map<String, Object> pagingMemberList(int currentPage) {
		
		int countMember = memberMapper.countMemberList();
		int rowPerPage = 10;
		
		int startRow = (currentPage-1)*rowPerPage;
		System.out.println(startRow + "startRow");
		int lastPage = countMember/rowPerPage;
		System.out.println(lastPage + "lastPage");
		if(countMember%rowPerPage != 0) {
			lastPage++; //lastPage = lastPage + 1;
		}
		
		
		List<Member> list = memberMapper.pagingMemberList(startRow, rowPerPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lastPage", lastPage);
		map.put("list", list);
		map.put("currentPage", currentPage);
		return map;
	}
}
