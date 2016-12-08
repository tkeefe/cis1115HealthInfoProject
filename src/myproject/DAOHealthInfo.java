
package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The data access object to a collection of coins
 * @author TravisKeefe
 */
public class DAOHealthInfo {
    List<HealthInfo> myList;
    private final String fileName = "HealthInfodata.txt";
    
    public DAOHealthInfo(){
        myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOHealthInfo.class.getName()).log(Level.SEVERE,null,ex);
        }
        readList();
    }
    
    public void create(HealthInfo he){
        myList.add(he);
        writeList();
    }
    
    public HealthInfo retrieve(int id){
        for(HealthInfo h : myList){
            if(h.getId() == id){
                return h;
            }
        }
        return null;
    }
    
    public void update(HealthInfo he){
        for(HealthInfo h : myList){
            if(h.getId() ==  he.getId()){
                h.setName(he.getName());
                h.setAge(he.getAge());
                h.setAddress(he.getAddress());
                h.setInsurancePolicy(he.getInsurancePolicy());
                break;
            }
        }
    }
    
    public void delete(int id){
        HealthInfo myHealth = null;
        for(HealthInfo h : myList){
            if(h.getId() ==  id){
                myHealth = h;
                break;
            }
        }
        myList.remove(myHealth);
    }
    
    public String orderById(){
        myList.sort(Comparator.comparing(HealthInfo :: getId));
        return this.toString();
    }
    
    public String orderByAge(){
        myList.sort(Comparator.comparing(HealthInfo :: getAge));
        return this.toString();
    }
    
    public String orderByAddress(){
        myList.sort(Comparator.comparing(HealthInfo :: getAddress));
        return this.toString();
    }
    
    public String orderByInsurancePolicy(){
        myList.sort(Comparator.comparing(HealthInfo :: getInsurancePolicy));
        return this.toString();
    }
    
    public String orderByName(){
        myList.sort(Comparator.comparing(HealthInfo :: getName));
        return this.toString();
    }
    
    public String orderByNameAgeD(){
        myList.sort((HealthInfo h1, HealthInfo h2) -> {
            if(h1.getName().equals(h2.getName())){
                return Double.compare(h2.getAge(), h1.getAge());
            } else {
                return h1.getName().compareTo(h2.getName());
            }
        });
        return this.toString();
    }
    
    public String orderByNameAgeA(){
        myList.sort((HealthInfo h1, HealthInfo h2) -> {
            if(h1.getName().equals(h2.getName())){
                return Double.compare(h1.getAge(), h2.getAge());
            } else {
                return h2.getName().compareTo(h1.getName());
            }
        });
        return this.toString();
    }
    
    public void Statistics(){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        double avg = 0;
        int count = 0;
        double total = 0;
        for(HealthInfo h : myList){
            if(h.getAge()<min){
                min = h.getAge();
            }
            if(h.getAge()>max){
                max = h.getAge();
            }
            sum += h.getAge();
            count++;
        }
        avg = sum/count;
        for(HealthInfo h : myList){
            total += Math.pow(h.getAge() - avg, 2);
        }
        double standardDeviation =Math.sqrt(total/(count - 1));
        System.out.println("The standard deviation is " + standardDeviation);
        System.out.println("The sum is " + sum);
        System.out.println("The max age is " + max);
        System.out.println("The min age is " + min);
        System.out.println("The average is " + avg);
    }
    
    private void readList(){
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                int age = Integer.parseInt(data[2]);
                String name = data[1];
                String address = data[3];
                String InsurancePolicy = data[4];
                HealthInfo h = new HealthInfo(id,name,age,address,InsurancePolicy);
                myList.add(h);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOHealthInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void writeList(){
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
            for(HealthInfo h : myList){
                writer.write(String.format("%d,%s,%d,%s,%s\n",
                        h.getId(),h.getName(),h.getAge(),h.getAddress(),h.getInsurancePolicy()));
            }
        }
      catch (IOException ex) {
            Logger.getLogger(DAOHealthInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(HealthInfo he : myList){
            sb.append(he).append("\n");
        }
        return sb.toString();
    }
}
