package database;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 10:38 AM , 12/18/2020
 */

public class Utils {
    public static String getInsertQuery(String tableName, String columns, String values)
    {
        return "INSERT INTO " + tableName + columns + " VALUES " + values + ";";
    }

    public static String getGetQuery(String tableName, String columns, String conditions)
    {
        String query = "SELECT " + columns + " FROM " + tableName ;
        if (conditions != null) query +=  " WHERE " + conditions ;

        return query + ";";
    }
}
