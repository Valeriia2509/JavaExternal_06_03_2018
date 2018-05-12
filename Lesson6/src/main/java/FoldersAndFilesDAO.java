
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoldersAndFilesDAO implements FoldersAndFilesDAOInterface{
    private Scanner sc=new Scanner(System.in);
    private ConnectionPoolDB connectionPool=new ConnectionPoolDB();
    private Logger log=Logger.getLogger(FoldersAndFilesDAO.class);

    public Connection getConnection() {
        //Connection connection=ConnectorDB.getConnection();
        Connection connection=connectionPool.getConnectionFromPool();
        if (connection!=null) {
            log.info("Got connection");
        } else {
            log.error("Connection failed");
        }
        return connection;
    }

    public List<Folder> getFolders(){
        List<Folder> folders = new ArrayList<>();
        Connection connection=getConnection();
        String sql="SELECT * FROM Folders";
        ResultSet rs;
        try {
            PreparedStatement pr  = connection.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                Folder folder = new Folder();
                folder.setId(rs.getInt(1));
                folder.setName(rs.getString(2));
                folders.add(folder);
            }
            rs.close();
            log.info("Got array of Folders");
        } catch (SQLException e) {
            log.error(e);
        }
        //connection.close();
        connectionPool.returnConnectionToPool(connection);
        return  folders;
    }

    public List<File> getFiles(){
        List<File> files = new ArrayList<>();
        Connection connection=getConnection();
        String sql="SELECT * FROM Files";
        ResultSet rs;
        try {
            PreparedStatement pr  = connection.prepareStatement(sql);
            rs=pr.executeQuery();
            while(rs.next()){
                File file = new File();
                file.setId(rs.getInt(1));
                file.setName(rs.getString(2));
                file.setFormat(rs.getString(3));
                file.setModified(rs.getDate(4));
                file.setFolderName(rs.getString(5));
                files.add(file);
            }
            rs.close();
            log.info("Got array of Files");
        } catch (SQLException e) {
            log.error(e);
        }
        //connection.close();
        connectionPool.returnConnectionToPool(connection);
        return  files;
    }

    public boolean addFolder(Folder folder)  {
        Connection connection=getConnection();
        String sql="INSERT INTO Folders(id,Name) VALUES(?,?)";
        PreparedStatement pr ;
            int result = 0;
            try {
                pr = connection.prepareStatement(sql);
                pr.setInt(1,folder.getId());
                pr.setString(2,folder.getName());
                result=pr.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                log.error(e);
            }
        //connection.close();
        connectionPool.returnConnectionToPool(connection);

        if (result>0){
            log.info("Folder added");
                return true;
        }
        else return false;
    }

    public boolean addFile(File file){
        Connection connection=getConnection();
        String sql1="INSERT INTO Files(id, name, format,modified,foldername) VALUES(?,?,?,?,?)";
        String sql2="SELECT * FROM Folders WHERE name=?";
        PreparedStatement pr1;
        PreparedStatement pr2;
        ResultSet rs;
            try {
                Savepoint save1=connection.setSavepoint();
                pr1 = connection.prepareStatement(sql1);
                pr1.setInt(1,file.getId());
                pr1.setString(2,file.getName());
                pr1.setString(3,file.getFormat());
                pr1.setDate(4,file.getModified());
                pr1.setString(5,file.getFolderName());
                pr1.executeUpdate();

                try {
                    pr2 = connection.prepareStatement(sql2);
                    pr2.setString(1,file.getFolderName());
                    rs=pr2.executeQuery();
                    if (rs.next())
                        rs.getInt(1);
                    //connection.commit();
                    log.info("File added");
                    return true;
                } catch (SQLException e) {
                    connection.rollback(save1);
                    log.error("There is no such folder");
                }
            } catch (SQLException e) {
                log.error(e);
            }
            //connection.close();
            connectionPool.returnConnectionToPool(connection);
            return false;
    }

    public boolean deleteFolder(String name){
        Connection connection=getConnection();
        String sql="DELETE fo, f FROM Folders fo Join Files f ON fo.name=f.folderName WHERE fo.name=?";
        PreparedStatement pr ;
        int result=0;
        try {
            pr = connection.prepareStatement(sql);
            pr.setString(1,name);
            result=pr.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            log.error(e);
        }
        //connection.close();
        connectionPool.returnConnectionToPool(connection);

        if (result>0) {
            log.info("Folder deleted");
            return true;
        }
        else return false;
    }

    public boolean deleteFile(int fileId){
        Connection connection=getConnection();
        String sql="DELETE FROM Files WHERE id=?";
        PreparedStatement pr ;
        int result=0;
        try {
            pr = connection.prepareStatement(sql);
            pr.setInt(1,fileId);
            result=pr.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            log.error(e);
        }
        //connection.close();
        connectionPool.returnConnectionToPool(connection);

        if (result>0) {
            log.info("File deleted");
            return true;
        }
        else return false;
    }

    public List<File> findFilesInFolder(String folder){
        Connection connection=getConnection();
        String sql="SELECT * FROM Files f WHERE f.folderName= ?";
        List<File> files = new ArrayList<>();
        ResultSet rs;
        try {
            PreparedStatement pr  = connection.prepareStatement(sql);
            pr.setString(1,folder);
            rs=pr.executeQuery();
            while(rs.next()){
                File file= new File();
                file.setId(rs.getInt(1));
                file.setName(rs.getString(2));
                file.setFormat(rs.getString(3));
                file.setModified(rs.getDate(4));
                file.setFolderName(rs.getString(5));
                files.add(file);
            }
            rs.close();
            log.info("Files was found");
        } catch (SQLException e) {
            log.error(e);
        }
        //connection.close();
        connectionPool.returnConnectionToPool(connection);
        return files;
    }
}
