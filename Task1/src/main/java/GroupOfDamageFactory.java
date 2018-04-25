import java.io.*;

public class GroupOfDamageFactory {

    public GroupOfDamage createGroupOfDamage(File file){
        GroupOfDamage groupOfDamage=new GroupOfDamage("");
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String str;
            String [] strs;
            if ((str=bufferedReader.readLine())!=null){
                groupOfDamage=new GroupOfDamage(str);
            }
            while ((str=bufferedReader.readLine())!=null){
                strs=str.split("\\t");
                InsuranceEvent event=new InsuranceEvent(strs[0],Integer.valueOf(strs[1]),Integer.valueOf(strs[2]));
                groupOfDamage.addInsuranceEvent(event);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return groupOfDamage;
    }
}
