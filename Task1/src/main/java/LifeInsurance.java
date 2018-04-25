import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LifeInsurance {
    private static ArrayList<GroupOfDamage> groupsOfDamages=new ArrayList<>();
    private static ArrayList<InsuranceEvent> insuranceEvents=new ArrayList<>();
    private static GroupOfDamageFactory groupOfDamageFactory=new GroupOfDamageFactory();

    public LifeInsurance(){
        File folder=new File("C:\\Users\\Valeriia\\Documents\\IdeaProjects\\HomeWork\\Insurance files");
        File [] listOfFiles=folder.listFiles();

        for (File file: listOfFiles){
            if (file.isFile()){
                GroupOfDamage newGroup=groupOfDamageFactory.createGroupOfDamage(file);
                groupsOfDamages.add(newGroup);
                for (int i=0; i<newGroup.getInsuranceEvents().size(); i++)
                    insuranceEvents.add(newGroup.getInsuranceEvents().get(i));
            }
        }
    }


    public void showMenu() {
        System.out.println("\t*** Меню ***");
        System.out.println("\t1 Вывести информацию о страховых обязательствах");
        System.out.println("\t2 Составить дериватив страховых обязательтсв");
        System.out.println("\t0 Выйти из меню");
        System.out.print("Выберите вариант: ");
    }

    public void userOption (int command){
        switch (command) {
            case 1: {
                System.out.println();
                printInsuranceEvents(sortInsuranceEventsByYearPayment(insuranceEvents));
                break;
            }
            case 2:{
                System.out.println();
                makeDerivative();
                break;
            }
            case 0:{
                return;
            }
            default: {
                System.out.println("Команда не верна");
            }
        }
        System.out.println();
    }

    public ArrayList<InsuranceEvent> sortInsuranceEventsByYearPayment(ArrayList<InsuranceEvent> insuranceEvents) {
        ArrayList <InsuranceEvent> sorted=new ArrayList<>();
        for (int i=0; i<insuranceEvents.size(); i++)
            sorted.add(insuranceEvents.get(i));

        InsuranceEvent x;
        for (int i=0; i<insuranceEvents.size()-1; i++){
            for (int j=i+1; j<insuranceEvents.size(); j++){
                if (sorted.get(i).getYearInsurancePayment()<sorted.get(j).getYearInsurancePayment()){
                    x=sorted.get(i);
                    sorted.set(i,sorted.get(j));
                    sorted.set(j,x);
                }
            }
        }
        return sorted;
    }

    public void makeDerivative(){
        System.out.println("\t1 Показать все страховые случаи");
        System.out.println("\t2 Страховые случаи по типу");
        int command;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.print("Выберите вариант: ");
            command=sc.nextInt();
        } while ((command!=1)&&(command!=2));

        ArrayList <InsuranceEvent> optionsToChoose=new ArrayList<>();

        switch (command){
            case 1:{
                System.out.println();
                printInsuranceEvents(insuranceEvents);
                optionsToChoose=insuranceEvents;
                break;
            }
            case 2:{
                System.out.println();
                optionsToChoose=getGroupOfDamage();
                break;
            }
        }

        ArrayList <InsuranceEvent> choosedInsuranceEvents;
        choosedInsuranceEvents=chooseInsuranceEvents(optionsToChoose);

        System.out.println();
        System.out.println("Вы выбрали страховые случаи:");
        printInsuranceEvents(choosedInsuranceEvents);
        System.out.println("\tОбщая сумма страховки: "+getSumYearInsurancePayment(choosedInsuranceEvents));
        System.out.println();

        saveDerivative(choosedInsuranceEvents);
    }

    public int getSumYearInsurancePayment(ArrayList<InsuranceEvent> choosedInsuranceEvents) {
        int sum=0;
        for (int i=0; i<choosedInsuranceEvents.size(); i++){
           sum+=choosedInsuranceEvents.get(i).getYearInsurancePayment();
        }
        return sum;
    }

    public void saveDerivative(ArrayList<InsuranceEvent> choosedInsuranceEvents){
        Scanner sc=new Scanner(System.in);
        String str;
        do{
            System.out.print("Сформировать дериватив? Y/N: ");
            str=sc.nextLine();
        } while ((!str.equals("Y"))&&(!str.equals("N")));

        if (str.equals("Y")){
            FileNameExtensionFilter filter=new FileNameExtensionFilter("*.txt","*,*");
            JFileChooser fileChooser=new JFileChooser("C:\\Users\\Valeriia\\Documents\\IdeaProjects\\HomeWork\\Insurance files\\Derivatives");
            fileChooser.setFileFilter(filter);
            JFrame frame=new JFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            int save=fileChooser.showSaveDialog(frame);

            if (save==JFileChooser.APPROVE_OPTION) {
                try (FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile()) ) {
                    fileWriter.write("\tСтраховой случай\tВзнос\tВыплата\n");
                    for (int i=0; i<choosedInsuranceEvents.size();i++)
                        fileWriter.write((i+1)+". "+choosedInsuranceEvents.get(i)+"\n");
                    fileWriter.write("- - - - - - - - - - - - - - - - - - - -\n");
                    fileWriter.write("\tОбщая сумма страховки: "+getSumYearInsurancePayment(choosedInsuranceEvents));
                    fileWriter.close();
                }
                catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
            frame.dispose();
        }
    }

    public ArrayList<InsuranceEvent> chooseInsuranceEvents(ArrayList<InsuranceEvent> options){
        Scanner sc=new Scanner(System.in);
        ArrayList<InsuranceEvent> result=new ArrayList<>();
        String[] choosedS;
        String str;
        Boolean notAccept=true;
        do {
            System.out.print("Перечислите через запятую интересующие случаи: ");
            str=sc.nextLine();
            choosedS=str.split(",");
            int accepted=0;

            for (int i=0;i<choosedS.length; i++){
                if ((Integer.valueOf(choosedS[i])>0)&&(Integer.valueOf(choosedS[i])<=options.size())) {
                    accepted++;
                }
            }

            if (accepted==choosedS.length){
                for (int i=0; i<choosedS.length; i++){
                    result.add(options.get(Integer.valueOf(choosedS[i])-1));
                }
                notAccept=false;
            }
        } while (notAccept);

        return result;
    }

    public ArrayList<InsuranceEvent> getGroupOfDamage() {
        for (int i=0; i<groupsOfDamages.size(); i++){
            System.out.println((i+1)+". "+groupsOfDamages.get(i).getTypeOfDamage());
        }
        int Ngroup;
        Scanner sc=new Scanner(System.in);
        do {
            System.out.print("Выберите группу страховых случаев: ");
            Ngroup=sc.nextInt();
        } while ((Ngroup<1)||(Ngroup>groupsOfDamages.size()));

        System.out.println();
        groupsOfDamages.get(Ngroup-1).printDamages();

        return groupsOfDamages.get(Ngroup-1).getInsuranceEvents();
    }

    public void printInsuranceEvents(ArrayList<InsuranceEvent> events){
        System.out.println("\tСтраховой случай\tВзнос\tВыплата");
        for (int i=0; i<events.size();i++)
            System.out.println((i+1)+". "+events.get(i));
    }
}
