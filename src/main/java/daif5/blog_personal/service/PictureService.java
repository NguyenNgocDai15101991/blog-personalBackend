package daif5.blog_personal.service;

import daif5.blog_personal.model.Picture;



public interface PictureService {
    void save(Picture picture);
    void delete(Long id);

}
