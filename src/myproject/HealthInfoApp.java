
package myproject;

/**
 *
 * @author TravisKeefe
 */
public class HealthInfoApp {
    public static void main(String[] args) {
        HealthInfo he = new HealthInfo(1,"Travis Keefe",19,"107 Barrick Drive","Blue Cross/Blue Shield");
        System.out.println(he.toString());
    }
}
