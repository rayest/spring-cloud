package mobi.rayson.point.configuration;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 3:44 PM
 *  Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPointLog implements Serializable {
  private int customerId;
  private int point;
}
