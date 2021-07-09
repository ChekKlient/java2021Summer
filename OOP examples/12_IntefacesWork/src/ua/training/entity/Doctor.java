package ua.training.entity;

public class Doctor {
    private HumanDoctor human;
    private LicenceDoctor license;

    public Doctor(HumanDoctor doctor, LicenceDoctor license) {
        this.human = doctor;
        this.license = license;
    }

    public HumanDoctor getHuman() {
        return human;
    }

    public void setHuman(HumanDoctor human) {
        this.human = human;
    }

    public LicenceDoctor getLicense() {
        return license;
    }

    public void setLicense(LicenceDoctor license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "human=" + human +
                ", license=" + license +
                '}';
    }
}
