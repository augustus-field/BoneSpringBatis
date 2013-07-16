package com.bone.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bone.dao.BoneDao;
import com.bone.entity.Bone;
import com.bone.service.BoneService;
@Service
public class BoneServiceImpl implements BoneService {
	@Autowired
	BoneDao boneDao;
	@Override
	public List<Bone> getAllBones() {
		return boneDao.getAllBones();
	}

	@Override
	public void addBone(Bone bone) {
		boneDao.addBone(bone);
	}

	@Override
	public int getTotalNumberOfBones() {
		return boneDao.getTotalNumberOfBones();
	}
	
	@Override
	public int updateBone(Map<String, Object> map){
		return boneDao.updateBone(map);
	}

	@Override
	public void addDummyBones(int entries) {
		for(int i=0;i<entries;i++){
			Bone bone = new Bone();
			bone.setId(i);
			bone.setAddress("Address"+i);
			bone.setInfo(new Integer(i).hashCode()+"");
			bone.setName("name"+i);
			bone.setPhone((i+"a").hashCode()+"");
			addBone(bone);
		}
	}
}
