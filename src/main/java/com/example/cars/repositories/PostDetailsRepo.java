package com.example.cars.repositories;

import com.example.cars.entities.PostDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDetailsRepo extends JpaRepository<PostDetails,Integer> {

    PostDetails findByPostId(Integer postId);
}
