package com.codeforce.product.repo;

import com.codeforce.product.model.UserImages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImagesRepository extends CrudRepository<UserImages, Long> {
}
