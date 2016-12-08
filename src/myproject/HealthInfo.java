
package myproject;

/**
 *
 * @author TravisKeefe
 */
public class HealthInfo {
    private int id;
    private String address;
    private String name;
    private String InsurancePolicy;
    private int age;

    public HealthInfo() {
    }

    public HealthInfo(int id, String name, int age, String address, String InsurancePolicy) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.InsurancePolicy = InsurancePolicy;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsurancePolicy() {
        return InsurancePolicy;
    }

    public void setInsurancePolicy(String InsurancePolicy) {
        this.InsurancePolicy = InsurancePolicy;
    }

    @Override
    public String toString() {
        //return "HealthInfo{" + "id=" + id + ", name=" + name + ", address=" + address + ", InsurancePolicy=" + InsurancePolicy + ", age=" + age + '
        String holder = String.format("%5d %5s %5s %5s %3d",id,name,address,InsurancePolicy,age);
        return holder;
    }
    
    
    
}
