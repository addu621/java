package com.example.cars.repositories;

import com.example.cars.entities.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDetailsRepo extends JpaRepository<PostDetails,Integer> {

    PostDetails findByPostId(Integer postId);

    @Query(value = "select * from post_details where is_approved=false",nativeQuery = true)
    List<PostDetails> findAllUnApprovedPosts();
}
