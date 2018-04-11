package com.platzi.platziprofesores.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.platzi.platziprofesores.model.SocialMedia;
import com.platzi.platziprofesores.model.TeacherSocialMedia;

@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements SocialMediaDao {

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().persist(socialMedia);

	}

	@Override
	public void deleteSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		SocialMedia socialMedia = findSocialMediaById(idSocialMedia);

		if (socialMedia != null) {
			getSession().delete(socialMedia);
		}

	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		// TODO Auto-generated method stub
		getSession().update(socialMedia);

	}

	@Override
	public SocialMedia findSocialMediaById(Long idSocialMedia) {
		// TODO Auto-generated method stub
		return getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public List<SocialMedia> findAllSocialMedia() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findSocialMediaByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name").setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndNickname(Long idSocialMedia, String nickname) {
		// TODO Auto-generated method stub

		List<Object[]> objects = getSession()
				.createQuery("from TeacherSocialMedia tsm join tsm.socialMedia sm "
						+ "where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickname")
				.setParameter("idSocialMedia", idSocialMedia).setParameter("nickname", nickname).list();

		if (objects.size() > 0) {
			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					if (object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}

		/*
		 * Al realizar este JOIN, se pueden devolver múltiples objetos de tipo
		 * TeacherSocialMedia, SocialMedia ó Teacher, por lo tanto se deben guardar en
		 * una lista de arreglos de objetos.
		 * 
		 * El primer for, recorre el List<Object> y el segundo for recorre el Object[]
		 * de cada fila del List<Object>
		 * 
		 */
		return null;
	}

}
