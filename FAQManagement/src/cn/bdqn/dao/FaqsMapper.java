package cn.bdqn.dao;

import java.util.List;
import java.util.Map;

import cn.bdqn.pojo.Faqs;

public interface FaqsMapper {
	public List<Faqs> getFaqsByPage(Map<String,Object> map);
	public int count(Map<String,Object> map);
	public int save(Faqs faqs);
	public List<Faqs> getFaqsById(Map<String,Object> map);
}
