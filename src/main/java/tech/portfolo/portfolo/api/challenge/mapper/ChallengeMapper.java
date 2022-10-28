package tech.portfolo.portfolo.api.challenge.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import tech.portfolo.portfolo.api.challenge.vo.ScenarioParamVo;

@Mapper
@Repository
public interface ChallengeMapper {

    Long insertChallengeScenario(ScenarioParamVo scenarioParamVo)throws Exception;

}
