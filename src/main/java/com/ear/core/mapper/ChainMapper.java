package com.ear.core.mapper;

import org.apache.ibatis.annotations.Param;

public interface ChainMapper {

	Integer getIdChain(@Param("nameChain") String nameChain);

}
