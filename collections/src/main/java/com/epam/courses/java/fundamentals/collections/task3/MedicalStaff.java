package com.epam.courses.java.fundamentals.collections.task3;

import java.util.ArrayList;
import java.util.List;

public class MedicalStaff {}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}

class TaskThree {
  Doctor doctor1 = new Doctor();
  Doctor doctor2 = (Doctor) new MedicalStaff(); /* You can create object with MedicalStaff constructor and Doctor object type
                                                   only when you casting object to Doctor type*/
  Doctor doctor3 = new HeadDoctor();
  Object object1 = new HeadDoctor();
  Object object2 = new Nurse();
  List<Doctor> list = new ArrayList<>();
}
