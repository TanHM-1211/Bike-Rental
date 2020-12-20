package database;

import entity.GiaoDichThanhToan;
import entity.The;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 11:08 PM , 12/18/2020
 */

public class GiaoDichThanhToanDAO implements DAO<GiaoDichThanhToan> {
    private List<GiaoDichThanhToan> listGiaoDichThanhToan = new ArrayList<>();
    private DAOManager daoManager = DAOManager.getInstance();
    public static GiaoDichThanhToanDAO giaoDichThanhToanDAO = null;

    public GiaoDichThanhToanDAO() {
        ResultSet resultSet = daoManager.executeQuery("SELECT * FROM " + GiaoDichThanhToan.name + ";");
        try {
            while (resultSet.next()){
                listGiaoDichThanhToan.add(this.parse(resultSet));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static GiaoDichThanhToanDAO getInstance()
    {
        if(giaoDichThanhToanDAO == null){
            giaoDichThanhToanDAO = new GiaoDichThanhToanDAO();
        }
        return giaoDichThanhToanDAO;
    }

    @Override
    public GiaoDichThanhToan parse(ResultSet resultSet) {
        The the = TheDAO.getInstance().getTheHienTai();
        try {
            return new GiaoDichThanhToan(resultSet.getInt(1),
                    the,
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GiaoDichThanhToan get(int id) {
        for(GiaoDichThanhToan giaoDichThanhToan: this.listGiaoDichThanhToan){
            if(giaoDichThanhToan.getId() == id) return giaoDichThanhToan;
        }
        return null;
    }

    @Override
    public List<GiaoDichThanhToan> getAll() {
        return this.listGiaoDichThanhToan;
    }

    @Override
    public void save(GiaoDichThanhToan giaoDichThanhToan) {
        if (giaoDichThanhToan.getId() == -1){
            giaoDichThanhToan.setId(this.listGiaoDichThanhToan.size());
        }
        this.listGiaoDichThanhToan.add(giaoDichThanhToan);
        daoManager.executeQuery("INSERT INTO " + GiaoDichThanhToan.name + " " + GiaoDichThanhToan.paramsName +
                " VALUES " + giaoDichThanhToan.toSQLString() + ";");
    }

    @Override
    public void update(GiaoDichThanhToan giaoDichThanhToan) {

    }

    @Override
    public void delete(GiaoDichThanhToan giaoDichThanhToan) {
    }

}
