package j.brzostek.spaceagency.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Mission {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long missionId;
    private String imageryType;
    private Instant startDate;
    private Instant finishDate;

    public Mission() {
    }

    public Mission(Long missionId, String imageryType, Instant startDate, Instant finishDate) {
        this.missionId = missionId;
        this.imageryType = imageryType;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Long getMissionId() {
        return missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public String getImageryType() {
        return imageryType;
    }

    public void setImageryType(String imageryType) {
        this.imageryType = imageryType;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Instant finishDate) {
        this.finishDate = finishDate;
    }
}
