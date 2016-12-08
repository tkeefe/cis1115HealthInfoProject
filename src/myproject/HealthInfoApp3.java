
package myproject;

/**
 *
 * @author TravisKeefe
 */
public class HealthInfoApp3 {
    public static void main(String[] args) {
        DAOHealthInfo data = new DAOHealthInfo();
        System.out.println(data);
        
        data.create(new HealthInfo(1,"Kevin Keefe",46,"107 Barrick Drive","Blue Cross/Blue Shield"));
        data.create(new HealthInfo(2,"Ryan Keefe",11,"107 Barrick Drive","Blue Cross/Blue Shield"));
        System.out.println(data);
        HealthInfo myHealth = new HealthInfo(3,"Travis Keefe",19,"107 Barrick Drive","Blue Cross/Blue Sheild");
        data.create(myHealth);
        
    }
}
