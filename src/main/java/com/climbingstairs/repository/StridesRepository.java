package com.climbingstairs.repository;


import com.climbingstairs.models.StridesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StridesRepository extends JpaRepository<StridesRecord,Long> {


    @Query(value="select ID, result_status, steps_per_stride, flights, strides_required from STRIDES_RECORD where STRIDES_REQUIRED < ?1 LIMIT ?2", nativeQuery = true)
     List<StridesRecord> getRecords(int threshold, int limit);

}
