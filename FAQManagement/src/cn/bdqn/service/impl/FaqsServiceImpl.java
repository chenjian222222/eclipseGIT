package cn.bdqn.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.dao.ClassesMapper;
import cn.bdqn.dao.FaqsMapper;
import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Faqs;
import cn.bdqn.service.FaqsService;

@Service
public class FaqsServiceImpl implements FaqsService{
	@Resource
	FaqsMapper faqsMapper;
	@Resource
	ClassesMapper classesMapper;
	public List<Faqs> getFaqsByPage(Map<String,Object> map){
		return faqsMapper.getFaqsByPage(map);
	}
	
	public int count(Map<String,Object> map) {
		return faqsMapper.count(map);
	}
	
	public List<Classes> getClasses(){
		return classesMapper.getClasse();
	}
	
	public int save(Faqs faqs) {
		return faqsMapper.save(faqs);
	}
	
	public List<Faqs> getFaqsById(Map<String,Object> map){
		return faqsMapper.getFaqsById(map);
	}
}
