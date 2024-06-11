package com.cwnu.lease.common.login;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Jisam
 */
@Data
@AllArgsConstructor
public class LoginUser {
    private Long userId;
    private String username;
}
