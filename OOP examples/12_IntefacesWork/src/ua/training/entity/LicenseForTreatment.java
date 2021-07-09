package ua.training.entity;

import java.time.LocalDate;

public class LicenseForTreatment implements LicenceDoctor {

    private HumanLicence human;

    public enum KindOfActivity{
        Dentist, Oculist, Surgeon
    }
    private KindOfActivity category;

    private LocalDate fromDate;
    private LocalDate expires;

    public LicenseForTreatment(HumanLicence human,
                               KindOfActivity category,
                               LocalDate fromDate,
                               LocalDate expires) {
        this.human = human;
        this.category = category;
        this.fromDate = fromDate;
        this.expires = expires;
    }

    @Override
    public KindOfActivity category() {
        return category;
    }

    @Override
    public LocalDate fromDate() {
        return fromDate;
    }

    @Override
    public LocalDate expires() {
        return expires;
    }


    public HumanLicence getHuman() {
        return human;
    }

    public void setHuman(HumanLicence human) {
        this.human = human;
    }

    public KindOfActivity getCategory() {
        return category;
    }

    public void setCategory(KindOfActivity category) {
        this.category = category;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "LicenseForTreatment{" +
                "human=" + human +
                ", category=" + category +
                ", fromDate=" + fromDate +
                ", expires=" + expires +
                '}';
    }
}
