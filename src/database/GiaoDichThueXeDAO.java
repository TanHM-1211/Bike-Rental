package database;

import entity.GiaoDichThueXe;
import entity.Xe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:26 PM , 12/17/2020
 */

public class GiaoDichThueXeDAO implements DAO<GiaoDichThueXe> {
    private List<GiaoDichThueXe> listGiaoDichThueXe = new ArrayList<>();

    public GiaoDichThueXeDAO() {
    }

    @Override
    public Optional<GiaoDichThueXe> get(long id) {
        return Optional.ofNullable(listGiaoDichThueXe.get((int) id));
    }

    @Override
    public List<GiaoDichThueXe> getAll() {
        return listGiaoDichThueXe;
    }

    @Override
    public void save(GiaoDichThueXe giaoDichThueXe) {
        listGiaoDichThueXe.add(giaoDichThueXe);
    }

    @Override
    public void update(GiaoDichThueXe giaoDichThueXe, String[] params) {
//        Xe.setName(Objects.requireNonNull(
//                params[0], "Name cannot be null"));
//        Xe.setEmail(Objects.requireNonNull(
//                params[1], "Email cannot be null"));

        listGiaoDichThueXe.add(giaoDichThueXe);
    }

    @Override
    public void delete(GiaoDichThueXe giaoDichThueXe) {
        listGiaoDichThueXe.remove(giaoDichThueXe);
    }
}