import java.sql.Connection;
import java.util.List;

public interface FoldersAndFilesDAOInterface {

    public Connection getConnection();
    public List<Folder> getFolders();
    public List<File> getFiles();
    public boolean addFolder(Folder folder);
    public boolean addFile(File file);
    public boolean deleteFolder(String name);
    public boolean deleteFile(int fileId);
    public List<File> findFilesInFolder(String folder);
}
