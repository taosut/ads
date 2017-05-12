package com.hanv.ads.repository;

import com.hanv.ads.domain.Post;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Post entity.
 */
@SuppressWarnings("unused")
public interface PostRepository extends JpaRepository<Post,Long> {

}
