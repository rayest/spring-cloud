package mobi.rayson.point;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PointController {

    @Resource
    private PointService pointService;

    @PutMapping("/point/{userNo}")
    public void updateByUserNo(@PathVariable("userNo") String userNo){
        pointService.updateByUserNo(userNo);
    }
}
