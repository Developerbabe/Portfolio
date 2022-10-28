package tech.portfolo.portfolo.api.challenge.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScenarioParamVo {

    @ApiModelProperty(value = "사용자 일련번호",example = "1")
    private BigDecimal userSn;
    @ApiModelProperty(value = "시나리오 고유번호",example = "1000")
    private Long snroNo;

}
