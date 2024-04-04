package com.itfb.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "The Account")
public class AccountDto {

    @ApiModelProperty(value = "Account Identifier")
    private int id;

    @ApiModelProperty(value = "Account Name")
    private String name;

}
