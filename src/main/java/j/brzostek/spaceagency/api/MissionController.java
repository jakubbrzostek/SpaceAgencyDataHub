package j.brzostek.spaceagency.api;

import j.brzostek.spaceagency.DAO.entity.Mission;
import j.brzostek.spaceagency.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/missions")
public class MissionController {

    private MissionService missionList;

    @Autowired
    public MissionController(MissionService missionList) {
        this.missionList = missionList;
    }

    @GetMapping("/all")
    public Iterable<Mission> getAll() {
        return missionList.findAll();
    }

    @GetMapping
    public Optional<Mission> getById(@RequestParam Long index) {
        return missionList.findById(index);
    }

    @PostMapping
    public Mission addMission(@RequestBody Mission mission) {
        return missionList.save(mission);
    }

    @PutMapping
    public Mission updateMission(@RequestBody Mission mission) {
        return missionList.save(mission);
    }

    @DeleteMapping
    public void deleteMission(@RequestBody Long index) {
        missionList.deleteById(index);
    }


}
