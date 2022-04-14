package vaccopsjava;

import java.util.*;

public class VaccOps implements IVaccOps {
    private HashMap<Doctor, Set<Patient>> doctors;

    public VaccOps() {
        doctors = new HashMap<>();
    }

    public void addDoctor(Doctor d) {
        if (doctors.containsKey(d)) {
            throw new IllegalArgumentException();
        }
        doctors.put(d, new HashSet<>());
    }

    public void addPatient(Doctor d, Patient p) {
        if (!doctors.containsKey(d)) {
            throw new IllegalArgumentException();
        }

        doctors.get(d).add(p);
    }

    public Collection<Doctor> getDoctors() {
        return new ArrayList<>(doctors.keySet());
    }

    public Collection<Patient> getPatients() {
        List<Patient> patientsAsList = new ArrayList<>();
            for (Set<Patient> patients : doctors.values()) {
                patientsAsList.addAll(patients);
            }
        return patientsAsList;
    }

    public boolean exist(Doctor d) {
        return doctors.containsKey(d);
    }

    public boolean exist(Patient p) {
        for (Set<Patient> patients : doctors.values()) {
            if (patients.contains(p)) {
                return true;
            }
        }
        return false;
    }


    public Doctor removeDoctor(String name) {
        Doctor doctorToRemove;

        for (Doctor doctor : doctors.keySet()) {
            if (doctor.name.equals(name)) {
                doctorToRemove = doctor;
                doctors.remove(doctorToRemove);
                return doctorToRemove;
            }
        }
        throw new IllegalArgumentException();
    }

    public void changeDoctor(Doctor from, Doctor to, Patient p) {
        if (!doctors.containsKey(from) || !doctors.containsKey(to)) {
            throw new IllegalArgumentException();
        }

        if (!doctors.get(from).contains(p)) {
            throw new IllegalArgumentException();
        }

        doctors.get(from).remove(p);
        doctors.get(to).add(p);

    }

    public Collection<Doctor> getDoctorsByPopularity(int populariry) {
        List<Doctor> doctorsByPopularity = new ArrayList<>();

        for (Doctor doctor : doctors.keySet()) {
            if (doctor.popularity == populariry) {
                doctorsByPopularity.add(doctor);
            }
        }
        return doctorsByPopularity;
    }

    public Collection<Patient> getPatientsByTown(String town) {
        List<Patient> patientsByTown = new ArrayList<>();

        for (Set<Patient> patients : doctors.values()) {
            for (Patient patient : patients) {
                if (patient.town.equals(town)) {
                    patientsByTown.add(patient);
                }
            }
        }
        return patientsByTown;
    }

    public Collection<Patient> getPatientsInAgeRange(int lo, int hi) {
        List<Patient> patientsByAgeRange = new ArrayList<>();

        for (Set<Patient> patients : doctors.values()) {
            for (Patient patient : patients) {
                if (patient.age >= lo && patient.age <= hi) {
                    patientsByAgeRange.add(patient);
                }
            }
        }
        return patientsByAgeRange;
    }

    public Collection<Doctor> getDoctorsSortedByPatientsCountDescAndNameAsc() {
       List<Doctor> doctorsSortedByPatientsCountDescAndNameAsc = new ArrayList<>(doctors.keySet());

       doctorsSortedByPatientsCountDescAndNameAsc.sort((o1, o2) -> {
           int result = Integer.compare(doctors.get(o2).size(), doctors.get(o1).size());
           if (result == 0) {
               result = o1.name.compareTo(o2.name);
           }
           return result;
       });

        return doctorsSortedByPatientsCountDescAndNameAsc;
    }

    public Collection<Patient> getPatientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge() {
        List<Patient> patientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge = new ArrayList<>();

        List<Doctor> doctorsByPopularity = new ArrayList<>(doctors.keySet());


        doctorsByPopularity.sort(Comparator.comparingInt(o -> o.popularity));


        for (Doctor doctor : doctorsByPopularity) {
            List<Patient> patients = new ArrayList<>(doctors.get(doctor));

            patients.sort((o1, o2) -> {
                int result = Integer.compare(o2.height, o1.height);
                if (result == 0) {
                    result = Integer.compare(o1.age, o2.age);
                }
                return result;
            });

            patientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge.addAll(patients);
         }

        return patientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge;
    }

}
