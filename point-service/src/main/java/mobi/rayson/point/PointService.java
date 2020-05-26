package mobi.rayson.point;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PointService {

    @Resource
    private UserPointRepository userPointRepository;

    public void updateByUserNo(String userNo) throws Exception {
        //  模拟异常
        if (StringUtils.equals(userNo, "2")){
            throw new Exception("模拟异常出现了...");
        }
        UserPointEntity foundUserPointEntity = userPointRepository.selectByUserNo(userNo);
        foundUserPointEntity.setPoints(foundUserPointEntity.getPoints() + 5);
        userPointRepository.update(foundUserPointEntity);
    }
}
