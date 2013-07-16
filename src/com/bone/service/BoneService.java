package com.bone.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bone.entity.Bone;
@Service
public interface BoneService {
	List<Bone> getAllBones();
	void addBone(Bone bone);
	int getTotalNumberOfBones();
	int updateBone(Map<String, Object> map);
	void addDummyBones(int entries);
}
