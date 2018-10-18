package cn.ghaien.designpattern.prototype;

/**
 * @author guo.haien
 * @Date 2018/7/13
 */
public class Resume_2 {

    private String name;

    private String sex;

    private String age;

    private WorkExperience_1 workExperience_1;

    public Resume_2(String name) {
        this.name = name;
        this.workExperience_1 = new WorkExperience_1();
    }

    private Resume_2(WorkExperience_1 workExperience_1) {
        this.workExperience_1 = (WorkExperience_1) workExperience_1.clone();
    }

    public void setPersonInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    public void setWorkExperience(String workDate, String company) {
        this.workExperience_1.setWorkDate(workDate);
        this.workExperience_1.setCompany(company);
    }

    public void display() {
        System.out.println(name + " " + sex + " " + age);
        System.out.println("工作经历：" + workExperience_1.getWorkDate() + " " + workExperience_1.getCompany());
    }

    @Override
    public Object clone() {
        try {
            Resume_2 resume_2 = new Resume_2(this.workExperience_1);
            resume_2.name = this.name;
            resume_2.sex = this.sex;
            resume_2.age = this.age;
            return resume_2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
