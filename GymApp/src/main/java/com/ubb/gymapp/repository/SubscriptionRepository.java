package com.ubb.gymapp.repository;

import org.springframework.data.repository.CrudRepository;


import com.ubb.gymapp.model.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {

}
