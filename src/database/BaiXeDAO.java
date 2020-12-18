package database;

import entity.BaiXe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project Ecobike System
 * BaiXe: Nhom 11
 * Create at 4:26 PM , 12/17/2020
 */

public class BaiXeDAO implements DAO<BaiXe> {
    private List<BaiXe> listBaiXe = new ArrayList<>();
    private DAOManager daoManager;

    public BaiXeDAO() {
    }

    public DAOManager getDaoManager() {
        return this.daoManager;
    }

    public void setDaoManager(DAOManager daoManager) {
        this.daoManager = daoManager;
    }

    @Override
    public Optional<BaiXe> get(int id) {
        return Optional.ofNullable(listBaiXe.get((int) id));
    }

    @Override
    public List<BaiXe> getAll() {
        return listBaiXe;
    }

    @Override
    public void save(BaiXe baiXe) {
        listBaiXe.add(baiXe);
    }

    @Override
    public void update(BaiXe baiXe, String[] params) {
//        BaiXe.setName(Objects.requireNonNull(
//                params[0], "Name cannot be null"));
//        BaiXe.setEmail(Objects.requireNonNull(
//                params[1], "Email cannot be null"));

        listBaiXe.add(baiXe);
    }

    @Override
    public void delete(BaiXe baiXe) {
        listBaiXe.remove(baiXe);
    }

    @Override
    public String getInsertQuery(List<BaiXe> list) {
        String values = "";
        for (BaiXe baiXe:
             list) {
            values += baiXe.toString() + ",";
        }
        if(values.charAt(values.length()-1) == ',') values = values.substring(0, values.length()-1);
        return Utils.getInsertQuery(BaiXe.name, BaiXe.paramsName, values);
    }

    @Override
    public void getFromDB() {

    }
}
