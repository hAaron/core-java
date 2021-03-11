package com.aaron.enums;

import java.util.EnumSet;

enum Role {
    SYSADMIN, ROLEA, ROLEC;
}

/**
 * EnumSet用于保存枚举项的集合，在枚举项本身并不互斥的情况下特别有用。 例如，一个应用系统通常会有多种角色，而某些人在系统中可能承担不止一种角色。如果这些角色是通过枚举定义的，
 * 则此时EnumSet将可以将多种角色保存在一起，标识特定用户承担的全部角色。
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.enums
 */
public class EnumSetEx {

    public static void main(String[] args) {
        EnumSet<Role> enumSet = EnumSet.of(Role.ROLEA, Role.ROLEC);
        for (Role role : enumSet) {
            System.out.println(role);
        }
    }

}
