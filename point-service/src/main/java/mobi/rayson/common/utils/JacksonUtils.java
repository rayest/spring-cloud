package mobi.rayson.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.stereotype.Service;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 1:39 PM
 *  Description:
 **/
@Service
public class JacksonUtils {

  public final String DEFAULT_CHARSET = "UTF-8";

  private ObjectMapper objectMapper = new ObjectMapper();

  public byte[] getByteFromObject(Object object) throws Exception {
    String json = objectMapper.writeValueAsString(object);
    return json.getBytes(DEFAULT_CHARSET);
  }

  public <T> T convertFromByte(byte[] body, Class<T> type) throws IOException {
    return objectMapper.readValue(body, type);
  }

  public <T> T convertFromStr(String body, Class<T> type) throws IOException {
    return objectMapper.readValue(body, type);
  }
}
