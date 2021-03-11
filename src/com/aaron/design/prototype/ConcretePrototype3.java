package com.aaron.design.prototype;

import java.io.*;

/**
 * 深复制
 * 
 * @author Aaron
 * @date 2019年6月21日
 * @version 1.0
 * @package_type com.aaron.design.prototype.ConcretePrototype3
 */
public class ConcretePrototype3 implements Prototype, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1036439683614905961L;
    /**
     * 对象属性
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Prototype cloneMethod() {
        // 将对象写入流中
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            // 将对象从流中取出来
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return (Prototype)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "ConcretePrototype3 [name=" + name + "]";
    }
}
