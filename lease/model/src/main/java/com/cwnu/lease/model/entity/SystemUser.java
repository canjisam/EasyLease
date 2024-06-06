package com.cwnu.lease.model.entity;

import com.cwnu.lease.model.enums.BaseStatus;
import com.cwnu.lease.model.enums.SystemUserType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统用户信息类，继承自基础实体类BaseEntity。
 * 该类描述了系统中的用户实体，包括用户名、密码等基本信息，以及与系统交互的状态信息。
 * @author Jisam
 */
@Schema(description = "员工信息")
@TableName(value = "system_user")
@Data
public class SystemUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名，用于系统中的身份标识。
     */
    @Schema(description = "用户名")
    @TableField(value = "username")
    private String username;

    /**
     * 用户密码，用于验证用户身份。
     * 注意：字段不参与查询，以保护用户隐私。
     */
    @Schema(description = "密码")
    @TableField(value = "password", select = false)
    private String password;

    /**
     * 用户的姓名，用于显示和识别用户。
     */
    @Schema(description = "姓名")
    @TableField(value = "name")
    private String name;

    /**
     * 用户类型，用于区分不同类型的用户，如管理员、普通用户等。
     */
    @Schema(description = "用户类型")
    @TableField(value = "type")
    private SystemUserType type;

    /**
     * 用户的手机号码，用于联系用户或验证用户身份。
     */
    @Schema(description = "手机号码")
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户的头像地址，用于显示用户图像。
     */
    @Schema(description = "头像地址")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * 用户的备注信息，用于记录额外的用户信息，如用户简介等。
     */
    @Schema(description = "备注信息")
    @TableField(value = "additional_info")
    private String additionalInfo;

    /**
     * 用户所在岗位的ID，用于关联用户和岗位。
     */
    @Schema(description = "岗位id")
    @TableField(value = "post_id")
    private Long postId;

    /**
     * 用户账号的状态，用于控制用户是否能登录系统等。
     */
    @Schema(description = "账号状态")
    @TableField(value = "status")
    private BaseStatus status;
}
