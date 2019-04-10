package info.dkuswai.abc.KleinSchwarzeBox.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BasicMapper {
    List<HashMap<String, Object>> list();
}