package controller;

import entity.SinhVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import servecie.SinhVienServiece;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="SinhVienController",value = {
        "/sinh-vien/danh-sach",
        "/sinh-vien/view-add",
        "/sinh-vien/add",
        "/sinh-vien/detail",
        "/sinh-vien/update",
        "/sinh-vien/delete"
})
public class SinhVienController extends HttpServlet {
    SinhVienServiece svSeVy = new SinhVienServiece();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String uri = req.getRequestURI();
       if(uri.contains("danh-sach")){
           hienThi(req,resp);
       }else if(uri.contains("view-add")){
            Viewthem(req,resp);
       }else if(uri.contains("detail")){
           showDetail(req,resp);
       }else if(uri.contains(("update"))){
           viewSua(req,resp);
       }else if(uri.contains("delete")){
           xoa(req,resp);
       }
    }

    protected void hienThi(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ArrayList<SinhVien> danhSach = svSeVy.getAll();
        req.setAttribute("danhSach",danhSach);
        req.getRequestDispatcher("/sinh-vien/danh-sach.jsp").forward(req,resp);
    }

    protected void Viewthem(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/sinh-vien/add.jsp").forward(req,resp);
    }

    protected void showDetail(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("id");
        if(ma != null){
            req.setAttribute("sv",svSeVy.getByMaSV(ma));
        }
        req.getRequestDispatcher("/sinh-vien/detail.jsp").forward(req,resp);
    }

    protected void viewSua(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ma = req.getParameter("id");
        if(ma !=null){
            req.setAttribute("sv",svSeVy.getByMaSV(ma));
        }
        req.getRequestDispatcher("/sinh-vien/update.jsp").forward(req,resp);
    }

    protected void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ma = req.getParameter("id");

        if(ma != null){
            System.out.println("Id xoa la:"+ ma);
            svSeVy.xoa(ma);
        }
        resp.sendRedirect("/sinh-vien/danh-sach");
    }
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")){
            them(req,resp);
        }else if(uri.contains("update")){
            sua(req,resp);
        }
    }

    protected void them(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, InvocationTargetException, IllegalAccessException {
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv,req.getParameterMap());
        svSeVy.them(sv);
        resp.sendRedirect("/sinh-vien/danh-sach");
    }

    protected void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SinhVien sv = new SinhVien();
        int id = Integer.parseInt(req.getParameter("id")) ;
        System.out.println(id);
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        int tuoi = Integer.valueOf(req.getParameter("tuoi"));
        boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        sv.setMa(ma);
        sv.setTen(ten);
        sv.setTuoi(tuoi);
        sv.setGioiTinh(gioiTinh);

        svSeVy.sua(sv,id);
        resp.sendRedirect("/sinh-vien/danh-sach");
    }


}
