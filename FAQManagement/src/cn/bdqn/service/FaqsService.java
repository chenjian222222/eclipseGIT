package cn.bdqn.service;

import java.util.List;
import java.util.Map;

import cn.bdqn.pojo.Classes;
import cn.bdqn.pojo.Faqs;

public interface FaqsService {
	public List<Faqs> getFaqsByPage(Map<String,Object> map);
	public int count(Map<String,Object> map);
	public List<Classes> getClasses();
	public int save(Faqs faqs);
	public List<Faqs> getFaqsById(Map<String,Object> map);
}
