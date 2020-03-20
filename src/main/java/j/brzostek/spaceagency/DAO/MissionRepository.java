package j.brzostek.spaceagency.DAO;

import j.brzostek.spaceagency.DAO.entity.Mission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends CrudRepository<Mission,Long> {
}
