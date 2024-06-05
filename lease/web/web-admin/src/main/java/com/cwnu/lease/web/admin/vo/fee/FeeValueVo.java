package com.cwnu.lease.web.admin.vo.fee;

import com.cwnu.lease.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "杂费值")
@Data
public class FeeValueVo extends FeeValue {

    @Schema(description = "费用所对的fee_key名称")
    private String feeKeyName;
}
