package com.competition.minshengstoriessmartsupermarketwarehousingmanagement.mapper;
import com.competition.minshengstoriessmartsupermarketwarehousingmanagement.entitity.testTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface testMapper{
    @Select("select * from testTable")
    List<testTable> selectAll();
}
