package com.demo.cyj.scroller.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: ChenYJ
 * Date: 2016/3/16 15:43
 * Email:cyjchenxiao@163.com
 */
public class ParcelablePerson implements Parcelable {

    private int id;
    private String name;

    protected ParcelablePerson(Parcel in) {
        // 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
        id = in.readInt();
        name = in.readString();
    }

    protected ParcelablePerson(){

    }

    // 1.必须实现Parcelable.Creator接口,否则在获取ParcelablePerson数据的时候，会报错，如下：
    // android.os.BadParcelableException:
    // Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class com.um.demo.ParcelablePerson
    // 2.这个接口实现了从Percel容器读取ParcelablePerson数据，并返回ParcelablePerson对象给逻辑层使用
    // 3.实现Parcelable.Creator接口对象名必须为CREATOR，不如同样会报错上面所提到的错；
    // 4.在读取Parcel容器里的数据事，必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
    // 5.反序列化对象
    public static final Creator<ParcelablePerson> CREATOR = new Creator<ParcelablePerson>() {
        @Override
        public ParcelablePerson createFromParcel(Parcel source) {
            //Type 1
//            return new ParcelablePerson(source);
            //Type2
            ParcelablePerson p = new ParcelablePerson();
            p.setId(source.readInt());
            p.setName(source.readString());
            return  p;
        }

        @Override
        public ParcelablePerson[] newArray(int size) {
            return new ParcelablePerson[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 实现抽象方法 writeToParcel，
     * 用于获取对象的当前状态并写入一个Parcel容器中
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        // TODO Auto-generated method stub
        // 1.必须按成员变量声明的顺序封装数据，不然会出现获取数据出错
        // 2.序列化对象
        dest.writeInt(id);
        dest.writeString(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
