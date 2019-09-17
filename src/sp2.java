import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.RealVariable;
import org.moeaframework.problem.AbstractProblem;

import jmetal.encodings.variable.Int;

public class sp2 extends AbstractProblem{
	
	public static final int POPULATION_SIZE = 20;

	public sp2() {
		super(135*20, 2, 2);
		// TODO Auto-generated constructor stub
	}

	
//	@Override
//	public void evaluate(Solution solution) {

		
		
		
//		// TODO Auto-generated method stub
//		
//		ArrayList<String> courseCodesList = new ArrayList<>(StudentsNcoursesDataStore.getInstance().getCoursesHashMap().keySet());
//		
//		Schedule[] schedules = new Schedule[POPULATION_SIZE];
//		int g=0;
//		for (int i=0; i< POPULATION_SIZE; i++) {
//			for (int j=0; j< Schedule.TOTAL_SLOTS; j++) {		
//				
//				
//				int x = (int) ((RealVariable)solution.getVariable(g)).getValue(); //courseNo
//				int y = (int) ((RealVariable)solution.getVariable(g+1)).getValue(); //slotNo
//				
//				schedules[i].getSlotsList()[j].setCourseCode(courseCodesList.get(x));
//				schedules[i].getSlotsList()[j].setSlotNo(y);
//				
//				courseCodesList.remove(x);
//				g=g+2;
//
//			}
//		}
//		
//		ArrayList<Chromosome> chromosomesList = new ArrayList<>();
//		for (int i=0; i< schedules.length; i++) {
//			Chromosome chromosome = mapScheduleToChromosome(schedules[i]);
//			chromosomesList.add(chromosome);
//		}
//		
//		
//		ArrayList<Double> f1 = new ArrayList<>();
//		ArrayList<Double> c1 = new ArrayList<>();
//		ArrayList<Double> c2 = new ArrayList<>();
//		
//		for (int i=0; i< POPULATION_SIZE; i++) {
//			chromosomesList.get(i).calculateFitness();
//			f1.add((double)chromosomesList.get(i).getFitness());
//		}
//		
//		for (int i=0; i< f1.size(); i++) {
//			solution.setObjective(i, f1.get(i));
//			c1.set(i, f1.get(i));
//			
//			solution.setConstraint(i, c1.get(i)<=15 ? 0.0 : c1.get(i));
//		}
//		
//		ArrayList<Double> f2 = new ArrayList<>();
//		for (int i=0; i< POPULATION_SIZE; i++) {
//			chromosomesList.get(i).calculateFitness();
//			f2.add((double)chromosomesList.get(i).getNoOfDaysWithOver1200StudentsAnySlot());
//		}
//		
//		for (int i=f1.size(); i< f1.size() + f2.size(); i++) {
//			solution.setObjective(i, (double) f2.get(i));
//			solution.setConstraint(i, c1.get(i)<=15 ? 0.0 : c2.get(i));
//
//		
//		}
		
	
		
	//}
	
	@Override
	public Solution newSolution() {
		Solution solution = new Solution(getNumberOfVariables(), 
				getNumberOfObjectives());

		for (int i = 0; i < getNumberOfVariables(); i++) {
			/*Chromosome chromosome = new Chromosome();
			chromosome.init();
			solution.setAttribute(String.valueOf(i),chromosome);
			solution.setVariable(i, new RealVariable(i));*/
			solution.setVariable(i,EncodingUtils.newInt(0,135));
		
		}

		return solution;
	}

	
	@Override
	public void evaluate(Solution solution) {

		double[] y = EncodingUtils.getReal(solution);
		/*int[] x = new int[y.length];
		for (int i=0; i< y.length; i++)
			x[i]= (int) y[i];
		;*/
		int i=0;
		int u=0;
		int [][] x = new int[POPULATION_SIZE+1][136];
		for (int j=0;j<y.length;j++) {
			
			x[i][u] = (int) y[j];
			u++;
			if((j%135)==0) {
				i=i+1;
				//j=i*134;
				u=0;
			}
			
			System.out.println(Arrays.toString(x[i]));
		
		}
		
		
		
		
		
		
		/*for (int i=0; i< POPULATION_SIZE; i++) {
			Chromosome chromosome = new Chromosome();
			int[] z = Arrays.stream(x).distinct().toArray();
			ArrayList<Integer> list = new ArrayList<>();
			for (int j : z) {
				list.add(j);
			}
			chromosome.init(list);
		}
		
		double[] f = new double[numberOfObjectives];
		
		for (int i=0; i< numberOfObjectives; i++) {
			f[i] = 
		}*/
		
		
		/*System.out.println("X: SIZE"+x.length);
		System.out.println("X "+ Arrays.stream(x).distinct().count());
		System.out.println("X: "+ Arrays.toString(x));*/

	}	
	
		
		
//		int [] x = new int[y.length];
//		for (int i=0;i< y.length;i++) {
//			x[i] = (int) y[i];
//		}
//		
//		System.out.println("X: " + x.length);
//		System.out.println(Arrays.toString(x));
		
		/*Chromosome [] chromosomes = new Chromosome[POPULATION_SIZE];
		
		for (int i=0; i< POPULATION_SIZE; i++) {
			
			chromosomes[i] = (Chromosome)solution.getAttribute(String.valueOf(i));
			chromosomes[i].printChromosome();
		}*/
				
		//double[] f = new double[numberOfObjectives];
		
//		// TODO Auto-generated method stub
//		
//		ArrayList<String> courseCodesList = new ArrayList<>(StudentsNcoursesDataStore.getInstance().getCoursesHashMap().keySet());
//		
//		Schedule[] schedules = new Schedule[POPULATION_SIZE];
//		int g=0;
//		for (int i=0; i< POPULATION_SIZE; i++) {
//			for (int j=0; j< Schedule.TOTAL_SLOTS; j++) {		
//				
//				
//				int x = (int) ((RealVariable)solution.getVariable(g)).getValue(); //courseNo
//				int y = (int) ((RealVariable)solution.getVariable(g+1)).getValue(); //slotNo
//				
//				schedules[i].getSlotsList()[j].setCourseCode(courseCodesList.get(x));
//				schedules[i].getSlotsList()[j].setSlotNo(y);
//				
//				courseCodesList.remove(x);
//				g=g+2;
//
//			}
//		}
//		
//		ArrayList<Chromosome> chromosomesList = new ArrayList<>();
//		for (int i=0; i< schedules.length; i++) {
//			Chromosome chromosome = mapScheduleToChromosome(schedules[i]);
//			chromosomesList.add(chromosome);
//		}
//		
//		
//		ArrayList<Double> f1 = new ArrayList<>();
//		ArrayList<Double> c1 = new ArrayList<>();
//		ArrayList<Double> c2 = new ArrayList<>();
//		
//		for (int i=0; i< POPULATION_SIZE; i++) {
//			chromosomesList.get(i).calculateFitness();
//			f1.add((double)chromosomesList.get(i).getFitness());
//		}
//		
//		for (int i=0; i< f1.size(); i++) {
//			solution.setObjective(i, f1.get(i));
//			c1.set(i, f1.get(i));
//			
//			solution.setConstraint(i, c1.get(i)<=15 ? 0.0 : c1.get(i));
//		}
//		
//		ArrayList<Double> f2 = new ArrayList<>();
//		for (int i=0; i< POPULATION_SIZE; i++) {
//			chromosomesList.get(i).calculateFitness();
//			f2.add((double)chromosomesList.get(i).getNoOfDaysWithOver1200StudentsAnySlot());
//		}
//		
//		for (int i=f1.size(); i< f1.size() + f2.size(); i++) {
//			solution.setObjective(i, (double) f2.get(i));
//			solution.setConstraint(i, c1.get(i)<=15 ? 0.0 : c2.get(i));
//
//		
//		}
		
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public Solution newSolution() {
//		// TODO Auto-generated method stub
//		
//		Solution newSolution = new Solution(2*POPULATION_SIZE*Schedule.TOTAL_SLOTS, POPULATION_SIZE*2,POPULATION_SIZE*2);
//		
//		newSolution.setVariable(0, new RealVariable(0, 134));
//		newSolution.setVariable(0, new RealVariable(0, 35));
//		
//		return newSolution;
//	}
//	
	private Chromosome mapScheduleToChromosome(Schedule schedule) {
		Chromosome chromosome = new Chromosome();
		chromosome.init("");
		
		Slot[] slots = schedule.getSlotsList();
		Day[] days = chromosome.getDays();
		
		for (int i=0; i< slots.length; i+=2) {
			int dayNo = i / 2;
			int slotNo;
			
			if ((i % 2) == 0)
				slotNo = 0;
			else
				slotNo = 1;
			
			int row = 0;
			while (!days[dayNo].getDaySlots()[getRandNum(0, row)][slotNo].equals("----"))
				row = getRandNum(0, Day.MAX_EXAMS_IN_SINGLE_SLOT-1);
			
			days[dayNo].getDaySlots()[getRandNum(0, row)][slotNo] = slots[i].getCourseCode();
		}
		
		
		return chromosome;
	}
	
	public int getRandNum(int min, int max) {
		int randNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randNum;
	}

}
