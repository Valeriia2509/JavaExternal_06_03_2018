import java.sql.Date;

public class File {
    private int id;
    private String name;
    private String format;
    private Date modified;
    private String folderName;

    public File() {
    }

    public File(int id, String name, String format, Date modified, String folderName) {
        this.id=id;
        this.name = name;
        this.format = format;
        this.modified = modified;
        this.folderName = folderName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public Date getModified() {
        return modified;
    }

    public String getFolderName() {
        return folderName;
    }

    @Override
    public String toString() {
        return id +"\t"+name+"\t"+format +"\t"+ modified +"\t"+
                folderName;
    }
}
