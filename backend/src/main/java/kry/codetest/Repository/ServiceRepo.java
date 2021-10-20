package kry.codetest.Repository;

import kry.codetest.Entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface ServiceRepo extends JpaRepository<ServiceEntity, String> {

    @Override
    List<ServiceEntity> findAll();

    @Query("select s from ServiceEntity s")
    Stream<ServiceEntity> findAllServiceEntity();

}
