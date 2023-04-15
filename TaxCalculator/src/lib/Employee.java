package lib;

import java.util.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee extends DataEmployee{

	DataEmployee pegawai;
	
	private Date yearJoined;
	private int monthWorkingInYear;
	
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	
	private String spouseName;
	private DataEmployee spouseIdNumber;

	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(DataEmployee pegawai, Date yearJoined, boolean isForeigner, boolean gender) {
		this.pegawai = pegawai;
		this.yearJoined = yearJoined;
		this.isForeigner = isForeigner;
		this.pegawai = pegawai;
		
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	 public void setMonthlySalary(int grade) {

        if (grade == 1) {
            monthlySalary = 3000000;

        } else if (grade == 2) {
            monthlySalary = 5000000;

        } else if (grade == 3) {
            monthlySalary = 7000000;
        }
        if (isForeigner) {
            monthlySalary = (int) (3000000 * 1.5);
        }
    }
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = pegawai;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}

	public boolean getgender(){
        return gender;
    }
    public void setgender(boolean gender){
        this.gender = gender;
    }
	
	public int getAnnualIncomeTax() {
		
		/* Menghitung berapalama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.*/

		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined.getYear()) {
			monthWorkingInYear = date.getMonthValue() - yearJoined.getMonth();
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}