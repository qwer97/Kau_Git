package Repository;

import Entity.BannedContent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface BannedContentRepository extends JpaRepository<BannedContent,Long> {

}
