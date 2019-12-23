package mobi.rayson.point;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserPointEntity {
    private Integer id;
    private String userNo;
    private Integer points;
}
