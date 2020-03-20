package j.brzostek.spaceagency.service;

import j.brzostek.spaceagency.DAO.MissionRepository;
import j.brzostek.spaceagency.DAO.entity.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class MissionService {

    private MissionRepository missionRepository;

    @Autowired
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public Optional<Mission> findById(Long id) {
        return missionRepository.findById(id);
    }

    public Iterable<Mission> findAll() {
        return missionRepository.findAll();
    }
    public Mission save(Mission mission) {
        return missionRepository.save(mission);
    }

    public void deleteById(Long id) {
        missionRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    //test purposes
    public void fillDB() {
        save(new Mission(1L, "Panchromatic", Instant.parse("2020-02-18T13:08:47.286655400Z"), Instant.now()));
        save(new Mission(2L, "Multispectral", Instant.parse("2020-01-18T13:08:47.286655400Z"), Instant.now()));
        save(new Mission(3L, "Hyperspectral", Instant.parse("2019-02-18T13:08:47.286655400Z"), Instant.now()));
    }

}
