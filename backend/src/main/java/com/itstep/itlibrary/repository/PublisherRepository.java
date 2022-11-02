package com.itstep.itlibrary.repository;


import com.itstep.itlibrary.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
