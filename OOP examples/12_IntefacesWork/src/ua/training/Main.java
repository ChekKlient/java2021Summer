package ua.training;

import ua.training.entity.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Human john = new Human("John" ,
                LocalDate.of(1999,8,7),
                Human.Gender.MALE , Human.BloodGroup.FIRST);
        System.out.println(john);

        LicenseForTreatment johnLicence = new LicenseForTreatment
                (john ,
                LicenseForTreatment.KindOfActivity.Surgeon ,
                LocalDate.of(2017,1,1) ,
                LocalDate.of(2027,1,1));
        System.out.println(johnLicence);

        Doctor johnDoctor = new Doctor(john, johnLicence);
        System.out.println(johnDoctor);
        johnDoctor = null;
    }
}
