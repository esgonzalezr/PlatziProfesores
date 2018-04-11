package com.platzi.platziprofesores.dao;

import java.util.List;

import com.platzi.platziprofesores.model.SocialMedia;
import com.platzi.platziprofesores.model.TeacherSocialMedia;

public interface SocialMediaDao {

	void saveSocialMedia(SocialMedia socialMedia);

	void deleteSocialMediaById(Long idSocialMedia);

	void updateSocialMedia(SocialMedia socialMedia);

	SocialMedia findSocialMediaById(Long idSocialMedia);

	List<SocialMedia> findAllSocialMedia();
	
	SocialMedia findSocialMediaByName(String name);
	
	TeacherSocialMedia findSocialMediaByIdAndNickname(Long idSocialMedia, String nickname);

}
