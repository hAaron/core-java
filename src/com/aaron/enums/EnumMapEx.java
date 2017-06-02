package com.aaron.enums;

import java.util.EnumMap;

enum RoleMap {
	SYSADMIN, ROLEA, ROLEB, ROLEC;
}

/**
 * EnumMap是必须使用枚举项作为其KEY的Map，其法与普通Map类似。
 * 以下例程将两类角色的中文含义置入到一个EnumMap对象中，并随后调用了EnumMap的size和get方法。
 * 
 * @author Aaron
 * @date 2017年6月2日
 * @version 1.0
 * @package_name com.aaron.enums
 */
public class EnumMapEx {
	public static void main(String[] args) {
		EnumMap<RoleMap, String> em = new EnumMap<RoleMap, String>(
				RoleMap.class);
		em.put(RoleMap.SYSADMIN, "系统管理员");
		em.put(RoleMap.ROLEA, "角色A");

		System.out.println(em.size());
		System.out.println(em.get(RoleMap.SYSADMIN));
	}

}
