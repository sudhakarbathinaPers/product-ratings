package com.sudhakar.store.repository;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.sudhakar.store.domain.Productratings;

public interface ProductRatingRepository extends CassandraRepository<Productratings>{
}
