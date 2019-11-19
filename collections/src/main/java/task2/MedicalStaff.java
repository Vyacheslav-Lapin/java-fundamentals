package task2;

import java.util.ArrayList;
import java.util.List;

public class MedicalStaff {}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}

/*There are classes possible to create: */
class Test {
  Doctor doctor = new Doctor();
  Doctor doctor2 = (Doctor) new MedicalStaff(); // only with casting
  Doctor doctor3 = new HeadDoctor();
  Object object = new HeadDoctor();
  Object object2 = new Nurse();

  List<Doctor> list = new ArrayList<>();
}
