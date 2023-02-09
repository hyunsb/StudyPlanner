package com.hyunsb.studyPlanner.Repository;

import com.hyunsb.studyPlanner.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

}
