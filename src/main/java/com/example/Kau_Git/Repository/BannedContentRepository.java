package com.example.Kau_Git.Repository;

import com.example.Kau_Git.Entity.BannedContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannedContentRepository extends JpaRepository<BannedContent,Long> {
    BannedContent findById(long id);
}
