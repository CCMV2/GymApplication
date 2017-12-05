package com.ubb.gymapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubb.gymapp.model.Rating;

public interface RatingRepository extends JpaRepository <Rating, Long>{

}
