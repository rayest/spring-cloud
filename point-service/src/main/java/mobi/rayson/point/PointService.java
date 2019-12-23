package mobi.rayson.point;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PointService {

    @Resource
    private UserPointRepository userPointRepository;

    public void updateByUserNo(String userNo) {
        UserPointEntity foundUserPointEntity = userPointRepository.selectByUserNo(userNo);
        foundUserPointEntity.setPoints(foundUserPointEntity.getPoints() + 5);
        userPointRepository.update(foundUserPointEntity);
    }
}
