package vn.hoangptit.learningframework.dao.impl;

/**
 * author Hoangptit
 * Date 9/14/2016
 */
public class Test {

    public static float tinhLuong(int ngayLam, float luong){
        return ngayLam*luong;
    }

    public static Float tinhLuongWrapper(Integer ngayLam, Float luong){
        return ngayLam*luong;
    }

    public static void main(String[] args) {
        tinhLuong(1,3);
        tinhLuongWrapper(1,3F);
    }
}
