package com.bone.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bone.entity.Bone;

@Service
public class BoneDao extends H2BaseDao{

	public List<Bone> getAllBones() {
		return getSqlMapClientTemplate().queryForList("boneOp.getAllEntries", "t_bone");
	}

	public void addBone(Bone bone) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", bone.getId());
		map.put("name", bone.getName());
		map.put("address", bone.getAddress());
		map.put("phone", bone.getPhone());
		map.put("info", bone.getInfo());
		getSqlMapClientTemplate().insert("boneOp.addBone",map);
	}

	public int getTotalNumberOfBones() {
		return (int) getSqlMapClientTemplate().queryForObject("boneOp.getNumberOfEntries","t_bone");
	}

	public int updateBone(Map<String, Object> map) {
		return getSqlMapClientTemplate().update("boneOp.updateBone", map);
	}
	
}
