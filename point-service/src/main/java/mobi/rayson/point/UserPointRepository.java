package mobi.rayson.point;

public interface UserPointRepository {
    UserPointEntity selectByUserNo(String userNo);

    void update(UserPointEntity userPointEntity);
}
