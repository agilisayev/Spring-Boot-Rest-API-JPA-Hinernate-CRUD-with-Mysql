package com.demo.springbootjpadocker.api.dto;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomerDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    private String address;
}
