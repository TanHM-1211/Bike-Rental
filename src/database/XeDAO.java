package database;

import entity.The;
import entity.Xe;

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

    public XeDAO() {
        this.listXe = this.getAll();
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
        listXe.add(xe);
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
