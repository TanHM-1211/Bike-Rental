package database;

import entity.BaiXe;
import entity.LoaiXe;
import entity.The;
import entity.Xe;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:25 PM , 12/17/2020
 */


public class XeDAO implements DAO<Xe> {
    private List<Xe> listXe = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static XeDAO xeDAO = null;

    public XeDAO() {
        daoManager.open();
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + Xe.name + ";");
        try {
            while (resultSet.next()){
                listXe.add(parse(resultSet));
//                System.out.println(listXe.get(listXe.size()-1).toString());
            }
            resultSet.close();
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public static XeDAO getInstance(){
        if (xeDAO == null){
            xeDAO = new XeDAO();
        }
        return xeDAO;
    }

    @Override
    public Xe parse(ResultSet resultSet) {
        LoaiXeDAO loaiXeDAO = LoaiXeDAO.getInstance();
        BaiXeDAO baiXeDAO = BaiXeDAO.getInstance();
        try {
            return new Xe(resultSet.getInt(1),
                    loaiXeDAO.get(resultSet.getInt(2)),
                    resultSet.getString(3),
                    baiXeDAO.get(resultSet.getInt(4)),
                    resultSet.getInt(5),
                    resultSet.getObject(6) != null ? resultSet.getInt(6) : null);  //  pin: null neu la xe dap, Integer neu la xe dap dien
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Xe get(int id) {
        return new Xe();
    }

    @Override
    public List<Xe> getAll() {
        return listXe;
    }

    @Override
    public void save(Xe xe) {
        this.listXe.add(xe);
    }

    @Override
    public void update(Xe xe, String[] params) {
//        Xe.setName(Objects.requireNonNull(
//                params[0], "Name cannot be null"));
//        Xe.setEmail(Objects.requireNonNull(
//                params[1], "Email cannot be null"));

        listXe.add(xe);
    }

    @Override
    public void delete(Xe xe) {
        listXe.remove(xe);
    }

    @Override
    public String getInsertQuery(List<Xe> list) {
        for (Xe xe:
             listXe) {

        }
        return "";
    }
    
}
