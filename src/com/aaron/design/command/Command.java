package com.aaron.design.command;

/**
 * 命令(Command)角色：声明了一个给所有具体命令类的抽象接口。
 * 
 * @author Aaron
 * @date 2017年6月9日
 * @version 1.0
 * @package_name com.aaron.design.command
 */
public interface Command {
    /**
     * 执行方法
     */
    public void execute();
}