package com.pdf.parser.common.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {

    private boolean success;

    private String message;

    private T data;

}
