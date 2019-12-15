package daif5.blog_personal.service.impl;

import daif5.blog_personal.model.Picture;
import daif5.blog_personal.repository.PictureRepository;
import daif5.blog_personal.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;


public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureRepository pictureRepository;
    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

    @Override
    public void delete(Long id) {
        pictureRepository.deleteById(id);
    }

}
