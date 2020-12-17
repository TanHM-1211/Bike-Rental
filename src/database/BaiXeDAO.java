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

    public BaiXeDAO() {
    }

    @Override
    public Optional<BaiXe> get(long id) {
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
}
