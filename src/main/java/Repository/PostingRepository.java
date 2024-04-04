package Repository;
import Entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
public interface PostingRepository extends JpaRepository<Posting,Long> {
}
