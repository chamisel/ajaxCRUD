package cafe.jjdev.ajaxcrud.mapper;
	 
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxcrud.vo.Member;
	 
@Mapper
public interface MemberMapper {
	    public List<Member> selectMemberList();
	    public List<Member> pagingMemberList(int startRow, int rowPerPage);
	    public int countMemberList();
	    public int insertMember(Member member);
	    public int deleteMember(Member member);
	    public int updateMember(Member member);
	}
