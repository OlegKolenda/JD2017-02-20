package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.Connection.ConnectorCreator;
import by.it.smirnov.jd03_02.bean.Sdel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class SdelCrud extends AbstractCrud<Sdel>{
    private static final String selectSQL = "SELECT `id`,`idbank`,`summa`,`idvalut`,`idopertype`,`fromdate`,`todate`,`idsysoper`,`idsysoperedit` FROM `sdels` WHERE ID=?";
    private static final String insertSQL = "INSERT INTO `sdels`(`id`,`idbank`,`summa`,`idvalut`,`idopertype`,`fromdate`,`todate`,`idsysoper`,`idsysoperedit`) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String updateSQL = "UPDATE `sdels` SET `idbank`=?,`summa`=?,`idvalut`=?,`idopertype`=?,`fromdate`=?,`todate`=?,`idsysoper`=?,`idsysoperedit`=? WHERE ID=?";
    private static final String deleteSQL = "DELETE FROM `sdels` WHERE ID=?";

    @Override
    Sdel CreateElement(ResultSet rs) throws SQLException {
        return new Sdel(
                rs.getInt("ID"),
                rs.getInt("idbank"),
                rs.getDouble("summa"),
                rs.getInt("idvalut"),
                rs.getInt("idopertype"),
                rs.getDate("fromdate"),
                rs.getDate("todate"),
                rs.getInt("idsysoper"),
                rs.getInt("idsysoperedit")
        );
    }

    @Override
    Sdel CreateElement(int id) {
        Sdel sdel = new Sdel();
        sdel.setId(id);
        return sdel;
    }

    @Override
    PreparedStatement getStatementInsertSQL(Sdel sdel) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(insertSQL, RETURN_GENERATED_KEYS);
        ps.setInt(1,sdel.getId());
        ps.setInt(2,sdel.getIdbank());
        ps.setDouble(3,sdel.getSumma());
        ps.setInt(4,sdel.getIdvalut());
        ps.setInt(5,sdel.getIdopertype());
        ps.setDate(6,sdel.getFromdate());
        ps.setDate(7,sdel.getTodate());
        ps.setInt(8,sdel.getIdsysoper());
        ps.setInt(9,sdel.getIdsysoperedit());
        return ps;
    }

    @Override
    PreparedStatement getStatementUpdateSQL(Sdel sdel) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(updateSQL);
        ps.setInt(1,sdel.getIdbank());
        ps.setDouble(2,sdel.getSumma());
        ps.setInt(3,sdel.getIdvalut());
        ps.setInt(4,sdel.getIdopertype());
        ps.setDate(5,sdel.getFromdate());
        ps.setDate(6,sdel.getTodate());
        ps.setInt(7,sdel.getIdsysoper());
        ps.setInt(8,sdel.getIdsysoperedit());
        ps.setInt(9,sdel.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementDeleteSQL(Sdel sdel) throws SQLException {
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(deleteSQL);
        ps.setInt(1,sdel.getId());
        return ps;
    }

    @Override
    PreparedStatement getStatementSelectSQL(Sdel sdel) throws SQLException{
        PreparedStatement ps = ConnectorCreator.getConnection().prepareStatement(selectSQL);
        ps.setInt(1,sdel.getId());
        return ps;
    }

}