
package myproject;

/**
 *
 * @author TravisKeefe
 */
public class HealthInfoApp2 {
    public static void main(String[] args) {
        DAOHealthInfo data = new DAOHealthInfo();
        data.create(new HealthInfo(1,"Kevin Keefe",46,"107 Barrick Drive","Blue Cross/Blue Shield"));
        data.create(new HealthInfo(2,"Ryan Keefe",11,"107 Barrick Drive","Blue Cross/Blue Shield"));
        data.create(new HealthInfo(3,"Zach Keefe",13,"107 Barrick Drive","Blue Cross/Blue Shield"));
        System.out.println(data);
        
        
        data.update(new HealthInfo(2,"Kaleb Keefe",15,"107 Barrick Drive","Blue Cross/Blue Shield"));
        data.delete(3);
        System.out.println(data);
    }
}
