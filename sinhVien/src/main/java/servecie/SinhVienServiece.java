package servecie;

import entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienServiece {
    ArrayList<SinhVien> danhSach = new ArrayList<>();

    public SinhVienServiece(){
        danhSach.add(new SinhVien("SV001","Cao Duc Anh",23,true));
        danhSach.add(new SinhVien("SV002","Cao Ly Huynh",22,true));
        danhSach.add(new SinhVien("SV003","Dau Cong Hoan",22,true));
        danhSach.add(new SinhVien("SV004","Nguyen Trong Nghia",23,true));
        danhSach.add(new SinhVien("SV005","Nguyen Huong Tra",23,false));
    }

    public ArrayList<SinhVien>getAll(){
        return danhSach;
    }

    public SinhVien getByMaSV(String ma){
        for (SinhVien sv: danhSach){
            if(sv.getMa().equals(ma)){
                return sv;
            }
        }
        return null;
    }

    public void them(SinhVien sv){
        danhSach.add(sv);
    }

    public void sua(SinhVien sv, int id ){

        for (int i = 0;i < danhSach.size();i++){
            if(i == id){
                danhSach.set(i,sv);
            }
        }
    }

    public void xoa(String ma){
        List<SinhVien> temp = new ArrayList<>();
        for (SinhVien sv : danhSach){
            if(ma.equals(sv.getMa())){
                temp.add(sv);
            }
        }
        danhSach.removeAll(temp);
    }
}
