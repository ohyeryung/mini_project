package com.ohye.mini_pj.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    void lombok_test() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto responseDto = new HelloResponseDto(name, amount);

        // then
        assertThat(responseDto.getName()).isEqualTo(name);
        assertThat(responseDto.getAmount()).isEqualTo(amount);
    }

}