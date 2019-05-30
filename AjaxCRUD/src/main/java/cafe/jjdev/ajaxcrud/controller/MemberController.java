package cafe.jjdev.ajaxcrud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafe.jjdev.ajaxcrud.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.service.MemberService;
import cafe.jjdev.ajaxcrud.vo.Member;

@RestController 
public class MemberController {
    @Autowired private MemberMapper memberMapper;
    @Autowired private MemberService memberService;
	
	  //회원 페이징
	  @GetMapping("/getMembers")
	  public Map<String, Object> pagingMembers(@RequestParam(required = true, value = "currentPage")int currentPage){ 
		  Map<String, Object> map = memberService.pagingMemberList(currentPage); 
	  
	  return map; 
	  }

	/*
	 * //회원 리스트
	 * 
	 * @GetMapping("/getMembers") public List<Member> getMembers() {
	 * System.out.println("/getMembers 요청"); List<Member> list =
	 * memberMapper.selectMemberList();
	 * System.out.println("memberMapper.selectMemberList().size : "+list.size());
	 * return list; }
	 */
    //회원 추가
    @PostMapping("/addMember")
    public void addMember(Member member) {
        System.out.println("/addMember 요청");
        System.out.println("MemberController.addMember member : "+member);
        memberMapper.insertMember(member);
    }
    //회원 삭제
    @PostMapping("/removeMember")
    public void removeMember(@RequestParam(value="ck[]") String[] ck) { // List<String> ck
         System.out.println("/removeMember 요청");
        System.out.println(ck);
        for(String id : ck) {
            Member member = new Member();
            member.setId(id);
            memberMapper.deleteMember(member);
        }
    }
    //회원 수정
    @PostMapping("/modifyMember")
    public void modifyMember(Member member) {
        System.out.println("/modifyMember 요청");
        System.out.println("MemberController.modifyMember member : "+member);
        memberMapper.updateMember(member);
    }
}